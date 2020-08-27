package bank;

import java.io.Serializable;

public class BankAccounts implements Serializable {
	public static final long serialVersionUID = 7654321L;
	
	Double balance;
	int accountNumber;
	int PIN;
	String Accessor;
	String jointAccessor;
	
	public BankAccounts(Double balance, int accountNumber, int PIN, 
			String Accessor, String jointAccessor) {
		this.balance = balance;
		this.accountNumber = accountNumber;
		this.PIN = PIN;
		this.Accessor = Accessor;
		this.jointAccessor = jointAccessor;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPIN() {
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
