import java.time.LocalTime;
import java.util.Scanner;

class ThreadOperation
{
	public void addition()
	{
		try {
		int num1,num2,result=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("task 1 started :");
		
		System.out.println("Enter First number:- ");
		num1=sc.nextInt();
		
		System.out.println("Enter second number:- ");
		num2=sc.nextInt();
		result=num1+num2;
		System.out.println("Addition :- "+result);
		
		
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task 1 ended :");
	}
	public void substraction()
	{
		try {
		int num1,num2,result=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("task 2 started :");
		
		System.out.println("Enter First number:- ");
		num1=sc.nextInt();
		
		System.out.println("Enter second number:- ");
		num2=sc.nextInt();
		result=num1-num2;
		System.out.println("Substraction :- "+result);
		
		
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task 2 ended :");
	}
	public void division()
	{
		try {
		int num1,num2,result=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("task 3 started :");
		
		System.out.println("Enter First number:- ");
		num1=sc.nextInt();
		
		System.out.println("Enter second number:- ");
		num2=sc.nextInt();
		result=num1/num2;
		System.out.println("Division :- "+result);
		
		
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("task 3 ended :");
	}
}

public class ThreadOperationDemo {

	public static void main(String[] args) {
		System.out.println("Parent thread started..");
		Thread pt=Thread.currentThread();
		System.out.println("Current Thread :- "+pt);
		
		String name=pt.getName();
		System.out.println("Name of thread: "+name);
		
		int pr=pt.getPriority();
		System.out.println("priority is :- "+pr);
		
		pt.setName("ThreadOperation");
		System.out.println(" Thread :- "+pt);
		
		pt.setPriority(3);
		pr=pt.getPriority();
		System.out.println("priority change :- "+pr);
		
		boolean isalive=pt.isAlive();
		System.out.println(isalive);
		
		ThreadOperation thread=new ThreadOperation();
		LocalTime time1=LocalTime.now();
		thread.addition();
		thread.substraction();
		thread.division();
		
		LocalTime time2=LocalTime.now();
		int totalTime=time2.toSecondOfDay()-time1.toSecondOfDay();
		System.out.println("Execution time to complete 3 tasks :- "+totalTime+ "seconds");
		System.out.println("Parent thread ended.");

	}
}
