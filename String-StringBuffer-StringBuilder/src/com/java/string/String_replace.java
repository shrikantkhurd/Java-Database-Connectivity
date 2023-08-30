// String replace() method..

package com.java.string;

import java.util.*;
public class String_replace 
{
	public static void main(String[] args) 
	{
		try
		{
			//Java String replace(char old, char new) method
	/*	String s1="Hello";
		
		System.out.println(s1);
		//varibable_Name.replace(char oldChar, char newChar);
		s1=s1.replace('H','m'); // Replace single character.
		System.out.println(s1);
		
		
		//Java String replace(CharSequence target, CharSequence replacement) method
		String s2=" My World...";
		
		System.out.println(s2);
		
		//variable_Name.replace(CharSequence target, CharSequence replacement);  
		s2=s2.replace("My", "Our");
		System.out.println(s2);*/
			
			// Take a user input..
			Scanner in=new Scanner(System.in);
			
			String s1;
			String i;
			String j;
			
			System.out.println("Enter string : ");
			s1=in.nextLine();
			
			System.out.println("String :- "+s1);
			
			System.out.println("Enter replace String :");
			i=in.nextLine();
			
			System.out.println("Enter new String :");
			j=in.nextLine();
			
			System.out.println("Before using replace string :- "+s1);
			String s2=s1.replace(i, j);
			
			System.out.println("After using replace string is :- "+s2);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
/*	Output :-	
Enter string : 
hello WORLD.
String :- hello WORLD.
Enter replace String :
hello
Enter new String :
HELLO
Before using replace string :- hello WORLD.
After using replace string is :- HELLO WORLD.		*/