package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer 
{
	DatagramSocket socket;
	DatagramPacket packet,packet1;
	
	public UDPServer() throws IOException
	{
		socket=new DatagramSocket(4567);
		System.out.println("---- Server Side ----");
		System.out.println("Server Running....");
		byte recpacket[]=new byte[200];
		packet=new DatagramPacket(recpacket, recpacket.length);
		socket.receive(packet);
		recpacket=packet.getData();
		String s=new String(recpacket);
		String s1=s.trim();
		System.out.println("Massage from client :"+s1);
		
		InetAddress clientAdd=packet.getAddress();
		int portno=packet.getPort();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter massage to send to client :");
		String s2=br.readLine();
		
		byte sendpacket[]=s2.getBytes();
		packet1=new DatagramPacket(sendpacket, sendpacket.length,clientAdd,portno);
		socket.send(packet1);
		
	}
	public static void main(String[] args) 
	{
		try {
			UDPServer server=new UDPServer();
			//client.UDPClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
