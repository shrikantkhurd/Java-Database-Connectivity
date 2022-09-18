package com.jdbc.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import com.jdbc.studentInfo.DbConnection;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class StudentDetails extends JFrame{

	public JFrame frame;
	private JTextField textFName;
	private JTextField textMName;
	private JTextField textLName;
	private JTextField textBDate;
	private JTextField textContact;
	private JTextField textAddress;
	private JButton btnReset;
	private JTextField textRollNo;
	private JTextField textDeleteRoll;

	
	public StudentDetails() 
	{
	/**
	 * Initialize the contents of the frame.
	 */
	
		frame = new JFrame();
		frame.setBounds(100, 100, 756, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentDetails = new JLabel("Student Details");
		lblStudentDetails.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblStudentDetails.setBounds(271, 23, 170, 36);
	//	frame.getContentPane().add(lblStudentDetails);
		frame.add(lblStudentDetails);
		
		JLabel lblFirstName = new JLabel("First Name :");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFirstName.setBounds(41, 93, 123, 30);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name :");
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMiddleName.setBounds(41, 136, 136, 30);
		frame.getContentPane().add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLastName.setBounds(41, 179, 123, 30);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblBirthDate = new JLabel("Birth Date :");
		lblBirthDate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBirthDate.setBounds(41, 222, 123, 30);
		frame.getContentPane().add(lblBirthDate);
		
		JLabel lblContact = new JLabel("Contact :");
		lblContact.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblContact.setBounds(41, 265, 123, 30);
		frame.getContentPane().add(lblContact);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(41, 304, 123, 30);
		frame.getContentPane().add(lblAddress);
		
		textFName = new JTextField();
		textFName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFName.setColumns(10);
		textFName.setBounds(206, 93, 170, 30);
		frame.getContentPane().add(textFName);
		
		textMName = new JTextField();
		textMName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textMName.setColumns(10);
		textMName.setBounds(206, 136, 170, 30);
		frame.getContentPane().add(textMName);
		
		textLName = new JTextField();
		textLName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textLName.setColumns(10);
		textLName.setBounds(206, 179, 170, 30);
		frame.getContentPane().add(textLName);
		
		textBDate = new JTextField();
		textBDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textBDate.setColumns(10);
		textBDate.setBounds(206, 222, 170, 30);
		frame.getContentPane().add(textBDate);
		
		textContact = new JTextField();
		textContact.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textContact.setColumns(10);
		textContact.setBounds(206, 265, 170, 30);
		frame.getContentPane().add(textContact);
		
		textAddress = new JTextField();
		textAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textAddress.setColumns(10);
		textAddress.setBounds(206, 304, 170, 30);
		frame.getContentPane().add(textAddress);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				PreparedStatement pstmt;
				
				try(Connection con=DbConnection.connect())
				{
				String s2="insert into student_details(first_name,middle_name,last_name,birth_date,contact,address) values(?,?,?,?,?,?)";
				
				String name = textFName.getText();
				String middle = textMName.getText();
				String last = textLName.getText();
				String date = textBDate.getText();
				String contact =textContact.getText();
				String address=textAddress.getText();
				
				pstmt=con.prepareStatement(s2);
				
				pstmt.setString(1, name);
				pstmt.setString(2, middle);
				pstmt.setString(3, last);
				pstmt.setString(4, date);
				pstmt.setString(5, contact);
				pstmt.setString(6, address);
				int no=pstmt.executeUpdate();
				if(no>0)
				{
					String data="select roll_no from student_details where contact=?";
					pstmt=con.prepareStatement(data);
					pstmt.setString(1, contact);
					ResultSet rs1=pstmt.executeQuery();
					int r=0;
					if(rs1.next())
					{
						r=rs1.getInt("roll_no");
					}
					// create pstmt then set contact
					//resultSet rs= pstmt.excuteQueey();
					//int r=0;
					//if(rs.next()){r=rs.getInt("roll_no");}
					
					
					
					
				System.out.println("Roll Number : "+ r +" Student name : "+name +" "+ middle +" "+ last +" Birth Date : "+ date +" Contact : "+contact+" Address : "+address);
				
				JOptionPane.showMessageDialog(frame, r+ " " +name + " " + middle + " " + last + " " + date + " " +contact+ " " +address);
				}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSubmit.setBounds(242, 360, 97, 30);
		frame.getContentPane().add(btnSubmit);
		
		//JButton btnReset;
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFName.setText("");
				textMName.setText("");
				textLName.setText("");
				textBDate.setText("");
				textContact.setText("");
				textAddress.setText("");
				textRollNo.setText("");
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReset.setBounds(100, 360, 97, 30);
		frame.getContentPane().add(btnReset);
		
		JLabel lblSearchStudent = new JLabel("Search Student ");
		lblSearchStudent.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSearchStudent.setBounds(464, 88, 185, 36);
		frame.getContentPane().add(lblSearchStudent);
		
		JLabel lblEnterRollNo = new JLabel("Enter Roll No. :");
		lblEnterRollNo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterRollNo.setBounds(410, 136, 150, 30);
		frame.getContentPane().add(lblEnterRollNo);
		
		textRollNo = new JTextField();
		textRollNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textRollNo.setColumns(10);
		textRollNo.setBounds(569, 136, 123, 30);
		frame.getContentPane().add(textRollNo);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				PreparedStatement pstmt;
				Statement stmt;
				ResultSet rs;
				try(Connection con=DbConnection.connect())
				{
					String search=textRollNo.getText();
					String data="select roll_no,first_name,middle_name,last_name,birth_date,contact,address from student_details where roll_no="+search+"";
				//	String data="select roll_no,first_name,middle_name,last_name,birth_date,contact,address from student_details where roll_no=?";
					stmt=con.createStatement();
					rs=stmt.executeQuery(data);
					
					/*pstmt=con.prepareStatement(data);
					pstmt.setString(1, search);
					rs=pstmt.executeQuery();*/
					
						if(rs.next())
						{
							int roll=rs.getInt("roll_no");
							String firstName=rs.getString("first_name");
							String middleName=rs.getString("middle_name");
							String lastName=rs.getString("last_name");
							String date=rs.getString("birth_date");
							String contact=rs.getString("contact");
							String address=rs.getString("address");
							
							
							textFName.setText(firstName);
							textMName.setText(middleName);
							textLName.setText(lastName);
							textBDate.setText(date);
							textContact.setText(contact);
							textAddress.setText(address);
							
							System.out.println("Roll Number : "+ roll +" Student Name : "+firstName +" "+ middleName +" "+ lastName +" Birth Date : "+ date +" Contact : "+contact+" Address : "+address);
						}
						else
						{
							JOptionPane.showMessageDialog(frame, "Invalid Roll Number.");
							textRollNo.setText("");
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
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearch.setBounds(507, 173, 97, 30);
		frame.getContentPane().add(btnSearch);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//extract data from all the textflied by using getText()
				// extract roll no also
				//parse apropriate  contact roll no.
				// established connection 
				// string query=" update student_details set first_name=?,middle_name=?,and so on clms in databases where roll_no=?";
				//create pstmt
				// call setter function on pstmt and set values to all question marks.
				// call execute update
				PreparedStatement pstmt;
				Statement stmt;
				ResultSet rs;
				
				String search=textRollNo.getText();
				String name = textFName.getText();
				String middle = textMName.getText();
				String last = textLName.getText();
				String date = textBDate.getText();
				String contact =textContact.getText();
				String address=textAddress.getText();
				
				try(Connection con=DbConnection.connect())
				{
				String query=" update student_details set first_name=?,middle_name=?,last_name=?,birth_date=?,contact=?,address=? where roll_no=?";
				pstmt=con.prepareStatement(query);
				
				pstmt.setString(1, name);
				pstmt.setString(2, middle);
				pstmt.setString(3, last);
				pstmt.setString(4, date);
				pstmt.setString(5, contact);
				pstmt.setString(6, address);
				pstmt.setString(7, search);
				int no=pstmt.executeUpdate();
				
				if(no>0)
				{
					System.out.println("Update Successfully.");
					System.out.println("Roll Number : "+ search +" Student name : "+name +" "+ middle +" "+ last +" Birth Date : "+ date +" Contact : "+contact+" Address : "+address);
					
					//JOptionPane.showMessageDialog(frame, search+ " " +name + " " + middle + " " + last + " " + date + " " +contact+ " " +address);
					JOptionPane.showMessageDialog(frame, "Update Successfully.");
					textFName.setText("");
					textMName.setText("");
					textLName.setText("");
					textBDate.setText("");
					textContact.setText("");
					textAddress.setText("");
					textRollNo.setText("");
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
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(387, 360, 97, 30);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Login login=new Login();
				login.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(629, 375, 97, 30);
		frame.getContentPane().add(btnExit);
		
		JLabel lblDeleteStudentDetail = new JLabel("Delete Student Detail");
		lblDeleteStudentDetail.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblDeleteStudentDetail.setBounds(430, 216, 262, 36);
		frame.getContentPane().add(lblDeleteStudentDetail);
		
		JLabel label = new JLabel("Enter Roll No. :");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(410, 265, 150, 30);
		frame.getContentPane().add(label);
		
		textDeleteRoll = new JTextField();
		textDeleteRoll.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textDeleteRoll.setColumns(10);
		textDeleteRoll.setBounds(569, 265, 123, 30);
		frame.getContentPane().add(textDeleteRoll);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				PreparedStatement pstmt;
				
				try(Connection con=DbConnection.connect())
				{
				String delete=textDeleteRoll.getText();
				String s2="delete from student_details where roll_no=?";
				pstmt=con.prepareStatement(s2);
				pstmt.setString(1, delete);
				int no=pstmt.executeUpdate();
				
				if(no>0)
				{
					System.out.println("Roll Number : "+ delete );
					JOptionPane.showMessageDialog(frame, "Roll Number : "+delete+ "delete successfully.");
					textDeleteRoll.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Invalid Roll Number.");
					textDeleteRoll.setText("");
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
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDelete.setBounds(507, 304, 97, 30);
		frame.getContentPane().add(btnDelete);
		
		frame.setVisible(true);
	}
/*public static void main(String[] args) {
	StudentDetails s=new StudentDetails();
	//s.StudentDetails();
	
}*/
}
