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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MoneyTransfer extends JFrame {

	private JPanel p1;
	private JTextField textAccNum;
	Statement stmt;
	PreparedStatement pstmt;
	PreparedStatement pstmt1;
	ResultSet rs;
	private JTextField textAmount;
	
	
	public MoneyTransfer(String Account_number) 
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
		
		JLabel lblMoneyTrsnsfer = new JLabel("MONEY TRSNSFER");
		lblMoneyTrsnsfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblMoneyTrsnsfer.setForeground(Color.BLACK);
		lblMoneyTrsnsfer.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblMoneyTrsnsfer.setBounds(324, 86, 244, 43);
		getContentPane().add(lblMoneyTrsnsfer);
		
		JLabel lblEnterAccountNumber = new JLabel("Enter account number :-");
		lblEnterAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAccountNumber.setForeground(Color.BLACK);
		lblEnterAccountNumber.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblEnterAccountNumber.setBounds(33, 237, 283, 36);
		getContentPane().add(lblEnterAccountNumber);
		
		textAccNum = new JTextField();
		textAccNum.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 20));
		textAccNum.setBounds(324, 237, 244, 36);
		getContentPane().add(textAccNum);
		textAccNum.setColumns(15);
		
		JLabel lblEnterAmount = new JLabel("Enter Amount :-");
		lblEnterAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAmount.setForeground(Color.BLACK);
		lblEnterAmount.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblEnterAmount.setBounds(33, 313, 283, 36);
		getContentPane().add(lblEnterAmount);
		
		textAmount = new JTextField();
		textAmount.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 20));
		textAmount.setColumns(15);
		textAmount.setBounds(324, 313, 244, 36);
		getContentPane().add(textAmount);
		
		JLabel lblAccountNumber = new JLabel("Account Number :-");
		lblAccountNumber.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 18));
		lblAccountNumber.setBounds(130, 141, 187, 34);
		getContentPane().add(lblAccountNumber);
		
		JButton btnSend = new JButton("SEND");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Connection con=null;
				try
				{
					con=DbConnect.connect();
					con.setAutoCommit(false);
					
					String amount=textAmount.getText();
					
					String query1="update account_information set Balance=Balance-? where Account_Number=?";
					pstmt=con.prepareStatement(query1);
					pstmt.setString(1, amount);
					pstmt.setString(2, Account_number);
					
					int n1=pstmt.executeUpdate();
					System.out.println("No of rows affected"+n1);
					if(n1>0)
					{
						System.out.println("First opertion Succeded...");
					}
					
					
					String Acc_Num=textAccNum.getText();
					String acc="select Account_Number from account_details where Account_Number ="+ Acc_Num + "";
					stmt=con.createStatement();
					rs=stmt.executeQuery(acc);
					
					int n2 = 0;
					if(rs.next())
					{
				//	String Acc_Num=textAccNum.getText();
					String query2="update account_information set Balance=Balance+? where Account_Number=?";
					pstmt1=con.prepareStatement(query2);
					pstmt1.setString(1, amount);
					pstmt1.setString(2, Acc_Num);
					
					n2=pstmt1.executeUpdate();
					System.out.println("No of rows affected"+n1);
					if(n2>0)
						{
							System.out.println("Second opertion Succeded...");
						}
					}
					else
						{
							JOptionPane.showMessageDialog( getContentPane(),"Invalid Account number.");
							textAccNum.setText("");
							textAmount.setText("");
						}
					
					if(n1>0 && n2>0)
					{
						System.out.println(".....Total Transaction succeded.....");
						System.out.println("Withdraw Amount : "+amount);
						JOptionPane.showMessageDialog(getContentPane(), "RS. "+ amount + " Amount Transfer Successfully ");
						textAccNum.setText("");
						textAmount.setText("");
						con.commit();
					}
					else
					{
						System.out.println(".....Total Transaction failed.....");
						con.rollback();
						System.out.println("Transaction rollbacked....");
					}
					
					
				}
				catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (SQLException ex) {
					ex.printStackTrace();
					System.out.println("Operation failed...");
					try {
						con.rollback();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
		});
		btnSend.setForeground(Color.WHITE);
		btnSend.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnSend.setBackground(Color.BLUE);
		btnSend.setBounds(282, 388, 139, 36);
		getContentPane().add(btnSend);
		
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
		btnBack.setBounds(455, 388, 139, 36);
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
		}
	
		
}