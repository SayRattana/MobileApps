package com.company;

public class Main {

    public static void main(String[] args) {

        /** For display default value of Circle.*/
                 Circle circle = new Circle();
       /** For assign new Circle, Please open below code and close above code.
        *  With 2 parameters.*/
                // Circle circle = new Circle(2.0,"Blue");

        /** For display default value of Cylinder.*/
               // Cylinder cylinder = new Cylinder();
        /** For assign new Cylinder, Please open below code and close above code.
         *  With 3 parameters.*/
                  Cylinder cylinder = new Cylinder(2.0,"White",4.0);

                  System.out.println(circle.toString()+" ==>> Show default value."+
                          "\n"+cylinder.toString()+" ==>> Show assign new value. ");
    }
}
