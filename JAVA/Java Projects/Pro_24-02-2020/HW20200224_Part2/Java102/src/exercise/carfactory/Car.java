
package exercise.carfactory;


public class Car {
     String model,color,maker;

    public Car() {
    }
    

    public Car(String model,  String color ,String maker) {        
        
        this.model = model;
        this.color = color;
        this.maker = maker;
    }

    @Override
    public String toString() {
        return "is{" + "model=" + "\'"+ model+"\'"+
                "\t color=" + "\'"+ color +"\'"+ 
                "\t maker=" + "\'"+ maker +"\'" + '}';
    }
    
}
