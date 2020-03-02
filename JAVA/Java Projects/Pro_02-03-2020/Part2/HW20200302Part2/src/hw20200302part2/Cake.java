package hw20200302part2;

/**
 *
 * @author Say Rattana
 */
public abstract class Cake {
    protected String name;
    protected double rate;

    public Cake() {
    }

    public Cake(String n, double r) {
        this.name = n;
        this.rate = r;
    }
    
    public abstract double calcPrice();

    @Override
    public String toString() {
        return "name=" + name + "\trate=" + rate ;
    }


    
    
    
    
}
