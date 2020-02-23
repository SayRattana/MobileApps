#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
/*
3.Write a program to accept 2 numbers. Calculate the difference between the two values.
If the difference is equal to any of the values entered, 
then display the following message:Difference is equal to value <number of value entered>
If the difference is not equal to any of the values entered, 
display the following message:Difference is not equal to any of the values entered.
*/


int main(int argc, char *argv[]) {

int val1,val2,result;
	printf ("Enter value1="); scanf("%d",&val1);
	printf ("Enter value2 ="); scanf("%d",&val2);
	
	result =val1+val2;
	printf ("\nCalutate value1 and value2= %d",result);
	
	if(val1==val2){
		printf("\n\nThe value of value1 is equal to value2. %d = %d",val1,val2);
	}
	else{
		printf("\n\nThe value of value1 is not equal to value2. %d != %d",val1,val2);
	}


	return 0;	
}
