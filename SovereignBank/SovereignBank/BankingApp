package bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
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
				System.out.println("Please input your username:");
				userLoginHolder.add(userReader.next());
				System.out.println("Please input your password:");
				userLoginHolder.add(userReader.next());

				/*if(userLoginHolder.get(0) && userLoginHolder.get(1) == ) {
					
					try
			        {    
			            FileInputStream file = new FileInputStream("userlogin.txt"); 
			            ObjectInputStream in = new ObjectInputStream(file); 
			              
			            userLoginHolder = (ArrayList<String>)in.readObject(); 
			              
			            in.close(); 
			            file.close(); 
			        } catch (IOException ioe) {
						System.out.println("IOException: " + ioe);
			        }
				} else {
					System.out.println("Invalid username or password. Please try again.");
				}*/
				
				//Connect array with pre-existing account read from userlogin.txt.
				errorCounter++;
				break;
			case 2: // Registration Option
				System.out.println("What is your first name?");
				String firstName = userReader.next();
				userLoginHolder.add(firstName);
				System.out.println("What is your last name?");
				String lastName = userReader.next();
				userLoginHolder.add(lastName);
				
				System.out.println("Please input your desired username:");
				String userName = userReader.next();


				//This block ensures username is unique.
				int userNameErrChk = 0;
				while (userNameErrChk == 0) {
				    if(Customer.contains(Customer.get(userName)) == true) {
				        System.out.println("Username is taken. Please pick another one.");
				        userName = userReader.next();
				    } else {
				    	userNameErrChk++;
				    }
				}
				userLoginHolder.add(userName);
				
				System.out.println("Please input your desired password:");
				String password = userReader.next();
				userLoginHolder.add(password);
				
				//Generates PIN number.
				int accountPIN = BankLib.pinGenerator();
				userLoginHolder.add(Integer.toString(accountPIN));
				System.out.println("Your account Personal ID Number is: " + accountPIN);
				
				//Creates the object of the Customer account, and adds it into an ArrayList<Customer>
				Customer customer = new Customer(firstName, lastName, userName, password, accountPIN);
				ArrayList<Customer> customerList = new ArrayList<Customer>();
				customerList.add(customer);
				
				//Prints out a message in console so the customer can see.
				System.out.println("\nUsername: " + userLoginHolder.get(2) + 
						"\n" + "Password: " + userLoginHolder.get(3) + 
						"\n" + "PIN: " + userLoginHolder.get(4)); //Test output to console.
				
				try {
					FileOutputStream fileOut = new FileOutputStream("userlogin.txt", true);
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					out.writeObject(customerList);
					out.close();
				} catch (FileNotFoundException fnfe) {
					System.out.println("FileNotFoundException: " + fnfe);
				} catch (IOException ioe) {
					System.out.println("IOException: " + ioe);
					ioe.printStackTrace();
				}
				
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
}
