package com.company;

import java.util.Scanner;

public class Lamp {
    boolean lampOn = true;
    /**
     * Switch the light on and off.
     */
    void toggleLamp() {
        lampOn = !lampOn;
    }

    /**
     * Check the status of the lamp.
     */
    boolean getLampState() {
            return lampOn;

    }

    /**
      Print out the lamp's status to the console -- this is just for
     * convenience.
     */
    void reportStatus() {
        if (getLampState())
            System.out.println("The lamp is on.");
        else
            System.out.println("The lamp is off.");

/**
 * Open this code for lamp ON/OFF by press 0 or 1.
 */

/*
        int lamp;
        System.out.println("Press [0] for Lamp ON \nPress [1] for Lamp OFF");
        System.out.print("Please input number:");
        Scanner scanner = new Scanner(System.in);
                lamp=scanner.nextInt();

                if (lamp==0)
                    System.out.println("The lamp is ON.\n");
                else if (lamp==1)
                    System.out.println("The lamp is OFF.\n");
                else
                    System.out.println("You must be input 0 or 1 only.\n");
*/

    }
}
