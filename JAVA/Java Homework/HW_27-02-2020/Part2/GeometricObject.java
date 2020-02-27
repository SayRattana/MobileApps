package hw20200227part2;

import java.util.Date;

/**
 *
 * @author Say Rattana
 */
public abstract class GeometricObject{
    String color;
    boolean filled;
    java.util.Date dateCreDate;
    
    abstract double getArea();
    abstract double getPerimeter();
    abstract double getDiameter();

     
    protected GeometricObject() {
        
    }

    protected GeometricObject(String color, boolean filled, Date dateCreDate) {
        this.color = color;
        this.filled = filled;
        this.dateCreDate = dateCreDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

   

    public Date getDateCreDate() {
        return dateCreDate;
    }

    @Override
    public String toString() {
        return "GeometricObject{" + "color=" + color + 
                ", filled=" + filled + 
                ", dateCreDate=" + dateCreDate + '}';
    }
    
}
