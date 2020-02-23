#include <stdio.h>
#include <stdlib.h>

/*Declare two variables x and y. Assign values to these variables.
Number x should be printed only if it is less than 2000 or greater than 3000,
and number y should be printed only if it is between 100 and 500. */

int main(int argc, char *argv[]) {
	
int x,y;
    printf("Input x =");scanf("%d",&x);
	    if(x<2000 || x>3000){
	        printf("x = %d\n",x);
	    }
	    
	printf("Input y =");scanf("%d",&y);
	    if(y>=100 && y<=500){
	        printf("y = %d",y);
	    }
    	
return 0;
}
