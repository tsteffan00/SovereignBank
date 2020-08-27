package bank;

import java.io.Serializable;

public class BankAccounts implements Serializable {
	public static final long serialVersionUID = 7654321L;
	
	static int balance;
	int accountNumber;
	static int PIN;
	String Accessor;
	String jointAccessor;
	
	public BankAccounts(int balance, int accountNumber, int PIN, 
			String Accessor, String jointAccessor) {
		BankAccounts.balance = balance;
		this.accountNumber = accountNumber;
		BankAccounts.PIN = PIN;
		this.Accessor = Accessor;
		this.jointAccessor = jointAccessor;
	}

	public static int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		BankAccounts.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public static int getPIN() {
		return PIN;
	}

	public void setPIN(int pIN) {
		PIN = pIN;
	}

	public String getAccessor() {
		return Accessor;
	}

	public void setAccessor(String accessor) {
		Accessor = accessor;
	}

	public String getJointAccessor() {
		return jointAccessor;
	}

	public void setJointAccessor(String jointAccessor) {
		this.jointAccessor = jointAccessor;
	}
	
	/*TODO: BankAccounts need to have balance, account number and a PIN.
	 * The PIN is for the user to access their own account. The account number
	 * is for transferring to a target. Possibly just add Accessor and Joint Accessor
	 * properties to the Bank Account objects.
	 * 
	 * Bank accounts will need to have methods that deposit/withdraw from balance,
	 * report balance, and transfer funds.
	 */
	

}
