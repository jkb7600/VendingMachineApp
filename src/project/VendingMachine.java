package project;
/**
	 * $Log$
	 * $Id$
	 * $Revision$
*/
import java.io.Serializable;
import java.util.ArrayList;

public class VendingMachine implements Serializable{

	//The ID code for this vending machine
	private int _machineID;
	
	//how tall the vending machine is (how many rows)
	private int _rows;
	
	//how wide the vending machine is (how many columns)
	private int _cols;
	
	//how many items can fit in a shelf (how many slots per shelf)
	private int _depth;
	
	//how many shelves the vending machine has (rows * columns)
	private int _totalItems;
	
	//a list of items (see class Item for more info)
	private ArrayList<Item> items; 
	
	//how much money is sitting inside the machine (excluding custbal)
	private double _totalBalance;
	
	//how much money has been inserted by the customer during their
	//session
	private double _customerBalance = 0.0;
	
	//whether or not the vending machine is being used
	private boolean _online = false;
	
	//The time of machine bootup
	private long _startTime;
	
	//The restocker report text
	private String _restockerReport = "";
	
	//The restocker feedback notes
	private String _restockerNotes = "";
	
	/**
	 * Makes a default, placeholder machine
	 */
	public VendingMachine(){
		_machineID = 0;
		_rows = 0;
		_cols = 0;
		_depth = 0;
		_totalItems = _rows*_cols;
		_totalBalance = 0;
		items = new ArrayList<Item>();;
		_startTime = 0;
	}
	
	/**
	 * Creates a vending machine instance
	 * @param machineID the ID number of the vending machines
	 * @param rows how tall the machine should be
	 * @param cols how wide should the machine be
	 * @param depth how deep the machine should be
	 * @param totalBalance how much money the machine is starts with
	 * @param items1 the item list that the machine starts with
	 */
	public VendingMachine(int machineID, int rows, int cols, int depth, 
			double totalBalance, ArrayList<Item> items1, long startTime){
		_machineID = machineID;
		_rows = rows;
		_cols = cols;
		_depth = depth;
		_totalItems = _rows*_cols;
		_totalBalance = totalBalance;
		items = items1;
		_startTime = startTime;
		_online = true;
		for(int i =0; i < _totalItems; i++){
			Item blankItem = new Item();
			if(i == items.size()){
				items.add(blankItem);
			}
			
		}
		
	}
	
	/**
	 * Adds money into the CUSTOMER balance
	 * @param amount how much is being added
	 */
	public void addMoney(double amount){
		_customerBalance += amount;
		if(_customerBalance < 0){
			System.out.println("NEGATIVE CUSTOMER BALANCE\n");
			_customerBalance = 0;
		}
	}
	
	/**
	 * Displays the customer balance to standard output
	 */
	public void printCustomerBalance(){
		System.out.printf("Customer Balance: $");
		System.out.printf("%.2f", _customerBalance);
		
	}
	
	/**
	 * displays how much money is in the machine
	 */
	public void printBalance(){
		System.out.printf("Machine Balance: $");
		System.out.printf("%.2f", _totalBalance);
		System.out.println();
	}
	
	/**
	 * Adds an amount to the machine profit balance
	 * @param amount how much money is being added to balance
	 */
	public void updateBalance(double amount){
		_totalBalance += amount;
		if(_totalBalance < 0){
			System.err.println("NEGATIVE MACHINE BALANCE\n");
			_totalBalance = 0;
		}
	}
	
	/**
	 * fetches the amount of money the customer entered so far
	 * @return the amount of money customer entered so far
	 */
	public double getCustomerBalance(){
		return _customerBalance;
	}
	
	/**
	 * Places a purchase request onto an item ID from the machine
	 * @param ID the identification number of the vending machine
	 * item
	 * @return true if purchase was a success
	 */
	public boolean selectItem(int ID){
		Item current = new Item();
		for(int i = 0; i < items.size(); ++i){
			if(items.get(i).getItemID() == ID){
				current = items.get(i); 
				break;
			}
			if( i == items.size()){
				System.err.println("ITEM NOT FOUND");
				return false;
			}
		}
		if((current.getCurrentNum() > 0) && (_customerBalance >= current.getCost())){
			System.out.println("You bought: " + current.getName());
			//TODO GOT RID OF THE MAIN.ADDSTAT()
			removeItem(current.getItemID(), 1);
			updateBalance(current.getCost());
			addMoney(current.getCost() * -1);
			System.out.printf("Your change is: $");
			System.out.printf("%.2f", _customerBalance);
			System.out.println("");
			_customerBalance = 0.0;
			
			return true;
		}else{
			System.out.println("Insufficient Funds");
		}
		return false;
		
	}
	
	/**
	 * Decrements the item quantity selected by the desired amount
	 * @param ID the identification number of the item selected
	 * @param quantity the amount to take from that item
	 */
	public void removeItem(int ID, int quantity){
		if(quantity > 0){
			for(int i = 0; i < items.size(); ++i){
				if(items.get(i).getItemID() == ID){
					if(items.get(i).getCurrentNum() > 0 && (items.get(i).getCurrentNum() - quantity) >= 0){
						items.get(i).setCurrentNum(-1*quantity);
						items.get(i).removeExpDates(quantity);
					}
				}
			}
		}
	}
	
	/**
	 * Removes the selected item from the vending machine completely
	 * @param itemID the identification number of the item we are 
	 * removing
	 */
	public void discontinueItem(int itemID){
		for(int i = 0; i < items.size(); ++i){
			if(items.get(i).getItemID() == itemID){
				items.get(i).setCurrentNum(items.get(i).getCurrentNum()*-1);
				items.get(i).setCost(0.0);
				items.get(i).setItemID(0);
				items.get(i).setName("");
				items.get(i).clearExp();
			}
		}
	}
	
