package com.jdbc.studentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



class Account
{
	 public void moneyTransfer(long srcAccNo, long destAccNo, double amount)
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
					System.out.println("Source account not exist....");
					throw new 	AccountNotFountException();
				}
				
				String s1="select acc_num from account where acc_num=?";
				PreparedStatement pstmt4=con.prepareStatement(s1);
				pstmt4.setLong(1, destAccNo);
				ResultSet rs1=pstmt4.executeQuery();
				
				if(!rs1.next())
				{
					System.out.println("Destiantion account not exist....");
					throw new 	AccountNotFountException();
				}
				
			
				
				
				String query1="update account set balance=balance-? where acc_num=?";
				PreparedStatement pstmt=con.prepareStatement(query1);
				pstmt.setDouble(1, amount);
				pstmt.setLong(2, srcAccNo);
				
				int n1=pstmt.executeUpdate();
				System.out.println("No of rows affected"+n1);
				if(n1>0)
				{
					System.out.println("First opertion Succeded...");
				}
				String query2="update account set balance=balance+? where acc_num=?";
				PreparedStatement pstmt1=con.prepareStatement(query2);
				pstmt1.setDouble(1, amount);
				pstmt1.setLong(2, destAccNo);
				
				int n2=pstmt1.executeUpdate();
				System.out.println("No of rows affected"+n1);
				if(n2>0)
				{
					System.out.println("Second opertion Succeded...");
				}
				if(n1>0 && n2>0)
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
public class DataIntegrityDemo
{
	
	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter source account number : ");
		long srcAccNo=in.nextLong();
		System.out.println("Enter destiantion account number : ");
		long destAccNo=in.nextLong();
		System.out.println("Enter money to transfer : ");
		double amt=in.nextDouble();
		
		
		Account acc=new Account();
		acc.moneyTransfer(srcAccNo,destAccNo,amt);


	}

}
