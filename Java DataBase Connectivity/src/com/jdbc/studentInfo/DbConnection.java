package com.jdbc.studentInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection 
{
	public static Connection connect() throws ClassNotFoundException, SQLException
	{
			Connection con=null;
			Class.forName("com.mysql.cj.jdbc.Driver");
		//	System.out.println("Driver present.");
			
			String url="jdbc:mysql://localhost:3306/jdbc_texceed";
			String username="root";
			String password="password";
			
			con=DriverManager.getConnection(url, username, password);
		//	System.out.println(con.getClass());
		//	System.out.println("Connection established");
			return con;
	}
}
