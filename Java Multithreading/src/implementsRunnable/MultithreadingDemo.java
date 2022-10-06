package implementsRunnable;

import java.time.LocalTime;

public class MultithreadingDemo 
{
	public static void main(String[] args) 
	{
		System.out.println("Parent thread started..");
		Thread pt=Thread.currentThread();
		pt.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Parent Thread :- "+pt);
		Runnable r1=new AdditionThread();
		Thread add=new Thread(r1);
		add.setName("Addition");
		System.out.println("Child1 : "+add);
		
		Runnable r2=new SubtractionThreaad();
		Thread sub=new Thread(r2);
		sub.setName("Substraction");
		System.out.println("Child2 : "+sub);
		
		Runnable r3=new DivisionThread();
		Thread div=new Thread(r3);
		div.setName("Division");
		System.out.println("Child3 : "+div);
		
		LocalTime time1=LocalTime.now();
		System.out.println("Time before tasks started : "+time1);
		add.start();
		sub.start();
		div.start();
		System.out.println("parent waiting..");
		try {
			add.join();
			sub.join();
			div.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalTime time2=LocalTime.now();
		int totalTime=time2.toSecondOfDay()-time1.toSecondOfDay();
		System.out.println("Execution time to complete 3 tasks :- "+totalTime+ "seconds");
		System.out.println("Parent thread ended.");

	}

}
