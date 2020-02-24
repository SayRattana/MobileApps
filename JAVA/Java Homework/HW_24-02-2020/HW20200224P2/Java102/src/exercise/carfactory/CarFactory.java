
package exercise.carfactory;


public class CarFactory {
   
    public static void main(String[] args) {
        Car carX = new Car("Mazida","Blue","Mr.Rattana");
        Car carY = new Car("Ferrari","Pink","Mr.Hoan");
        
        System.out.println("CarX " + carX.toString()+
                           "\nCarY "+ carY.toString());
        
    }
    
}
