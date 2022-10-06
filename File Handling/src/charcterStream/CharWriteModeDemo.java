package charcterStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CharWriteModeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw=null;
		try 
		{
			
			fw=new FileWriter("C:\\Users\\Admin\\Desktop\\File Handling\\Charcter Stream.txt");

			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			System.out.println("Enter the contents to write in file..");
			
			String contents=br.readLine();
		//	char arr[]=contents.toCharArray();
		//	fw.write(arr);
			fw.write(contents);
			System.out.println("Save your content.");
			
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				fw.close();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
}
