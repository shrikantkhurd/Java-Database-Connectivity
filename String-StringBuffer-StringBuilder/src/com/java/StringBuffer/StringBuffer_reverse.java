// StringBuffer reverse() method..

package com.java.StringBuffer;

import java.util.*;
public class StringBuffer_reverse 
{
	public static void main(String[] args) 
	{
		StringBuffer sb=new StringBuffer();
		Scanner in=new Scanner(System.in);
		
		try
		{
		/*	StringBuffer sb=new StringBuffer("java01");
			
			sb.reverse();
			System.out.println(sb);	*/
			
			// Take a user input.
			
			String s1;
			System.out.println("Enter a string : ");
			s1=in.nextLine();
			sb=sb.append(s1);
			
			//System.out.println("String :- "+s1);
			System.out.println("before using reverse method :- "+sb);
			sb=sb.reverse();
			System.out.println("After using reverse method :- "+sb);
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
/* Output:-
Enter a string : 
01 Java 01
before using reverse method :- 01 Java 01
After using reverse method :- 10 avaJ 10	*/