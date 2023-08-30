//StringBuffer append() method...

package com.java.StringBuffer;

import java.util.*;
public class StringBuffer_append {

public static void main(String[] args) {
		
	/*	StringBuffer sb=new StringBuffer("Hello ");
		sb.append("java");
		System.out.println(sb);	*/
	
	// Take a user input..
	
		StringBuffer sb=new StringBuffer();
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
/* Output :-
Enter a string :
java 
Enter second string : 
Programmer.
First string :- java 
Second string :- Programmer.
After using append method :- java Programmer.	*/

