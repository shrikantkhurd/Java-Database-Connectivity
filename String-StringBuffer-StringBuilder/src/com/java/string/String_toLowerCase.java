//String toLowerCase() method.(Small letter). convert upper case letter to lower case letter.(Capital letter to small letter.)

package com.java.string;

import java.util.*;
public class String_toLowerCase 
{
	public static void main(String[] args) 
	{
		try
		{
			/*String s1="HEllo WORLD.";
			
			System.out.println(s1);
			
			s1=s1.toLowerCase();
			System.out.println(s1);*/
			
			Scanner in=new Scanner(System.in);
			
			String s1;
			
			System.out.println("Enter String :");
			s1=in.nextLine();
			System.out.println("Upper case letters :-"+s1);
			
			s1=s1.toLowerCase();
			System.out.println("convert lower case :-"+s1);
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
HELLO world.
Upper case letters :-HELLO world.
convert lower case :-hello world.
String length :12
*/