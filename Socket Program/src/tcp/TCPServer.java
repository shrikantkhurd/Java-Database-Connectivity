
package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer 
{
	ServerSocket ss;
	Socket socket;
	InetAddress inetadd;
	BufferedReader userin;
	BufferedReader socketRead;
	PrintWriter pw;
	
	public TCPServer() throws IOException 
	{
		ss=new ServerSocket(8080);
		System.out.println("---- Server Side ----");
		System.out.println("Server Running....");
		socket=ss.accept();
		System.out.println("Server ready to communicate.");
		inetadd= InetAddress.getLocalHost();
		System.out.println("Client name : "+inetadd);
		
		socketRead=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		userin=new BufferedReader(new InputStreamReader(System.in));
		pw=new PrintWriter(socket.getOutputStream(),true);
	}
	public void communicate() throws IOException
	{
		while(true)
		{
			String msg=socketRead.readLine();
			System.out.println("massege from client: "+msg);
			
			System.out.println("Enter massege to send to client:");
			String msg1=userin.readLine();
			pw.println(msg1);
		}
	}
	public static void main(String[] args) 
	{
		try  
		{
			TCPServer server= new TCPServer();
			server.communicate();
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
