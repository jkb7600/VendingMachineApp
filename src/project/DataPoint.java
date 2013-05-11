package project;
/**
 * $Log$
 * $Id$
 * $Revision$
 */

import java.io.Serializable;
import java.util.Date;

/**
 * Contains information of a single vending machine purchase
 * @author FTM
 */
public class DataPoint implements Serializable{
	
	//Name of the item variety
	private String _name;
	
	//System ID for the item
	private int _itemID;
	
	//Date of purchase
	private Date _date;
	
	//the machine number that the good was purchased from
	private int _machineID;
	
	//Where in the machine the good was located for the purchase
	private int _itemIndex;
	
	/**
	 * Generates a generic Datapoint
	 */
	public DataPoint(){
		_name = "";
		_itemID = 0;
		_date = new Date();
		_machineID = 0;
		_itemIndex = 0;
	}
	
	/**
	 * Generates a data point
	 * @param name Name of the item purchased
	 * @param itemID System ID that the item had during purchase
	 * @param machineID The machine the item was purchased from
	 * @param itemIndex Which shelf the item was from
	 */
	public DataPoint(String name, int itemID, int machineID, int itemIndex){
		_name = name;
		_itemID = itemID;
		_date = new Date();
		_machineID = machineID;
		_itemIndex = itemIndex;
	}
	
	/**
	 * Fetches name of the item
	 * @return name of item
	 */
	public String getName(){
		return _name;
	}
	
	/**
	 * Fetches the item's system ID
	 * @return the id number of the item variety
	 */
	public int getItemID(){
		return _itemID;
	}
	
	/**
	 * Fetches the date/time of purchase for the item
	 * @return the date of purchase
	 */
	//TODO change/remove
	public String getDate(){
		return _date.toGMTString();
	}

	/**
	 * Fetches the machine ID of where the item was bought from
	 * @return the machine's ID
	 */
	public int getMachineID(){
		return _machineID;
	}
	
	/**
	 * Fetches which shelf the item was on for purchase
	 * @return the shelf index number
	 */
	public int getItemIndex(){
		return _itemIndex;
	}
}
