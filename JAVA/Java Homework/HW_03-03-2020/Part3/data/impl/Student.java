package aptech.data.impl;

import aptech.data.IStudent;
import java.util.*;

/**
 *
 * @author Say Rattana
 */
public class Student implements IStudent{
    private int id;
    private String studentName;
    private String className;
    private float price;
    private Scanner scanner = new Scanner(System.in);
    
    public Student() {
    }

    public Student(int id, String studentName, String className, float price) {
        this.id = id;
        this.studentName = studentName;
        this.className = className;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public void input() {
        System.out.print("\nEnter Student ID: ");
        this.id = scanner.nextInt();
        
        System.out.print("Enter Student Name: ");
        scanner = new Scanner(System.in);
        this.studentName = scanner.nextLine();
        
        System.out.print("Enter Class Name: ");
        scanner = new Scanner(System.in);
        this.className = scanner.nextLine();
        
        System.out.print("Enter Price: ");
        scanner = new Scanner(System.in);
        this.price = scanner.nextFloat();
    }

    @Override
    public void show() {
        System.out.println("\n\tStudent ID: " + this.id);
        System.out.println("\tStudent Name: " + this.studentName);
        System.out.println("\tClass Name: " + this.className);
        System.out.println("\tPice: $" + this.price);
       
    }
}
