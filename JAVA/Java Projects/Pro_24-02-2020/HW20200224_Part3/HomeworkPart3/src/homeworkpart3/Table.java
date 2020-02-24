package homeworkpart3;

/**
 *
 * @author Say Rattana
 */
public class Table {    
  
     int width,height;

    public Table() {
    }

    public Table(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public void showData(){        
        System.out.println("\tWidth= " + this.width +
                            "\n\tHeigth= " + this.height);
   }
  
    
}
