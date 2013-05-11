/**
 * $Id$
 * 
 * $Log$
 * 
 * $Revision$
 */
package project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The customer command line interface.  Allows the customer to connect to a 
 * machine and make transactions from it.
 * 
 * @author FTM
 */
public class CustomerCML {

	//This is the model that provides funcionality for performing use case
	//actions on vending machines
	private Customer customerModel;
	
	/**
	 * Loads up a customer use sequence for logging into a machine and 
	 * transacting.  Handles welcome message and startup
	 * @param machine the vending system that the customer is entering into
	 * @param scan standard input parser to take user inputs.
	 * @param system The vending machine system (for stat adding)
	 */
	public void runCustomer(VendingMachine machine, Scanner scan, 
			VendingSystem system) {

		System.out.println("Welcome to French Toast Vending");
		customerModel = new Customer(system, machine);
		transaction(machine, scan);

	}

	/**
	 * The main loop for transacting, after one has logged into a machine
	 * @param machine the chosen machine we are logged into
	 * @param scan the input scanner
	 */
	public void transaction(VendingMachine machine,
			Scanner scan) {
		boolean continueLoop = true;

		//Transaction loop
		while (continueLoop) {

			//Display menu options
			machine.printAvailableItems();
			machine.printCustomerBalance();
			int userChoice = getInt("\n0. Quit This Vending Machine\n1. Insert Money\n2. Make Selection\n3. Refund Change",scan);

				switch (userChoice) {
				case 1:
					commandLineInsertMoney(scan);
					break;
				case 2:
					commandLineMakeSelection(scan);
					break;
				case 3:
					commandLineCoinReturn();
					break;
				case 0:
					commandLineQuit();
					return;
				default:
					System.out.println("Invalid Input-customer");
					break;

				}// end switch
		}// end while
	}// end method
	
	/**
	 * Takes command line inputs and guarentees correct int input
	 * @param prompt The message displayed before input.
	 * @param scan the scanner used for grabbing user input
	 * @return the number that the user inputed
	 */
	public int getInt(String prompt, Scanner scan){
		boolean validInput = false;
		int intInput = 0;
		String stringInput;
		//scan.reset();
		
		//loop until input is valid
		while(!validInput){
			System.out.println(prompt);
			stringInput = scan.nextLine();
			//check for valid input
			try{
				intInput = Integer.parseInt(stringInput);
				if(intInput >= 0){
					validInput = true;
				}else{
					System.out.println("Enter positive value");
				}
			}catch(NumberFormatException e){
				System.out.println("Invalid Input-customer");
			}//end catch
		}//end while
		return intInput;
	}//end getInt

	/**
	 * This is the command line interface for inserting money into the 
	 * machine
	 * @param scanner The scanner being used to insert money
	 */
	private void commandLineInsertMoney(Scanner scan){
		System.out.println("Amount inserted: ");
		//Check for valid money input
		try {
			String temp = scan.nextLine();
			double amountInserted = Double.parseDouble(temp);
			if (amountInserted >= 0) {
				customerModel.insertMoney(amountInserted);
			} else {
				System.out
						.println("You have inserted a negative value");
			}
		} catch (Exception e) {
			System.out.println("\nInvalid Input\n");
		}
	}
	
	/**
	 * This is the command line interface for making a selection on an item
	 * @param scan The input scanner
	 */
	private void commandLineMakeSelection(Scanner scan){
		System.out.println("Make Selection: ");
		
		ArrayList<Item> avail = customerModel.getAvailableItemList();
		
		//Checks for valid number input for vending machine item
		try {
			String temp = scan.nextLine();
			int selection = Integer.parseInt(temp);
			if (selection >= 0 && selection < avail.size()) {
				Item item = avail.get(selection);
				boolean isbought = customerModel.selectItem(item);
				if(isbought){
					//system.addStat is in the customer Model now, this
					//is the viewer now
				}
			} else {
				System.out.println("Item not in machine");
			}
		} catch (Exception e) {
			System.out.println("\nInvalid Input\n");
		}
	}
	
	/**
	 * This is the command line interface that goes through a coin return
	 * procedure; simply displays info using print()
	 */
	private void commandLineCoinReturn(){
		double customerBalance = customerModel.getBalance();
		customerModel.refund();
		System.out.printf("Your change is: $");
		System.out.printf("%.2f", customerBalance);
		System.out.println("");
	}
	
	/**
	 * This is the command line interface that goes through the quit/logout
	 * procedure; simply displays info using print()
	 * Logs out of the machine for the customerModel.
	 */
	private void commandLineQuit(){
		double customerBalance = customerModel.getBalance();
		customerModel.logout();
		System.out.printf("Your change is: $");
		System.out.printf("%.2f", customerBalance);
		System.out.println("");
		System.out.println("Now Exiting the Vending Machine");
	}
	
}
