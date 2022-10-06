package extendingThread;

public class ChildThread1 extends Thread 
{
	public void  run()
	{
		System.out.println("Child thread 1 started..");
		iloop();
		System.out.println("child thread 1 ended..");
	}
	
	public void iloop()
	{
		Thread t=Thread.currentThread();
		System.out.println("task 1 started by "+t.getName()+"....");
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
		System.out.println("task 1 ended by "+t.getName()+"....");
	}
}
