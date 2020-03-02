package aptech.data;

import java.util.*;

/**
 *
 * @author Say Rattana
 */
public class Book implements IDocument{
    private int id;
    private String bookName;
    private String authorName;
    private float price;
    Scanner scanner = new Scanner(System.in);
    
    public Book() {
        this.id = 1;
        this.bookName = "Book IT";
        this.authorName = "Mr.Rattana";
        this.price = 50.0f;
    }

    public Book(int id, String bookName, String authorName, float price) {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        
        this.authorName = authorName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public void input() {
            System.out.print("Enter ID:");
            this.scanner = new Scanner(System.in);
            this.id = this.scanner.nextInt();
            
            System.out.print("Enter BookName:");
            this.scanner = new Scanner(System.in);
            this.bookName = this.scanner.next();
            
            System.out.print("Enter AuthorName:");
            this.scanner = new Scanner(System.in);
            this.authorName = this.scanner.next();
            
            System.out.print("Enter Price:");
            this.scanner = new Scanner(System.in);
            this.price = this.scanner.nextFloat();
        
           
    }
    
    @Override
    public void show() {
        System.out.println("BookID= "+this.id+
                            ",\tBookName= "+this.bookName+
                            ",\tAuthorName= "+this.authorName+
                            ",\tBookPrice= "+this.price);
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id +
                ", bookName=" + bookName 
                + ", authorName=" + authorName + 
                ", price=" + price + '}';
    }
    
}
