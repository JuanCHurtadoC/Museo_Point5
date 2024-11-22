package museo;

import java.util.Scanner;
import Dto_Generics.Generic;
import Controller.PaintingController;
import Controller.PortraitController;
import Model.Painting;
import Model.Portrait;

public class Museo {
private static Scanner scan = new Scanner(System.in);
private static PaintingController objPaintingController = new PaintingController();
private static PortraitController objPortraitController = new PortraitController();
    public static void main(String[] args) {
registerArt();
Funcionalidades();
scan.close();
    }

    private static void registerArt() {
        
        int Opc;
        char sw = 'S';
      
        
        
        while (sw == 'S')
        {         
        System.out.println("Ingrese que tipo de obra desea ingresar: ");
        System.out.println("1 para Pintura");
        System.out.println("2 para Retrato");
        System.out.println("3 para Escultura");
        Opc = scan.nextInt();
            switch(Opc){
                case 1:
        

        
                System.out.println("\nIngresar Pintura");
                System.out.println("Nombre de la Pintura: ");
                scan.nextLine();
                String titleArtwork = scan.nextLine();                
                System.out.println("Autor: ");
                String author = scan.nextLine();               
                System.out.println("Altura en cm: ");
                double height = scan.nextDouble();
                System.out.println("Largo en cm: ");
                double width = scan.nextDouble();
                System.out.println("Tecnica: ");
                scan.nextLine();
                String technique = scan.nextLine();               
                System.out.println("¿Esta en venta? Si o No");
                String sale = scan.next();
                scan.nextLine();

                Painting objPainting = new Painting(height, width, technique, sale,author, titleArtwork);

                Generic<Painting> objGeneric = new Generic<>();
                objGeneric.setContent(objPainting);

                if (objPaintingController.register(objGeneric.getContent())) {
                    System.out.println("\nPintura ingresada correctamente");
                    }
                 else {
                    System.out.println("\nPintura no ingresada intentelo de nuevo");
                }
                break;
            case 2:
                
               System.out.println("\nIngresar Pintura");
                System.out.println("Nombre de la Pintura: ");
                scan.nextLine();
                 titleArtwork = scan.nextLine();               
                System.out.println("Autor: ");
                 author = scan.nextLine();               
                System.out.println("Altura en cm: ");
                 height = scan.nextDouble();
                System.out.println("Largo en cm: ");
                 width = scan.nextDouble();
                System.out.println("Tecnica: ");
                scan.nextLine();
                 technique = scan.nextLine();              
                System.out.println("¿Esta en venta? Si o No");
                sale = scan.next();
                scan.nextLine();

               Portrait objPortrait = new Portrait(height, width, sale, author, titleArtwork);

                 objGeneric.setContent(objPortrait);

               if (objGeneric.getContent() instanceof Portrait) {
                 if (objPortraitController.register((Portrait) objGeneric.getContent())) {
                  System.out.println("\nRetrato ingresado correctamente");
                } else {
                   System.out.println("\nRetrato no ingresado, intentelo de nuevo");                                                                         
                   
                  }
                    } else {
                     System.out.println("\nEl objeto no es un retrato, no se puede registrar");
                    }
                break; 
                
            case 3:
                
            default: 
                System.out.println("Opcion seleccionada no valida");  
            

        }
            System.out.println("\n¿Desea ingresar otra Obra? Si o No");
            sw = scan.next().toUpperCase().charAt(0);        
        
        }
    }

