
package Model;


public class Portrait extends WorkOfArt {
    
    private double height;
    private double width;

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    

    public Portrait(double height, double width, String sale, String author, String titleArtwork) {
        super(sale, author, titleArtwork);
        this.height = height;
        this.width = width;
    }
    
    
}
