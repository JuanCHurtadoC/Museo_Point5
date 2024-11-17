
package Controller;

import java.util.ArrayList;
import Dto_Generics.Generic;
import Model.Painting;

public class PaintingController extends WorkOfArtController {

    private final ArrayList<Painting> ListPainting = new ArrayList<>();
           
    
    @Override
    public <T> boolean register(T obj) {
        try {
            if (obj == null) {
                return false;
            } else {
                Painting objPainting = (Painting) obj; 
                this.ListPainting.add(objPainting);

                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String search(String titleArtwork) {
            String result = "";

        for (int i = 0; i < this.ListPainting.size(); i++) {
            if (this.ListPainting.get(i).getTitleArtwork().equals(titleArtwork)) {
                result = "\nNombre de la Pintura: " + this.ListPainting.get(i).getTitleArtwork()
                        + "\nAutor: " + this.ListPainting.get(i).getAuthor() 
                        +"\nTamaño en cm "+this.ListPainting.get(i).getHeight() + " x "
                        + this.ListPainting.get(i).getWidth() +
                        "\nTecnica de pintura: " + this.ListPainting.get(i).getTechnique()+
                        "\n¿Esta en venta? " + this.ListPainting.get(i).getSale();
                

                break;
            }
        }
        return result;
    }

        @Override
    public <T> boolean update(String titleArtwork, T obj) {
        boolean result = true;
        try {
            if (obj == null) {
                result = false;
                return result;
            } else {
                Painting objPainting = (Painting) obj;

                for (Painting objtPainting : this.ListPainting) {
                    if (objtPainting.getTitleArtwork().equals(titleArtwork)) {
                        objtPainting.setTitleArtwork(objPainting.getTitleArtwork());
                       objtPainting.setAuthor(objPainting.getAuthor());
                        objtPainting.setHeight(objPainting.getHeight());
                        objtPainting.setWidth(objPainting.getWidth());
                        objtPainting.setTechnique(objPainting.getTechnique());
                        objtPainting.setSale(objPainting.getSale());

                        break;
                    }
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean remove(String titleArtwork) {
        boolean result = true;
        try {
            if (titleArtwork == null) {
                result = false;
                return result;
            } else {
                for (Painting objtPainting : this.ListPainting) {
                    if (objtPainting.getTitleArtwork().equals(titleArtwork)) {
                        this.ListPainting.remove(objtPainting);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public String list() {
            String ListPainting = "";

        for (int i = 0; i < this.ListPainting.size(); i++) {
            ListPainting += "\nNombre de la Pintura: " + this.ListPainting.get(i).getTitleArtwork()
                        + "\nAutor: " + this.ListPainting.get(i).getAuthor() 
                        +"\nTamaño en cm "+this.ListPainting.get(i).getHeight() + " x "
                        + this.ListPainting.get(i).getWidth() +
                        "\nTecnica de pintura: " + this.ListPainting.get(i).getTechnique()+
                        "\n¿Esta en venta? " + this.ListPainting.get(i).getSale() + "\n";
        }

        return ListPainting;
    }
    }
    




   
    

