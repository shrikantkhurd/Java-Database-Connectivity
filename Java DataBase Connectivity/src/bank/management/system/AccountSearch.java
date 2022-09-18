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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AccountSearch extends JFrame 
{

	private JPanel p1;
	private JTextField textField_Accountno;
	Statement stmt;
	ResultSet rs;
	
	/*public static void main(String[] args) {
		AccountSearch acc= new AccountSearch();
	
	}*/

	public AccountSearch() 
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
		
		JLabel lblAccountDetails = new JLabel("Account details");
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
		
		textField_Accountno = new JTextField();
		textField_Accountno.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 20));
		textField_Accountno.setBounds(324, 237, 244, 36);
		getContentPane().add(textField_Accountno);
		textField_Accountno.setColumns(15);
		
		
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBackground(new Color(0, 0, 255));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try(Connection con=DbConnect.connect())
				{
					
					String Account_number=textField_Accountno.getText();
					String data="Select *from account_details where Account_Number ="+Account_number+"";
					stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(data);
					
					if(e.getSource()==btnSubmit)
					{
						if(rs.next())
						{
							AccountDetails detailAcc=new AccountDetails(textField_Accountno.getText());
							detailAcc.setVisible(true);
							setVisible(false);
						}
						else
						{
							JOptionPane.showMessageDialog( getContentPane(),"Invalid Account number.");
							textField_Accountno.setText("");
						}
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
		});
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnSubmit.setBounds(451, 333, 129, 36);
		getContentPane().add(btnSubmit);
		
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
