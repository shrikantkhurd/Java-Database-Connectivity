package Assignment;
import java.util.Scanner;
import java.lang.*;

class MatrixDemo
{
public static void main(String args[])
{
int m,n,i,j;
Scanner in = new Scanner(System.in);
System.out.println("enter the number of rows of matrix");
m = in.nextInt();
System.out.println("enter the number of columns of matrix");
n = in.nextInt();

int first[][] = new int[m][n];
int second[][] = new int[m][n];
int result[][] = new int[m][n];

System.out.println("enter the elements of first matrix");
for(i= 0;i<m;i++) {
for(j= 0;j<n;j++) {
        first[i][j] = in.nextInt();
        System.out.print(first[i][j]+" ");
}
System.out.println();

}

System.out.println("enter the elements of second matrix");
for(i = 0;i<m;i++)
for(j= 0;j<n;j++)
        second[i][j] = in.nextInt();

System.out.println("1.Addition\n 2.Subtraction\n 3.Multiplication\n 4.Division \n enter your choice :");
int operator = in.nextInt();

switch(operator)
{

  case 1:
    //code for addition
    for(i = 0;i<m;i++)
      for(j= 0;j<n;j++)
         result[i][j] = first[i][j]+second[i][j]; 
         System.out.println("sum of the matrices:");
         for(i = 0;i<m;i++)
           {
               for(j= 0;j<n;j++)
                 System.out.print(result[i][j]+"\t");
                System.out.println(); 
            } 
        break;

  case 2:
    //code for subtraction
    for(i = 0;i<m;i++)
      for(j= 0;j<n;j++)
        result[i][j] = first[i][j]-second[i][j]; 
        System.out.println("sub of the matrices:");
         for(i = 0;i<m;i++)
          {
               for(j= 0;j<n;j++)
                System.out.print(result[i][j]+"\t");
                System.out.println(); 
           } 
        break;

    case 3:
        //code for multiplication
    for(i = 0;i<m;i++)
      for(j= 0;j<n;j++)
        result[i][j] = first[i][j]*second[i][j]; 
         System.out.println("mul of the matrices:");
          for(i = 0;i<m;i++)
           {
              for(j= 0;j<n;j++)
              System.out.print(result[i][j]+"\t");
              System.out.println(); 
            } 
         break;
  
   case 4:
      //code for division
      for(i = 0;i<m;i++)
        for(j= 0;j<n;j++)
            result[i][j] = first[i][j]/second[i][j]; 
              System.out.println("div of the matrices:");
               for(i = 0;i<m;i++)
               {
                 for(j= 0;j<n;j++)
                        System.out.print(result[i][j]+"\t");
                      System.out.println(); 
                } 
               break;

    default:
       System.out.println("Invalid choice"); 
       return;

 }
}
}
