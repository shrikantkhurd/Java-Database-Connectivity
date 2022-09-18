package com.jdbc.studentInfo;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentDetails 
{
	 
	//StudentInsertData db= new StudentInsertData();
	public static void main(String[] args) 
	{
		//StudentDetails student=new StudentDetails();
		StudentInsertData insert= new StudentInsertData();
		StudentUpdateData update= new StudentUpdateData();
		StudentDeleteData delete= new StudentDeleteData();
		StudentSelectData select= new StudentSelectData();
		
		Scanner in=new Scanner(System.in);
		System.out.println("#***#***#-- WELCOME --#***#***#");
		int ch;
		
		do
		{
		System.out.println("--------- Options ---------");
		System.out.println("1.Insert Student.");
		System.out.println("2.Display All Students.");
		System.out.println("3.Update Student.");
		System.out.println("4.Delete Student.");
		System.out.println("5.Select Student.");
		System.out.println("6.Exit");
		
		System.out.println("--------------------------");
			System.out.println("Enter your option :");
			ch=in.nextInt();
		System.out.println("--------------------------");

			switch(ch)
			{
			case 1:
				try {
					insert.insertDynamicQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 2:
				try {
					select.allStudentDetails();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 3:
				try {
					update.updateDynamicQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 4:
				try {
					delete.deleteDynamicQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 5:
				try {
					select.selectDynamicQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 6://Exit.
				System.out.println("Thank you.");
				System.exit(1);
				break;
				
			default :
				System.out.println("Invalid choice.");
			}
		}while(ch !=6);
	}

}
