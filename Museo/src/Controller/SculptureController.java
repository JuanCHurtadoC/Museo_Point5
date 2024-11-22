package Controller;

import Dto_Generics.Generic;
import Model.Sculpture;
import java.util.ArrayList;

public class SculptureController extends WorkOfArtController {
    private final ArrayList<Sculpture> sculptureList = new ArrayList<>();
/**
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
 **/
    @Override
    public <T> boolean register(T obj) {
        try {
            if (obj instanceof Sculpture) {
                Sculpture sculpture = (Sculpture) obj;
                this.sculptureList.add(sculpture);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error al registrar la escultura: " + e.getMessage());
        }
        return false;
    }

    @Override
    public String search(String titleArtwork) {
        String result = "Escultura no encontrada.";
        for (Sculpture sculpture : sculptureList) {
            if (sculpture.getTitleArtwork().equalsIgnoreCase(titleArtwork)) {
                result = "\nTítulo: " + sculpture.getTitleArtwork() +
                         "\nAutor: " + sculpture.getAuthor() +
                         "\nMaterial: " + sculpture.getMaterial() +
                         "\nTamaño (litros): " + sculpture.getSize() +
                         "\nEn venta: " + sculpture.getSale();
                break; 
            }
        }
        return result;
    }

    @Override
    public <T> boolean update(String titleArtwork, T obj) {
        try {
            if (obj instanceof Sculpture) {
                Sculpture updatedSculpture = (Sculpture) obj;
                for (int i = 0; i < sculptureList.size(); i++) {
                    if (sculptureList.get(i).getTitleArtwork().equalsIgnoreCase(titleArtwork)) {
                        sculptureList.set(i, updatedSculpture);
                        return true; // Detener el proceso al actualizar
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error al actualizar la escultura: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean remove(String titleArtwork) {
        for (int i = 0; i < sculptureList.size(); i++) {
            if (sculptureList.get(i).getTitleArtwork().equalsIgnoreCase(titleArtwork)) {
                sculptureList.remove(i);
                return true; // Detener el proceso al eliminar
            }
        }
        return false;
    }

    @Override
    public String list() {
        if (sculptureList.isEmpty()) {
            return "No hay esculturas registradas.";
        }
        StringBuilder result = new StringBuilder();
        for (Sculpture sculpture : sculptureList) {
            result.append("\nTítulo: ").append(sculpture.getTitleArtwork())
                  .append("\nAutor: ").append(sculpture.getAuthor())
                  .append("\nMaterial: ").append(sculpture.getMaterial())
                  .append("\nTamaño (litros): ").append(sculpture.getSize())
                  .append("\nEn venta: ").append(sculpture.getSale())
                  .append("\n");
        }
        return result.toString();
    }
}