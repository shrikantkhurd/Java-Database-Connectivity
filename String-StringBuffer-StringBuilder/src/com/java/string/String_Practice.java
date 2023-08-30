/*Write a program that takes your full name as input and displays 
the abbreviations of the first and middle names except the last name which is displayed as it is.
For example, if your name is Robert Brett Roser, then the output should be R.B.Roser.	*/

package com.java.string;

import java.util.*;
public class String_Practice 
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		
		String st;
		
		System.out.println("Enter your full name :");
		st=in.nextLine();
		String sr="";
		sr=sr+st.charAt(0);
		sr=sr+". ";
		for(int i=0;i<st.length();i++)
		{
			if(st.charAt(i)==' ' && st.charAt(i+1)!=' ' && i+1<st.length())
			{
				sr=(sr+st.charAt(i+1)).toUpperCase();
				sr=sr+". ";
			}
		}
		String last_wrd="";
		for(int i=st.length()-1;i>=0;i--)
		{
			if(st.charAt(i)==' ')
			{
				last_wrd=st.substring(i+2);
				break;
			}
		}
		sr=sr.substring(0,sr.length()-2);
		sr=sr+last_wrd;
		System.out.println("Name :-"+sr);
	}
}
