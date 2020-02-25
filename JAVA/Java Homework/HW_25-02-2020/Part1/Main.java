
package hw_part1;

/**
 * @author Say Rattana
 */
public class Main {

    public static void main(String[] args) {
        try{
            method();
            System.out.println("After the method call");
        }
        catch (RuntimeException ex){
            System.out.println("RuntimeException in main");            
        }
        catch (Exception ex){
            System.out.println("Exception in main");
        }
    }
    
    static void method() throws Exception{
        try {
            String s = "abe";
            System.out.println(s.charAt(3));
        } 
        catch (RuntimeException ex) {
            System.out.println("RuntimeException in method()");
            System.out.println("Hahaha...");
        }
        catch(Exception ex){
            System.out.println("Exception in method()");
        }
    }
    
}
