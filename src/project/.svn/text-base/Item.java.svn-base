package project;
/**
 * $Log$
 * $Id$
 * $Revision$
 */

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * A container for the information pertaining to the contents of a shelf in a 
 * Vending Machine.  (does not represent an individual good, but the collection
 * of a particular type of item)
 * @author FTM
 */
public class Item implements Serializable{
	
	//The name of the item variety
	private String _name;
	
	//The System ID given to the item type, (Ex. Mountain Goo:0, Snickels:1, ...)
	private int _itemID;
	
	//The quantity of the good remaining in the shelf
	private int _currentNum;
	
	//The price to purchase one good of this item type
	private double _cost;
	
	//The expiration dates of goods in this shelf corresponding with their shelf
	//position
	private ArrayList<Integer> _expDates;
	
	/**
	 * Makes a generic/null/placeholder item
	 */
	public Item(){
		_name = "";
		_itemID = 0;
		_currentNum = 0;
		_cost = 0;
		_expDates = new ArrayList<Integer>();
	}
	
	/**
	 * Makes an Item: contents for a shelf
	 * @param name name of the item variety
	 * @param itemID the system ID for the item
	 * @param currentNum How many goods in the shelf
	 * @param cost price of a good
	 * @param expDates a list of expiration dates
	 */
	public Item(String name, int itemID, int currentNum, double cost, ArrayList<Integer> expDates){
		_name = name;
		_currentNum = currentNum;
		_cost = cost;
		_expDates = expDates;
		_itemID = itemID;
	
	}
	
	/**
	 * Gets ID
	 * @return the Item variety's ID for the vending system
	 */
	public int getItemID(){
		return _itemID;
	}
	
	/**
	 * Adds a quantity of items to the shelf/item quantity, (does not add to 
	 * expiration date list).
	 * @param numToAdd amount being added to the current number status
	 */
	public void setCurrentNum(int numToAdd){
		_currentNum += numToAdd;
	}
	
	/**
	 * Gets name of item
	 * @return name name of item
	 */
	public String getName(){
		return _name;
	}
	
	/**
	 * Fetches the number of goods in this item shelf
	 * @return
	 */
	public int getCurrentNum(){
		return _currentNum;
	}
	
	/**
	 * Fetches the cost of an item from this shelf
	 * @return price to purchase a single item from this shelf
	 */
	public double getCost(){
		return _cost;
	}
	
	/**
	 * Sets the ID for this item variety.  The internals of the system may use
	 * this to set item ID's if need be
	 * @param ID
	 */
	public void setItemID(int ID){
		_itemID = ID;
	}
	
	/**
	 * Sets the name of this Item variety
	 * @param name
	 */
	public void setName(String name){
		_name = name;
	}
	
	/**
	 * Sets the price of an item of this variety.
	 * @param cost the price to be changed to
	 */
	public void setCost(double cost){
		_cost = cost;
	}
	
	public void setExp(ArrayList<Integer> intArray){
		_expDates = intArray;
	}
	/**
	 * Empties the Expiration Date List for this shelf
	 */
	public void clearExp(){
		if(_expDates != null){
		_expDates.clear();
		}
	}
	
	/**
	 * Counts how many expired items are in this item cubby
	 * @return the number of expired items in this item cubby
	 */
	public int amountOfExpired(long startTime){
		int amountExpired = 0;
		long elapsed = (System.nanoTime()/1000000000)/60 - startTime;
		for (Integer currentDate : _expDates){
			if(elapsed >= currentDate){
				amountExpired++;
			}
		}
		return amountExpired;
	}
	
	
	/**
	 * True iff expired
	 * @param startTime the initial start-up time for the vending machine system
	 * @return whether or not this item is expired
	 */
	public boolean isExpired(long startTime){
		long elapsed = (System.nanoTime()/1000000000)/60 - startTime;
		if(_expDates.get(0) <= elapsed){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Displays item
	 */
	public void printItem(){
		if(_itemID ==0){
			System.out.println("Empty Slot");
		}else{
			System.out.println(_name + ", ID=" + _itemID + ", quantity="+_currentNum);
		}
	}
	
	/**
	 * fetches size of the expiration list (generally this should = _currentNum)
	 * @return
	 */
	public int getExpSize(){
		return _expDates.size();
	}
	
	/**
	 * Pushes a series of expiration dates (corresponding to goods being added to a 
	 * this shelf
	 * @param dates a list of the dates being pushed into the shelf
	 */
	public void addExpDates(ArrayList<Integer> dates){
		for(int i =0; i < dates.size();i++){
			_expDates.add(dates.get(i));
		}
	}
	
	/**
	 * Takes out the dates from the front item shelf.
	 * @param quantity how many being popped
	 */
	public void removeExpDates(int quantity){
		for(int i = 0; i < quantity; i++){
			_expDates.remove(0);
		}
	}
	
	/**
	 * grabs the list of expiration dates from the list corresponding to each good
	 * @return the list of expiration dates
	 */
	public ArrayList<Integer> getExpDates(){
		return _expDates;
	}
	
	/**
	 * Returns the string representation of this object in the form:
	 * (ID) Name (quantity)
	 * @return the string representation of this object
	 */
	public String toString(){
		Double price = this._cost;
		DecimalFormat decim = new DecimalFormat("0.00");
		String price2 = decim.format(price);
		//Double price2 = Double.parseDouble();
		return (this.getItemID() + ": " + this.getName() + 
				": $" + price2);
		
	}
}