package synchronization;

public class DepositThread implements Runnable{
	BankAccount ba;
	public DepositThread(BankAccount ba) 
	{
		this.ba=ba;
	}
	@Override
	public void run() {

		String name=Thread.currentThread().getName();
		System.out.println(name+ " started...");
		for(int i=1;i<=3;i++)
		{
		//	System.out.println("----Deposit "+i+"started----");
			ba.deposit(30000);
		//	System.out.println("----Deposit "+i+"ended----");
			
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name+ " ended...");
	}
}
