// String contains() method.. Search the character in given string .

package com.java.string;

import java.util.*;

public class String_contains 
{
	public static void main(String[] args) 
	{	
		Scanner in=new Scanner(System.in);
		try
		{
		/*String s1="Hello im shrikant khurd.";
		
		if(s1.contains("shrikant"))
		{
			System.out.println("Present");
		}
		else
		{
			System.out.println("Not present");
		}*/
		
			String s1,s2;
			
			System.out.println("Enter string :");
			s1=in.nextLine();
			
			System.out.println("String is :- "+s1);
			
			System.out.println("Enter searching String :");
			s2=in.nextLine();
			
			System.out.println("String is :- "+s1);
			System.out.println("Searching string :- "+s2);
			
			if(s1.contains(s2))
			{
				System.out.println(s2+" is present in this string");
			}
			else
			{
				System.out.println(s2+" is Not present in this string");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
/* Output:-
Enter string :
Hello World..
String is :- Hello World..
Enter searching String :
Hello
String is :- Hello World..
Searching string :- Hello
Hello is present in this string		*/