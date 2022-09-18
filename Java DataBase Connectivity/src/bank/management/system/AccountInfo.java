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
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountInfo extends JFrame {

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
	private JTextField textGender;
	private JTextField textAcc_num;
	private JTextField textBirthDate;
	private JTextField textMaritalStatus;
	
	public AccountInfo(String Account_number) 
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
		
		JLabel label = new JLabel("Account Number :-");
		label.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		label.setBounds(52, 78, 187, 26);
		getContentPane().add(label);
		
		textAcc_num = new JTextField();
		textAcc_num.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textAcc_num.setColumns(10);
		textAcc_num.setBounds(246, 82, 215, 26);
		textAcc_num.setEditable(false);
		getContentPane().add(textAcc_num);
		
		JLabel lblName = new JLabel("Name :-");
		lblName.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblName.setBounds(52, 117, 84, 26);
		getContentPane().add(lblName);
		
		textField_Name = new JTextField();
		textField_Name.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Name.setBounds(246, 115, 215, 26);
		getContentPane().add(textField_Name);
		textField_Name.setEditable(false);
		textField_Name.setColumns(10);
		
		JLabel lblFathersName = new JLabel("Father's Name :-");
		lblFathersName.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblFathersName.setBounds(52, 156, 154, 26);
		getContentPane().add(lblFathersName);
		
		textField_Fathername = new JTextField();
		textField_Fathername.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Fathername.setColumns(10);
		textField_Fathername.setBounds(246, 154, 215, 26);
		textField_Fathername.setEditable(false);
		getContentPane().add(textField_Fathername);
		
		JLabel lblSurName = new JLabel("Sur Name :-");
		lblSurName.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblSurName.setBounds(52, 195, 154, 26);
		getContentPane().add(lblSurName);
		
		textField_Surname = new JTextField();
		textField_Surname.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Surname.setColumns(10);
		textField_Surname.setBounds(246, 197, 215, 26);
		textField_Surname.setEditable(false);
		getContentPane().add(textField_Surname);
		
		JLabel lblGender = new JLabel("Gender  :-");
		lblGender.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblGender.setBounds(52, 237, 154, 26);
		getContentPane().add(lblGender);
		
		textGender = new JTextField();
		textGender.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textGender.setColumns(10);
		textGender.setBounds(246, 236, 215, 26);
		textGender.setEditable(false);
		getContentPane().add(textGender);
		
		
		JLabel lblAddress = new JLabel("Address :-");
		lblAddress.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblAddress.setBounds(495, 115, 95, 26);
		getContentPane().add(lblAddress);
		
		textField_Address = new JTextField();
		textField_Address.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Address.setColumns(30);
		textField_Address.setBounds(602, 117, 237, 26);
		textField_Address.setEditable(false);
		getContentPane().add(textField_Address);
		
		JLabel lblCity = new JLabel("City :-");
		lblCity.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblCity.setBounds(495, 156, 95, 26);
		getContentPane().add(lblCity);
		
		textField_City = new JTextField();
		textField_City.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_City.setColumns(10);
		textField_City.setBounds(602, 156, 215, 26);
		textField_City.setEditable(false);
		getContentPane().add(textField_City);
		
		JLabel lblPin = new JLabel("Pin Code :-");
		lblPin.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblPin.setBounds(495, 195, 108, 26);
		getContentPane().add(lblPin);
		
		textField_Pincode = new JTextField();
		textField_Pincode.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Pincode.setColumns(10);
		textField_Pincode.setBounds(602, 195, 215, 26);
		textField_Pincode.setEditable(false);
		getContentPane().add(textField_Pincode);
		
		JLabel lblState = new JLabel("State :-");
		lblState.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblState.setBounds(495, 234, 95, 26);
		getContentPane().add(lblState);
		
		textField_State = new JTextField();
		textField_State.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_State.setColumns(10);
		textField_State.setBounds(602, 237, 215, 26);
		textField_State.setEditable(false);
		getContentPane().add(textField_State);
		
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth :-");
		lblDateOfBirth.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblDateOfBirth.setBounds(52, 276, 154, 26);
		getContentPane().add(lblDateOfBirth);
		
		textBirthDate = new JTextField();
		textBirthDate.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textBirthDate.setColumns(10);
		textBirthDate.setBounds(246, 275, 215, 26);
		textBirthDate.setEditable(false);
		getContentPane().add(textBirthDate);
		
		JLabel lblMarital_status = new JLabel("Marital Status :-");
		lblMarital_status.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblMarital_status.setBounds(52, 309, 154, 26);
		getContentPane().add(lblMarital_status);
		
		textMaritalStatus = new JTextField();
		textMaritalStatus.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textMaritalStatus.setColumns(10);
		textMaritalStatus.setBounds(246, 313, 215, 26);
		textMaritalStatus.setEditable(false);
		getContentPane().add(textMaritalStatus);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number :-");
		lblMobileNumber.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblMobileNumber.setBounds(52, 348, 166, 26);
		getContentPane().add(lblMobileNumber);
		
		textField_Mobileno = new JTextField();
		textField_Mobileno.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Mobileno.setColumns(10);
		textField_Mobileno.setBounds(246, 350, 215, 26);
		textField_Mobileno.setEditable(false);
		getContentPane().add(textField_Mobileno);
		
		JLabel lblEmailI = new JLabel("Email Address :-");
		lblEmailI.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 16));
		lblEmailI.setBounds(52, 387, 154, 26);
		getContentPane().add(lblEmailI);
		
		textField_Email = new JTextField();
		textField_Email.setFont(new Font("MS Reference Sans Serif", Font.ITALIC, 18));
		textField_Email.setColumns(30);
		textField_Email.setBounds(246, 389, 297, 26);
		textField_Email.setEditable(false);
		getContentPane().add(textField_Email);
		
		
		try(Connection con=DbConnect.connect())
		{
		
			String data="select * from account_details where Account_Number='" + Account_number + "'";
			stmt=con.createStatement();
			rs=stmt.executeQuery(data);
		
			if(rs.next())
			{
				String account_number=rs.getString("Account_Number");
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
			
		        textAcc_num.setText(account_number);
		        textField_Name.setText(name);
				textField_Fathername.setText(father_name);
				textField_Surname.setText(sur_name);
				textGender.setText(gender);
				textBirthDate.setText(date+"-"+month+"-"+year);
				textMaritalStatus.setText(marital_status);
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
		
		
		JButton button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AccountDetails acc=new AccountDetails(Account_number);
				acc.setVisible(true);
				setVisible(false);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("MS Reference Sans Serif", Font.BOLD, 22));
		button.setBackground(Color.BLUE);
		button.setBounds(392, 440, 108, 37);
		getContentPane().add(button);
		
		
		setTitle("Bank management.");
		setVisible(true);
	}


	

}
