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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UpdateAccount extends JFrame {

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

	public UpdateAccount(String Account_number) 
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
				AccountDetails acc=new AccountDetails(Account_number);
				acc.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewBack.setBackground(new Color(0, 0, 255));
		btnNewBack.setForeground(new Color(255, 255, 255));
		btnNewBack.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		btnNewBack.setBounds(321, 436, 108, 37);
		getContentPane().add(btnNewBack);
		
		try(Connection con=DbConnect.connect())
		{
			
			//String query1="select Account_Number,Name,Fathers_Name,Sur_Name,Gender,Date,Month,Year,Marital_Status,Address,City,Pin_Code,State,Mobile_Number,Email_Address where Account_Number=" + Account_number + "";
		//	stmt=con.createStatement();
		//	rs=stmt.executeQuery(query1);
			
			String data="select * from account_details where Account_Number='" + Account_number + "'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(data);
			
			if(rs.next())
			{
			//	String account_number=rs.getString("Account_Number");
				String name=rs.getString("Name");
				String father_name=rs.getString("Fathers_Name");
				String sur_name=rs.getString("Sur_Name");
				String gender = rs.getString("Gender");
				
                String date = rs.getString("Date");
                String month = rs.getString("Month");
                String year = rs.getString("Year");
                String marital_status = rs.getString("Marital_Status");
                String address = rs.getString("Address");
                String city = rs.getString("City");
                String pin_code = rs.getString("Pin_Code");
                String state = rs.getString("State");
                String mobile_number = rs.getString("Mobile_Number");
                String email_address = rs.getString("Email_Address");
				
				textField_Name.setText(name);
				textField_Fathername.setText(father_name);
				textField_Surname.setText(sur_name);
				
				if (rdbtnMale.isSelected())
					
				rdbtnMale.setText(gender);
				if (rdbtnFemale.isSelected())
					
				rdbtnFemale.setText(gender);
				
				textField_Address.setText(address);
				textField_City.setText(city);
				textField_Pincode.setText(pin_code);
				textField_State.setText(state);
				
				textField_Mobileno.setText(mobile_number);
				textField_Email.setText(email_address);
				
				
				
			}
			
			
			
			}
			
			
		
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnSave = new JButton("UPDATE");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String name= textField_Name.getText();
				String father_name= textField_Fathername.getText();
				String sur_name= textField_Surname.getText();
				String address= textField_Address.getText();
				String city= textField_City.getText();
				String pin_code= textField_Pincode.getText();
				String state= textField_State.getText();
				String mobile= textField_Mobileno.getText();
				String email= textField_Email.getText();
				
				try(Connection con=DbConnect.connect())
				{
				
				String query = "update  account_details set Name=?,Fathers_Name=?,Sur_Name=?,Address=?,City=?,Pin_Code=?,State=?,Mobile_Number=?,Email_Address=? where Account_Number=" + Account_number + "";
				pstmt=con.prepareStatement(query);
					
				
				pstmt.setString(1, name);
				pstmt.setString(2,father_name);
				pstmt.setString(3, sur_name);
				pstmt.setString(4,address);
				pstmt.setString(5, city);
				pstmt.setString(6,pin_code);
				pstmt.setString(7, state);
				pstmt.setString(8,mobile);
				pstmt.setString(9, email);
			//	pstmt.setString(2,father_name);
				
				
				
				
				int no=pstmt.executeUpdate();
				if(no>0)
				{
					System.out.println("Update Successfully.");
					//System.out.println(query);
					
					//JOptionPane.showMessageDialog(frame, search+ " " +name + " " + middle + " " + last + " " + date + " " +contact+ " " +address);
				//	JOptionPane.showMessageDialog(getContentPane(), "Update Successfully.");
					
				}
				
				String query1 = "update  account_information set Name=?,Fathers_Name=?,Sur_Name=?,Mobile_Number=? where Account_Number=" + Account_number + "";
				pstmt1=con.prepareStatement(query1);
				
				pstmt1.setString(1, name);
				pstmt1.setString(2,father_name);
				pstmt1.setString(3, sur_name);
				pstmt1.setString(4,mobile);
				
				//pstmt1=con.prepareStatement(query1);
				int n2=pstmt1.executeUpdate();
				if(n2>0)
				{
					System.out.println("Account update successfully.");
					JOptionPane.showMessageDialog(getContentPane(), "Update Successfully.");
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
		btnSave.setBounds(472, 436, 131, 37);
		getContentPane().add(btnSave);
		
		JLabel lblAccountNumber = new JLabel("Account Number :-");
		lblAccountNumber.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblAccountNumber.setBounds(50, 82, 187, 26);
		getContentPane().add(lblAccountNumber);
		
		try(Connection con=DbConnect.connect())
		{
		String data="select * from account_details where Account_Number='" + Account_number + "'";
		stmt=con.createStatement();
		rs=stmt.executeQuery(data);
		
		while(rs.next())
		{
			String account_number=rs.getString("Account_Number");
			
			JLabel lblAccNum = new JLabel(account_number);
			lblAccNum.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
			lblAccNum.setBounds(246, 82, 215, 26);
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