#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
/* 
1.Write a program that asks for your first name and last name, 
and then prints the names in the format last name, first name.
*/

int main(int argc, char *argv[]) {
 	char firstname[25];
    char lastname[50];
    
    printf("What is your first name? \n ");scanf("%s",&firstname);    
    printf("What is your last name? \n ");scanf("%s",&lastname);
    
    printf("\nYour name is %s %s.\n",lastname,firstname);

	return 0;
}
