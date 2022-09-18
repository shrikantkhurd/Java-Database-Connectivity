package com.jdbc.studentInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentSelectData 
{
//	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	/*public void connection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		//	System.out.println("Driver present.");
			
			String url="jdbc:mysql://localhost:3306/jdbc_texceed";
			String username="root";
			String password="password";
			
			con=DriverManager.getConnection(url, username, password);
		//	System.out.println(con.getClass());
		//	System.out.println("Connection established");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	public void selectStaticQuery() throws SQLException, ClassNotFoundException
	{
		try(Connection con=DbConnection.connect())
		{
		String s1="select roll_no,first_name,middle_name,last_name,birth_date,contact,address from student_details where address='mumbai'";
		stmt=con.createStatement();
		 rs=stmt.executeQuery(s1);
		
		while(rs.next())
		{
			int rollNo=rs.getInt("roll_no");
			String firstName=rs.getString("first_name");
			String middleName=rs.getString("middle_name");
			String lastName=rs.getString("last_name");
			String date=rs.getString("birth_date");
			String contact=rs.getString("contact");
			String address=rs.getString("address");
			System.out.println(rollNo+"  "+firstName+"  "+middleName+"  "+lastName+"  "+date+"  "+contact+"  "+address);
		}
		System.out.println(rs.next());
	}
	finally {
		stmt.close();
	}
	}
	public void	selectDynamicQuery() throws SQLException, ClassNotFoundException
	{
		try(Connection con=DbConnection.connect())
		{
		String s2="select roll_no,first_name,middle_name,last_name,birth_date,contact,address from student_details where address=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("----------Search student -----------");
		System.out.println("Enter address :");
		String address1=sc.next();
	//	int roll=sc.nextInt();
		pstmt=con.prepareStatement(s2);
		pstmt.setString(1, address1);
		
		//rs=pstmt.executeQuery(s2);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			int rollNo=rs.getInt("roll_no");
			String firstName=rs.getString("first_name");
			String middleName=rs.getString("middle_name");
			String lastName=rs.getString("last_name");
			String date=rs.getString("birth_date");
			String contact=rs.getString("contact");
			String address=rs.getString("address");
			
			System.out.println(rollNo+"  "+firstName+"  "+middleName+"  "+lastName+"  "+date+"  "+contact+"  "+address);
		}
		System.out.println(rs.next());
	}
	finally {
		pstmt.close();
	}
	}
	public void	allStudentDetails() throws SQLException, ClassNotFoundException
	{
		try(Connection con=DbConnection.connect())
		{
		String s3="select * from student_details";
		stmt=con.createStatement();
		 rs=stmt.executeQuery(s3);
		 System.out.println("---------- All Student Details -----------");
		// System.out.println("Roll_No  First_Name  Middle_Name  LastName  Birth_Date  Contact  Address");
		while(rs.next())
		{
			int rollNo=rs.getInt("roll_no");
			String firstName=rs.getString("first_name");
			String middleName=rs.getString("middle_name");
			String lastName=rs.getString("last_name");
			String date=rs.getString("birth_date");
			String contact=rs.getString("contact");
			String address=rs.getString("address");
		//	System.out.println(rollNo+" \t"+firstName+" \t"+middleName+" \t"+lastName+" \t"+date+" \t"+contact+" \t"+address);
			System.out.println(rollNo+"    "+firstName+"    "+middleName+"    "+lastName+"    "+date+"    "+contact+"    "+address);
		}
		System.out.println(rs.next());
		}
		finally {
			stmt.close();
		}
	}
	
	public static void main(String[] args) {
		StudentSelectData db= new StudentSelectData();
	//	db.connection();
		try {
			db.selectStaticQuery();
		//	db.selectDynamicQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally {
			try {
				db.con.close();
				System.out.println("Conection closed..");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/ 
	}
}
