package hw20200227part2;


/**
 *
 * @author Say Rattana
 */
public  class Rectangle extends GeometricObject{
    private double width ,height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        this.color = color;
        this.filled= filled;
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    

    @Override
    public double getPerimeter( ) {
       
        return 2*(width+height);
    }
     @Override
    public double getArea() {
        return  width*height;
    }
    @Override
    public double getDiameter(){
        return (width+height)/2;
 
    }

    @Override
    public String toString() {
        return "Rectangle\t{" + "width=" + width + 
                "\theight=" + height +
                "\tArea= "+getArea()+
                "\tPrimeter="+getPerimeter()+
                "\tDiameter="+getDiameter()+'}';
    }

    
    
}
   
   
    

