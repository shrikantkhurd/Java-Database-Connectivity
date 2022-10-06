package extendingThread;

//public class ChildThread3 extends Thread
public class ChildThread3 implements Runnable
{
	public void  run()
	{
		System.out.println("Child thread 3 started..");
		kloop();
		System.out.println("child thread 3 ended..");
	}
	
	public void kloop()
	{
		Thread t=Thread.currentThread();
		System.out.println("task 3 started by "+t.getName()+"....");
		for(char k='A';k<='E';k++)
		{
			System.out.println("kloop :- "+k);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("task 3 ended by "+t.getName()+"....");
	}
}
