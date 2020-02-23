
package SayRattana;


public class Main {

   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Movable mp= new MovablePoint(5, 15, 20, 30);
        Movable mc= new MovableCircle(5,15, 20, 30, 20);
         System.out.println(mp+"\n"+mc);
     //   System.out.println("Haha...");
    }
    
}
