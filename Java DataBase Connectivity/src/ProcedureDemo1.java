import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;


 public class ProcedureDemo1 
{
	public void moneyTransfer(long srcAccNo, long destAccNo, double amt)
	{
		try (Connection con=DbConnection.connect())
		{
			/*create procedure moneyTransfer(IN src bigint, IN dest bigint,IN amt double,OUT srcBal double,OUT destBal double)
		    -> BEGIN
		    -> update account set balance=balance-amt where acc_num=src;
		    -> update account set balance=balance+amt where acc_num=dest;
		    -> select balance into srcBal from account where acc_num=src;
		    -> select balance into destBal from account where acc_num=dest;
		    -> END
		    -> $*/
			
			
			String query="call moneyTransfer(?,?,?,?,?)";
			CallableStatement cstmt=con.prepareCall(query);
			cstmt.setLong(1, srcAccNo);
			cstmt.setLong(2, destAccNo);
			cstmt.setDouble(3, amt);
			cstmt.registerOutParameter(4, Types.DOUBLE);
			cstmt.registerOutParameter(5, Types.DOUBLE);
			
			boolean b=cstmt.execute();
			System.out.println(b);
			double b1=cstmt.getDouble(4);
			double b2=cstmt.getDouble(5);
			System.out.println(srcAccNo+" : "+b1+"		"+destAccNo+" : "+b2);
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Operation failed...");
			
		}
		
	}


public static void main(String[] args) 
{
	Scanner in=new Scanner(System.in);
	System.out.println("Enter source account number : ");
	long srcAccNo=in.nextLong();
	System.out.println("Enter destiantion account number : ");
	long destAccNo=in.nextLong();
	System.out.println("Enter money to transfer : ");
	double amt=in.nextDouble();
	
	
	ProcedureDemo1 p1=new ProcedureDemo1();
	p1.moneyTransfer(srcAccNo,destAccNo,amt);


}

	
}
