package com.company;

public class MyPoint {
    int x;
    int y;



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    MyPoint(double x, double y) {
        this.x = (int) x;
        this.y = (int) y;
    }



    public double distance(int x, int y) {
        int xDiff = this.x - x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }

    public double distance(MyPoint another) {
        int xDiff = (int) (this.x - another.getX());
        int yDiff = (int) (this.y - another.getY());
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

}

