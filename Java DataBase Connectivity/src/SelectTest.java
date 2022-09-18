import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.studentInfo.DbConnection;

public class SelectTest {

	//Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
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
		String s1="select id,name,salary from employee where salary<80000";
		stmt=con.createStatement();
		 rs=stmt.executeQuery(s1);
		
		while(rs.next())
		{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			Double sal=rs.getDouble("salary");
			System.out.println(id+"  "+name+"  "+sal);
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
		String s2="select id,name,salary from employee where salary<?";
		Scanner sc=new Scanner(System.in);
	
		System.out.println("Enter salary :");
		int salary=sc.nextInt();
		pstmt=con.prepareStatement(s2);
		pstmt.setInt(1, salary);
		
		//rs=pstmt.executeQuery(s2);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			int id=rs.getInt("id");
			String name=rs.getString("name");
			Double sal=rs.getDouble("salary");
			System.out.println(id+"  "+name+"  "+sal);
		}
		System.out.println(rs.next());
		}
		finally {
			pstmt.close();
		}
	}
	
	public static void main(String[] args) {
		SelectTest db= new SelectTest();
		//db.connection();
		try {
		//	db.insertStaticQuery();
			db.selectDynamicQuery();
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
