package implementsRunnable;

import java.util.Scanner;

public class SubtractionThreaad implements Runnable
{
	public void run() {
		System.out.println("Child thread 2 started..");
		substraction();
		System.out.println("child thread 2 ended..");
		
	}
	public void substraction()
	{
		Thread t=Thread.currentThread();
		System.out.println("task 2 started by "+t.getName()+"....");
		try 
		{
		int num1,num2,result=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("task 2 started :");
		Thread.sleep(500);
		
		System.out.println("Sub Enter First number:- ");
		num1=sc.nextInt();
		
		System.out.println("Sub Enter second number:- ");
		num2=sc.nextInt();
		result=num1-num2;
		System.out.println("Substraction :- "+result);
		
		
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task 2 ended by "+t.getName()+"....");
	}
}
