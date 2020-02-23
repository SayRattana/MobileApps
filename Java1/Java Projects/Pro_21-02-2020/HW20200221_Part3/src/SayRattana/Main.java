package SayRattana;

public class Main {
    public static void main(String[] args) {
       Circle defValue = new Circle(); // Default value of radius.
       GeometricObject cicl = new Circle(15.0); // Assign new value of radius.
       ResizableCircle smallResize=new ResizableCircle(); // Resize (Big to Small).
                       smallResize.resize(25);   
          
        System.out.println("Defaul\tGeometricObject[Perimeter= "
                                    + defValue.getPerimeter()+
                            "\tArea= "+defValue.getArea()+"]");

            
        System.out.println("\nNew\tGeometricObject["+"Perimeter= "
                +cicl.getPerimeter()+"\tArea= "+cicl.getArea()+"]");
         
          
        System.out.println("Resize\tto small Circle["+"Perimeter= "
                                    +smallResize.getPerimeter()+ 
                          "\tArea= "+smallResize.getArea()+"]");
         
          
          
          
       
    }
    
}
