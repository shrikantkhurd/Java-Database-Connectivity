//String length() method...
package com.java.string;

import java.util.*;
public class String_length {

	public static void main(String[] args) {
		
	/*	String s1="shrikant khurd";
		String s2="khurd";
		
		System.out.println("String s1 length is :-"+s1.length());
		System.out.println("String s1 length is :-"+s2.length());*/
		
		Scanner in=new Scanner(System.in);
		
		System.out.println("enter string :-");
		String name=in.nextLine();
		
		System.out.println("String length :-"+name.length());
	}
}
/* Output:-
enter string :-
Hello World.
String length :-12
*/