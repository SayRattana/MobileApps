package hw20200227part3;

/**
 *
 * @author Say Rattana
 */
public abstract class GeometricObject {
    private String color = "while";
	private boolean filled;
	private final java.util.Date dateCreated;

	/** Construct a default geometric object */
	protected GeometricObject() {
		dateCreated = new java.util.Date();
	}

	/** Construct a geometric object with color and filled value */
	protected GeometricObject(String color, boolean filled) {
		dateCreated = new java.util.Date();
		this.color = color;
		this.filled = filled;
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

	
	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	
	public abstract double getArea();
	public abstract double getPerimeter();
    

        // Implement the compareTo method defined in Comparable
	public int compareToMax(GeometricObject o) {
		if (getArea() > o.getArea())
			return 1;
		else if (getArea() < o.getArea())
			return -1;
		else
			return 0;
	}



    @Override
    public String toString() {
        return "GeometricObject{" + "Color= " + color + 
                "\tFilled= " + filled + 
                "\tDateCreated= " + dateCreated +
                 "\tAreaGeometric: " + getArea()+'}';
    }
         
        
}

   




