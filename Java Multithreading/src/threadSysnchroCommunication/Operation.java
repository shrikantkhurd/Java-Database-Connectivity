package threadSysnchroCommunication;

public class Operation 
{
	private int v=5;
	
	public synchronized void stockManager() throws InterruptedException
	{
	//	System.out.println("Stock: "+v);
	//	Thread.sleep(2000);
		if(v<=5 && v>0)
		{
			wait();
		//	System.out.println("--- stockManager got notification ---");
		}
			v=v+5;
			Thread.sleep(3000);
			System.out.println("Add Stock: "+v);
			notifyAll(); //multiple customer.
			
			System.out.println("Customer got notification");
		//	System.out.println("Notification sent to customer.");
			
		}
	
	public synchronized void customer() throws InterruptedException
	{
		Thread.sleep(2000);
		if(v==0)
		{
			wait();
			System.out.println("customer got notification");
		}
	
		Thread.sleep(3000);
		System.out.println("Purchesed: "+v);
		v--;
		if(v==0)
		{
		notify();// only one stock manager
		System.out.println("--- stockManager got notification ---");
//		System.out.println("Notification sent to customer.");
		}
		Thread.sleep(500);
	}
}
