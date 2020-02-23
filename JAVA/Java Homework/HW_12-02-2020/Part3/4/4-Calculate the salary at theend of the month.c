#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */
/*
4.Calculate the salary at theend of the month. (Accept Salary and Grade from the user)
Write a program to evaluate the Grade of a student for the following constraints:
If marks > 75 –grade A
if 60 < marks < 75 –grade B
If 45 < marks<60 –grade C
If 35 < marks<45 -grade D
If marks < 35 –grade E
*/
int main(int argc, char *argv[]) {
 int marks;
      printf("Enter your marks: ");
      scanf("%d",&marks);
      if(marks>=75)
      {
          printf("Grade A");
      }
      else if(marks>60 && marks<75)
      {
          printf("Grade B");
      }
    else if(marks>45 && marks<=60)
      {
          printf("Grade C");
      }
    else if(marks>35 && marks<=45)
      {
          printf("Grade D");
      }
    else if(marks<=35)
      {
          printf("Grade E");
      }
	
	return 0;
}
