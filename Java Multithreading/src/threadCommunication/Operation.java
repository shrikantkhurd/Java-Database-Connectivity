package threadCommunication;

public class Operation {
	private int v=0;
	boolean flag=false;
	
	public synchronized void produce() throws InterruptedException
	{
	//	System.out.println("Locked by producer thread");
		Thread.sleep(200);
		if(flag==true)
		{
		//	System.out.println("Producer is waiting to consume the value");
		//	System.out.println("Unlocked by producer thread");
			wait();
		//	System.out.println("Producer got notification");
		}
		v++;
		Thread.sleep(1000);
		System.out.println("Produced: "+v);
		flag=true;
		notify();
		Thread.sleep(500);
	//	System.out.println("Unlocked by producer thread");
	}
	
	public synchronized void consume() throws InterruptedException
	{
	//	System.out.println("Locked by consumer thread");
		Thread.sleep(1000);
		if(flag==false)
		{
		//	System.out.println("Consumer is waiting to producer the value");
		//	System.out.println("Unlocked by consumer thread");
			wait();
		//	System.out.println("Consumer got notification");
		}
		System.out.println("Consumed: "+v);
		Thread.sleep(2000);
		flag=false;
		notify();
	//	System.out.println("Unlocked by consumer thread");
	}
}
