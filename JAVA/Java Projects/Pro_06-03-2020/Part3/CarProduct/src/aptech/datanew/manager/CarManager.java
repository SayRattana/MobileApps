package aptech.datanew.manager;

import aptech.datanew.impl.Car;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Say Rattana
 */
public class CarManager {
    private Scanner scanner =new Scanner(System.in);
    private ArrayList<Car> cars = new ArrayList<Car>();
    
    public void addCar(){
        System.out.print("Number of Cars: ");
        int numOfCars = scanner.nextInt();
        for(int i = 0 ; i < numOfCars; i ++ ){
            Car car = new Car();
            car.input();
            this.cars.add(car);
        }
    }
    
    public void displayCar(){
        int i = 0;
        for(Car car: this.cars) {
            i++;
            System.out.println("Car: "+i);
            car.show();
        }
    }
    
     public void searchByCarName(String carName) {
        //search = filter        
        ArrayList<Car> result = 
        (ArrayList<Car>)this.cars.stream().filter(car -> {
            return car.getCarName().equalsIgnoreCase(carName);
        }).collect(Collectors.toList());
        
        //show result 
        if(result.isEmpty()) {
            System.err.println("Cannot find Car name : "+carName);
        } else {
            System.out.println("We found "+result.size()+" cars");
            for(Car car: result) {
                car.show();
            }
        }
    }
     
    public void deleteByCarName(String carName) {
    /* 
        //delete = remove / filter  
        this.cars.removeIf(car -> {
            return car.getCarName().equalsIgnoreCase(carName);
        });
    */
    /*
        //if the "condition's function"(lambda expression) has 1 LINE, let do as here
        this.cars.removeIf(car -> car.getCarName().equalsIgnoreCase(carName));
    */   
    
     ArrayList<Car> result = (ArrayList<Car>)this.cars
                .stream()
                .filter(eachCarName -> {
                        //this function return to true/false
                        return !eachCarName.getCarName().equalsIgnoreCase(carName);
                })
                .collect(Collectors.toList());
        if(result.size() < this.cars.size()) {            
            this.cars = result;
            System.out.println("Delete successfully !");
        } else {
            System.err.println("Cannot find car's name to delete: "+ carName);
        }
    
    
    
    
    
    
    }
    
     public void updatecar() {
        System.out.print("Enter Car's id to update: ");
        int id = scanner.nextInt();
        ArrayList<Car> result = 
        (ArrayList<Car>)this.cars.stream()
                .filter(car -> car.getCarID() == id)
                .collect(Collectors.toList());
        if(result.isEmpty()) {
            System.err.println("Cannot find car id= "+id+" to update");
        } else {
            Car foundCar = result.get(0);
            foundCar.isUpdate = true;
            foundCar.input();
        }        
    }
    
    
            
}
