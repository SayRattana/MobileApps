#include <stdio.h>
#include <stdlib.h>

/* 3.Write a program to display the following patterns.
1
12
123
1234
12345
AND:
12345
1234
123
12
1
*/
int main(int argc, char *argv[]) {

int i,j;   
    for(i=1;i<=5;i++){
     // print blank spaces. 
     	for(j=1;j>=5-j;j++)
  			printf(" ");
     // Display number in ascending order upto middle.
     	for(j=1;j<=i;j++)
		   	printf("%d",j);
			printf ("\n");			
	}
	
	printf("AND: \n");
		
	for(i=5;i>=1;i--){
     /* print blank spaces */
     	for(j=1;j>=5-j;j++)
  			printf(" ");
     /* Display number in ascending order upto middle*/
     	for(j=1;j<=i;j++)
		   	printf("%d",j);
			printf ("\n");
	}
getch();			
return 0;

}