    private static void Funcionalidades() {
    
    char sw2='S';
    
    while(sw2 == 'S'){
     int option;
     
        System.out.println("Ingrese que tipo de Obra de arte desea consultar o modificar:");
        System.out.println("1 Pintura");
        System.out.println("2 Retrato");
        System.out.println("3 Escultura");
        option=scan.nextInt();
        
     switch(option){ 
         case 1:    
            int option2;
            System.out.println("Ingrese que opcion desea ejecutar");
            System.out.println("1 Listar");
            System.out.println("2 Buscar");
            System.out.println("3 Actualizar");
            System.out.println("4 Eliminar");
            option2 = scan.nextInt();    
             switch(option2) {  
                case 1:{
                    System.out.println("\nLista de pinturas");

                    String result = objPaintingController.list();

                    if (result != "") {
                    System.out.println(result);}
                    else {
                    System.out.println("\nNo hay pinturas registradas!");
                    }
                    break;}
                case 2:{
                    System.out.println("Ingrese el nombre de la Pintura que desea buscar: ");
                    scan.nextLine();
                    String titleArtwork = scan.nextLine();

                    String result2 = objPaintingController.search(titleArtwork);
                    if (result2 != "") {
                    System.out.println("\nDatos de la pintura");
                    System.out.println(result2);
                    } else {
                    System.out.println("\nPintura no encontrada");
                    }
                    break;}
                case 3:{
                   System.out.println("\nActualizar Pintura");
                    System.out.println("Ingrese el nombre de la pintura que desea buscar para actualizar: ");
                    scan.nextLine();
                    String searchTitleArtwork = scan.nextLine();

                    String result3 = objPaintingController.search(searchTitleArtwork);
                    if (result3 != "") {
                        System.out.println("\nDatos de la pintura");
                        System.out.println(result3);

                        System.out.println("\n¿Desea actualizar los datos de la pintura? Si o No");
                        sw2 = scan.next().toUpperCase().charAt(0);

                        if (sw2 == 'S') {
                            System.out.println("\nIngresar Pintura");
                            System.out.println("Nombre de la Pintura: ");
                            scan.nextLine();
                            String titleArtwork = scan.nextLine();                
                            System.out.println("Autor: ");
                            String author = scan.nextLine();               
                            System.out.println("Altura en cm: ");
                            double height = scan.nextDouble();
                            System.out.println("Largo en cm: ");
                            double width = scan.nextDouble();
                            System.out.println("Tecnica: ");
                            scan.nextLine();
                            String technique = scan.nextLine();               
                            System.out.println("¿Esta en venta? Si o No");
                            String sale = scan.next();
                            scan.nextLine();

                            Painting objPainting = new Painting(height, width, technique, sale,author, titleArtwork);

                            Generic<Painting> objGeneric = new Generic<>();
                            objGeneric.setContent(objPainting);

                        if (objPaintingController.update(searchTitleArtwork, objPainting)) {
                            if (objPaintingController.update(searchTitleArtwork, objGeneric.getContent())) {
                                System.out.println("\nPintura actualizada correctamente.");
                            }
                        }else {
                            System.out.println("\nPintura no se logro actualizar.");
                            }
                    }} else {
                        System.out.println("\nPintura no se encontro");
                        }
                    break;}
                case 4: {
                    System.out.println("\nRemover Pintura");
                    System.out.println("Ingrese el nombre de la pintura que desea eliminar: ");
                    scan.nextLine();
                    String titleArtwork = scan.nextLine();

                    String result = objPaintingController.search(titleArtwork);
                    if (result != "") {
                        System.out.println("\nDatos de la pintura");
                        System.out.println(result);

                        System.out.println("\n¿Desea eliminar los datos de la pintura? Si o No ");
                        sw2 = scan.next().toUpperCase().charAt(0);

                        if (sw2 == 'S') {
                            if (objPaintingController.remove(titleArtwork)) {
                                System.out.println("\nPintura Eliminada exitosamente!");
                            } else {
                                System.out.println("\nPintura no se logró eliminar.");
                            }
                        }
                    } else {
                        System.out.println("\nPintura no se encontro.");
                    }
                    break;}


                
                default: 
                    System.out.println("Opcion seleccionada no valida");    
            }
         case 2:
             break;
         case 3:    
             break;
        }
    System.out.println("\n¿Desea ejecutar otra funcion? Si o No");
    sw2 = scan.next().toUpperCase().charAt(0); 
    }
    System.out.println("Gracias por utilizar el aplicativo!");
}
    
}
