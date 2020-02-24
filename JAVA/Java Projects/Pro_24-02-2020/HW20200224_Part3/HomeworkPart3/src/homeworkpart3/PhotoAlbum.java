package homeworkpart3;

/**
 *
 * @author Say Rattana
 */
public class PhotoAlbum {
    private final int numberOfPages;

    public PhotoAlbum() {
        numberOfPages=16;
    }

    public PhotoAlbum(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    
    

    public int getNumberOfPages() {
        return numberOfPages;
    }
    


    @Override
    public String toString() {
         return "[numberOfPages=" + numberOfPages + ']';
    }
    
     

   

    
}
