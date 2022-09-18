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
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.SwingConstants;

public class CreateAccount extends JFrame {

	private JPanel p1;
	private JTextField textField_Name;
	private JTextField textField_Fathername;
	private JTextField textField_Surname;
	private JTextField textField_Address;
	private JTextField textField_City;
	private JTextField textField_Pincode;
	private JTextField textField_State;
	private JTextField textField_Mobileno;
	private JTextField textField_Email;

	PreparedStatement pstmt;
	PreparedStatement pstmt1;
	Statement stmt;
	ResultSet rs;
	private JTextField textField_Accountno;
	
	public CreateAccount() 
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
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateAccount.setForeground(Color.BLACK);
		lblCreateAccount.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		lblCreateAccount.setBounds(344, 76, 204, 26);
		getContentPane().add(lblCreateAccount);
		
		JLabel lblName = new JLabel("Name :-");
		lblName.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblName.setBounds(52, 117, 84, 26);
		getContentPane().add(lblName);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Name.setBounds(246, 115, 215, 26);
		getContentPane().add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblFathersName = new JLabel("Father's Name :-");
		lblFathersName.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblFathersName.setBounds(52, 156, 154, 26);
		getContentPane().add(lblFathersName);
		
		textField_Fathername = new JTextField();
		textField_Fathername.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Fathername.setColumns(10);
		textField_Fathername.setBounds(246, 154, 215, 26);
		getContentPane().add(textField_Fathername);
		
		JLabel lblSurName = new JLabel("Sur Name :-");
		lblSurName.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblSurName.setBounds(52, 195, 154, 26);
		getContentPane().add(lblSurName);
		
		textField_Surname = new JTextField();
		textField_Surname.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Surname.setColumns(10);
		textField_Surname.setBounds(246, 197, 215, 26);
		getContentPane().add(textField_Surname);
		
		JLabel lblGender = new JLabel("Gender  :-");
		lblGender.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblGender.setBounds(52, 237, 154, 26);
		getContentPane().add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		rdbtnMale.setBounds(246, 238, 67, 25);
		getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		rdbtnFemale.setBackground(Color.WHITE);
		rdbtnFemale.setBounds(321, 238, 87, 25);
		getContentPane().add(rdbtnFemale);
		
		JLabel lblAddress = new JLabel("Address :-");
		lblAddress.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblAddress.setBounds(495, 115, 95, 26);
		getContentPane().add(lblAddress);
		
		textField_Address = new JTextField();
		textField_Address.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Address.setColumns(30);
		textField_Address.setBounds(602, 117, 237, 26);
		getContentPane().add(textField_Address);
		
		JLabel lblCity = new JLabel("City :-");
		lblCity.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblCity.setBounds(495, 156, 95, 26);
		getContentPane().add(lblCity);
		
		textField_City = new JTextField();
		textField_City.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_City.setColumns(10);
		textField_City.setBounds(602, 156, 215, 26);
		getContentPane().add(textField_City);
		
		JLabel lblPin = new JLabel("Pin Code :-");
		lblPin.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblPin.setBounds(495, 195, 108, 26);
		getContentPane().add(lblPin);
		
		textField_Pincode = new JTextField();
		textField_Pincode.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Pincode.setColumns(10);
		textField_Pincode.setBounds(602, 195, 215, 26);
		getContentPane().add(textField_Pincode);
		
		JLabel lblState = new JLabel("State :-");
		lblState.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblState.setBounds(495, 234, 95, 26);
		getContentPane().add(lblState);
		
		textField_State = new JTextField();
		textField_State.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_State.setColumns(10);
		textField_State.setBounds(602, 237, 215, 26);
		getContentPane().add(textField_State);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth :-");
		lblDateOfBirth.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblDateOfBirth.setBounds(52, 276, 154, 26);
		getContentPane().add(lblDateOfBirth);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblNewLabel.setBounds(246, 282, 48, 16);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox_Date = new JComboBox();
		comboBox_Date.setMaximumRowCount(10);
		comboBox_Date.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox_Date.setBounds(282, 279, 41, 25);
		getContentPane().add(comboBox_Date);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblMonth.setBounds(332, 283, 48, 16);
		getContentPane().add(lblMonth);
		
