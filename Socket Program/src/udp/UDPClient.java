package udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPClient 
{
	DatagramSocket socket;
	DatagramPacket packet,packet1;
	
	public UDPClient() throws IOException
	{
		socket=new DatagramSocket();
		InetAddress add=InetAddress.getLocalHost();
		System.out.println("---- Client Side ----");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter massage to send to server :");
		String s=br.readLine();
		
		byte sendpacket[]=s.getBytes();
		packet=new DatagramPacket(sendpacket, sendpacket.length,add,4567);
		socket.send(packet);
		
		byte recpacket[]=new byte[200];
		packet1=new DatagramPacket(recpacket, recpacket.length);
		socket.receive(packet1);
		recpacket=packet1.getData();
		String s2=new String(recpacket);
		String s1=s2.trim();
		System.out.println("Massage from Server :"+s1);
	}
	
	public static void main(String[] args) 
	{
		try {
			UDPClient client=new UDPClient();
			//client.UDPClient();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
