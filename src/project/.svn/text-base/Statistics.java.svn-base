package project;
/**
 * $Log$
 * $Id$
 * $Revision$
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * A container for customer and restocker data points.  Contains functionality
 * for analyzing the data
 * @author FTM
 */
public class Statistics implements Serializable{
	
	//List of customer purchase data points
	private ArrayList<DataPoint> dataStatList;
	
	//List of restocker data points
	private ArrayList<RestockPoint> restockStatList;
	
	/**
	 * Makes an empty statistics container
	 */
	public Statistics(){
		dataStatList = new ArrayList<DataPoint>();
		restockStatList = new ArrayList<RestockPoint>();
	}
	
	/**
	 * Adds a customer purchase data point to the list of purchase data
	 * @param name name of item bought
	 * @param itemID the System ID for the given item variety
	 * @param machineID the machine it was purchased from
	 * @param itemIndex which shelf it was purchased from
	 */
	public void addStat(String name, int itemID, int machineID, int itemIndex){
		DataPoint stat = new DataPoint(name, itemID, machineID, itemIndex);
		dataStatList.add(stat);
	}
	
	/**
	 * Displays all purchase data points.  The data is raw info; no sorting or
	 * manipulation yet
	 */
	public void printDataStats(){
		String statString;
		for(int x = 0; x < dataStatList.size(); x++){
			statString = "";
			statString += dataStatList.get(x).getName() + ", from Machine ";
			statString += dataStatList.get(x).getMachineID() + " at ";
			statString += dataStatList.get(x).getDate() + "\n";
			System.out.println(statString);
		}
	}
	
	/**
	 * Adds a restocker data point into the existing restocker data
	 * @param name
	 * @param instruction
	 */
	public void addRestock(String name, ArrayList<String> instruction){
		RestockPoint stat = new RestockPoint(name, instruction);
		restockStatList.add(stat);
	}
	
	/**
	 * Displays the raw collection of restocker data
	 */
	public void printRestockStats(){
		String statString;
		for(int x = 0; x < restockStatList.size(); x++){
			statString = "";
			
			statString += "Restocker " + restockStatList.get(x).getName() + 
				", completed the following tasks at" + restockStatList.get(x).getDate() + "\n";
			for(int i = 0; i < restockStatList.get(x).getInstruction().size(); i++){
				statString += restockStatList.get(x).getInstruction().get(i) + "\n";
			}
			
			System.out.println(statString);
		}
	}
	
	/**
	 * Displays all machine usage statistics across the system
	 */
	public void printAggregates(){
		ArrayList<String> names = new ArrayList<String>();
		for(int i =0; i < dataStatList.size(); i++){
			if(names.contains(dataStatList.get(i).getName())){
				
			}else{
				names.add(dataStatList.get(i).getName());
			}
		}
		int occurence = 0;
		int runningTotal = 0;
		for(int i =0; i < names.size(); i++){
			for(int j =0; j<dataStatList.size();j++){
				if(names.get(i).equals(dataStatList.get(j).getName())){
					occurence +=1;
				}
			}
			System.out.println("There were " + occurence + " "+ names.get(i)+ "'s bought.");
			runningTotal = runningTotal + occurence;
			occurence = 0;
		}
		System.out.println("There have been " + runningTotal + " items bought");
	}
	
	/**
	 * Fetches the list of customer purchase data
	 * @return the list of data
	 */
	public ArrayList<DataPoint> getDataStatList(){
		return dataStatList;
	}
	
	/**
	 * Fetches the list of restocker performance data
	 * @return list of data
	 */
	public ArrayList<RestockPoint> getRestockStatList(){
		return restockStatList;
	}
	
	/**
	 * Returns a hashmap of each machine and total items bought
	 */
	public HashMap<Integer,Integer> getAgs(){
		int count;
		HashMap<Integer,Integer> ags = new HashMap<Integer,Integer>();
		for(int i =0; i < dataStatList.size(); i++){
			if(ags.containsKey(dataStatList.get(i).getMachineID())){
				count = ags.get(dataStatList.get(i).getMachineID());
				count +=1;
				ags.put(dataStatList.get(i).getMachineID(), count);
			}else{
				ags.put(dataStatList.get(i).getMachineID(),1);
			}
		}
		return ags;
	}
	
	/**
	 * Returns a hashmap of each item for each machine
	 *
	 */
	public ArrayList<String> getBar(int machineID){
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> itemStats = new ArrayList<String>();
		for(int i =0; i < dataStatList.size(); i++){
			if(dataStatList.get(i).getMachineID()== machineID){
				if(names.contains(dataStatList.get(i).getName())){
					
				}else{
					names.add(dataStatList.get(i).getName());
				}
			}
			
		}
		int occurence = 0;
		int runningTotal = 0;
		for(int i =0; i < names.size(); i++){
			for(int j =0; j<dataStatList.size();j++){
				if(dataStatList.get(j).getMachineID()==machineID){
					if(names.get(i).equals(dataStatList.get(j).getName())){
						occurence +=1;
					}
				}
				
			}
			itemStats.add("There were " + occurence + " "+ names.get(i)+ "'s bought.");
			runningTotal = runningTotal + occurence;
			occurence = 0;
		}
		itemStats.add("There have been " + runningTotal + " items bought from Machine ID: " + machineID);
		names.clear();
		return itemStats;
	}
	

}
