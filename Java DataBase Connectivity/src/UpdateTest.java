import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.studentInfo.DbConnection;

public class UpdateTest {

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
		String s1="update employee set salary=salary+2000 where salary<50000";
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
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter salary for condition :");
		double salary=sc.nextDouble();
		
		System.out.println("Enter incerement :");
		double inc=sc.nextDouble();
		
		String s2="update employee set salary=salary+? where salary<?";
		pstmt=con.prepareStatement(s2);
		System.out.println(pstmt);
		pstmt.setDouble(1, inc);
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
		UpdateTest db= new UpdateTest();
	//	db.connection();
		try {
			//db.insertStaticQuery();
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
