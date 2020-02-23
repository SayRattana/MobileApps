package SayRattana;

public class ResizableCircle extends Circle implements Resizable{

    public ResizableCircle(double radius) {
        super(radius);
    }

    ResizableCircle() {
    }

    @Override
    public void resize( int percent) {      
      radius*=percent/100.0;     
      
    }
}
   

    
    
    
    
  
