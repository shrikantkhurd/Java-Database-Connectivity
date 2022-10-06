package synchronization;

public class BankAccount {
 public int accNo;
 public int custId;
 public int balance;

public BankAccount(int accNo, int custId, int balance) 
{
	super();
	this.accNo = accNo;
	this.custId = custId;
	this.balance = balance;
}

@Override
public String toString() 
{
	return "BankAccount [accNo=" + accNo + ", custId=" + custId + ", balance=" + balance + "]";
}

public void deposit(int dpstamt)
 {
	 try 
	 {
	 
	 	synchronized (this) 
	 	{
	//	System.out.println("---- DEPOSIT RESOURCE LOCKED---");
		System.out.println("Balance before deposit: "+balance);
			Thread.sleep(3000);
		System.out.println("Deposit amt: "+dpstamt);
		Thread.sleep(2000);
		balance=balance+dpstamt;
		System.out.println("Balance after deposit: "+balance);
		Thread.sleep(1000);
		//System.out.println("---- DEPOSIT RESOURCE UNLOCKED---");
	 	}
	 }	
	 catch (InterruptedException e) 
	 {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 }
 }
 
 public synchronized void withdraw(int withamt)
 {
	 try 
	 {
	//	System.out.println("---- WITHDRAW RESOURCE LOCKED---");
		System.out.println("Balance before withdraw: "+balance);
		Thread.sleep(1500);
		System.out.println("withdraw amt: "+withamt);
		Thread.sleep(3000);
		balance=balance-withamt;
		System.out.println("Balance after withdraw: "+balance);
		Thread.sleep(1200);
	 }	
	 catch (InterruptedException e) 
	 {
			// TODO Auto-generated catch block
			e.printStackTrace();
	 }
	// System.out.println("---- WITHDRAW RESOURCE UNLOCKED---");
 }
}
