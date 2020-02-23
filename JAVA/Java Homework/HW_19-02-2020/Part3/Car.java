package com.company;

public class Car {
    String model,color;
    double price;
    int year,seat;


    public Car(String model, String color, double price, int year, int seat) {
        this.model = model;
        this.color = color;
        this.price = price;
        this.year = year;
        this.seat = seat;
    }

    public Car() {

    }

    public String getModel() {
        model="Toyota";
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        color="White";
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        price = 50000.0;
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        year=2019;
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeat() {
        seat=4;
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }


    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", \tcolor='" + color + '\'' +
                ", \tprice= " + price +
                ", \tyear= " + year +
                ", \tseat= " + seat +
                "}";
    }
}
