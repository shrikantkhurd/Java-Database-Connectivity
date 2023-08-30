// String getChars() method. copies the content of this string into specified char array. 
//There are 4 arguments passed in getChars() method
// Syntax :- public void getChars(int srcBeginIndex, int srcEndIndex, char[] destination, int dstBeginIndex); 
package com.java.string;

import java.util.*;
public class String_getChars 
{
	public static void main(String[] args) 
	{
		String str = new String("hello javatpoint how r u");  
	      char[] ch = new char[30];  
	      try{  
	         str.getChars(6, 20, ch, 0);  
	         System.out.println(ch);  
	      }catch(Exception ex){
	    	  System.out.println(ex);
	    	  }  
	}

}
