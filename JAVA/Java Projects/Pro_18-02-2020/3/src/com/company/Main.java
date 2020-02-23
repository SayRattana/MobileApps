package com.company;

public class Main {

    public static void main(String[] args) {

        Lamp lamp = new Lamp();

    // turn the lamp on
        lamp.toggleLamp();
        lamp.reportStatus();

    // turn it off again
        lamp.toggleLamp();
        lamp.reportStatus();
    }
}
