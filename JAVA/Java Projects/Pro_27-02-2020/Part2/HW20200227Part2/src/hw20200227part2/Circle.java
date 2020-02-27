package hw20200227part2;


/**
 *
 * @author Say Rattana
 */
public class Circle extends GeometricObject{
    private double radius;
    public static final double PI=3.14159;

    
    @Override
    public double getPerimeter( ) {
        return 2*PI*radius;
    }
     @Override
    public double getArea() {
        return PI * Math.pow(radius,2);
    }
    @Override
    public double getDiameter(){
        return 2*radius;
   
    }

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        this.color = color;
        this.filled= filled;
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle\t\t{" + "radius=" + radius +
                       "\tArea= "+getArea() +
                       "\tPrimeter= "+getPerimeter()+
                       "\tDiameter=" +getDiameter()+'}';
    }

  
    
    
    
    
}

   

