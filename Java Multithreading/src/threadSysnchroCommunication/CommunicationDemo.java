package threadSysnchroCommunication;


public class CommunicationDemo {

	public static void main(String[] args) 
	{
		Operation op=new Operation();
		
		Runnable r1=new StockManagerThread(op);
		Thread stock=new Thread(r1,"Stock Manager Thread");
		
		Runnable r2=new CustomerThread(op);
		Thread customer=new Thread(r2,"Customer1 Thread");
		
		Thread customer3=new Thread(r2,"Customer2 Thread");
		
		Thread customer4=new Thread(r2,"Customer3 Thread");
		
		
		stock.start();
		customer.start();
		customer3.start();
		customer4.start();
		
	}

}
