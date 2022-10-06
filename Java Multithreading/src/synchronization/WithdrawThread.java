package synchronization;

public class WithdrawThread implements Runnable{

	BankAccount ba;
	public WithdrawThread(BankAccount ba) 
	{
		this.ba=ba;
	}
	@Override
	public void run() {

		String name=Thread.currentThread().getName();
		System.out.println(name+ " started...");
		for(int i=1;i<=3;i++)
		{
		//	System.out.println("----Withdraw "+i+"started----");
		//	synchronized(ba)
		//	{
			ba.withdraw(20000);
		//	}
		//	System.out.println("----Withdraw "+i+"ended----");
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name+ " ended...");
	}
}
