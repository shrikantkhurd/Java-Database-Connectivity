package PrintWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class PrintWriterDemo {

	public static void main(String[] args) {
		String name;
		int age;
		float sal;
		Scanner sc=new Scanner(System.in);
		
		
		File file=new File("Employee.txt");
	//	PrintWriter pw=null;
		
		try (PrintWriter pw=new PrintWriter(file))
		{
			pw.printf("\n     Name               Age            Salary");
			while(true)
			{
			System.out.println("--- Employee Details ---");
			System.out.println("Enter  name");
			 name=sc.next();
			System.out.println("Enter age");
			age=sc.nextInt();
			System.out.println("Enter salary");
			sal=sc.nextFloat();
		//	pw=new PrintWriter(file);
			pw.print(name);
			pw.print(age);
			pw.print(sal);
			
			
			pw.printf("\n %s         %d         %f",name, age,sal); 
			pw.print("\n");
		//	pw.printf("\n Name: %s, Age: %d, Salary: %f", name,age,sal);
			System.out.println("Save File.");
			pw.flush();
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
