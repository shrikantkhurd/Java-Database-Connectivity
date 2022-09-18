package bank.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class AccountDetails extends JFrame {

	private JPanel p1;
	Statement stmt;
	ResultSet rs;
	
	
	public AccountDetails(String Account_number) 
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
		
		JLabel lblAccountNumber = new JLabel("Account Number :-");
		lblAccountNumber.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblAccountNumber.setBounds(46, 82, 170, 26);
		getContentPane().add(lblAccountNumber);
		
		JLabel lblName = new JLabel("Name :-");
		lblName.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblName.setBounds(46, 122, 84, 26);
		getContentPane().add(lblName);
		
		try(Connection con=DbConnect.connect())
		{
			
			String data="select * from account_details where Account_Number='" + Account_number + "'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(data);
			
			while(rs.next())
			{
				String account_number=rs.getString("Account_Number");
				String name=rs.getString("Name");
				String father_name=rs.getString("Fathers_Name");
				String sur_name=rs.getString("Sur_Name");
				
				JLabel label_Account_Number = new JLabel(account_number);
				label_Account_Number.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
				label_Account_Number.setBounds(239, 82, 196, 26);
				getContentPane().add(label_Account_Number);
				
				JLabel label_Name = new JLabel( name+" "+father_name+ " "+sur_name  );
				label_Name.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
				label_Name.setBounds(239, 122, 230, 26);
				getContentPane().add(label_Name);
			}
		}
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnAccountInfo = new JButton("ACCOUNT INFO");
		btnAccountInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AccountInfo info=new AccountInfo(Account_number);
				info.setVisible(true);
				setVisible(false);
			}
		});
		btnAccountInfo.setForeground(Color.WHITE);
		btnAccountInfo.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnAccountInfo.setBackground(Color.BLUE);
		btnAccountInfo.setBounds(46, 195, 244, 50);
		getContentPane().add(btnAccountInfo);
		
		JButton btnWithdrawal = new JButton("CASH WITHDRAWL");
		btnWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Withdraw withdraw=new Withdraw(Account_number);
				withdraw.setVisible(true);
				setVisible(false);
			}
		});
		btnWithdrawal.setForeground(Color.WHITE);
		btnWithdrawal.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnWithdrawal.setBackground(Color.BLUE);
		btnWithdrawal.setBounds(606, 195, 274, 50);
		getContentPane().add(btnWithdrawal);
		
		JButton btnDiposit = new JButton("DEPOSIT");
		btnDiposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Deposit deposit=new Deposit(Account_number);
				deposit.setVisible(true);
				setVisible(false);
			}
		});
		btnDiposit.setForeground(Color.WHITE);
		btnDiposit.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnDiposit.setBackground(Color.BLUE);
		btnDiposit.setBounds(329, 195, 232, 50);
		getContentPane().add(btnDiposit);
		
		JButton btnCheckBalance = new JButton("CHECK BALANCE");
		btnCheckBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try(Connection con=DbConnect.connect())
				{
				
					String query="select * from account_information where Account_Number=" + Account_number +"";
					stmt=con.createStatement();
					rs=stmt.executeQuery(query);
					if(rs.next())
					{
				//	String account_number=rs.getString("Account_Number");
					String Balance=rs.getString("Balance");
					JOptionPane.showMessageDialog(getContentPane(), "Your Balance  :- "+ Balance);//+ "\n Account Number :" +account_number);	
					}
				//	ResultSet rs= cl.s.executeQuery("Select Balance from account_information ORDER BY Account_Number");
				//	String Balance=rs.getString("Balance");
				//	JOptionPane.showMessageDialog(null, "Your Balance  :- "+ Balance);
					
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
		btnCheckBalance.setForeground(Color.WHITE);
		btnCheckBalance.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnCheckBalance.setBackground(Color.BLUE);
		btnCheckBalance.setBounds(46, 284, 244, 50);
		getContentPane().add(btnCheckBalance);
		
		JButton btnExit = new JButton("Exit");
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
		btnExit.setBounds(707, 426, 131, 37);
		getContentPane().add(btnExit);
		
		JButton btnMiniStatement = new JButton("MONEY TRANSFER");
		btnMiniStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				MoneyTransfer money=new MoneyTransfer(Account_number);
				money.setVisible(true);
				setVisible(false);
			}
		});
		btnMiniStatement.setForeground(Color.WHITE);
		btnMiniStatement.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnMiniStatement.setBackground(Color.BLUE);
		btnMiniStatement.setBounds(606, 284, 274, 50);
		getContentPane().add(btnMiniStatement);
		
		JButton btnUpdateAccount = new JButton("UPDATE ACCOUNT");
		btnUpdateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				UpdateAccount update=new UpdateAccount(Account_number);
				update.setVisible(true);
				setVisible(false);
			}
		});
		btnUpdateAccount.setForeground(Color.WHITE);
		btnUpdateAccount.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnUpdateAccount.setBackground(Color.BLUE);
		btnUpdateAccount.setBounds(315, 284, 262, 50);
		getContentPane().add(btnUpdateAccount);
		
		setTitle("Bank management.");
		setVisible(true);
	}

}
