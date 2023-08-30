// String IsEmpty() method...

package com.java.string;

import java.util.*;
public class String_IsEmpty 
{
	public static void main(String[] args) 
	{
		/*String s1="Hello";
		String s2="";
		
		System.out.println(s1.isEmpty());
		System.out.println("String s1 length :"+s1.length());
		System.out.println(s2.isEmpty());
		System.out.println("String s1 length :"+s2.length());*/
		
		Scanner in=new Scanner(System.in);
		
		String s1;
		
		
		System.out.println("Enter String :");
		s1=in.nextLine();
		
		System.out.println("String :-"+s1);
		System.out.println("String length :"+s1.length());
		
		System.out.println("");
		if(s1.isEmpty())
		{
			System.out.println("String is empty..");
		}
		else
		{
			System.out.println("String is not empty..");
		}
	}
}
/* Output:-
Enter String :
Hello
String :-Hello
String length :5

String is not empty..

Enter String :

String :-
String length :0

String is empty..	*/