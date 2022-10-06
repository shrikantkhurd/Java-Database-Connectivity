package extendingThread;

public class ChildThread2 extends Thread
{
	public void  run()
	{
		System.out.println("Child thread 2 started..");
		jloop();
		System.out.println("child thread 2 ended..");
	}
	
	public void jloop()
	{
		Thread t=Thread.currentThread();
		System.out.println("task 2 started by "+t.getName()+"....");
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
		System.out.println("task 2 ended by "+t.getName()+"....");
	}
}
