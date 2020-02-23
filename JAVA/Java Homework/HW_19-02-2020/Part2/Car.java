package com.company;

/** Super Class*/
public class Car {
     int speed=120;
     double regularPrice= 40000.0;
     String color="RED";

    /** Creates a new instance of Car */
    public Car(){

    }

    public Car(double regularPrice, int speed, String color) {
        this.regularPrice = regularPrice;
        this.speed = speed;
        this.color = color;
    }
    double getSalePrice() {
       // sellPrice=regularePrice;
        System.out.println("Regular Price of Car is: "+regularPrice+
                "\t\tSpeed "+speed+
                "\t\tColor "+color);
        return 0;
    }



}





