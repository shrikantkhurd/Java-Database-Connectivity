package bank.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Deposit extends JFrame {

	private JPanel p1;
	private JTextField textDeposit;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	/*public static void main(String[] args) {
		new Deposit();
	}*/

	
	public Deposit(String Account_number) 
	{
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 550);
		getContentPane().setLayout(null);
		
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.BLUE);
		p1.setBounds(0, 0, 892, 74);
		getContentPane().add(p1);
		
		JLabel lblWelcome = new JLabel("WELCOME TO");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcome.setBounds(381, 10, 129, 22);
		p1.add(lblWelcome);
		
		JLabel lblBankOfMaharashtra = new JLabel("BANK OF MAHARASHTRA");
		lblBankOfMaharashtra.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBankOfMaharashtra.setForeground(Color.WHITE);
		lblBankOfMaharashtra.setBounds(291, 34, 309, 27);
		p1.add(lblBankOfMaharashtra);
		
		JLabel label = new JLabel("DEPOSIT");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(359, 86, 173, 43);
		getContentPane().add(label);
		
		JLabel lblAccountNumber = new JLabel("Account Number :-");
		lblAccountNumber.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		lblAccountNumber.setBounds(130, 141, 187, 34);
		getContentPane().add(lblAccountNumber);
		
		JLabel lblEnterAmount = new JLabel("ENTER AMOUNT YOU WANT");
		lblEnterAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAmount.setForeground(Color.BLACK);
		lblEnterAmount.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 28));
		lblEnterAmount.setBounds(186, 205, 477, 44);
		getContentPane().add(lblEnterAmount);
		
		JLabel lblToDeposit = new JLabel("TO DEPOSIT");
		lblToDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblToDeposit.setForeground(Color.BLACK);
		lblToDeposit.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 28));
		lblToDeposit.setBounds(335, 257, 221, 44);
		getContentPane().add(lblToDeposit);
		
		textDeposit = new JTextField();
		textDeposit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textDeposit.setColumns(10);
		textDeposit.setBounds(335, 314, 221, 35);
		getContentPane().add(textDeposit);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try(Connection con=DbConnect.connect())
				{
					String deposit=textDeposit.getText();
					
					String query="select Balance from account_information where Account_Number ="+ Account_number + "";
					stmt=con.createStatement();
					rs=stmt.executeQuery(query);
					 double balance = 0;
					 if(rs.next())
					 {
						 balance=rs.getDouble("Balance");
						 double d=Double.parseDouble(deposit);
                                                 
						 balance=balance+d;
                                                  
						 String q2="update  account_information set Balance= ('" + balance + "' ) where Account_Number =('" + Account_number + "' ) ";
						stmt=con.createStatement();
						int n1=stmt.executeUpdate(q2);
						if(n1>0)
						{
							System.out.println("Deposit Amount : "+deposit);
						JOptionPane.showMessageDialog(getContentPane(), "RS. "+ deposit + " Deposit Successfully ");
						textDeposit.setText("");
						}
					//	 String q1="update account_information set Balance ='" + (balance)  + "' where Account_Number '" + balance + "'";
					//	 cl.s.executeUpdate(q1);
					 }
					 
				/*	String deposit=textField_deposit.getText();
					
				ResultSet rs= cl.s.executeQuery("Select * from account_information where Balance");
				double balance=0;
			//	if(rs.next())
			//	{
					balance= rs.getDouble("Balance");
					double d= Double.parseDouble(deposit);
					balance=balance+d;
					
			*/
	
					
					
				
				
			
				}
				catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDeposit.setForeground(Color.WHITE);
		btnDeposit.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnDeposit.setBackground(Color.BLUE);
		btnDeposit.setBounds(268, 378, 139, 36);
		getContentPane().add(btnDeposit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AccountDetails acc=new AccountDetails(Account_number);
				acc.setVisible(true);
				setVisible(false);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnBack.setBackground(Color.BLUE);
		btnBack.setBounds(474, 378, 139, 36);
		getContentPane().add(btnBack);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MainWindow main=new MainWindow();
				main.setVisible(true);
				setVisible(false);
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnExit.setBackground(Color.BLUE);
		btnExit.setBounds(376, 437, 139, 36);
		getContentPane().add(btnExit);
		
		
		
		try(Connection con=DbConnect.connect())
		{
		String data="select * from account_details where Account_Number='" + Account_number + "'";
		stmt=con.createStatement();
		rs=stmt.executeQuery(data);
		
		while(rs.next())
		{
			String account_number=rs.getString("Account_Number");
			
			JLabel lblAccNum = new JLabel(account_number);
			lblAccNum.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblAccNum.setBounds(350, 142, 231, 33);
			//lblAccNum.setBounds(x, y, width, height);
			getContentPane().add(lblAccNum);
		
		}
	}
	catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
		
		
		
		
		
		setTitle("Bank management.");
		setVisible(true);
	}
}
