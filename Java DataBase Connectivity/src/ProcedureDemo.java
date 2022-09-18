import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcedureDemo 
{
	public void callProc()
	{
		try (Connection con=DbConnection.connect())
		{
		/*create procedure moneyTrans()
    -> BEGIN
    -> update account set balance=balance-2000 where acc_num=1234;
    -> update account set balance=balance+3000 where acc_num=2345;
    -> select * from account;
    -> END
    -> $*/
		String query="call moneyTrans()";
		CallableStatement cstmt=con.prepareCall(query);
		boolean b=cstmt.execute();
		System.out.println(b);
		ResultSet rs=cstmt.getResultSet();
		while(rs.next())
		{
			long accnum=rs.getLong("acc_num");
			long id=rs.getLong("cust_id");
			Double balance=rs.getDouble("balance");
			System.out.println(accnum+"  "+id+"  "+balance);
		
		
		
			
			/*System.out.println(rs.getLong("acc_num"));
			System.out.println(rs.getLong("cust_id"));
			System.out.println(rs.getLong("balance"));*/
		}
			
			System.out.println(rs.next());
		}  
		catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ProcedureDemo p=new ProcedureDemo();
		p.callProc();
	}

}
