package com.company;

public class Truck extends Car {
     int weight= 2500;
     double manufacturerDiscount;

    /** Creates a new instance of Truck */
    public Truck(double regularPrice, int speed, String color, int weight, int manufacturerDiscount) {
        super( regularPrice, speed, color);
        this.weight = weight;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public Truck() {

    }

    @Override
    double getSalePrice() {
        double x;
        if (weight>2000){
            x = regularPrice*0.1;
            manufacturerDiscount=regularPrice-x;
        }
        else {
            x= regularPrice*0.2;
            manufacturerDiscount=regularPrice-x;
        }
        System.out.println("The price after discount the truck = "+manufacturerDiscount);
        return 0;
    }

    public double getManufacturerDiscount(){
        double d = (double)( manufacturerDiscount / 100 );
        return d;
    }




}
