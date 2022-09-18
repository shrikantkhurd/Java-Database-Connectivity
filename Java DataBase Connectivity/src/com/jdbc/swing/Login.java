package com.jdbc.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame 
{
	private JTextField textFieldUserName;
	private JPasswordField passwordField;
	public JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		Login login=new Login();
	
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		frame = new JFrame();
		frame.setBounds(100, 100, 632, 409);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLogIn.setBounds(251, 50, 112, 30);
		frame.getContentPane().add(lblLogIn);
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUserName.setBounds(84, 141, 123, 30);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPassword.setBounds(84, 203, 123, 30);
		frame.getContentPane().add(lblPassword);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldUserName.setBounds(232, 141, 149, 30);
		frame.getContentPane().add(textFieldUserName);
		textFieldUserName.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(232, 203, 149, 30);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String username = textFieldUserName.getText();
				String password = passwordField.getText();
				
				if(username.equals("shrikant") && password.equals("shrikant"))
				{
					passwordField.setText("");
					textFieldUserName.setText("");
					StudentDetails s=new StudentDetails();
					s.frame.setVisible(true);
					frame.setVisible(false);
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame,"invaid user name and password","login error",JOptionPane.ERROR_MESSAGE);
					passwordField.setText("");
					textFieldUserName.setText("");
				}
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnLogIn.setBounds(258, 270, 97, 30);
		frame.getContentPane().add(btnLogIn);
		
		
		
		
		frame.setVisible(true);

	}
}
