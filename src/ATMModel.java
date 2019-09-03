
public class ATMModel {

	private double balance;
	
	public ATMModel( ) {
		balance = 0.0;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public boolean deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			return true;
		} else {
			return false;
		}
	}
	
}
