package com.company;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Invoice InvoiceOne = new Invoice();
        InvoiceOne.getNum();
        InvoiceOne.getItem();
        InvoiceOne.getQty();
        InvoiceOne.getPrice();
        InvoiceOne.invoiceAmount();
        InvoiceOne.DisplayInfo();
        

    }
}
