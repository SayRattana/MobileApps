#include <stdio.h>
#include <stdlib.h>

/* 
2.Accept values in three variables and print the highest value.
 */

int main(int argc, char *argv[]) {
	printf("Programe for accept values in three variables and print the highest value. \n\n");

	int n1, n2, n3;
    printf("Enter a value1=  "); scanf("%d", &n1);
    printf("Enter a value2=  "); scanf("%d", &n2);
    printf("Enter a value3=  "); scanf("%d", &n3);
	
		if (n1>n2)
			printf ("\nValue1= %d is the highest value.",n1);
			
		else if (n2>n3)
	        printf ("\nValue2= %d is the highest value.",n2);
	        	
	    else if (n3>n1)
	        printf ("\nValue3= %d is the highest value.",n3);
	        	
        else 
        	printf("\nThe three value is equal [%d]");
        	
	return 0;
}
