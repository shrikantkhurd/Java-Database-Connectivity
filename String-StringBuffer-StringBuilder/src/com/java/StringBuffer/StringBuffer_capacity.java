// StringBuffer capacity() method....is used to return the current capacity.

package com.java.StringBuffer;
import java.util.*;
public class StringBuffer_capacity 
{
	public static void main(String[] args) 
	{
		StringBuffer sb=new StringBuffer();
		Scanner in=new Scanner(System.in);
		
		try
		{
			/*	StringBuffer sb=new StringBuffer();
			System.out.println("capacity : "+sb.capacity());
			sb.append("Hello");
			System.out.println("capacity : "+sb.capacity());
			sb.append("Hello java programmer..");
			System.out.println("capacity : "+sb.capacity());	*/
			
			//Take a user input..
			String s1,s2,s3;
			
			System.out.println("Defualt capacity of Stringbuffer :- "+sb.capacity());
		//	System.out.println("Empty String length :- "+sb.length());
			
			System.out.println("Enter a string : ");
			s1=in.nextLine();
			sb.append(s1);
			System.out.println("String :- "+s1);
			System.out.println("---Add new string in StringBuffer---");
			System.out.println("StringBuffer capacity :- "+sb.capacity());
		//	System.out.println("String length :- "+sb.length());
			
			System.out.println("Enter new string : ");
			s2=in.nextLine();
		//	sb.append(in.nextLine());
			sb.append(s2);
			System.out.println("String :- "+s2);
			System.out.println("---Add new string in StringBuffer---");
			System.out.println("StringBuffer  capacity :- "+sb.capacity());
		//	System.out.println("String length :- "+sb.length());
			System.out.println("append sb string is :- "+sb);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
/* Output :-
 Defualt capacity of Stringbuffer :- 16
Enter a string : 
Hello
String :- Hello
---Add new string in StringBuffer---
StringBuffer capacity :- 16
Enter new string : 
Hello Java Programmer.
String :- Hello Java Programmer.
---Add new string in StringBuffer---
StringBuffer  capacity :- 34	*/

