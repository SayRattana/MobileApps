
package aptech.data.test;

import aptech.datanew.impl.Car;
import java.util.Scanner;

/**
 *
 * @author Say Rattana
 */
public class Test {
    public static void main (String [] args){
        Scanner scanner = new Scanner(System.in);
        
        int userChoice = -1;
        while(userChoice != 6) {
            System.out.println("1. Add new Car");
            System.out.println("2. Display All Cars");
            System.out.println("3. Search By Car name");
            System.out.println("4. Delete By Car name");
            System.out.println("5. Update car with id");
            System.out.println("6. Exit");
            System.out.print("\nEnter your choice : ");userChoice = scanner.nextInt();  
                       
            switch (userChoice){
                case 1:
                    System.out.println("You choice: 1.Add new Car");
                    break;
                    
                case 2:
                    System.out.println("You choice: 2.Display All Cars");
                                               
                    break;  
                    
                case 3:
                    System.out.println("You choice: 3.Search By Car name");
                    break;  
                    
                case 4:
                    System.out.println("You choice: 4.Delete By Car name");
                    break; 
                    
                case 5:
                    System.out.println("You choice: 5. Update car with id");
                    break;    
            }
        }
            System.out.println("This program is Ended.");
    }
}
