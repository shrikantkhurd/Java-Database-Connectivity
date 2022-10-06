package byteStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class CopyFileDemo {

	public static void main(String[] args) {
		FileOutputStream fos=null;
		FileInputStream fis=null;
		try 
		{	
			File file = new File("C:\\Users\\Admin\\Desktop\\File Handling\\File_one.txt"); 
	        fis = new FileInputStream(file);
	      
	        long len=file.length();
			int l=(int)len;     
	        byte arr[]=new byte[l];
	        int j=fis.read(arr);
			System.out.println("File size is: " +j);           
			String contents=new String(arr);
			System.out.println("File contents is: " +contents);
	     
	        fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\File Handling\\File_one_Copy.txt");
	       
	        /*int c = 0;
	        while((c!=-1)) {
	        c=fis.read();
	        if((c!=-1))
	        	fos.write(c);
	        fos.flush();
	        }
	        System.out.println("File copied.");
	        System.out.println("contents: "+c);*/ 
	        
	        for (int i=0;i<l;i++)
	        {
	           fos.write(arr[i]);
	        }       
	        System.out.println("File copied.");
	        contents=new String(arr);
			System.out.println("Copied contents is: " +contents);  
	       
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
				fis.close();
				fos.close();
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
