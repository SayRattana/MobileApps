
package hw20200302part1;

/**
 *
 * @author Say Rattana
 */
public class ReadyMadeCake extends Cake{
    private int quantity;
    
    @Override
    public  double calcPrice() {
        return rate * quantity;  
    }

    public ReadyMadeCake() {
    }

    public ReadyMadeCake(int quantity) {
        this.quantity = quantity;
    }

    public ReadyMadeCake(int quantity, String n, double r) {
        super(n, r);
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ReadyMadeCake\t{"+ super.toString()+
               "\tquantity"+quantity+
                 "\tCalcPrice " + calcPrice() + '}';
    }
    
     
    
    
}
