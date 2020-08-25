package bank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;

public class BankLib {
	
	//This method generates PINs and confirms that they are unique.
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
	
	public void saveCustomerToFile(ArrayList<Customer> customerList) {
		try {
			FileOutputStream fileOut = new FileOutputStream("userlogin.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(customerList);
			out.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("FileNotFoundException: " + fnfe);
		} catch (IOException ioe) {
			System.out.println("IOException: " + ioe);
			ioe.printStackTrace();
		}
	}
	
	public void readCustomersFromFile() {
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
	}
	
	
}