
package hw20200302part2;

import java.util.*;

/**
 *
 * @author Say Rattana
 */
public class CakeManager {
        Cake[] arr=new Cake[5];
        int i=0;
        Scanner sc=new Scanner(System.in);
        String opt;
        String name;
        double rate;
        float weight;
        int quantity;
        
        double totalPrice=0;
        double readyMadePrice=0;
        double maxPrice=-1;
        int maxIndex=0;
    
    
  public  void input(){       
  
        while(i<5) {
            System.out.println("Enter type of cake from below menu(1 or 2) for cake number "+(i+1));
            System.out.println("1.OrderCake");
            System.out.println("2.ReadyMadeCake");
            opt=sc.next();
        if(opt.equals("1")) {
                System.out.println("Enter name of cake");
                sc.nextLine();
                name=sc.nextLine();
                System.out.println("Enter rate of cake");
                rate=sc.nextDouble();
                System.out.println("Enter weight of cake");
                weight=sc.nextFloat();
                arr[i]=new OrderCake(weight, name, rate);
                totalPrice=totalPrice+arr[i].calcPrice();
                if(maxPrice<arr[i].calcPrice()) {
                    maxPrice=arr[i].calcPrice();
                    maxIndex=i;
                }
                i++;
        }
        else if(opt.equals("2")) {
                System.out.println("Enter name of cake");
                sc.nextLine();
                name=sc.nextLine();
                System.out.println("Enter rate of cake");
                rate=sc.nextDouble();
                System.out.println("Enter quantity of cake");
                quantity=sc.nextInt();
                arr[i]=new ReadyMadeCake(quantity,name,rate);
                totalPrice=totalPrice+arr[i].calcPrice();
                readyMadePrice=readyMadePrice+arr[i].calcPrice();
                    if(maxPrice<arr[i].calcPrice()) {
                        maxPrice=arr[i].calcPrice();
                        maxIndex=i;
                          i++;
                    }
        }
        else{
                System.out.println("Invalid input");
        }
        
        } 
  
  }
  
  public void show(){
        System.out.println("\nTotal price of cakes = $"+totalPrice);
            System.out.println("Total price of readymade cakes = $"+readyMadePrice);
            System.out.println("\nCake sold for highest price is below:");
            System.out.println(arr[maxIndex].toString());
        }
    }
      
  
  
  
  


