package project;
/**
 * $Log$
 * $Id$
 * $Revision$
 */

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This is the customer model that provides functionality to peek into a 
 * machine and perform customer operations onto it
 * @author French Toast Mafia
 */
public class Customer implements Serializable{
	
	//This is the machine that this customer will be performing on.
	private VendingMachine currentMachine;
	
	//This is the system that the customer's machine is contained in
	//  (this is used to plug customer statistics into the statistics)
	private VendingSystem vendingSystem;
	
	/**
	 * Default constructor
	 */
	public Customer() {
	}
	
	/**
	 * Constructor for a Customer.  Will likely be used in Customer GUI
	 * @param machine The machine this customer will log in to upon 
	 * initialization of object
	 */
	public Customer(VendingSystem system, VendingMachine machine){
		this.login(machine);
		vendingSystem = system;
	}
	
	/**
	 * Loads up a customer use sequence for logging into a machine and 
	 * transacting.  Handles welcome message and startup
	 * @param machine the vending system that the customer is entering into
	 * @param scan standard input parser to take user inputs.
	 * 
	 * @deprecated THE ENTRY POINT FOR COMMAND LINE INTERFACE HAS BEEN MOVED
	 * TO CustomerCML.java
	 */
	public void runCustomer(VendingMachine machine, Scanner scan) {

		VendingSystem placeholderSystem = new VendingSystem();
		//TODO this is not the actual system
		//, but just a placeholder so the rest of the software can still 
		//remain untouched
		CustomerCML view = new CustomerCML();
		
		view.runCustomer(machine,scan,placeholderSystem);

	}
	
	/**
	 * Attaches this customer to a machine.  Appropriately changes any 
	 * 'online/offline' status in the machine
	 * @param machine The machine that this customer is logging in to
	 */
	private void login(VendingMachine machine){
		currentMachine = machine;
	}
	
	/**
	 * Undoes the customer's login, detaches machine, and gracefully exits the machine
	 * (sets balance to $0, etc)
	 */
	public void logout(){
		refund(); // reset balance
		currentMachine = null;
		//at this point, the customer object will probably be thrown out,
		//unless future functionality wants to keep it around for some reason
	}
	
	/**
	 * Puts an amount of change into the vending machine this customer is at.
	 * @param amount The amount being put into the machine.  This argument
	 * should never be 
	 */
	public void insertMoney(double amount){
		currentMachine.addMoney(amount);
	}
	
	/**
	 * Fetches the balance of the machine this customer is looking into.
	 * @return the customer's inserted money balance
	 */
	public double getBalance(){
		return currentMachine.getCustomerBalance();
	}
	
	/**
	 * Resets coin balance to $0 in the machine
	 */
	public void refund(){
		double currentBalance = this.getBalance();
		currentMachine.addMoney(-1 * currentBalance); // remove what is in the balance
	}
	
	/**
	 * Fetches the available items from the machine.
	 * @return the list of available, purchasable items from the machine
	 */
	public ArrayList<Item> getAvailableItemList(){
		return currentMachine.listAvailableItems();
	}
	
	/**
	 * Fetches the ID of the machine 
	 * @return the ID of the machine being logged into
	 */
	public int getMachineID(){
		return currentMachine.getMachineID();
	}
	
	/**
	 * Selects an item from a vending machine and attempts a purchase upon 
	 * that item; if purchase was successful, purchase info will be added 
	 * to the vending machine statistics pool.
	 * @param item The item of the item being purchased.  
	 * @return whether or not the purchase actually did anything, incase the
	 * customer view class wants to know this info
	 */
	public boolean selectItem(Item item){
		boolean purchaseSuccessful;
		
		int id = item.getItemID();
		purchaseSuccessful = currentMachine.selectItem(id);
		
		if (purchaseSuccessful){
			//Add purchase info to the system statistics
			vendingSystem.addStat(
					item.getName(), 
					item.getItemID(), 
					currentMachine.getMachineID(), 
					currentMachine.getAllItems().indexOf(item));
		}
		
		return purchaseSuccessful;
	}
	
	/**
	 * Cleans up the customer
	 */
	protected void finalize(){
		logout();
	}
	
	
}//end class
