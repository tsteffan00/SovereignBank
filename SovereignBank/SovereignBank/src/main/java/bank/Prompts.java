package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Prompts {
	public static void initialPrompt() {
		System.out.println("Welcome to Sovereign Bank.\n"
				+ "If logging in, press 1. If registering a new account, "
				+ "press 2. To exit, press 3.");
		Scanner userReader = new Scanner(System.in);
		ArrayList<String> userLoginHolder = new ArrayList<String>(); //Holds First name, last name, Username, password and PIN
		
		int errorCounter = 0;
		while (errorCounter == 0) {
			
		int numInput = userReader.nextInt();
		
			switch (numInput) {
			case 1: // Login Option
				BankLib.readCustomersFromFile();
				System.out.println("Please input your username:");
				userLoginHolder.add(userReader.next());
				System.out.println("Please input your password:");
				userLoginHolder.add(userReader.next());
				BankLib.login(userLoginHolder.get(0), userLoginHolder.get(1));
				

				
				errorCounter++;
				break;
			case 2: // Registration Option
				ArrayList<Customer> masterCustList = new ArrayList<Customer>();

				
				/*TODO: IF there are no customer objects in masterCustArray, create admin account.
				 * Customer(admin, admin, John, Doe, ****)
				 */
				
				System.out.println("Please input your desired username:");
				String userName = userReader.next();
				BankLib.usernameUniqueCheck(userReader.next()); //This method ensures username is unique.
				userLoginHolder.add(userName);
				System.out.println("Please input your desired password:");
				String password = userReader.next();
				userLoginHolder.add(password);
				System.out.println("What is your first name?");
				String firstName = userReader.next();
				userLoginHolder.add(firstName);
				System.out.println("What is your last name?");
				String lastName = userReader.next();
				userLoginHolder.add(lastName);
				
				//Generates PIN number.
				int accountPIN = BankLib.pinGenerator();
				userLoginHolder.add(Integer.toString(accountPIN));
				System.out.println("Your account Personal ID Number is: " + accountPIN);
				
				//Creates the object of the Customer account, and adds it into an ArrayList<Customer>
				Customer customer = new Customer( userName, password, firstName, lastName, accountPIN);
				masterCustList.add(customer);
				
				BankLib.saveCustomerToFile(masterCustList);
				
				//Prints out a message in console so the customer can see.
				System.out.println("\nUsername: " + userLoginHolder.get(2) + 
						"\n" + "Password: " + userLoginHolder.get(3) + 
						"\n" + "PIN: " + userLoginHolder.get(4)); //Test output to console.
				
				errorCounter++;
				break;
			case 3: //Exit
				System.out.println("Goodbye. Bank with us again soon.");
				System.exit(0);
			default: // Bad input catcher.
				System.out.println("Incorrect input. Please try again.");
				break;
			}
		}
	}
	
	
		/* Decide how to structure Bank Accounts as separate objects. Consider moving PIN to
		 *  the account, so PIN is generated on application acceptance.
		 *  Also consider AccountPrompt asking for an account number when transferring funds.
		 *  TODO: Figure out how to properly get the right customer properties.
		 */
	
	public static void accountMenuPrompt(Customer customer) { 
		System.out.println("=========================================================");
		System.out.println("Welcome back to Sovereign Bank Services, " 
									+ customer.get(2) + customer.get(3));
		System.out.println("Your PIN is: " + customer.get(5));
		System.out.println("What service would you like to perform today?");
		System.out.println("Press the corresponding number to perform your desired service:");
		System.out.println("1. Deposit  || 3. Transfer Funds");
		System.out.println("2. Withdraw || 4. Apply for New Account");
		System.out.println("5. Balance  || 6. Apply to Joint Ownership");
		System.out.println("            ||    of a Pre-existing Account");
		System.out.println("=========================================================");

		Scanner actionReader = new Scanner(System.in);
		int numInput = actionReader.nextInt();
		
		switch (numInput) {
			case 1:
				//Directs to deposit method.
			case 2:
				//Directs to withdraw method.
			case 3:
				//Directs to Transfer Funds method.
			case 4:
				//Directs to application for new account method.
			case 5:
				/*Directs to method that, upon acceptance, sends PIN of account back to new user.
				 * This may not fall under assignment requirements.
				 */
		}
	}
	
	/* This menu prompt will have all of the options for admin in it.
	 * 
	 */
	public static void adminMenuPrompt() {
		
	}
	
	/*This menu prompt will have all Employee options in it.
	 * 
	 */
	public static void employeeMenuPrompt() {
		
	}
}
