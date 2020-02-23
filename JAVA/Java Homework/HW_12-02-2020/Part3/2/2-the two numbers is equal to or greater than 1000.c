#include <stdio.h>
#include <stdlib.h>

/*
2.Write a program to accept 2 numbers and tell whether the product of the two numbers is equal to or greater than 1000.
*/

int main(int argc, char *argv[]) {
printf("2.Write a program to accept 2 numbers and tell whether \n  the product of the two numbers is equal to or greater than 1000.\n");
printf ("--------------------------------------------------------------\n\n");

int valueOne,valueTwo,product;
	printf("Input Value1=");scanf("%d",&valueOne);
  	printf("Input Value2=");scanf("%d",&valueTwo);
  
  	product=valueOne*valueTwo;
  	printf("The product of value1*value2 is. %d x %d = %d ",valueOne,valueTwo,product);
  
  if(product==1000){
    printf("\nProduct is equal to 1000");
  }
  else if(product>1000){
    printf("\nProduct is grater than 1000");
  }	
  
  else {
  	printf("\nProduct is less than 1000");
  }
	return 0;
}