		JComboBox comboBox_Month = new JComboBox();
		comboBox_Month.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
		comboBox_Month.setMaximumRowCount(10);
		comboBox_Month.setBounds(381, 279, 87, 25);
		getContentPane().add(comboBox_Month);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 14));
		lblYear.setBounds(476, 282, 48, 16);
		getContentPane().add(lblYear);
		
		JComboBox comboBox_Year = new JComboBox();
		comboBox_Year.setModel(new DefaultComboBoxModel(new String[] {"1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		comboBox_Year.setMaximumRowCount(10);
		comboBox_Year.setBounds(516, 279, 87, 25);
		getContentPane().add(comboBox_Year);
		
		JLabel lblMarital_status = new JLabel("Marital Status :-");
		lblMarital_status.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblMarital_status.setBounds(52, 315, 154, 26);
		getContentPane().add(lblMarital_status);
		
		JRadioButton rdbtnMarried = new JRadioButton("Married");
		rdbtnMarried.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		rdbtnMarried.setBackground(Color.WHITE);
		rdbtnMarried.setBounds(250, 316, 95, 25);
		getContentPane().add(rdbtnMarried);
		
		JRadioButton rdbtnUnmarried = new JRadioButton("Unmarried");
		rdbtnUnmarried.setFont(new Font("MS Reference Sans Serif", Font.PLAIN, 16));
		rdbtnUnmarried.setBackground(Color.WHITE);
		rdbtnUnmarried.setBounds(349, 316, 112, 25);
		getContentPane().add(rdbtnUnmarried);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number :-");
		lblMobileNumber.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblMobileNumber.setBounds(52, 348, 166, 26);
		getContentPane().add(lblMobileNumber);
		
		textField_Mobileno = new JTextField();
		textField_Mobileno.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Mobileno.setColumns(10);
		textField_Mobileno.setBounds(246, 350, 215, 26);
		getContentPane().add(textField_Mobileno);
		
		JLabel lblEmailI = new JLabel("Email Address :-");
		lblEmailI.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblEmailI.setBounds(52, 387, 154, 26);
		getContentPane().add(lblEmailI);
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Email.setColumns(30);
		textField_Email.setBounds(246, 389, 297, 26);
		getContentPane().add(textField_Email);
		
		JButton btnNewBack = new JButton("BACK");
		btnNewBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				MainWindow main=new MainWindow();
				main.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewBack.setBackground(new Color(0, 0, 255));
		btnNewBack.setForeground(new Color(255, 255, 255));
		btnNewBack.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnNewBack.setBounds(321, 436, 108, 37);
		getContentPane().add(btnNewBack);
		
		JLabel lblAccountNumber = new JLabel("Account Number :-");
		lblAccountNumber.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblAccountNumber.setBounds(495, 337, 176, 26);
		getContentPane().add(lblAccountNumber);
		
		textField_Accountno = new JTextField();
		textField_Accountno.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Accountno.setColumns(10);
		textField_Accountno.setBounds(602, 369, 215, 26);
		getContentPane().add(textField_Accountno);
		
		
		
		JButton btnSave = new JButton("SAVE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				Random ran=new Random();
				long first6 =(ran.nextLong() & 9000L) + 1500510000L;
				long first7 = Math.abs(first6);
				
			//	String acc_num=Long.toString(first7);
			//	textField_Accountno.setText(acc_num);
				
				double balance= 100;
				
				try(Connection con=DbConnect.connect())
				{
					//String query = "insert into account_details(Account_Number,Name,Father's_Name,Sur_Name,Gender,Date,Month,Year,Marital_Status,Address,City,Pin_Code,,State,Mobile_Number,Email_Address)"
					//		+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
					
					
					String name= textField_Name.getText();
					String father_name= textField_Fathername.getText();
					String sur_name= textField_Surname.getText();
					
					String gender = new String("");
					if (rdbtnMale.isSelected())
						gender = "Male";
					if (rdbtnFemale.isSelected())
						gender = "Female";
					
					String date = comboBox_Date.getSelectedItem().toString();
					String month = comboBox_Month.getSelectedItem().toString();
					String year = comboBox_Year.getSelectedItem().toString();
					
					String marital_status= new String("");
					if (rdbtnMarried.isSelected())
						marital_status = "Married";
					if (rdbtnUnmarried.isSelected())
						marital_status = "Unmarried";
					
					String address= textField_Address.getText();
					String city= textField_City.getText();
					String pin_code= textField_Pincode.getText();
					String state= textField_State.getText();
					String mobile= textField_Mobileno.getText();
					String email= textField_Email.getText();
					
					//pstmt=con.prepareStatement(query);
					
					String query = "insert into account_details values ('" + first7 + "','" + name + "','" + father_name + "','"+ sur_name + "','" + gender + "','" + date + "','" + month + "','"+ year + "','" + marital_status + "','" + address + "','" + city + "','"+ pin_code + "','" + state + "','" + mobile + "','" + email + "')";
					System.out.println(query);
					pstmt=con.prepareStatement(query);
					int n1=pstmt.executeUpdate(query);
					if(n1>0)
					{
					JOptionPane.showMessageDialog(getContentPane(), "Accountant Name :- "+ name + " " + father_name + " " + sur_name +"\n Account Number :- "+ first7); //+ ", "Account created",JOptionPane.INFORMATION_MESSAGE);
					textField_Name.setText("");
					textField_Fathername.setText("");
					textField_Surname.setText("");
					
					textField_Address.setText("");
					textField_City.setText("");
					textField_Pincode.setText("");
					textField_State.setText("");
					
					textField_Mobileno.setText("");
					textField_Email.setText("");
					
					textField_Accountno.setText("");
					
					}
					
					String query1 = "insert into account_information values ('" + first7 + "','" + name + "','" + father_name + "','"+ sur_name + "','" + mobile + "','" + balance + "')";
					pstmt1=con.prepareStatement(query1);
					int n2=pstmt1.executeUpdate(query1);
					if(n2>0)
					{
						System.out.println("Account create successfully.");
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
		btnSave.setForeground(new Color(255, 255, 255));
		btnSave.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnSave.setBackground(new Color(0, 0, 255));
		btnSave.setBounds(472, 436, 108, 37);
		getContentPane().add(btnSave);
		
		/*JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try(Connection con=DbConnect.connect())
				{
				String Account_number=textField_Accountno.getText();
				String data="Select *from account_details where Account_Number ="+Account_number+"";
				stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(data);
				
				if(e.getSource()==btnNext)
				{
					if(rs.next())
					{
						AccountDetails detailAcc=new AccountDetails(textField_Accountno.getText());
						detailAcc.setVisible(true);
						setVisible(false);
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
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnNext.setBackground(Color.BLUE);
		btnNext.setBounds(617, 436, 108, 37);
		getContentPane().add(btnNext);
		
		*/
		
		setTitle("Bank management.");
		setVisible(true);
		
	}
}
