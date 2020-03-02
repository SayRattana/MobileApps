
package hw20200302part3;

/**
 *
 * @author Say Rattana
 */
public class Main {
    public static void main(String[] args) {       
    //Instantiate 2 saving account objects saver1 and saver2
        SavingsAccount saver1 = new SavingsAccount (2000.0f);
        SavingsAccount saver2 = new SavingsAccount (3000.0f);

        System.out.println("Current month:");
        System.out.println("\tSaver 1 balance= $"+ saver1 +
                         "\n\tSaver 2 balance= $"+ saver2);           

    //Set the annual interest rate to 4% = 0.04
        SavingsAccount.modifyInterestRate (0.04);
        
        //Calculate monthly interest 
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        
        //Print out the new balances for both savers
        System.out.println("\nThis month interest rate to 4%:");
        System.out.println("\tSaver 1 balance= $"+ saver1.getSavingsBalance()+
                         "\n\tSaver 2 balance= $"+ saver2.getSavingsBalance());


    //Change annual interest rate to 5% = 0.05
        SavingsAccount.modifyInterestRate(0.05);
        
        //Calculate the next month interest rate and print out balances
        saver1.calculateMonthlyInterest();
        saver2.calculateMonthlyInterest();
        System.out.println("\nNext month interest rate to 5%:");
        System.out.println("\tSaver 1 balance= $"+ saver1.getSavingsBalance()+
                         "\n\tSaver 2 balance= $"+ saver2.getSavingsBalance());
        
    }   
}
