#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
/* EPC Excercise date 10-02-2020 Part3(3)
   Write a program to evaluate the volume of a cylinder.*/	
   
 int height,radius;
 double pie=3.14,volume;
 
 printf("Enter the height :"); scanf("%d",&height);
 printf("Enter the radius :"); scanf("%d",&radius);  
 
 	volume = pie*(radius*radius)*height;
 
 printf("The Volume of the cylinder is %lf",volume);   
	return 0;
}
