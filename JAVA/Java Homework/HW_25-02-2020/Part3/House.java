/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw_part3;
/**
 *
 * @author Say Rattana
 */
public class House {
        Integer area;

    public House() {
       area =200;
    }

    public House(Integer area) {
        this.area = area;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
    Door door = new Door("Brown"); 
    public Door getDoor() {
        return door;
    }  
    
    public void showData(){
        System.out.println("I am a door, my color is: "+getDoor().getColor());
    }
    
}
