package threadSysnchroCommunication;



public class StockManagerThread implements Runnable
{
	Operation op;
	public StockManagerThread(Operation op) {
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
			while(true)
			{
				op.stockManager();
				
					Thread.sleep(500);
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
