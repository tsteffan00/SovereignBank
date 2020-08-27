package bank;

import java.util.ArrayList;
import java.util.Scanner;

public class Prompts {
	private static final String password = null;
	private static String userName;

	public static void initialPrompt() {
		System.out.println("Welcome to Sovereign Bank.\n"
				+ "If logging in, press 1. If registering a new account, "
				+ "press 2. Admin/Employee login, press 3. To exit, press 4.");
		Scanner userReader = new Scanner(System.in);
		ArrayList<String> userLoginHolder = new ArrayList<String>(); //Holds First name, last name, Username, and password
		ArrayList<String> adminHolder = new ArrayList<String>(); //holds the admin username and password
		
		int errorCounter = 0;
		while (errorCounter == 0) {
			
		int numInput = userReader.nextInt();
		
			switch (numInput) {
			case 1: // Login Option
				Customer custome= new Customer(userName,password);
				BankLib.readCustomersFromFile();
				System.out.println("Please input your username:");
				userLoginHolder.add(userReader.next());
				System.out.println("Please input your password:");
				userLoginHolder.add(userReader.next());
				BankLib.login(userLoginHolder.get(0), userLoginHolder.get(1));
				

				
				errorCounter++;
				accountMenuPrompt(custome);

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
				

				
				//Creates the object of the Customer account, and adds it into an ArrayList<Customer>
				Customer customer = new Customer(userName, password, firstName, lastName, 0);
				masterCustList.add(customer);
				
				BankLib.saveCustomerToFile(masterCustList);
				
				//Prints out a message in console so the customer can see.
				System.out.println("\nUsername: " + userLoginHolder.get(0) + 
						"\n" + "Password: " + userLoginHolder.get(1) + 
						"\n" + "PIN: " + userLoginHolder.get(3)); //Test output to console.
				
				errorCounter++;
				accountMenuPrompt(customer);
				break;
			case 3: 
				
				BankLib.readAdminFromFile();
				System.out.println("Enter username: ");
				adminHolder.add(userReader.next());
				System.out.println("Enter password: ");
				adminHolder.add(userReader.next());
				BankLib.adlogin(adminHolder.get(0),adminHolder.get(0));
				adminMenuPrompt();
				break;
				
			case 4: //Exit
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
		Scanner actionReader = new Scanner(System.in);
		System.out.println("=========================================================");
		System.out.println("Welcome back to Sovereign Bank Services, " 
									+ customer.getFirstName() + customer.getLastName());
		System.out.println("Do you have a standing account with us? (Y/N)");
		String standingAccount = actionReader.next();
		
		switch (standingAccount) {
		case "Y":
			System.out.println("Please enter your account's PIN.");
			int PIN = actionReader.nextInt();
			accountActionPrompt(customer);
			break;
		case "N":
			
		}
		
	}
		
		
		
	public static int accountActionPrompt(Customer customer) {
		Scanner actionReader = new Scanner(System.in);
		System.out.println("What service would you like to perform today?");
		System.out.println("Press the corresponding number to perform your desired service:");
		System.out.println("1. Deposit  || 3. Transfer Funds");
		System.out.println("2. Withdraw || 4. Apply for New Account");
		System.out.println("5. Balance  || 6. Apply to Joint Ownership");
		System.out.println("            ||    of a Pre-existing Account");
		System.out.println("=========================================================");


		int numInput = actionReader.nextInt();
		
		switch (numInput) {
		
			case 1:
				System.out.println("How much would you like to deposit?");
				numInput=actionReader.nextInt();
				if(BankAccounts.getBalance() <= numInput) {
					
					int updatedBalance=BankAccounts.getBalance()+numInput;
					return updatedBalance;	
				}
				
				break;
			case 2:
				System.out.println("How much would you like to withdraw?");
				numInput=actionReader.nextInt();
				if(BankAccounts.getBalance() <= numInput) {
					int updatedBalance=BankAccounts.getBalance()-numInput;
					return updatedBalance;	
				}
				break;
			case 3:
				System.out.println("How much would you like to transfer?");
				numInput=actionReader.nextInt();
				if(BankAccounts.getBalance() <= numInput) {
					int updatedBalance=BankAccounts.getBalance()-numInput;
					return updatedBalance;	
				}
				break;
			case 4:
				BankLib.applyForNewAccount(customer);


				System.out.println("Your account PIN is: " + BankAccounts.getPIN());
				accountActionPrompt(customer);
			case 5:
				/*Directs to method that, upon acceptance, sends PIN of account back to new user.
				 * This may not fall under assignment requirements.
				 */
			default:
				return numInput; 
		}
		return numInput;
	}
	
	/* This menu prompt will have all of the options for admin in it.
	 * 
	 */
	public static void adminMenuPrompt() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What services would you like to perform today?"+"\n"
							+"1)Delete an account " + " 2)Edit a Deposit"+"\n"
							+"3)Edit a withdraw " + " 4)Approve/Deny an Account");
		int input = scan.nextInt();
		
		switch(input) {
		case 1:
			Admin.deleteAccount();
			break;
		case 2:
			Admin.editAccountDeposit();
			break;
		case 3:
			Admin.editAccountWithdraw();
			break;
		case 4:
			Admin.approveAccounts();
			break;
		default:
			return;
		
		}
		
	}
	
	/*This menu prompt will have all Employee options in it.
	 * 
	 */
	public static void employeeMenuPrompt() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What services would you like to perform today?"+"\n"
							+"1)View Customer Information" + "2)Approve/Deny an Account");
		int input = scan.nextInt();
		
		switch(input) {
		case 1:
			Scanner scann = new Scanner(System.in);
			System.out.println("What is the account number of the Customer you want to look up?");
			int view = scann.nextInt();
			//BankLib.writeBankAccountToFile();
			
			break;
			
		case 2:
			Admin.approveAccounts();
			break;
		
		default:
			return;
		}
	}
}
