package bank;

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

	}
}