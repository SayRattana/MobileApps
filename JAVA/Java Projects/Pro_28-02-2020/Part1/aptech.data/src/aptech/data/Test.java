package aptech.data;
/**
 *
 * @author Say Rattana
 */
import java.util.*;
public class Test {

    public static void main(String[] args) {
        DocumentManager documentManager=new DocumentManager();
             
        int userChoice;
        while(true){
            System.out.print("------------------MENU-----------------------");
            System.out.print("\nENTER YOUR CHOICE" );
            System.out.println("\n\t1. Add New Books"
                            + "\n\t2. Display All Books"
                            + "\n\t3. Search Books By Author Name"
                            + "\n\t4. Exit");
            
        System.out.print("\nEnter Your Menu Choice:");
        Scanner scanner = new Scanner(System.in);
        userChoice = new Scanner(System.in).nextInt();      
        
            switch(userChoice){
            case 1:
                documentManager.addDocument();
                documentManager.displayAllDocument();
                break;

            case 2: 
                documentManager.displayAllDocument();
                break;

            case 3:
                documentManager.searchByAuthorName();
               
                break;

            case 4: 
                System.out.println("Exiting Program...");
                System.exit(0);
                break;

            default :
                System.out.println("This is not a valid Menu Option! Please Select Another");
                break;
     
            }
        }
    }
}
       
    

