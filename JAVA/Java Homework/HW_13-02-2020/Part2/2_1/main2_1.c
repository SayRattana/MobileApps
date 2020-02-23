#include <stdio.h>
#include <stdlib.h>

/*
1.Write a program to show your computer’s capabilities. The user types in a letter of the alphabet and your program should display the corresponding language 
or package available. Some sample input and output is given below(see the attachment file)
You can use if...else or switch...case
 */

int main(int argc, char *argv[]) {
char alphabet;
    printf("PRESS [A or a] for ADA, [B or b] for Basic,\nPRESS [C or c] for Cobol, [D or d] for dBaseIII,\nPRESS [F or f] for Fortran, [P or p] for Pascal,\nPRESS [V or v] for Visual C++. \n\n");
    
	printf("Enter an alphabet: ");scanf("%c",&alphabet);
    
    switch(alphabet)
    {
        case 'a':
            printf("Ada \n");
            break;
    case 'A':
            printf("Ada \n");
            break;
        case 'b':
            printf("Basic \n");
            break;
    case 'B':
            printf("Basic \n");
            break;
        case 'c':
            printf("Cobol \n");
            break;
    case 'C':
            printf("Cobol \n");
            break;
        case 'd':
            printf("dBaseIII \n");
            break;
    case 'D':
            printf("dBaseIII \n");
            break;
   		case 'f':
            printf("Fortran \n");
            break;
    case 'F':
            printf("Fortran \n");
            break;   
    	case 'p':
            printf("Pascal \n");
            break;
    case 'P':
            printf("Pascal \n");
            break;   
    	case 'v':
            printf("Visual C++ \n");
            break;
    case 'V':
            printf("Visual C++ \n");
            break;      
        
        default:
            printf("Please Enter Alphabet: A,a,B,b,C,c,D,c,F,f,P,p and V,v. \n");
    }
	return 0;
}
