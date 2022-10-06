package threadCommunication;

public class ProducerThread implements Runnable
{
	Operation op;
	 public ProducerThread(Operation op) {
		// TODO Auto-generated constructor stub
		this.op=op;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String name=Thread.currentThread().getName();
		System.out.println(name+" started...");
		try 
		{
			//while(true)
			for(int i=1;i<=5;i++)
			{
				op.produce();
				
					Thread.sleep(5000);
			}
		}
		 catch (InterruptedException e) 
		 {
					// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		System.out.println(name+" ended...");
	}

}
