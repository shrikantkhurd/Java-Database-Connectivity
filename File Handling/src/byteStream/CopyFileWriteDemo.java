package byteStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CopyFileWriteDemo {
	public static void main(String[] args) {
		FileOutputStream fos=null;
		try 
		{
			File file=new File("C:\\Users\\Admin\\Desktop\\File Handling\\File_one.txt");
			fos=new FileOutputStream(file);
			
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
