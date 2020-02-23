#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) {
/* EPC Excercise date 10-02-2020 Part3(2)
   Write a program to evaluate the area and perimeter of the rectangle.*/	
   
   
 // declare variable.  
 int len, bre, area, per;   
 
 printf("\nEnter the Length of Rectangle :"); scanf("%d",&len);
 printf("Enter the Breath of Rectangle :"); scanf("%d",&bre);  
 	area= len*bre;
 	per = (len+bre)*2;
 	
 printf("\nArea of Rectangle is : %d",area);
 printf("\nPerimeter of Rectangle is : %d",per); 
	
	return 0;
}
