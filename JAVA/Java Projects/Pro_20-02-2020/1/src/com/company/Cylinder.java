package com.company;

import static java.lang.Math.pow;

public class Cylinder extends Circle {
    double height=1.0;
    double volume;

    public Cylinder() {
    }

    public Cylinder(double radius) {
        super(radius);
    }

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return pi*pow(radius, 2)*height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "Radius=" + radius +
                ", Color='" + color + '\'' +
                ", AreaOfCircle= " + getArea() +
                ", Height=" + height +
                ", Volume= " + getVolume() +
                '}';
    }
}
