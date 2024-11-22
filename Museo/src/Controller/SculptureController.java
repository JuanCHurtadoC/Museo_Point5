package Controller;
import Model.Sculpture;
import java.util.HashMap;
import java.util.Map;

public class SculptureController {

    private final Map<String, Sculpture> sculptureMap = new HashMap<>(); // Usamos un Map para optimizar la búsqueda por título

    // Registrar una nueva escultura
    public boolean register(Sculpture sculpture) {
        if (sculpture == null || sculptureMap.containsKey(sculpture.getTitleArtwork())) {
            return false; // Si la escultura es nula o ya está registrada, no la registramos
        }
        sculptureMap.put(sculpture.getTitleArtwork(), sculpture); // Registramos la escultura
        return true;
    }

    // Buscar una escultura por su título
    public String search(String titleArtwork) {
        Sculpture sculpture = sculptureMap.get(titleArtwork);
        if (sculpture != null) {
            return sculpture.toString(); // Retorna la información de la escultura
        }
        return "Escultura no encontrada.";
    }

    // Actualizar los detalles de una escultura
    public boolean update(String titleArtwork, Sculpture updatedSculpture) {
        Sculpture sculpture = sculptureMap.get(titleArtwork);
        if (sculpture != null) {
            sculpture.setAuthor(updatedSculpture.getAuthor());
            sculpture.setMaterial(updatedSculpture.getMaterial());
            sculpture.setSize(updatedSculpture.getSize());
            sculpture.setSale(updatedSculpture.getSale());
            return true;
        }
        return false;
    }

    // Eliminar una escultura por su título
    public boolean remove(String titleArtwork) {
        if (sculptureMap.containsKey(titleArtwork)) {
            sculptureMap.remove(titleArtwork); // Elimina la escultura del mapa
            return true;
        }
        return false;
    }

    // Listar todas las esculturas registradas
    public String list() {
        if (sculptureMap.isEmpty()) {
            return "No hay esculturas registradas."; // Mensaje cuando no hay esculturas
        }
        StringBuilder list = new StringBuilder();
        for (Sculpture sculpture : sculptureMap.values()) {
            list.append(sculpture.toString()).append("\n-----------------------------\n");
        }
        return list.toString(); // Retorna una lista de todas las esculturas registradas
    }
}