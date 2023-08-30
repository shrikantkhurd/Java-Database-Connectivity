//StringBuilder append() method...

package com.java.StringBuilder;

import java.util.Scanner;

public class StringBuilder_append 
{
	public static void main(String[] args) 
	{	
		/*	StringBuilder sb=new StringBuilder("Hello ");
		sb.append("java");
		System.out.println(sb);	*/
	
	// Take a user input..
	
		StringBuilder sb=new StringBuilder();
		Scanner in=new Scanner(System.in);
		
		String s1,s2;
	
		System.out.println("Enter a string :");
		//sb.append(in.nextLine());
		//System.out.println(sb);
		s1=in.nextLine();
		
		System.out.println("Enter second string : ");
		s2=in.nextLine();
		
		System.out.println("First string :- "+s1);
		System.out.println("Second string :- "+s2);
		
		 sb=sb.append(s1);
		 sb=sb.append(s2);
		 
		 System.out.println("After using append method :- "+sb);
	}
}
