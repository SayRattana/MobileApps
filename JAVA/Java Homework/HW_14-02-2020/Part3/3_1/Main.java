package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Book [] book = new Book [30];
        int i=0;
        System.out.printf("How many books info you want to store: ");
        int n = Integer.parseInt(br.readLine());
        System.out.printf("you want to give the values by get method or set method \nEnter 1 for get method. \nEnter 2 for set method.");
        int ch = Integer.parseInt(br.readLine());
        try
        {
            if(ch==1)
            {
                for(i=0;i<n;i++)
                {
                    System.out.printf("\nEnter %d book Details:\n",i+1);
                    book[i]=new Book();
                    book[i].getbook_name();
                    book[i].getisbn();
                    book[i].getauthor();
                    book[i].getpublisher();
                }
            }
            else
            {
                book[i]=new Book();
                book[i].setbook_name("Java Programming");
                book[i].setisbn(0001);
                book[i].setauthor("Rattana Say");
                book[i].setpublisher("Cambodia");
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        for(i=0;i<n;i++)
        {
            book[i].displayinfo();
            System.out.println();
        }
    }
}

