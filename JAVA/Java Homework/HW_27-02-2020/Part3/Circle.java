package hw20200227part3;

/**
 *
 * @author Say Rattana
 */
public class Circle extends GeometricObject{
    private double radius;

	public Circle() {
	}

	public Circle(double radius) {
		this.radius = radius;
	}

	public Circle(double radius, 
		String color, boolean filled) {
		this.radius = radius;
		setColor(color);
		setFilled(filled);
	}

	
	public double getRadius() {
		return radius;
	}

	
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override 
	public double getArea() {          
                       
		return radius * radius * Math.PI;
	}

	
	public double getDiameter() {
		return 2 * radius;
	}

	@Override 
	public double getPerimeter() {
		return 2 * radius * Math.PI;
	}

	@Override /** Implement the toString method in GeometricObject */
	public String toString() {
		return super.toString() + 
                        "\nDate created: " + getDateCreated() +
			"\nRadius: " + radius;
	}
    
}
