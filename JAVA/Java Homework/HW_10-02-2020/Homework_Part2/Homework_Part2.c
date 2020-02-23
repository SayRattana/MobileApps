#include <stdio.h>
#include <stdlib.h>
 
/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
/* EPC Excercise date 10-02-2020 Part2.
   Write a program to accept and add three number.*/
   	
//define 4 variables.
	int x,y,z,result;
	
//for input value x,y,z.	
	printf("Enter value x = "); scanf("%d", &x);
	printf("Enter value y = "); scanf("%d", &y);
	printf("Enter value z = "); scanf("%d", &z);
	
	result= x+y+z; // Addition 3 value.	
	printf("\nThe result of x+y+z is %d", result); // display the result value of x,y,z.
	
	return 0;
	
}
