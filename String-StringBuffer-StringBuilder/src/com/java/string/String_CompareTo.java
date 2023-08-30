// String CompareTo() method...

package com.java.string;

import java.util.*;


public class String_CompareTo 
{
	public static void main(String[] args) 
	{
		/*String s1="Hello";
		String s2="hello";
		s1.compareTo(s2);
		
		System.out.println("Both are not equals..");*/
		
		Scanner in=new Scanner(System.in);
		
		String s1;
		String s2;
		
		System.out.println("Enter first String :");
		s1=in.nextLine();
		
		System.out.println("Enter second String :");
		s2=in.nextLine();
		
		System.out.println("----Strings :----");
		System.out.println("First String : "+s1);
		System.out.println("First string length :"+s1.length());
		System.out.println("Second String : "+s2);
		System.out.println("Second string length :"+s2.length());
		
		if(s1.compareTo(s2)==0) //use compareTo String method..
		//	if(s1.equals(s2))	// use equals String method... 
		{
			System.out.println("Both string are same..");
		}
		else
		{
			System.out.println("Both string are not same..");
		}
	}
}
/* Output:-
Enter first String :
Hello World
Enter second String :
Hi World
----Strings :----
First String : Hello World
First string length :11
Second String : Hi World
Second string length :8
Both string are not same..	*/