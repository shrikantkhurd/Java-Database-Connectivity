//StringBuffer replace() method... is used to replace the string from specified startIndex and endIndex.

package com.java.StringBuffer;

import java.util.*;
public class StringBuffer_replace 
{
	public static void main(String[] args) 
	{
		StringBuffer sb=new StringBuffer();
		Scanner in= new Scanner(System.in);
		
		try
		{
	/*	StringBuffer sb=new StringBuffer("Hello");
	  	System.out.println("length : "+sb.length());
		sb.replace(1,3, "java");
		System.out.println(sb);
		System.out.println("length : "+sb.length());	*/
		
			// Take a user input..
			String s1,s2,s3;
			int i,j;
			
			System.out.println("Enter a string : ");
			//s1=in.nextLine();
			
			sb=sb.append(in.nextLine());
			
			System.out.println("String :- "+sb);
			System.out.println("String length :- "+sb.length());
			
			System.out.println("Enter replace String : ");
			s2=in.nextLine();
			
			System.out.println("Enter new String : ");
			s3=in.nextLine();
			
			System.out.println("Enter start index number : ");
			i=in.nextInt();
			System.out.println("Enter end index number : ");
			j=in.nextInt();

			System.out.println("before using replace method :- "+sb);
			sb=sb.replace(i, j, s3);
			
			
			System.out.println("After using replace method :- "+sb);
			System.out.println("String length :- "+sb.length());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
/* Output :-
Enter a string : 
Hi Java Programmer.
String :- Hi Java Programmer.
String length :- 19
Enter replace String : 
Hi
Enter new String : 
Hello
Enter start index number : 
0
Enter end index number : 
2
before using replace method :- Hi Java Programmer.
After using replace method :- Hello Java Programmer.	*/