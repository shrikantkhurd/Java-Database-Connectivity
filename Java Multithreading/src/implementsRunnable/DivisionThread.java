package implementsRunnable;

import java.util.Scanner;

public class DivisionThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Child thread 3 started..");
		division();
		System.out.println("child thread 3 ended..");
		
	}
	public void division()
	{
		Thread t=Thread.currentThread();
	System.out.println("task 3 started by "+t.getName()+"....");
		try 
		{
		int num1,num2,result=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("task 3 started :");
		Thread.sleep(1000);
		
		System.out.println("Div Enter First number:- ");
		num1=sc.nextInt();
		
		System.out.println("Div Enter second number:- ");
		num2=sc.nextInt();
		result=num1/num2;
		System.out.println("Division :- "+result);
		
		
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task 3 ended by "+t.getName()+"....");;
	}

	
}
