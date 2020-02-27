package hw20200227part3;
/**
 *
 * @author Say Rattana
 */
public class Main {
  
    public static void main(String[] args) {
        // Create two instances of ComparableCircle objects
		ComparableCircle comparableCircle1 = new ComparableCircle(12.5);
		ComparableCircle comparableCircle2 = new ComparableCircle(18.3);

		// Display comparableCircles
		System.out.println("\nComparableCircle1:");
		System.out.println(comparableCircle1);
		System.out.println("\nComparableCircle2:");
		System.out.println(comparableCircle2);

		// Find and display the larger of the two ComparableCircle objects
		System.out.println((comparableCircle1.compareTo(comparableCircle2) == 1 
			? "\nComparableCircle1 " : "\nComparableCircle2 ") + 
			"is the larger of the two Circles");
	
    }
    
}
