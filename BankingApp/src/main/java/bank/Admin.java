package bank;
import java.util.Scanner;

public class Admin {

	String userName;
	String password;
	
	
	
	public Admin() {
		super();
		
	}
	
	public Admin(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
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

	
	
	public static void deleteAccount() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is the account number of the Customer you want to delete?");
		int deletion = scan.nextInt();
		BankLib.readCustomersFromFile().remove(deletion);
          		
	}
	
	public static int editAccountDeposit() {

		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to credit the account?");
		int credit = scan.nextInt();
		return credit;
	}
	
	public static int editAccountWithdraw() {
		Scanner scan = new Scanner(System.in);
		System.out.println("How much would you like to withdraw from the account?");
		int takeAway = scan.nextInt();
		return takeAway;
	}
	
	public static boolean approveAccounts() {
		boolean approve = true;
		if(approve = true) {
			return Applications.getApproved();
		}
		return false;
	}
	
}
