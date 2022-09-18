package com.jdbc.studentInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentUpdateData 
{
	//Connection con;
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
	
	public void updatetStaticQuery() throws SQLException, ClassNotFoundException
	{
		try(Connection con=DbConnection.connect())
		{
		String s1="update student_details set address='pune' where address='sangli'";
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
	public void updateDynamicQuery() throws SQLException, ClassNotFoundException
	{
		try(Connection con=DbConnection.connect())
		{
		String s2="update student_details set address=? where address=?";
		Scanner sc=new Scanner(System.in);
		System.out.println("----------Update student details-----------");
		System.out.println("Enter new address :");
		String newAddress=sc.next();
		System.out.println("Enter old address :");
		String oldAddress=sc.next();
		
		
		pstmt=con.prepareStatement(s2);
		System.out.println(pstmt);
	//	pstmt.setInt(1, id);
		pstmt.setString(1, newAddress);
		pstmt.setString(2, oldAddress);
		
		
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
		StudentUpdateData db= new StudentUpdateData();
		//db.connection();
		try {
			db.updatetStaticQuery();
		//	db.updateDynamicQuery();
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
