package com.company;

import static java.lang.Math.pow;

public class Circle {

    double radius =1.0;
    String color ="Red";
    double area;
    double pi = 3.14159;


    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return pi * pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "Radius=" + radius +
                ", Color='" + color + '\'' +
                ", Area= " + getArea()+
                '}';
    }
}
