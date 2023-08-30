// StringBuiler delete() method. Is used to delete the string from specified startIndex and endIndex.

package com.java.StringBuilder;

import java.util.Scanner;

public class StringBuilder_delete 
{
	public static void main(String[] args) 
	{
		StringBuilder sb=new StringBuilder();
		Scanner in=new Scanner(System.in);
		
		try
		{
	/*	StringBuilder sb=new StringBuilder("Hello");
		
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
			System.out.println("String length :- "+sb.length());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
