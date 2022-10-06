package synchronization;

public class SynchronizationDemo {

	public static void main(String[] args) {

		BankAccount ba=new BankAccount(123,11,50000);
		
		Runnable r1=new DepositThread(ba);
		Thread dpstThread=new Thread(r1,"Deposit Thread");
		
		Runnable r2=new WithdrawThread(ba);
		Thread withThread=new Thread(r2,"Withdraw Thread");
		
		dpstThread.start();
		withThread.start();
		
		try {
			dpstThread.join();
			withThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("parent ended...");
	}
}
