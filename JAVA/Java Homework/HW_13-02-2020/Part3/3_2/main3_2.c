#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */


/*2.Write a program to generate the following pattern.
*******
******
*****
****
***
**
*
*/
int main(int argc, char *argv[]) {
	int i,j; 
		for(i=1;i<=7;i++){
			for(j=1;j<=7;j++){
		 		if(i<=j)
		 			printf ("*");
		 		else(" ");
		 		}
		 	printf ("\n");
		}	
	return 0;
}
