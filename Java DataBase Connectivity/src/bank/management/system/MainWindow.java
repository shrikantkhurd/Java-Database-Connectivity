package bank.management.system;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel p1;
	public JButton btnAccountDetails;
	public JButton btnAllAccountantsDetails;
	public JButton btnCreateAccount;
	public JButton btnDeleteAccount;
	public JButton btnLogOut;

	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	//public static void main(String[] args) {
//		MainWindow m=new MainWindow();
//	}
	
	
	public MainWindow() 
	{
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 550);
		getContentPane().setLayout(null);
		
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(Color.BLUE);
		p1.setBounds(0, 0, 892, 85);
		getContentPane().add(p1);
		
		JLabel lblWelcome = new JLabel("WELCOME TO");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcome.setBounds(381, 10, 129, 22);
		p1.add(lblWelcome);
		
		JLabel lblBankOfMaharashtra = new JLabel("BANK OF MAHARASHTRA");
		lblBankOfMaharashtra.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblBankOfMaharashtra.setForeground(Color.WHITE);
		lblBankOfMaharashtra.setBounds(291, 42, 309, 27);
		p1.add(lblBankOfMaharashtra);
		
		btnAccountDetails = new JButton("ACCOUNT DETAILS");
		btnAccountDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				AccountSearch searchAcc=new AccountSearch();
				searchAcc.setVisible(true);
				setVisible(false);
			}
		});
		btnAccountDetails.setForeground(Color.WHITE);
		btnAccountDetails.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnAccountDetails.setBackground(Color.BLUE);
		btnAccountDetails.setBounds(53, 312, 262, 50);
		getContentPane().add(btnAccountDetails);
		
		btnAllAccountantsDetails = new JButton("ALL ACCOUNTANT");
		btnAllAccountantsDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AllAccountDetails allAccount=new AllAccountDetails();
				allAccount.setVisible(true);
				setVisible(false);
			}
		});
		btnAllAccountantsDetails.setForeground(Color.WHITE);
		btnAllAccountantsDetails.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnAllAccountantsDetails.setBackground(Color.BLUE);
		btnAllAccountantsDetails.setBounds(461, 186, 262, 50);
		getContentPane().add(btnAllAccountantsDetails);
		
		btnCreateAccount = new JButton("CREATE ACCOUNT");
		btnCreateAccount.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) 
			{
								
				CreateAccount crtAcc=new CreateAccount();
				crtAcc.setVisible(true);
				setVisible(false);
			}
		});
		btnCreateAccount.setForeground(Color.WHITE);
		btnCreateAccount.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnCreateAccount.setBackground(Color.BLUE);
		btnCreateAccount.setBounds(53, 186, 262, 50);
		getContentPane().add(btnCreateAccount);
		
		btnDeleteAccount = new JButton("DELETE ACCOUNT");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				DeleteAccount deleteAcc=new DeleteAccount();
				deleteAcc.setVisible(true);
				setVisible(false);
			}
		});
		btnDeleteAccount.setForeground(Color.WHITE);
		btnDeleteAccount.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnDeleteAccount.setBackground(Color.BLUE);
		btnDeleteAccount.setBounds(461, 312, 262, 50);
		getContentPane().add(btnDeleteAccount);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Login login= new Login();
				login.frame.setVisible(true);
				setVisible(false);
			}
		});
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnLogOut.setBackground(Color.BLUE);
		btnLogOut.setBounds(317, 430, 148, 43);
		getContentPane().add(btnLogOut);
		
		setTitle("Bank management.");
		setVisible(true);
	}
}
