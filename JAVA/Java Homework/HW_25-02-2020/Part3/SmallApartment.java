package hw_part3;
/**
 *
 * @author Say Rattana
 */
public class SmallApartment extends House{
    private int area;

    public SmallApartment(int area) {
        this.area = area;
    }

    public SmallApartment() {
    }

    @Override
    public Integer getArea() {
        return area;
    }
    @Override
    public void setArea(Integer area) {
        this.area = area;
    }

    @Override
   public void showData(){
        System.out.println("I am a house, my area is: "+ super.area+ " m2"+
                "\nI am a Smallapartment, my area is: "+this.area +" m2");
    }
}
