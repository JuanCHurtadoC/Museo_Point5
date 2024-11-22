package Controller;

import Model.Portrait;
import java.util.HashMap;
import java.util.Map;

public class PortraitController {

    private final Map<String, Portrait> portraitMap = new HashMap<>(); // Usamos un Map para almacenar los retratos

    // Registrar un nuevo retrato
    public boolean register(Portrait portrait) {
        if (portrait == null || portraitMap.containsKey(portrait.getTitleArtwork())) {
            return false; // Si el retrato es nulo o ya está registrado, no lo registramos
        }
        portraitMap.put(portrait.getTitleArtwork(), portrait); // Registramos el retrato
        return true;
    }

    // Buscar un retrato por su título
    public String search(String titleArtwork) {
        Portrait portrait = portraitMap.get(titleArtwork);
        if (portrait != null) {
            return portrait.toString(); // Retorna la información del retrato
        }
        return "Retrato no encontrado.";
    }

    // Actualizar los detalles de un retrato
    public boolean update(String titleArtwork, Portrait updatedPortrait) {
        Portrait portrait = portraitMap.get(titleArtwork);
        if (portrait != null) {
            portrait.setAuthor(updatedPortrait.getAuthor());
            portrait.setHeight(updatedPortrait.getHeight());
            portrait.setWidth(updatedPortrait.getWidth());
            portrait.setSale(updatedPortrait.getSale());
            return true;
        }
        return false;
    }

    // Eliminar un retrato por su título
    public boolean remove(String titleArtwork) {
        if (portraitMap.containsKey(titleArtwork)) {
            portraitMap.remove(titleArtwork); // Elimina el retrato del mapa
            return true;
        }
        return false;
    }

    // Listar todos los retratos registrados
    public String list() {
        if (portraitMap.isEmpty()) {
            return "No hay retratos registrados."; // Mensaje cuando no hay retratos
        }
        StringBuilder list = new StringBuilder();
        for (Portrait portrait : portraitMap.values()) {
            list.append(portrait.toString()).append("\n-----------------------------\n");
        }
        return list.toString(); // Retorna una lista de todos los retratos registrados
    }
}