#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */


int main(int argc, char *argv[]) {	
   
   	float centimeter;
	printf ("Enter centimeter ="); scanf ("%f",&centimeter);
  
		float feet = 0.0328 * centimeter;
   		float inch = 0.3937 * centimeter; 	
   	
   			printf ("\nConvert Centimeter to Feet is: %.1f \n", feet);
		   	printf ("Convert Centimeter to Inches is: %.1f \n", inch);
   		
	return 0;
}
