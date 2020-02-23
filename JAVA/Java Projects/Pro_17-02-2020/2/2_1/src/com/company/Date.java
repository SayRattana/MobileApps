package com.company;

import java.util.Scanner;

public class Date {
    Integer month;
    Integer day;
    Integer year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    // Create default constructor
        public Date() {

        }

    public int getMonth() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month:");
        month = scanner.nextInt();
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter day:");
        day = scanner.nextInt();
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year:");
        year = scanner.nextInt();
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }



    // for dislaly result.
    public void displayDate(){
        System.out.println("Your input date is: "+month+
                                       "/"+day+
                                       "/"+year);
    }
}
