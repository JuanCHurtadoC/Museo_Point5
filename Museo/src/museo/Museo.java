package museo;

import java.util.Scanner;
import Dto_Generics.Generic;
import Controller.PaintingController;
import Controller.PortraitController;
import Controller.SculptureController;
import Model.Painting;
import Model.Portrait;
import Model.Sculpture;

public class Museo {
private static Scanner scan = new Scanner(System.in);
private static PaintingController objPaintingController = new PaintingController();
private static PortraitController objPortraitController = new PortraitController();
private static SculptureController objSculptureController = new SculptureController();
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
                case 1:{
        

        
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
                break;}
            case 2:{
                
               System.out.println("\nIngresar Retrato");
                System.out.println("Nombre de la Retrato: ");
                scan.nextLine();
                String titleArtwork = scan.nextLine();               
                System.out.println("Autor: ");
                String author = scan.nextLine();               
                System.out.println("Altura en cm: ");
                double height = scan.nextDouble();
                System.out.println("Largo en cm: ");
                double width = scan.nextDouble();             
                System.out.println("¿Esta en venta? Si o No");
                String sale = scan.next();
                scan.nextLine();

               Portrait objPortrait = new Portrait(height, width, sale, author, titleArtwork);

                Generic<Portrait> objGeneric = new Generic<>();
                objGeneric.setContent(objPortrait);

                if (objPortraitController.register(objGeneric.getContent())) {
                    System.out.println("\nRetrato ingresada correctamente");
                    }
                 else {
                    System.out.println("\nRetrato no ingresada intentelo de nuevo");
                }
                break; }
                
            case 3:{
        

        
                System.out.println("\nIngresar Escultura");
                System.out.println("Nombre de la Escultura: ");
                scan.nextLine();
                String titleArtwork = scan.nextLine();                
                System.out.println("Autor: ");
                String author = scan.nextLine();               
                System.out.println("Volumen en cm cubicos: ");
                double size = scan.nextDouble();
                System.out.println("Material: ");
                scan.nextLine();
                String material = scan.nextLine();               
                System.out.println("¿Esta en venta? Si o No");
                String sale = scan.next();
                scan.nextLine();

                Sculpture objSculpture = new Sculpture(size, material, sale,author, titleArtwork);

                Generic<Sculpture> objGeneric = new Generic<>();
                objGeneric.setContent(objSculpture);

                if (objSculptureController.register(objGeneric.getContent())) {
                    System.out.println("\nEscultura ingresada correctamente");
                    }
                 else {
                    System.out.println("\nEscultura no ingresada intentelo de nuevo");
                }
                break;}
                
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
                    }break;
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
                    }break;
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
                    }break;


                
                default: 
                    System.out.println("Opcion seleccionada no valida");    
            }break;
         case 2:
             int option3;
            System.out.println("Ingrese que opcion desea ejecutar");
            System.out.println("1 Listar");
            System.out.println("2 Buscar");
            System.out.println("3 Actualizar");
            System.out.println("4 Eliminar");
            option3 = scan.nextInt();    
             switch(option3) {  
                case 1:{
                    System.out.println("\nLista de Retratos");

                    String result = objPortraitController.list();

                    if (result != "") {
                    System.out.println(result);}
                    else {
                    System.out.println("\nNo hay Retratos registradas!");
                    }
                    }break;
                case 2:{
                    System.out.println("Ingrese el nombre de la Retrato que desea buscar: ");
                    scan.nextLine();
                    String titleArtwork = scan.nextLine();

                    String result2 = objPortraitController.search(titleArtwork);
                    if (result2 != "") {
                    System.out.println("\nDatos del Retrato");
                    System.out.println(result2);
                    } else {
                    System.out.println("\nretrato no encontrada");
                    }
                    }break;
                case 3:{
                   System.out.println("\nActualizar retrato");
                    System.out.println("Ingrese el nombre del retrato que desea buscar para actualizar: ");
                    scan.nextLine();
                    String searchTitleArtwork = scan.nextLine();

                    String result3 = objPortraitController.search(searchTitleArtwork);
                    if (result3 != "") {
                        System.out.println("\nDatos de la retrato");
                        System.out.println(result3);

                        System.out.println("\n¿Desea actualizar los datos de la retrato? Si o No");
                        sw2 = scan.next().toUpperCase().charAt(0);

                        if (sw2 == 'S') {
                            System.out.println("\nIngresar retrato");
                            System.out.println("Nombre del retrato: ");
                            scan.nextLine();
                            String titleArtwork = scan.nextLine();                
                            System.out.println("Autor: ");
                            String author = scan.nextLine();               
                            System.out.println("Altura en cm: ");
                            double height = scan.nextDouble();
                            System.out.println("Largo en cm: ");
                            double width = scan.nextDouble();
                            scan.nextLine();            
                            System.out.println("¿Esta en venta? Si o No");
                            String sale = scan.next();
                            scan.nextLine();

                            Portrait objPortrait = new Portrait(height, width, sale,author, titleArtwork);

                            Generic<Portrait> objGeneric = new Generic<>();
                            objGeneric.setContent(objPortrait);

                        if (objPortraitController.update(searchTitleArtwork, objPortrait)) {
                            if (objPortraitController.update(searchTitleArtwork, objGeneric.getContent())) {
                                System.out.println("\nretrato actualizada correctamente.");
                            }
                        }else {
                            System.out.println("\nretrato no se logro actualizar.");
                            }
                    }} else {
                        System.out.println("\nretrato no se encontro");
                        }
                    }break;
                case 4: {
                    System.out.println("\nRemover retrato");
                    System.out.println("Ingrese el nombre de la retrato que desea eliminar: ");
                    scan.nextLine();
                    String titleArtwork = scan.nextLine();

                    String result = objPortraitController.search(titleArtwork);
                    if (result != "") {
                        System.out.println("\nDatos del retrato");
                        System.out.println(result);

                        System.out.println("\n¿Desea eliminar los datos del retrato? Si o No ");
                        sw2 = scan.next().toUpperCase().charAt(0);

                        if (sw2 == 'S') {
                            if (objPortraitController.remove(titleArtwork)) {
                                System.out.println("\nretrato Eliminado exitosamente!");
                            } else {
                                System.out.println("\nretrato no se logró eliminar.");
                            }
                        }
                    } else {
                        System.out.println("\nretrato no se encontro.");
                    }
                    }break;


                
                default: 
                    System.out.println("Opcion seleccionada no valida");
             }
             
         case 3:   
             
             System.out.println("\nLista de Retratos");

                    String result = objSculptureController.list();

                    if (result != "") {
                    System.out.println(result);}
                    else {
                    System.out.println("\nNo hay Retratos registradas!");
                    }
                    break;
             
            
        }
    System.out.println("\n¿Desea ejecutar otra funcion? Si o No");
    sw2 = scan.next().toUpperCase().charAt(0); 
    }
    System.out.println("Gracias por utilizar el aplicativo!");
}
    
}
