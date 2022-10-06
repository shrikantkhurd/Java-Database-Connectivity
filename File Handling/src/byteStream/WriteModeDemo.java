package byteStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteModeDemo {
	
	
	public static void main(String[] args) 
	{
		FileOutputStream fos=null;
		try 
		{
			fos=new FileOutputStream("demo.txt");
			

			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			System.out.println("Enter the contents to write in file..");
			
			String contents=br.readLine();
			byte arr[]=contents.getBytes();
			fos.write(arr);
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
				fos.close();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
