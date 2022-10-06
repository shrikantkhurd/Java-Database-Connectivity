package implementsRunnable;

import java.util.Scanner;

public class AdditionThread implements Runnable
{
	public void run() {
		System.out.println("Child thread 1 started..");
		addition();
		System.out.println("child thread 1 ended..");
		
	}
	public void addition()
	{
		Thread t=Thread.currentThread();
		System.out.println("task 1 started by "+t.getName()+"....");
		try 
		{
		int num1,num2,result=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("task 1 started :");
		Thread.sleep(2000);
		
		System.out.println("Add Enter First number:- ");
		num1=sc.nextInt();
		
		System.out.println("Add Enter second number:- ");
		num2=sc.nextInt();
		result=num1+num2;
		System.out.println("Addition :- "+result);
		
		
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task 1 ended by "+t.getName()+"....");
	}
}
