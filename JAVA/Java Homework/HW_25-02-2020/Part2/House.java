
package hw_part2;

/**
 *
 * @author Say Rattana
 */
public class House {
    Integer area;

    public House() {
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
    
   
    Door door = new Door("Light Blue"); 
    public Door getDoor() {
        return door;
    }  
    
    
    
    public void showData(){
        System.out.println("I am a house, my area is: "+this.area+
                "\nI am a door, my color is: "+getDoor().getColor());
    }
}
