package com.company;

import java.util.*;
public class Matrix {
    private double[][] mat;
    int row, column;

// default constructor
    Matrix()
    {
        row=0;
        column=0;
    }

//constructor
    Matrix(int r, int c)
    {
        row = r;
        column = c;
        mat = new double[row][column];
    }

//function to accept matrix values from user
    public void get_input()
    {
        Scanner scanner = new Scanner(System.in);
        int i=0,j=0;

        System.out.println("Enter the matrix elements(row-wise)");
        for (i=0; i < row; i++)
        {
            for(j=0; j<column; j++)
            {
                mat[i][j] = scanner.nextDouble();
            }

        }
    }

//function to print matrix
    public void print_matrix()
    {
        int i = 0, j = 0;
        System.out.print("The matrix is:>>");
        for (i = 0; i < row; i++)
        {
            System.out.println("");
            for (j = 0; j < column; j++)
            {
                System.out.print("   "+mat[i][j]);
            }

        }
    }

//function to add 2 matrices
    public Matrix add(Matrix matrix)
    {
        Matrix ans = new Matrix(row,column);
        int i=0,j=0;
        if (this.row != matrix.row || this.column != matrix.column)
        {
            System.out.println("ERROR: The two matrices should have same no. of rows and columns for addition!");
        }
        else
        {
            for (i = 0; i < row; i++)
            {
                for (j = 0; j < column; j++)
                {
                    ans.mat[i][j] = this.mat[i][j] + matrix.mat[i][j];
                }
            }
        }
        return ans;
    }

//function to subtract 2 matrices
    public Matrix sub(Matrix m1)
    {
        Matrix ans = new Matrix(row,column);
        int i=0,j=0;
        if (this.row != m1.row || this.column != m1.column)
        {
            System.out.println("ERROR: The two matrices should have same no. of rows and columns for subtraction!");
        }
        else
        {
            for (i = 0; i < row; i++)
            {
                for (j = 0; j < column; j++)
                {
                    ans.mat[i][j] = this.mat[i][j] - m1.mat[i][j];
                }
            }
        }
        return ans;
    }
}
