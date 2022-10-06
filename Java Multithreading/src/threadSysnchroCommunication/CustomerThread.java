package threadSysnchroCommunication;


public class CustomerThread implements Runnable
{
	Operation op;
	 public CustomerThread(Operation op) {
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
			while(true) {
				Thread.sleep(5000);
				op.customer();
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
