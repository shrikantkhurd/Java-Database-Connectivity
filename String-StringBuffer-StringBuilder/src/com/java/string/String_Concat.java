//String Concatenation concat() method.. combine two string..

package com.java.string;

import java.util.*;
public class String_Concat 
{
	public static void main(String[] args) 
	{
		/*String s1="Hello";
		String s2=" World";
		
		s1=s1.concat(s2);
		System.out.println(s1);*/
		
		Scanner in=new Scanner(System.in);
		
		String s1;
		String s2;
		String s3;
		
		System.out.println("Enter first String :");
		s1=in.nextLine();
		
		System.out.println("Enter second String :");
		s2=in.nextLine();
		
		System.out.println("First String : "+s1);
		System.out.println("First string length :"+s1.length());
		System.out.println("Second String : "+s2);
		System.out.println("Second string length :"+s2.length());
		
		s3=s1.concat(s2);
	//	s3=s1+(s2);
		
		System.out.println("After concatenation :-"+s3);
		System.out.println("After concatenation string length is :-"+s3.length());
	}
}
/* Output :-
Enter first String :
Hello
Enter second String :
 World..
First String : Hello
First string length :5
Second String :  World..
Second string length :8
After concatenation :-Hello World..
After concatenation string length is :-13	*/