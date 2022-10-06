package extendingThread;

import java.time.LocalTime;

public class ExtendingThreadDemo 
{
	public static void main(String[] args) {
		System.out.println("Parent thread started..");
		Thread pt=Thread.currentThread();
		pt.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Parent :- "+pt);
		Thread ct1=new ChildThread1();
		ct1.setName("Shrikant");
		System.out.println("Child1 : "+ct1);
		Thread ct2=new ChildThread2();
		ct2.setName("Soumya");
		System.out.println("Child2 : "+ct2);
		
		Runnable r=new ChildThread3();
		Thread ct3=new Thread(r);
		ct3.setName("Siya");
		System.out.println("Child3 : "+ct3);
		
		LocalTime time1=LocalTime.now();
		System.out.println("Time before tasks started : "+time1);
		ct1.start();
		ct2.start();
		ct3.start();
		System.out.println("parent waiting..");
		try {
			ct1.join();
			ct2.join();
			ct3.join();
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
