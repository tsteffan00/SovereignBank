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
	
<<<<<<< HEAD
	public static int routingNum() {
		ArrayList<Integer> routNum = new ArrayList<Integer>(); //logs all rouning numbers
		Random ran = new Random();
		int minimum = 10000;
		int ranRange = 99999 - minimum + 1;
		int routCount= 0;
		int routingNumber = 0;
			while (routCount == 0) { //This loop ensures unique routing number
			routingNumber = ran.nextInt(ranRange) + minimum; 		
					if (routNum.contains(routingNumber) == false) {
						routCount++;

					}
				}
			return routingNumber;
			}
	
	public static int accNum() {
		//you could use the same generator as routing number or make a new one

=======
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
>>>>>>> 32f84746401266a3955d2cccb77fc3a6513ec0e8
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