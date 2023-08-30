// String getBytes() method. returns the byte array of the string. In other words, it returns sequence of bytes.

package com.java.string;

import java.util.*;
public class String_getBytes 
{
	public static void main(String[] args) 
	{
		/*String s1="AbCDEF";
		
		byte[] barr=s1.getBytes();  
		for(int i=0;i<barr.length;i++){  
		System.out.println(barr[i]);  
		} */ 
		
		Scanner in= new Scanner(System.in);
		
		String s1;
		System.out.println("Enter string :");
		s1=in.nextLine();
		
		byte[] barr=s1.getBytes();
		
		for(int i=0;i<barr.length;i++)
		{
			System.out.println(barr[i]);
		}
	}

}
