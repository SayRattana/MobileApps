package com.company;
import java.util.*;
public class Main {

    private static Matrix m1,m2,ans;
    public static void main(String[] args) {
        int i = 0, j = 0,r=0,c=0;
        Scanner scanner = new Scanner(System.in);

    //get the number of rows and columns of the matrix from the user
        System.out.println("Enter number of rows:");
        r = scanner.nextInt();

        System.out.println("Enter number of columns:");
        c = scanner.nextInt();

    //accept the first matrix
        System.out.println("Enter the first matrix:>>");
        m1 = new Matrix(r,c);
        m1.get_input();

    //accept the second matrix
        System.out.println("Enter the second matrix:>>");
        m2 = new Matrix(r,c);
        m2.get_input();

    //Add the 2 matrices and print the result
        ans = m1.add(m2);
        System.out.println("\nAddition of the two matrices is:>>");
        ans.print_matrix();

    //Suntract the 2 matrices and print the result
        ans = m1.sub(m2);
        System.out.println("\n\nSubtraction of the two matrices is:>>");
        ans.print_matrix();
    }
}
