
package Model;


public class Sculpture extends WorkOfArt {
    private double size;
    private String material;

    public double getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    

    public Sculpture(double size, String material, String sale, String author, String titleArtwork) {
        super(sale, author, titleArtwork);
        this.size = size;
        this.material = material;
    }
    
    
    
}
