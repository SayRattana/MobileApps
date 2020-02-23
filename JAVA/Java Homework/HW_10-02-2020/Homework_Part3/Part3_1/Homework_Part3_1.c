#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
/* EPC Excercise date 10-02-2020 Part3(1)
   Write a program to evaluate the expression.*/	

// declare the variable and assign value.	
int a=10,b=7,d=4,e=2;
float c=15.75,f=5.6,z=0;	
	z=a*b+(c/d)-e*f;		
	
	printf("\n%d*%d+(%f/%d)-%d*%f=%f\n",a,b,c,d,e,f,z); // display the result.
	
	return 0;
}
