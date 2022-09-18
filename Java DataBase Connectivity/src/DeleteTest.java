import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.studentInfo.DbConnection;

public class DeleteTest {

//	Connection con;
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
	public void deleteStaticQuery() throws SQLException, ClassNotFoundException
	{
		try(Connection con=DbConnection.connect())
		{
		String s1="delete from employee where salary between 80000 and 90000";
	//	String s1="delete from employee where id=1";
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
	public void deleteDynamicQuery() throws SQLException, ClassNotFoundException
	{
		try(Connection con=DbConnection.connect())
		{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter salary between :");
		double salaryFrom=sc.nextDouble();
		
		System.out.println("Enter salary to :");
		double salaryTo=sc.nextDouble();
	//	System.out.println("Enter id : ");
	//	int id=sc.nextInt();
		
		String s2="delete from employee where salary between ? and ?";
		//String s2="delete from employee where id=?";
		pstmt=con.prepareStatement(s2);
		System.out.println(pstmt);
		pstmt.setDouble(1, salaryFrom);
		pstmt.setDouble(2, salaryTo);
	//	pstmt.setInt(1, id);
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
		DeleteTest db= new DeleteTest();
	//	db.connection();
		try {
			//	db.deleteStaticQuery();
				db.deleteDynamicQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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


}
