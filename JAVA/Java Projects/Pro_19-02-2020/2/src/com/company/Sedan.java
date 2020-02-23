package com.company;

public class Sedan extends Car {
   int length = 25;
    double manufacturerDiscount;

    @Override
    double getSalePrice() {
        double x;
        if (length>20){
            x = regularPrice*0.05;
            manufacturerDiscount=regularPrice-x;
        }
        else {
            x= regularPrice*0.1;
            manufacturerDiscount=regularPrice-x;
        }
        System.out.println("The price after discount the  Sedan = "+manufacturerDiscount);

        return 0;
    }
}
