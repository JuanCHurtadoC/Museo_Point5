package Controller;

import Model.Portrait;
import Dto_Generics.Generic;
import java.util.ArrayList;
        
        
public class PortraitController extends WorkOfArtController
{
    private final ArrayList<Portrait> ListPortrait = new ArrayList<>();
           
    
    @Override
    public <T> boolean register(T obj) {
        try {
            if (obj == null) {
                return false;
            } else {
                Portrait objPortrait = (Portrait) obj; 
                this.ListPortrait.add(objPortrait);

                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String search(String titleArtwork) {
            String result = "";

        for (int i = 0; i < this.ListPortrait.size(); i++) {
            if (this.ListPortrait.get(i).getTitleArtwork().equals(titleArtwork)) {
                result = "\nNombre del Retrato: " + this.ListPortrait.get(i).getTitleArtwork()
                        + "\nAutor: " + this.ListPortrait.get(i).getAuthor() 
                        +"\nTamaño en cm "+this.ListPortrait.get(i).getHeight() + " x "
                        + this.ListPortrait.get(i).getWidth() +
                        "\n¿Esta en venta? " + this.ListPortrait.get(i).getSale();
                

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
                Portrait objPainting = (Portrait) obj;

                for (Portrait objtPortrait : this.ListPortrait) {
                    if (objtPortrait.getTitleArtwork().equals(titleArtwork)) {
                        objtPortrait.setTitleArtwork(objPainting.getTitleArtwork());
                       objtPortrait.setAuthor(objPainting.getAuthor());
                        objtPortrait.setHeight(objPainting.getHeight());
                        objtPortrait.setWidth(objPainting.getWidth());
                        objtPortrait.setSale(objPainting.getSale());

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
                for (Portrait objtPortrait : this.ListPortrait) {
                    if (objtPortrait.getTitleArtwork().equals(titleArtwork)) {
                        this.ListPortrait.remove(objtPortrait);
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
            String ListPortrait = "";

        for (int i = 0; i < this.ListPortrait.size(); i++) {
            ListPortrait += "\nNombre del Retrato: " + this.ListPortrait.get(i).getTitleArtwork()
                        + "\nAutor: " + this.ListPortrait.get(i).getAuthor() 
                        +"\nTamaño en cm "+this.ListPortrait.get(i).getHeight() + " x "
                        + this.ListPortrait.get(i).getWidth() +
                        "\n¿Esta en venta? " + this.ListPortrait.get(i).getSale() + "\n";
        }

        return ListPortrait;
    }
    }

