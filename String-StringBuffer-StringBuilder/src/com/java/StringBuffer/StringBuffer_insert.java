//StringBuffer insert() method... is used to insert the specified string with this string at the specified position.

package com.java.StringBuffer;

import java.util.*;
public class StringBuffer_insert 
{
	public static void main(String[] args) 
	{
	/*	StringBuffer sb=new StringBuffer("Hello");
		
		sb.insert(1, "Java");
		System.out.println(sb);	*/
		
		// Take a user input..
		
		StringBuffer sb=new StringBuffer();
		Scanner in=new Scanner(System.in);
		
		int i;	// StartIndex number.
		String s1,s2;
		
		try
		{
		System.out.println("Enter a string : ");
		s1=in.nextLine();
	//	sb.append(in.nextLine());
		sb=sb.append(s1);
		
		System.out.println("String :- "+s1);
		System.out.println("String length :- "+s1.length());
		
		System.out.println("Enter new string: ");
		s2=in.nextLine();
		System.out.println("String :- "+s2);
		
		System.out.println("Enter position to insert new string : ");
		i=in.nextInt();
		sb=sb.insert(i, s2);
		
		System.out.println("After using insert method :- "+sb);
		System.out.println("String sb length :- "+sb.length());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
/* Output:-
Enter a string : 
Hello 
String :- Hello 
String length :- 6
Enter new string: 
Java Programmer.
String :- Java Programmer.
Enter position to insert new string : 
6
After using insert method :- Hello Java Programmer.
String sb length :- 22		*/