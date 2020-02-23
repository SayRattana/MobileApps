package com.company;
import java.io.*;
public class Book {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String book_name;
    int isbn;
    String author;
    String publisher;

    Book() {
        book_name = "jivan";
        isbn = 1000;
        author = "sarvajeet";
        publisher = "nilabh books";
    }

    public void getbook_name() throws IOException {
        System.out.printf("Enter book name");
        book_name = br.readLine();
    }

    public void getisbn() throws IOException {
        System.out.printf("Enter isbn number ");
        isbn = Integer.parseInt(br.readLine());
    }

    public void getauthor() throws IOException {
        System.out.printf("Enter author name");
        author = br.readLine();
    }

    public void getpublisher() throws IOException {
        System.out.printf("Enter publisher name");
        publisher = br.readLine();
    }

    public void setbook_name(String book) {
        this.book_name = book;
    }

    public void setisbn(int isbn) {
        this.isbn = isbn;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public void setpublisher(String publisher) {
        this.publisher = publisher;
    }

    public void displayinfo() {
        System.out.println("\nBook name " + book_name);
        System.out.println("ISBN number " + isbn);
        System.out.println("Author name " + author);
        System.out.println("Publisher name " + publisher);

    }
}
