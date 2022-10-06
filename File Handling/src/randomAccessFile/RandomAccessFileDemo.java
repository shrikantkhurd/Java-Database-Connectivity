package randomAccessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

	public static void main(String[] args) {
		RandomAccessFile readFile=null;
		try {
		File file=new File("C:\\Users\\Admin\\Desktop\\File Handling\\Charcter Stream.txt");
		
			readFile=new RandomAccessFile(file, "r");
			int len=(int)file.length();
			byte[] arr=new byte[len];
			readFile.read(arr);
			String contents=new String(arr);
			System.out.println(contents);
			System.out.println("------------------------");
			
			readFile.seek(5);
			readFile.read(arr);
			 contents=new String(arr);
			System.out.println(contents);
			/*int ch=0;
			while(ch!=-1)
			{
				ch=readFile.read();
				
			if(ch!=-1)
				System.out.print((char)ch);
			}*/
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
