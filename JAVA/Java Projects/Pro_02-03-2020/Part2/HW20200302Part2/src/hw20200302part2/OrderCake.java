
package hw20200302part2;

/**
 *
 * @author Say Rattana
 */
public class OrderCake extends Cake{
    private double weight;

    @Override
    public double calcPrice() {
        return rate * weight;
    }


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public OrderCake() {
    }

    public OrderCake(double weight) {
        this.weight = weight;
    }

    public OrderCake(double weight, String n, double r) {
        super(n, r);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "OrderCake\t{" + super.toString()+
                "\tWeight"+weight+
                "\tCalcPrice= " + calcPrice() + '}';
    }
    
    
    
}
