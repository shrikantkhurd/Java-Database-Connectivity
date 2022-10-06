import java.io.*;
import java.util.Scanner;
 
 class StudentDetails {
    public String name[][] = new String[10][10];
    void getDetails(int n)
     {
        Scanner get = new Scanner(System.in);
        int limit=n;
        System.out.println("Enter "+limit+" Student Details\n");
 
        for(int i=0;i<limit;i++)
        {
            System.out.println("Enter Student #"+(i+1)+" Name, Roll Number & Marks:");
            for(int j=0;j<3;j++)
            {
                name[i][j] = get.nextLine();
            }
        }
         
        display(limit);
    }
 
    void display(int limit)
    {
        System.out.println("Student Name"+"\t"+"Roll"+"\t\t"+"Marks");
        for(int i=0;i<limit;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(name[i][j]+"\t\t");
            }
        System.out.println();
        }
    }
     
     

    public static void main(String args[]) throws IOException
    {   
        Scanner in  =  new Scanner(System.in);
        System.out.print("Enter Number of Students:");
        int n = in.nextInt();
        StudentDetails std = new StudentDetails();
        std.getDetails(n);
 
             
            PrintStream output = new PrintStream(new File("StudentDetails.txt"));
            output.println("Student Name"+"\t"+"Roll"+"\t\t"+"Marks");
            output.println("======================================");
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<3;j++)
                {
                    output.print(std.name[i][j]+"\t\t");
                }
            output.println();
            output.println("======================================");
            }
            output.close();
 
    }
}