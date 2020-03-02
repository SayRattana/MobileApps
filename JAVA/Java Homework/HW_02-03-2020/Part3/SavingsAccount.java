package hw20200302part3;

/**
 *
 * @author Say Rattana
 */
public class SavingsAccount {
    private static double annualInterestRate = 0.0f;
    private double savingsBalance = 0.0f;

    public SavingsAccount() {
    }
    
    public  SavingsAccount(double savingsBalance) {
        setSavingsBalance(savingsBalance);
    }
   
    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }
       
    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    
    // update the interest rate
    public static void modifyInterestRate(double newInterestRate){
        // check for negative interest rates
        if(newInterestRate >= 0.0f)
            annualInterestRate = newInterestRate;
        else
            throw new IllegalArgumentException("interest rate must be >= 0.0f");
    }
 
    public static double getAnnualInterestRate(){
        return annualInterestRate;
    }
    // calculates the monthly interest and update the savings balance
        public void calculateMonthlyInterest(){
            savingsBalance += (savingsBalance * annualInterestRate) / 12;
        }
    // return savingsBalance as string
   @Override
    public String toString(){
        return String.format("%.2f",getSavingsBalance());
    }
    
    
    
}
