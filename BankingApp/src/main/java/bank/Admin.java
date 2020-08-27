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
		int pin = scan.nextInt();
		while(pin!=BankAccounts.getPIN()) {
		int deletion = scan.nextInt();
		BankLib.readCustomersFromFile().remove(deletion);
          		
	}
	}
	public static int editAccountDeposit() {

		Scanner scan = new Scanner(System.in);
		System.out.println("Who's account would you like to alter?");
		int pin = scan.nextInt();
		while(pin!=BankAccounts.getPIN()) {
		System.out.println("How much would you like to credit the account?");
		int credit = scan.nextInt();
		int currentBalance= BankAccounts.getBalance();
		int updatedBalance = currentBalance+credit;
		System.out.println(currentBalance);
		return updatedBalance;
		
	}
		return pin;
	}
	public static int editAccountWithdraw() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Who's account would you like to alter?");
		int pin = scan.nextInt();
		while(pin!=BankAccounts.getPIN()) {
		System.out.println("How much would you like to withdraw from the account?");
		int takeAway = scan.nextInt();
		int currentBalance= BankAccounts.getBalance();
		int updatedBalance = currentBalance-takeAway;
		System.out.println(updatedBalance);
		return updatedBalance ;
	}
		
		return pin ;
	}
	
		
	public static boolean approveAccounts() {
		boolean approve = true;
		if(approve = true) {
			return Applications.getApproved();
		}
		return false;
	}
	
}
