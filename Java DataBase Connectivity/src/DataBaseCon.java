import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseCon 
{
	Connection con;
	public void connection()
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
	}
	public static void main(String[] args) {
		DataBaseCon db=new DataBaseCon();
		db.connection();
	}
}
