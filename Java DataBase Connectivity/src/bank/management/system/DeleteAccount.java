package bank.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class DeleteAccount extends JFrame {

	private JPanel p1;
	private JTextField textFieldDelete;
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;

public static void main(String[] args) {
	DeleteAccount d=new DeleteAccount();
}
	
	public DeleteAccount() 
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
		
		JLabel lblAccountDetails = new JLabel("Account Delete");
		lblAccountDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountDetails.setForeground(new Color(0, 0, 0));
		lblAccountDetails.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 26));
		lblAccountDetails.setBounds(312, 119, 268, 43);
		getContentPane().add(lblAccountDetails);
		
		JLabel lblEnterAccountNumber = new JLabel("Enter account number :-");
		lblEnterAccountNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAccountNumber.setForeground(Color.BLACK);
		lblEnterAccountNumber.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 20));
		lblEnterAccountNumber.setBounds(33, 237, 283, 36);
		getContentPane().add(lblEnterAccountNumber);
		
		textFieldDelete = new JTextField();
		textFieldDelete.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 20));
		textFieldDelete.setBounds(324, 237, 244, 36);
		getContentPane().add(textFieldDelete);
		textFieldDelete.setColumns(15);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBackground(new Color(0, 0, 255));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try(Connection con=DbConnect.connect())
				{
					String delete=textFieldDelete.getText();
					//	String account=Account_Number.getText();
					String query1="select * from account_details where Account_Number ="+ delete + "";
					stmt=con.createStatement();
					rs=stmt.executeQuery(query1);
						
						 if(rs.next())
						 {
							 String data1="delete from account_details where Account_Number = "+delete+"";
							 stmt=con.createStatement();
							 int n1=stmt.executeUpdate(data1);
						 }
						 
						 String query2="select * from account_information where Account_Number ="+ delete + "";
						 stmt=con.createStatement();
						 rs=stmt.executeQuery(query2);
						 if(rs.next())
						 {
							 String data2="delete from account_information where Account_Number = "+delete+"";
							 stmt=con.createStatement();
							 int n2=stmt.executeUpdate(data2);
						 }
						 
						 //JOptionPane.showMessageDialog(null,  " Account Deleted Successfully " );
						 System.out.println("Delete Successfully"+delete);
						 JOptionPane.showMessageDialog(getContentPane(), "Account Number :-  "+ delete + "\n Account Deleted Successfully ");
						 textFieldDelete.setText("");
					
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
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnDelete.setBounds(451, 333, 129, 36);
		getContentPane().add(btnDelete);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(0, 0, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				MainWindow main=new MainWindow();
				main.setVisible(true);
				setVisible(false);
				
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnBack.setBounds(312, 333, 108, 36);
		getContentPane().add(btnBack);
		
		setTitle("Bank management.");
		setVisible(true);
	}

}
