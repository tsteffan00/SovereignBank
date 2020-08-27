package bank;

import java.io.Serializable;

public class Customer implements Serializable {
	

	public static final long serialVersionUID = 1234567L;
	
	String firstName;
	String lastName;
	String userName;
	String password;

	static int PIN;
	
	public Customer (String firstName, String lastName, 
				String userName, String password, int PIN) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.PIN = PIN;
	}

	public Customer(String userName2, String password2) {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static int getPIN() {
		return PIN;
	}

	public void setPIN(int pIN) {
		PIN = pIN;
	}

	@Override
	public String toString() {
		return "Customer First Name=" + firstName + ", Last Name=" + lastName + ", User Name=" + userName + ", password="
				+ password+ "PIN: "+ PIN+"\n";
	}
	
}
