package bank;

import java.io.Serializable;

public class Customer implements Serializable {
	public static final long serialVersionUID = 1234567L;
	
	String firstName;
	String lastName;
	String userName;
	String password;
	int accountPIN; //This number is exclusive per user.
	
	public Customer (String firstName, String lastName, 
				String userName, String password, int accountPIN) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.accountPIN = accountPIN;
	}
}
