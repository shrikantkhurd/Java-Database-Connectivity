import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.studentInfo.DbConnection;

public class TestDatabase 
{
	//Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	
	/*public void connection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver present.");
			
			String url="jdbc:mysql://localhost:3306/jdbc_texceed";
			String username="root";
			String password="password";
			
			con=DriverManager.getConnection(url, username, password);
			System.out.println(con.getClass());
			System.out.println("Connection established");
			
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
		String s1="insert into employee(name,id,salary) values('Priya',5,90000)";
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
		String s2="insert into employee(name,salary) values(?,?)";
		Scanner sc=new Scanner(System.in);
	//	System.out.println("Enter id :");
	//	int id=sc.nextInt();
		System.out.println("Enter Name :");
		String nm=sc.next();
		System.out.println("Enter Salary :");
		double salary=sc.nextDouble();
		
		pstmt=con.prepareStatement(s2);
		System.out.println(pstmt);
	//	pstmt.setInt(1, id);
		pstmt.setString(1, nm);
		pstmt.setDouble(2, salary);
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
	public static void main(String[] args) {
		TestDatabase db= new TestDatabase();
		//db.connection();
		try {
		//	db.insertStaticQuery();
			db.insertDynamicQuery();
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
