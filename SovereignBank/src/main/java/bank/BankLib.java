package bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankLib { 
	/*TODO: Ask about how to implement Serializable. May have to move
	 * the read/write methods to special class.
	 */
	
	ArrayList<BankAccounts> bankList = new ArrayList<BankAccounts>();
	
	/*
	 * This method generates PINs and confirms that they are unique.
	 */
	public static int pinGenerator() {
	ArrayList<Integer> pins = new ArrayList<Integer>(); //logs all PINs
	Random rand = new Random();
	int minimum = 1000;
	int randRange = 9999 - minimum + 1;
	int pinGenErrCount = 0;
	int generatedPIN = 0;
		while (pinGenErrCount == 0) { //This loop ensures unique PINs.
		generatedPIN = rand.nextInt(randRange) + minimum; 		
				if (pins.contains(generatedPIN) == false) {
					pinGenErrCount++;

				}
			}
		return generatedPIN;
		}
	
	/*This method saves the array list holding ALL bank customers (customer objects) 
	 * back to the userlogin.txt file in the package.
	 */
	public static void saveCustomerToFile(ArrayList<Customer> masterCustList) {
		try {
			FileOutputStream fileOut = new FileOutputStream("userlogin.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(masterCustList);
			out.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException: " + fnfe);
		} catch (IOException ioe) {
			System.out.println("IOException: " + ioe);
			ioe.printStackTrace();
		}
	}
	
	/*This method pulls the masterCustList array list from userlogin.txt
	 * in order for the data to be used by the program.
	 */
	public static ArrayList<Customer> readCustomersFromFile() {
		ArrayList<Customer> masterCustList = null; //MAY CAUSE BREAK
		
		try
        {    
            FileInputStream file = new FileInputStream("userlogin.txt"); 
            ObjectInputStream in = new ObjectInputStream(file); 
            masterCustList = (ArrayList<Customer>) in.readObject();      
            in.close(); 
            file.close();
            return masterCustList;
        } catch (IOException ioe) {
			System.out.println("IOException: " + ioe);
        } catch (ClassNotFoundException cnfe) {
			System.out.println("Invalid username or password. Please try again.");
        	cnfe.printStackTrace();
        }
		return masterCustList; 
	}
	
	/*This method reads the master customer list and checks against it to ensure
	 * a unique user name. If user name is not unique, it prompts user and re-runs the
	 * check.
	 */
	public static void usernameUniqueCheck(String userName) {
		ArrayList<Customer> masterCustList = readCustomersFromFile();
		Scanner userReader = new Scanner(System.in);
		int userNameErrChk = 0;
		while (userNameErrChk == 0) {
			for (Customer customer : masterCustList)
		    if(customer.equals(userName) == true) { //MAY CAUSE BREAK
		        System.out.println("Username is taken. Please pick another one.");
		        userName = userReader.next();
		    } else {
		    	userNameErrChk++;
		    }
		}
	}
	
	/*This method will read the username and password to the master customer list
	 * and look for matches. If it matches, it will return that object index.
	 * TODO: Add a nested If-if checking for admin login and employee login.
	 * Send them to different menus.
	 */
	
	public static void login(String userName, String password) {
		ArrayList<Customer> masterCustList = null;
		masterCustList = readCustomersFromFile();
		for (Customer customer : masterCustList) {
			if (customer.equals(userName) && customer.equals(password)) {
				Prompts.accountMenuPrompt(customer);
			} else {
				System.out.println("That user does not exist. Goodbye.");
				System.exit(0);
			}
		}
	}
	
	public void applyForNewAccount(Customer customer) {
		
	}
	
	public void createNewAccount(Customer customer) {
		
		Double balance = 0.0;
		Random rand = new Random();
		int minimum = 1000;
		int randRange = 9999 - minimum + 1;
		int accountNumber = rand.nextInt(randRange) + minimum;
		String Accessor = customer.getUserName();
		String jointAccessor = "";
		int PIN = BankLib.pinGenerator();
		BankAccounts bankaccount = new BankAccounts(balance, accountNumber, PIN, Accessor, jointAccessor);
		bankList.add(bankaccount);
		writeBankAccountToFile(bankList);
		
	}
	
	public void writeBankAccountToFile(ArrayList<BankAccounts> bankaccount) {
		try {
			FileOutputStream fileOut = new FileOutputStream("bankaccounts.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(bankList);
			out.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException: " + fnfe);
		} catch (IOException ioe) {
			System.out.println("IOException: " + ioe);
			ioe.printStackTrace();
		}
	}
}