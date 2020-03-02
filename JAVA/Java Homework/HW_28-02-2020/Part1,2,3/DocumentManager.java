
package aptech.data;

import java.util.*;
import java.util.stream.Collectors;
/**
 *
 * @author Say Rattana
 */
public class DocumentManager {
     private ArrayList<Book> books = new ArrayList<Book>();
    private Scanner scanner = new Scanner(System.in);
    Book book=new Book();
    
    public void addDocument(){
        System.out.println("How many Books do you want to input : ");
        int numberOfBooks = this.scanner.nextInt();
        for(int i = 0; i < numberOfBooks; i++) {
            System.out.println("Book "+(i+1)); 
            
            System.out.print("Enter ID:");
            this.scanner = new Scanner(System.in);
            int id = this.scanner.nextInt();
            
            System.out.print("Enter BookName:");
            this.scanner = new Scanner(System.in);
            String bookName = this.scanner.next();
            
            System.out.print("Enter AuthorName:");
            this.scanner = new Scanner(System.in);
            String authorName = this.scanner.next();
            
            System.out.print("Enter Price:");
            this.scanner = new Scanner(System.in);
            float price = this.scanner.nextFloat();
            
            Book book=new Book(id,bookName,authorName,price);
            this.books.add(book);
        
    }
    }
    
    public void displayAllDocument(){
        book.show();
        int i = 0;
        for(Book book: this.books) {
            i++;
            System.out.println(i+"."+book.toString());
            
        }
    }
    
    public void searchByAuthorName(){
        System.out.println("Enter Author Name you want to SEARCH?");
        String searchAuthorName = this.scanner.next();
        ArrayList<Book> result = new ArrayList<>();
                for(Book book: books){
                   if(book.getAuthorName().equals(searchAuthorName)){
                     System.out.println(book);
                    }
                }

                 

    }
}
