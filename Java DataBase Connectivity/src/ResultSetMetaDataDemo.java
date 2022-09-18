import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

import com.jdbc.studentInfo.DbConnection;

public class ResultSetMetaDataDemo 
{
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs; 
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
		
		System.out.println("------- METADATA -----");
		ResultSetMetaData rsmd=rs.getMetaData();
		int count=	rsmd.getColumnCount();
		System.out.println(count);
		System.out.println("table name: "+rsmd.getTableName(1));
		String col=rsmd.getColumnName(1);
		String col1=rsmd.getColumnName(2);
		String col2=rsmd.getColumnName(3);
		System.out.println("Columns in tables :"+col+ " "+col1+" "+col2);
		
		String clm=rsmd.getColumnLabel(1);
		System.out.println(clm);
		//System.out.println("table name: "+rsmd.getTableName(1));
		
		System.out.println("--------------------");
		System.out.println("----- DATABASE METADATA ------");
		DatabaseMetaData dbmd=con.getMetaData();
		System.out.println("Driver : "+dbmd.getDriverName());
		System.out.println("Version : "+dbmd.getDriverVersion());
		
		String keys=dbmd.getSQLKeywords();
		System.out.println("SQL Keywords : "+keys);
		StringTokenizer key = new StringTokenizer(dbmd.getSQLKeywords(),",");  
	     while (key.hasMoreElements()) {  
	         System.out.println("SQL Keywords :"+key.nextElement());  
	        // System.out.println("SQL Keys : "+keys);
	     }  

	     String type[]= {"TABLE"};
	   //  ResultSet rs1=dbmd.getTables(null, "jdbc_texceed","employee" , type);
	     ResultSet rs1=dbmd.getTables(null, null,null , type);
	     while(rs1.next())
	     {
	    	 System.out.println(rs1.getString(1));
	    	 System.out.println(rs1.getString(2));
	    	 System.out.println(rs1.getString(3));
	    	 System.out.println(rs1.getString(4));
	     }
		
		}
		finally {
			stmt.close();
		}
	}
	public static void main(String[] args) {
		ResultSetMetaDataDemo result=new ResultSetMetaDataDemo();
		try {
			result.insertStaticQuery();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
