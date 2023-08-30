// StringBuilder reverse() method..

package com.java.StringBuilder;

import java.util.Scanner;

public class StringBuilder_reverse 
{
	public static void main(String[] args) 
	{
		StringBuilder sb=new StringBuilder();
		Scanner in=new Scanner(System.in);
		
		try
		{
		/*	StringBuilder sb=new StringBuilder("java01");
			
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
