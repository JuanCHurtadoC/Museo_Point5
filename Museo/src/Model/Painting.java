
package Model;


public class Painting extends WorkOfArt {
    
    private double height;
    private double width;
    private String technique;

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public String getTechnique() {
        return technique;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }
    
    

    public Painting(double height, double width, String technique, String sale, String author, String titleArtwork) {
        super(sale, author, titleArtwork);
        this.height = height;
        this.width = width;
        this.technique = technique;
    }
    
       
    }
    

