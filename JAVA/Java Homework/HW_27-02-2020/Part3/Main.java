package hw20200227part3;
/**
 *
 * @author Say Rattana
 */
public class Main {
  
    public static void main(String[] args) {
        // Create two instances of ComparableCircle objects
            ComparableCircle comparableCircle1 = new ComparableCircle(15.5);
            ComparableCircle comparableCircle2 = new ComparableCircle(5.5);

            // Display comparableCircles and GeometricObject
            System.out.println("\nComparableCircle1:");
            System.out.println(comparableCircle1);

            System.out.println("\nComparableCircle2:");
            System.out.println(comparableCircle2);

            // Find and display the larger of the two ComparableCircle and Geometricobjects
            System.out.println((comparableCircle1.compareTo(comparableCircle2) == 1 
                    ? "\nComparableCircle1 " : "\nComparableCircle2 ") + 
                    "is the larger of the two Circles"+
                    (comparableCircle1.compareTo(comparableCircle2) == 1 
                    ? "\nGeometricObject1 " : "\nGeometricObject2 ") + 
                    "is the larger of the two GeometricObject");
	       System.out.println("\n hahaha...");  
        
    }
    
}
