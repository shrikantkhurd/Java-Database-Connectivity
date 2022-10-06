package byteStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadModeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis=null;
		try 
		{
		File file=new File("demo.txt");
		file.exists();
		fis=new FileInputStream(file);
		
		long len=file.length();
		int l=(int)len;

		byte arr[]=new byte[l];
		
		fis.read(arr);
		
		String contents=new String(arr);
		System.out.println(contents);
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
