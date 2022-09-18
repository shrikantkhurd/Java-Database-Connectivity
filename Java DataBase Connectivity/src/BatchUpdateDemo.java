import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


class AccountNotFountException extends Exception 
{ 
	AccountNotFountException()
	{
		super("Account not exist.");
	}
    public AccountNotFountException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
} 
 class Account 
{
	public void moneyTransfer(long srcAccNo, long destAccNo, double amt)
	{
			Connection con=null;
			try
			{
				con=DbConnection.connect();
				con.setAutoCommit(false);
				
				
				String s="select acc_num from account where acc_num=?";
				PreparedStatement pstmt3=con.prepareStatement(s);
				pstmt3.setLong(1, srcAccNo);
				ResultSet rs=pstmt3.executeQuery();
				
				if(!rs.next())
				{
					throw new 	AccountNotFountException();
				}
				
				String s1="select acc_num from account where acc_num=?";
				PreparedStatement pstmt4=con.prepareStatement(s1);
				pstmt4.setLong(1, destAccNo);
				ResultSet rs1=pstmt4.executeQuery();
				
				if(!rs1.next())
				{
					throw new 	AccountNotFountException();
				}
				
				String query1="update account set balance=balance+? where acc_num=?";
				PreparedStatement pstmt=con.prepareStatement(query1);
				pstmt.setDouble(1, -amt);
				pstmt.setLong(2, srcAccNo);
				pstmt.addBatch();
				System.out.println(pstmt);
				pstmt.setDouble(1, amt);
				pstmt.setLong(2, destAccNo);
				pstmt.addBatch();
				System.out.println(pstmt);
				
				int arr[]=pstmt.executeBatch();
				for(int n:arr)
				{
					System.out.println(n);
				}
				if(arr[0]>0 && arr[1]>0)
				{
					System.out.println(".....Total Transaction succeded.....");
					con.commit();
				}
				else
				{
					System.out.println(".....Total Transaction failed.....");
					//System.out.println("Account number dose not exits...");
					con.rollback();
					System.out.println("Transaction rollbacked....");
				}
			}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Operation failed...");
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			catch (AccountNotFountException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
}
public class BatchUpdateDemo
{
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter source account number : ");
		long srcAccNo=in.nextLong();
		System.out.println("Enter destiantion account number : ");
		long destAccNo=in.nextLong();
		System.out.println("Enter money to transfer : ");
		double amt=in.nextDouble();
		
		
		Account batch=new Account();
		batch.moneyTransfer(srcAccNo,destAccNo,amt);
	}
}		


