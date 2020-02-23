package com.company;

import java.util.Scanner;

public class Calculation {
    int a,b,c;
    int total,avg;

    public Calculation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public Calculation() {

    }

    public int getA() {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Input value a: ");
        a=scanner.nextInt();
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Input value b: ");
        b=scanner.nextInt();
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Input value c: ");
        c=scanner.nextInt();
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }


    public void displayResult(int a,int b,int c){
        this.total = a+b+c;
        System.out.println("\nSum of three integer = "+total);

        this.avg = total/3;
       System.out.println("Average = "+avg);


        if (a>b){
            System.out.println("Number "+a+" is largest of the value.");
        }else if (b>c){
            System.out.println("Number "+b+" is largest of the value.");
        }else if (c>a) {
            System.out.println("Number "+c+" is largest of the value.");
        }
        else {
            System.out.println("The three of the numbers is equals value.");
        }
    }

}
