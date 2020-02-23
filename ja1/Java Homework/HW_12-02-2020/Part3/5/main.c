#include <stdio.h>
#include <stdlib.h>

/*  
5.Write a program which takes name, basic , daper ( ie, percentage of D.A), 
bonper (ie, percentage bonus) and loandet ( loan amount to be debited) for an employee. 
Calculate the salary using the following relation:
salary = basic + basic * daper /100 +bonper * basic/100 -loandet
Calculate salary and then print the result under the following headings.
(Salary to be printed to the nearest dollar.).See the attachment file
*/

int main(int argc, char *argv[]) {
  	char name[100];
  	int basic,daper;
  	float bonper,loandet,salary; 
	   
	  	printf("Input Name:");		scanf("%s",&name); 
	    printf("Input Basic:");	scanf("%d",&basic);
	    printf("Input Daper:");	scanf("%d",&daper);
	    printf("Input Bonper:");	scanf("%f",&bonper); 
	    printf("Input Loandet:");	scanf("%f",&loandet);
      
      	salary=(float)basic + (float)basic * (float)daper/100 + bonper * (float)basic/100 - loandet;
     
	  	printf("\nThe Salary of this Employee is $ %.2f",salary);

	return 0;
}
