#include <stdio.h>
#include <stdlib.h>

/* 
4.Accept two numbers num1 and num2. 
Find the sum of all odd numbers between the two numbers entered.
*/

int main(int argc, char *argv[]) {
	printf("Accept two numbers num1 and num2.\nFind the sum of all odd numbers between the two numbers entered.\n\n");
	
int i, start, end, sum=0;
    /* Input range to find sum of odd numbers */
    printf("Enter start number: ");scanf("%d", &start);    
    printf("Enter end number: ");scanf("%d", &end);
    
    int x=start; // for use when display the result.

    /* If lower limit is even then make it odd */
    if(start % 2 == 0)
    {
        start++;
    }
    
    /* Iterate from start to end and find sum */
    for(i=start; i<=end; i+=2)
    {
        sum += i;
    }
    printf("Sum of odd numbers %d between %d = %d",x,end,sum);
	return 0;
}
