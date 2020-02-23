package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Employee e1=new Employee();
        Employee e2=new Employee();

        Scanner sc=new Scanner(System.in);
        String first;
        String last;
        double salary;
//input
        System.out.printf("Enter First Name of Employee1: ");
        first=sc.next();
        e1.setFirstName(first);

        System.out.printf("Enter Last Name of  Employee1: ");
        last=sc.next();
        e1.setLastName(last);

        System.out.printf( "Enter Monthly Salary of  Employee1: " );
        salary=sc.nextDouble();
        e1.setSalary(salary);

        System.out.printf("\nEnter First Name of Employee2: ");
        first=sc.next();
        e2.setFirstName(first);
        System.out.printf("Enter Last Name of  Employee2: ");
        last=sc.next();
        e2.setLastName(last);

        System.out.printf( "Enter Monthly Salary of  Employee2: ");
        salary=sc.nextDouble();
        e2.setSalary(salary);
// Output
        System.out.println("\nFirst Employee's Full Name and Yearly Salary.");
        System.out.println( e1.getFirstName() + " " + e1.getLastName() + "  "
                + e1.getSalary() * 12 + "\n" );

        System.out.println("Second Employee's Full Name and Yearly Salary.");
        System.out.println( e2.getFirstName() + " " + e2.getLastName() + "  "
                + e2.getSalary() * 12 + "\n" );

        System.out.println("Displaying New Total Annual Salary After 10% Raise.");
        System.out.println( e1.getFirstName() + " "
                + e1.getLastName() + "  "
                + (e1.getSalary()*1.10 * 12 ));
        System.out.println( e2.getFirstName() + " "
                + e2.getLastName() + "  "
                + (e2.getSalary()*1.10 * 12 ));

    }
}
