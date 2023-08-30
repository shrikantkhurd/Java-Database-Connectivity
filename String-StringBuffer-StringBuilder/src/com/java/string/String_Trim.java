// String trim() method... remove space.
package com.java.string;

import java.util.*;
public class String_Trim 
{
	public static void main(String[] args) 
	{
		/*String s1="  Hello World ";
		
		System.out.println(s1+" Im shrikant."); // without using trim() method.
		//System.out.println("String s1 length : "+s1.length());
		
		s1=s1.trim();
		System.out.println(s1+"Im shrikant.");// using trim() method.
	//	System.out.println("String s1 length : "+s1.length());*/
		
		Scanner in=new Scanner(System.in);
		
		String s1;
		
		System.out.println("Enter String :");
		s1=in.nextLine();
		
		System.out.println("String :-"+s1);
		System.out.println("String length :"+s1.length());
		s1=s1.trim();
		System.out.println("After use trim method :");
		System.out.println("String :-"+s1);
		System.out.println("String length :"+s1.length());
	}
}
/* Output :-
Enter String :
Hello World  
String :-  Hello World  
String length :15
After use trim method :
String :-Hello World
String length :11
*/