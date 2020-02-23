#include <stdio.h>
#include <stdlib.h>

//1.Write a program to generate the Fibonacci series. (1,1,2,3,5,8,13,.........). 

int main(int argc, char *argv[]) {
int i, n, t1 = 0, t2 = 1, nextTerm;
    printf("Enter the number of terms: ");scanf("%d", &n);
    
    printf("Fibonacci Series: ");
    for (i = 1; i <= n; ++i) {
        printf("%d, ", t1);
        nextTerm = t1 + t2;
        t1 = t2;
        t2 = nextTerm;	
	}
	
	return 0;
}
