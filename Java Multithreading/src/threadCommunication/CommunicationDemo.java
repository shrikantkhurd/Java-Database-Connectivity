package threadCommunication;

public class CommunicationDemo {

	public static void main(String[] args) 
	{
		Operation op=new Operation();
		
		Runnable r1=new ProducerThread(op);
		Thread produceThread=new Thread(r1,"Producer Thread");
		
		Runnable r2=new ConsumerThread(op);
		Thread consumeThread=new Thread(r2,"Consumer Thread");
		
		produceThread.start();
		consumeThread.start();
		
		//produceThread.join();
	}
}
