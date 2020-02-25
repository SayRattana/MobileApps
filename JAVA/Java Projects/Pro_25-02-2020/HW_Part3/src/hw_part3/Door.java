/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_part3;

/**
 *
 * @author HP01
 */
public class Door {
     String color;
    public Door() {
        
    }

    public Door(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void showData(){
        System.out.println("I am a door, my color is Brown "+ color);
    }
    
}
