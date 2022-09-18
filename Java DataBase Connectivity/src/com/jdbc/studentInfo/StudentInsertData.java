package com.jdbc.studentInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentInsertData 
{
	//Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	
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
	
	public void insertStaticQuery() throws SQLException, ClassNotFoundException
	{
		try(Connection con=DbConnection.connect())
		{
		String s1="insert into student_details(first_name,middle_name,last_name,birth_date,contact,address) values('rahul','ravi','patil',"
				+ "'1996-11-30','7845123665','mumbai') ";
		stmt=con.createStatement();
		int no=stmt.executeUpdate(s1);
		System.out.println("Number of rows affected: "+no);
		if(no>0)
		{
			System.out.println("SUCCESS");
		}
		}
		finally {
			stmt.close();
		}
	}
	public void insertDynamicQuery() throws SQLException, ClassNotFoundException
	{
		try(Connection con=DbConnection.connect())
		{
		String s2="insert into student_details(first_name,middle_name,last_name,birth_date,contact,address) values(?,?,?,?,?,?)";
		Scanner sc=new Scanner(System.in);
		System.out.println("------ Add new student ------");
		System.out.println("Enter First Name :");
		String firstName=sc.next();
		System.out.println("Enter Middle Name :");
		String middleName=sc.next();
		System.out.println("Enter last Name :");
		String lastName=sc.next();
		System.out.println("Enter Birth Date :");
		String date=sc.next();
		System.out.println("Enter Contact number :");
		String contact=sc.next();
		System.out.println("Enter Address :");
		String address=sc.next();
		
		pstmt=con.prepareStatement(s2);
	//	System.out.println(pstmt);
	//	pstmt.setInt(1, id);
		pstmt.setString(1, firstName);
		pstmt.setString(2, middleName);
		pstmt.setString(3, lastName);
		pstmt.setString(4, date);
		pstmt.setString(5, contact);
		pstmt.setString(6, address);
		
		System.out.println(pstmt);
		int no=pstmt.executeUpdate();
		
		System.out.println("Number of rows affected: "+no);
		if(no>0)
		{
			System.out.println("SUCCESS");
		}
		}
		finally {
			pstmt.close();
		}
	}
	
	public static void main(String[] args) 
	{
		StudentInsertData db= new StudentInsertData();
		
		try {
			db.insertStaticQuery();
		//	db.insertDynamicQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
