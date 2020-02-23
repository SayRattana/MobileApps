package com.company;

import java.io.*;
public class Invoice {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String num;
    String iterm;
    int qty;
    double price;
    double amount;

    public String getNum() throws IOException {
        System.out.printf("Enter code of items:");
        num=br.readLine();
        return num;
    }
    public String getItem() throws IOException {
        System.out.printf("Enter name of items:");
        iterm=br.readLine();
        return iterm;
    }
    public int getQty() throws IOException {
        System.out.printf("Enter of quantity:");
        qty=Integer.parseInt(br.readLine());
        return qty;
    }
    public double getPrice() throws IOException {
        System.out.printf("Enter price of items:");
        price=Double.parseDouble(br.readLine());
        return price;
    }
    public String setNum(String num)
    {
        this.num=num;
        return num;
    }
    public String setIterm(String iterm)
    {
        this.iterm=iterm;
        return iterm;
    }
    public int setQty(int qty)
    {
        this.qty=qty;
        return qty;
    }
    public double setPrice(double price )
    {
        this.price=price;
        return price;
    }
    public double invoiceAmount()
    {
        amount = qty*price;
        return amount;
    }
    public void DisplayInfo()
    {
        System.out.printf("\n\nCode items: " + num +
                "\nName items: "+ iterm +
                "\nQTY: " + qty +
                "\nPRICE: "+ price +
                "\nTotal amount: " + amount +"\n");

    }
}