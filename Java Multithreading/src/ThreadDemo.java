import java.time.LocalTime;

class Loops
{
	public void iloop()
	{
		System.out.println("task 1 started :");
		for(int i=1;i<=5;i++)
		{
			System.out.println("iloop :- "+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("task 1 ended :");
	}
	
	public void jloop()
	{
		System.out.println("task 2 started :");
		for(int j=5;j>=1;j--)
		{
			System.out.println("jloop :- "+j);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("task 2 ended :");
	}
	public void kloop()
	{
		System.out.println("task 3 started :");
		for(char k='a';k<='e';k++)
		{
			System.out.println("kloop :- "+k);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("task 3 ended :");
	}
}

public class ThreadDemo {

	public static void main(String[] args) {
		System.out.println("Parent thread started..");
		Thread pt=Thread.currentThread();
		System.out.println("Current Thread :- "+pt);
		
		String name=pt.getName();
		System.out.println("Name of thread: "+name);
		
		int pr=pt.getPriority();
		System.out.println("priority is :- "+pr);
		
		pt.setName("LoopsParentThread");
		System.out.println(" Thread :- "+pt);
		
		pt.setPriority(3);
		pr=pt.getPriority();
		System.out.println("priority change :- "+pr);
		
		boolean isalive=pt.isAlive();
		System.out.println(isalive);
		
		Loops loop=new Loops();
		LocalTime time1=LocalTime.now();
		loop.iloop();
		loop.jloop();
		loop.kloop();
		
		LocalTime time2=LocalTime.now();
		int totalTime=time2.toSecondOfDay()-time1.toSecondOfDay();
		System.out.println("Execution time to complete 3 tasks :- "+totalTime+ "seconds");
		System.out.println("Parent thread ended.");
	}
}
