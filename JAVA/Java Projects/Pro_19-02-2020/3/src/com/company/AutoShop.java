package com.company;

public class AutoShop {
    public static void main(String[] args) {
        Car car = new Car("Luxus","White",60000.5,2020,6);
        Sedan sedan= new Sedan("BMW","Black",90000.0,2020,4);
            System.out.println(car.toString() +"\n"+sedan.toString() );
    }
}
