package Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDemo {

	public static void main(String[] args) {
		File file=new File("C:\\Users\\Admin\\Desktop\\File Handling\\demo.txt");
		//Scanner sc=null;
		try(Scanner sc=new Scanner(file);)
		{
	//	sc=new Scanner(file);
		while(sc.hasNext())
		{
			String s=sc.next();
			System.out.println(s+"***");
		}
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
