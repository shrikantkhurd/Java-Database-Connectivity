package Scanner;

import java.util.Scanner;
import java.util.StringTokenizer;

public class StringTokenizerDemo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name :");
		String name=sc.next();
		StringTokenizer st = new StringTokenizer(name,"-");  
	     while (st.hasMoreElements()) {  
	         System.out.println(st.nextElement());  
	     }  

	}

}
