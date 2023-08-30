//String toUpperCase() method..(Capital letter.) convert lower case letter to upper case letter.(small letter to capital letter.)

package com.java.string;

import java.util.*;
public class String_toUpperCase 
{
	public static void main(String[] args) 
	{
		try
		{
			/*String s1="Hello World.";
			
			System.out.println(s1);
			
			s1=s1.toUpperCase();
			System.out.println(s1);*/
			
			Scanner in=new Scanner(System.in);
			
			String s1;
			
			System.out.println("Enter String :");
			s1=in.nextLine();
			System.out.println("lower case letters :-"+s1);
			
			s1=s1.toUpperCase();
			System.out.println("convert upper case :-"+s1);
			System.out.println("String length :"+s1.length());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
/* Output:-
 Enter String :
hello WORLD.
lower case letters :-hello WORLD.
convert upper case :-HELLO WORLD.
String length :12
*/
