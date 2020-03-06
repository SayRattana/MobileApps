package aptech.datanew.impl;

import aptech.datanew.ICar;
import java.util.Scanner;

/**
 *
 * @author Say Rattana
 */
public class Car implements ICar{
    private int carID;
    private String carName;
    private String color;
    private int yearModel;
    private float price;
    public Boolean isUpdate = false;
    private Scanner scanner =new Scanner(System.in);

    public Car() {
    }

    public Car(int carID, String carName, String color, int yearModel, float price) {
        this.carID = carID;
        this.carName = carName;
        this.color = color;
        this.yearModel = yearModel;
        this.price = price;
    }

   

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearModel() {
        return yearModel;
    }

    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public void input() {
        if(isUpdate == false) {
            System.out.print("\nEnter Car ID: ");
            this.carID = this.scanner.nextInt();
        }
        System.out.print("Enter Car Name: ");
        this.scanner = new Scanner(System.in);
        this.carName = this.scanner.nextLine();
        
        System.out.print("Enter Color: ");
        this.scanner = new Scanner(System.in);
        this.color = this.scanner.nextLine();
        
        System.out.print("Enter Year Model: ");
        this.scanner = new Scanner(System.in);
        this.yearModel = this.scanner.nextInt();
        
        System.out.print("Enter Car Price: ");
        this.scanner = new Scanner(System.in);
        this.price = this.scanner.nextFloat();
               
    }

    @Override
    public void show() {
        System.out.println("\tCar ID: "+this.carID);
        System.out.println("\tCar Name: "+this.carName);
        System.out.println("\tCar Color: "+this.color);
        System.out.println("\tCar Year Model: "+this.yearModel);
        System.out.println("\tCar Price: $"+this.price + "\n");
    }   
    
}
