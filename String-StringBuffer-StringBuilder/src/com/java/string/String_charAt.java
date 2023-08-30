//String charAt() method. search character position in string..

package com.java.string;

import java.util.*;
public class String_charAt 
{
	public static void main(String[] args) 
	{
		//try
		//{
		/*String s1="Shrikant";
		
		System.out.println("String :"+s1);
		char s=s1.charAt(5);
		System.out.println("index 4 charcater is :"+s);*/
			
			Scanner in=new Scanner(System.in);
			
			String s1;
			char ch;
			int i;
			try {
			
			System.out.println("Enter String :");
			s1=in.nextLine();
			
			System.out.println("String :-"+s1);
			System.out.println("String length :"+s1.length());
			
			
			System.out.println("Enter search index number :-");
			i=in.nextInt();
			System.out.println("Search index number is : "+i);
			
			ch=s1.charAt(i);
			System.out.println("index "+ i +" character is :-" +ch);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception found");
			System.out.println(e);
		}
	}
}
/* Output :-
Enter String :
Hello World.
String :-Hello World.
String length :12
Enter search index number :-
6
Search index number is : 6
index 6 character is :-W	*/