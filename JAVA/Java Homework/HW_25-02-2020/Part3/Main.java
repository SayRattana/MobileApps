package hw_part3;
/**
 *
 * @author Say Rattana
 */
public class Main {
    public static void main(String[] args) { 
    // for information of person     
        Person myPerson = new Person();                     
        myPerson.showData();
        
    // for information of house and smallapartment area    
        SmallApartment mySmallApart = new SmallApartment();         
        mySmallApart.setArea(50);
        mySmallApart.showData();  
    
    // for information of color door     
        House myhouse = new House();         
        myhouse.showData();  
    }
    
}
