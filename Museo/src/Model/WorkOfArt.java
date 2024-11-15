package Model;
abstract class WorkOfArt {
    protected String author;
    protected String titleArtwork;
    protected String sale;

    public String getAuthor() {
        return author;
    }

    public String getTitleArtwork() {
        return titleArtwork;
    }

    public String getSale() {
        return sale;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitleArtwork(String titleArtwork) {
        this.titleArtwork = titleArtwork;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }
    
    
    public WorkOfArt(String sale, String author,String titleArtwork){
        this.sale=sale;
        this.author=author;
        this.titleArtwork=titleArtwork;
    
}


    }
    


