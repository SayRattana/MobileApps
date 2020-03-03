
package aptech.data.test;

import aptech.data.manager.StudentManager;
import java.util.*;

/**
 *
 * @author Say Rattana
 */
public class Test {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        System.out.println("--------- Choice menu ---------");
        System.out.println("1. Add New Students");
        System.out.println("2. Display All Students");
        System.out.println("3. Search Students By Class Name");
        System.out.println("4. Delete Students By Class Name");
        System.out.println("5. Exit");
        
        int choice = 0;
        while(choice != 5) {            
            //int choice = (new Scanner(System.in)).nextInt(); //this can prevent enter key
            //int choice = this.scanner; //NO, because scanner is "NON - static"
            System.out.print("Please choose(1,2,3,4,5): ");
            choice = scanner.nextInt();//ok because scanner is also "static"
           
            switch(choice) {
                    case 1:                        
                        studentManager.addStudent();                       
                        break;
                        
                    case 2:                      
                        studentManager.displayAllStudent();
                        break;
                        
                    case 3:                        
                        System.out.print("Enter Class's name to search : ");
                        String searchClassName = (new Scanner(System.in)).nextLine();                        
                        studentManager.searchByClassName(searchClassName);                       
                        break;
                        
                    case 4:
                        System.out.print("Enter class's name you want to DELETE ? ");
                        String deleteClassName = (new Scanner(System.in)).nextLine();
                        studentManager.deleteByClassName(deleteClassName);
                        studentManager.displayAllStudent();
                       
                        break;    
                    case 5:                      
                        System.out.println("you choose 5 exit");
                        break;
                    default:
                        
                        break;                
            }
       }
        System.out.println("End program");
    }

    }
    