	/**
	 * fills out the item's shelf with a desired amount of items
	 * @param itemID the identification number of the desired item
	 * @param quantity how much is being added
	 */
	public void addItemQuantity(int itemID, int quantity, ArrayList<Integer> dates){
		for(int i =0; i < items.size(); ++i){
			if(items.get(i).getItemID() == itemID){
				if((items.get(i).getCurrentNum() + quantity) <= _depth ){
					if(quantity == dates.size()){
						items.get(i).setCurrentNum(quantity);
						items.get(i).addExpDates(dates);
					}else{
						System.out.println("The number of items and the number of expiration dates are not the same");
					}

				}else{
					System.err.println("NOT ENOUGH ROOM IN MACHINE");
				}
				
			}
		}
	}
	
	public void setCustomerBalance(double amount){
		_customerBalance = amount;
	}
	
	/**
	 * This function copies and collects the items that are available
	 * for purchase from this vending machine.
	 * Checks for expired-ness and emptyness, and etc
	 * @return list of available items in vending machine
	 */
	public ArrayList<Item> listAvailableItems(){
		ArrayList<Item> availableItems = new ArrayList<Item>();
		for(int i = 0; i < items.size(); i++){
			
			if((items.get(i).getCurrentNum() > 0 && (items.get(i).getExpSize()> 0))){
				if(items.get(i).isExpired(_startTime)){
					availableItems.add(items.get(i));
				}
			}
		}
		return availableItems;
	}
	
	/**
	 * Prints the list of available items
	 */
	public void printAvailableItems(){
		ArrayList<Item> availableItems = listAvailableItems();
		int currentSelection = 0;
		for (Item item : availableItems){
			System.out.print(currentSelection);
			System.out.print(" $");
			System.out.printf("%.2f", item.getCost());
			System.out.print("   ");
			System.out.print(item.getName()+ " quantity: " + item.getCurrentNum() +"\n");
			currentSelection ++;
		}
	}
	
	/**
	 * fetches the ID for the this machine
	 * @return the identification number for this machine
	 */
	public int getMachineID(){
		return _machineID;
	}
	
	/**
	 * Fetches the profit balance inside the machine
	 * @return the profit balance
	 */
	public double getTotalBalance(){
		return _totalBalance;
	}
	
	/**
	 * Fetches the online/offline status
	 * @return the online status (true iff online)
	 */
	public boolean getStatus(){
		return _online;
	}
	
	/**
	 * Changes the online status of the machine
	 * @param status the state the machine is being changed to
	 */
	public void setStatus(boolean status){
		_online = status;
		if(status){
			System.out.println("Machine " + _machineID + " is now online");
		}else{
			System.out.println("Machine " + _machineID + " is now offline");
		}//end if
	}

	/**
	 * Changes the cost of a shelf item in the machine
	 * @param itemID the item ID that the system assigned to the desired item
	 * @param itemCost the cost we are changing the item price to
	 */
	public void changeCost(int itemID, double itemCost){
		for(int i =0; i < items.size(); i++){
			if(items.get(i).getItemID() == itemID){
				items.get(i).setCost(itemCost);
			}
			if(i == items.size()){
				System.out.println("Item not found");
			}
		}
	}
	
	/**
	 * Fetches how many items are in the machine
	 * @return number of items in the machine
	 */
	public int getItemsSize(){
		return items.size();
	}
	
	/**
	 * Fetches a list of items in the machines
	 * @return
	 */
	public ArrayList<Item> getAllItems(){
		return items;
	}
	
	/**
	 * Displays all the items in the machine
	 */
	public void printAllItems(){
		for(int i =0; i < items.size(); i++){
			System.out.print(i + ": ");
			items.get(i).printItem();
		}
	}
	
	/**
	 * Inserts a new Item variety into the machine
	 * @param index the position in the machine the item is being placed into
	 * @param name the name of the item variety
	 * @param ID the system ID for the item
	 * @param number the initial item quantity for the item
	 * @param cost the price to purchase one of the items
	 * @param dates the list of expiration dates in the shelf item 
	 */
	public void addNewItem(int index, String name,int ID, int number, double cost, ArrayList<Integer> dates){
		if(number != dates.size()){
			System.out.println("Item not created: the number of items does not match the number of expiration dates");
		}else if(number > _depth){
			System.out.println("Item not created: trying to add more quantity than machine has room for");
		}else{
			//System.out.println("New Item Created");
			items.get(index).setName(name);
			items.get(index).setItemID(ID);
			items.get(index).setCost(cost);
			items.get(index).setCurrentNum(number);
			items.get(index).setExp(dates);
		}
		
	}
	
	/**
	 * Sets the restocker report for this machine
	 * @param path the file location of the report .csv file
	 */
	public void setRestockerReport(String path){
		_restockerReport = path;
	}
	
	/**
	 * Fetches the restocker report from this machine (in string text form)
	 * @return the report string
	 */
	public String getRestockerReport(){
		return _restockerReport;
	}
	
	/**
	 * Fetches the feedback notes that restockers may have recorded
	 * @return the notes
	 */
	public String getRestockerNotes(){
		return _restockerNotes;
	}
	
	/**
	 * Sets the restocker feedback notes for this machine
	 * @param note the note text
	 */
	public void setRestockerNotes(String note){
		_restockerNotes += note + "\n";
	}
	
	public int getDepth(){
		return _depth;
	}
}
