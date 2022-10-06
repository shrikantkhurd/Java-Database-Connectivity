package charcterStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		try 
		{
		File file=new File("C:\\Users\\Admin\\Desktop\\File Handling\\Charcter Stream.txt");
		long len=file.length();
		int l=(int)len;
		
			fr=new FileReader(file);
		int ch=0;
		while(ch!=-1)
		{
			ch=fr.read();
		if(ch!=-1)
			System.out.print((char)ch);
		}
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
				fr.close();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
