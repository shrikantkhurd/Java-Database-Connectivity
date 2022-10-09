package tcp.com.client.server;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ChatClient extends JFrame {

	private JPanel p1;
	private JPanel p3;
	private JTextField textMsg;
	private static JTextArea textArea;
	private JButton btnSend;
	//public JFrame frame;
	
	static Socket socket;
	static InetAddress inetadd;
	static DataInputStream din;
	static DataOutputStream dout;
	static InputStreamReader in;
	static DataOutputStream out;
	static PrintWriter pw;
	
	public ChatClient() 
	{
		setBounds(100, 100, 450, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		p1 = new JPanel();
		p1.setLayout(null);
		//setContentPane(panel);
		p1.setBackground(new Color(7, 94,84));
		p1.setBounds(0, 0, 432, 49);
		getContentPane().add(p1);
		
		textMsg = new JTextField();
		textMsg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMsg.setBounds(8, 505, 300, 40);
		getContentPane().add(textMsg);
		textMsg.setColumns(10);
		
		JLabel lblServer = new JLabel("Client : Shrikant");
		lblServer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblServer.setForeground(Color.WHITE);
		lblServer.setBounds(12, 13, 180, 23);
		p1.add(lblServer);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		textArea.setBounds(10, 55, 412, 444);
		textArea.setEditable(false);
		getContentPane().add(textArea);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					String data=textMsg.getText();
					//textArea.setText(data);
					textArea.setText(textArea.getText()+"\n Client :\t"+data);
					dout.writeUTF(data);
					textMsg.setText("");
				}
				catch (Exception ex)
				{
					// TODO: handle exception
				}
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSend.setForeground(Color.WHITE);
		btnSend.setBackground(new Color(7, 94,84));
		btnSend.setBounds(313, 505, 112, 40);
		getContentPane().add(btnSend);
		
		setTitle("Chatting Application");
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ChatClient client=new ChatClient();
		client.setVisible(true);
		
		String msg="";
		try {
			inetadd= InetAddress.getLocalHost();
			socket=new Socket(inetadd, 8080);
			System.out.println("CLient : "+inetadd);
			System.out.println("---- Client Side ----");
			System.out.println("Connection Established.....");
			
			while(true)
			{
				din=new DataInputStream(socket.getInputStream());
				dout=new DataOutputStream(socket.getOutputStream());
				
			//	in=new InputStreamReader(socket.getInputStream());
			//	pw=new PrintWriter(socket.getOutputStream(),true);
				
				
				msg=din.readUTF();
				textArea.setText(textArea.getText()+" \n Server :\t"+msg);
			}
		} 
		catch (UnknownHostException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
