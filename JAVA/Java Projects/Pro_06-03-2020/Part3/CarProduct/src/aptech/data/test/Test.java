
package aptech.data.test;


import aptech.datanew.manager.CarManager;
import java.util.*;

/**
 *
 * @author Say Rattana
 */
public class Test {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        CarManager carmanager =new CarManager();
        
        int userChoice = -1;
        while(userChoice != 6) {
              System.out.println("------- Menu -------");
            System.out.println("1. Add new Car");
            System.out.println("2. Display All Cars");
            System.out.println("3. Search By Car name");
            System.out.println("4. Delete By Car name");
            System.out.println("5. Update car with id");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice : ");userChoice = scanner.nextInt();  
                       
            switch (userChoice){
                case 1:
                    carmanager.addCar();
                    break;
                    
                case 2:
                    carmanager.displayCar();
                                               
                    break;  
                    
                case 3:
                    System.out.print("Enter car's name to search: ");                                   
                    carmanager.searchByCarName(new Scanner(System.in).nextLine());
                    break;  
                    
                case 4:
                    System.out.print("Enter car's name to delete: ");
                    carmanager.deleteByCarName(new Scanner(System.in).nextLine());
                    break; 
                    
                case 5:
                                     
                    carmanager.updatecar();
                    break;   
//              default:
//                  System.err.println("Please choice 1 to 6");
//                  break;
            }
        }
            System.out.println("This program is Ended.");
    }
}
