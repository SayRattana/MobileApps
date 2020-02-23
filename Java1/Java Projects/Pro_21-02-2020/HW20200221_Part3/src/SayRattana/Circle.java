
package SayRattana;

public class Circle implements GeometricObject{
    double radius=1.0;
    double perimeter,area;
    double pi=3.14159;
    
     Circle() {       
    }
    public Circle(double  radius) {        
        this.radius=radius;
    }
   

    @Override
    public double getPerimeter() {
        return 2*pi*radius;
    }

    @Override
    public double getArea() {
      return pi*Math.pow(radius,2);
        
    }

   

    
    
    
}
