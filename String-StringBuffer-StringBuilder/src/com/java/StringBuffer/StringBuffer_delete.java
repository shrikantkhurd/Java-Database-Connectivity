// StringBuffer delete() method. Is used to delete the string from specified startIndex and endIndex.

package com.java.StringBuffer;

import java.util.*;
public class StringBuffer_delete 
{
	public static void main(String[] args) 
	{
		StringBuffer sb=new StringBuffer();
		Scanner in=new Scanner(System.in);
		
		try
		{
	/*	StringBuffer sb=new StringBuffer("Hello");
		
		//sb.deleteCharAt(2);		// delete single character
	//	System.out.println(sb);
		System.out.println("length "+sb.length());
		sb.delete(1, 3);			//	delete(int startIndex, int endIndex)
		System.out.println(sb);
		System.out.println("length "+sb.length());	
		sb.delete(1,sb.length()); 	//	delete(int startIndex, sb.length())
		System.out.println(sb);
		System.out.println("length "+sb.length());	*/
			
			//Take a user input.
			
			String s1;
			int i,j;
			
			System.out.println("Enter a string : ");
			s1=in.nextLine();
			sb=sb.append(s1);
			//sb.append(in.nextLine());
			System.out.println("String :- "+sb);
			System.out.println("String length :- "+sb.length());
			
			System.out.println("Enter start index number : ");
			i=in.nextInt();
			System.out.println("Enter end index number : ");
			j=in.nextInt();
			
			System.out.println("Before using delete method :- "+sb);
			sb=sb.delete(i, j);
		//	sb=sb.delete(i, sb.length());
			System.out.println("After using delete method :- "+sb);	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
/* Output :-
Enter a string : 
shri shrikant khurd
String :- shri shrikant khurd
String length :- 19
Enter start index number : 
0
Enter end index number : 
5
Before using delete method :- shri shrikant khurd
After using delete method :- shrikant khurd		*/
