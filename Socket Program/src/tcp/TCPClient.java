package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient 
{
	Socket socket;
	InetAddress inetadd;
	BufferedReader userin;
	BufferedReader socketRead;
	PrintWriter pw;
	
	public TCPClient() throws IOException 
	{
		inetadd= InetAddress.getLocalHost();
		socket=new Socket(inetadd,8080);
		System.out.println("CLient : "+inetadd);
		System.out.println("---- Client Side ----");
		System.out.println("Connection Established.....");
		
		
		userin=new BufferedReader(new InputStreamReader(System.in));
		pw=new PrintWriter(socket.getOutputStream(),true);
		socketRead=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	public void communicate() throws IOException
	{
		while(true)
		{
			System.out.println("Enter massege to send to server:");
			String msg=userin.readLine();
			pw.println(msg);
			
			String msg1=socketRead.readLine();
			System.out.println("massege from server: "+msg1);
		}
	}

	public static void main(String[] args) 
	{
		try  
		{
			TCPClient client= new TCPClient();
			client.communicate();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
