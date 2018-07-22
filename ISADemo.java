abstract class Account{
	int id;
	String name;
	double balance;
	void deposit(){
		System.out.println("Account Deposit...");
	}
	void roi(){
		System.out.println("ROI 4%");
	}
	abstract void services();
}
class SavingAccount extends Account {
	void limit(){
		System.out.println("Limit is 50K");
	}
	@Override
	void roi(){
		super.roi();
		System.out.println("ROI 5%");
	}
	@Override
	void services() {
		// TODO Auto-generated method stub
		System.out.println("Door to Door Service");
		
	}
}
class CurrentAccount extends Account{
	void odLimit(){
		System.out.println("Od Limit 1 Lakh ");
	}
	@Override
	void roi(){
		System.out.println("ROI 5.5% Pay");
	}
	@Override
	void services() {
		// TODO Auto-generated method stub
		System.out.println("Charge Service for Door to Door.");
	}
}
class AccountCaller{
	void callAccount(Account account){
		
		account.deposit();
		account.roi();
		if(account instanceof SavingAccount){
			SavingAccount sa= (SavingAccount) account;  // Downcasting
			sa.limit();
		}
		if(account instanceof CurrentAccount){
			CurrentAccount ca = (CurrentAccount) account;
			ca.odLimit();
		}
	System.out.println("********************************");
	}

}
public class ISADemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Account acObject = new Account();
		AccountCaller ac = new AccountCaller();
		Account account = new SavingAccount();
		ac.callAccount(account);
		ac.callAccount(new CurrentAccount());
		
//		Account account = new SavingAccount(); // Upcasting
//		account.deposit();
//		account.roi();
//		System.out.println("****************");
//		account = new CurrentAccount(); // Upcasting
//		account.deposit();
//		account.roi();
		//account.limit();
		
		/*SavingAccount savingAccount = new SavingAccount();
		savingAccount.deposit();
		savingAccount.limit();
		savingAccount.roi();
		System.out.println("*************************");
		
		CurrentAccount currentAccount = new CurrentAccount();
		currentAccount.deposit();
		currentAccount.odLimit();
		currentAccount.roi();*/
		
		

	}

}







