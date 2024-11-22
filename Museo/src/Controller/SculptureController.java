package Controller;

import Dto_Generics.Generic;
import Model.Sculpture;
import java.util.ArrayList;

public class SculptureController extends WorkOfArtController {
    private final ArrayList<Sculpture> ListSculpture = new ArrayList<>();
@Override
    public <T> boolean register(T obj) {
        try {
            if (obj == null) {
                return false;
            } else {
                Sculpture objSculpture = (Sculpture) obj; 
                this.ListSculpture.add(objSculpture);

                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String search(String titleArtwork) {
            String result = "";

        for (int i = 0; i < this.ListSculpture.size(); i++) {
            if (this.ListSculpture.get(i).getTitleArtwork().equals(titleArtwork)) {
                result = "\nNombre del Retrato: " + this.ListSculpture.get(i).getTitleArtwork()
                        + "\nAutor: " + this.ListSculpture.get(i).getAuthor() 
                        +"\nTamaño en cm cubicos o litros "+this.ListSculpture.get(i).getSize() 
                        + "\nTipo de material " + this.ListSculpture.get(i).getMaterial() + 
                        "\n¿Esta en venta? " + this.ListSculpture.get(i).getSale();
                

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
                Sculpture objSculpture = (Sculpture) obj;

                for (Sculpture objtSculpture : this.ListSculpture) {
                    if (objtSculpture.getTitleArtwork().equals(titleArtwork)) {
                        objtSculpture.setTitleArtwork(objSculpture.getTitleArtwork());
                       objtSculpture.setAuthor(objSculpture.getAuthor());
                        objtSculpture.setSize(objSculpture.getSize());
                        objtSculpture.setMaterial(objSculpture.getMaterial());
                        objtSculpture.setSale(objSculpture.getSale());

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
                for (Sculpture objtSculpture : this.ListSculpture) {
                    if (objtSculpture.getTitleArtwork().equals(titleArtwork)) {
                        this.ListSculpture.remove(objtSculpture);
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
            String ListSculpture = "";

        for (int i = 0; i < this.ListSculpture.size(); i++) {
            ListSculpture += "\nNombre del Retrato: " + this.ListSculpture.get(i).getTitleArtwork()
                        + "\nAutor: " + this.ListSculpture.get(i).getAuthor() 
                        +"\nTamaño en cm "+this.ListSculpture.get(i).getSize() + "\nTipo de material "
                        + this.ListSculpture.get(i).getMaterial() +
                        "\n¿Esta en venta? " + this.ListSculpture.get(i).getSale() + "\n";
        }

        return ListSculpture;
    }
    }