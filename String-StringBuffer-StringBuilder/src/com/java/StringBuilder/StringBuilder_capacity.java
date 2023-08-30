// StringBuilder capacity() method....is used to return the current capacity.

package com.java.StringBuilder;

import java.util.*;

public class StringBuilder_capacity 
{
	public static void main(String[] args) 
	{
		StringBuilder sb=new StringBuilder();
		Scanner in=new Scanner(System.in);
		
		try
		{
			/*	StringBuilder sb=new StringBuilder();
			System.out.println("capacity : "+sb.capacity());
			sb.append("Hello");
			System.out.println("capacity : "+sb.capacity());
			sb.append("Hello java programmer..");
			System.out.println("capacity : "+sb.capacity());	*/
			
			//Take a user input..
			String s1,s2,s3;
			
			System.out.println("Defualt capacity of StringBuilder :- "+sb.capacity());
		//	System.out.println("Empty String length :- "+sb.length());
			
			System.out.println("Enter a string : ");
			s1=in.nextLine();
			sb.append(s1);
			System.out.println("String :- "+s1);
			System.out.println("---Add new string in StringBuilderr---");
			System.out.println("StringBuilder capacity :- "+sb.capacity());
		//	System.out.println("String length :- "+sb.length());
			
			System.out.println("Enter new string : ");
			s2=in.nextLine();
		//	sb.append(in.nextLine());
			sb.append(s2);
			System.out.println("String :- "+s2);
			System.out.println("---Add new string in StringBuilder---");
			System.out.println("StringBuilder  capacity :- "+sb.capacity());
		//	System.out.println("String length :- "+sb.length());
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
