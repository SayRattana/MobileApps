package hw_part3;
/**
 *
 * @author Say Rattana
 */
public class Person {
      String name;
      House house;

    public Person() {
        name ="Say Rattana";
        house= new House(20);
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(House house) {
        this.house = house;
    }
    

    public Person(String name, House house) {
        this.name = name;
        this.house = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
    
    public void showData() {
        System.out.println("Myname is Mr." + this.name + 
                        ", myhouse area is: "+getHouse().area +" m2" );
        
    }   
}
