#include <stdio.h>
#include <stdlib.h>

/* 3.Write a program to print the series 100, 95 , 90, 85,.........., 5 */

int main(int argc, char *argv[]) {
// for loop
	int i;
		for(i=100;i>=5;i=i-5){
			printf("%d \n",i);
		}	
	
/*	
// while loop	
	int i=100;
	    while(i>=5){
	      printf("%d \n",i);
	      i=i-5;
	    }
*/

			/*	    
			// do while loop
				int i=100;
					do{
						printf("%d \n",i);
						i=i-5;
					}
					 while(i>=5);
			*/	      
	
	return 0;
}
