package project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Restocker implements Serializable {
	private String _username;
	private String _password;
	//This is the machine that this restocker will be performing on.
	private VendingMachine currentMachine;
	
	//The List of restockers
	
	
	//This is the system that the restockers machine is contained in
	//  (this is used to plug customer statistics into the statistics)
	private VendingSystem vendingSystem;
	
	/**
	 * Constructor
	 * @param username
	 * @param password
	 * @param system
	 * @param machine
	 */
	public Restocker(String username, String password){
		_username = username;
		_password = password;
		
	}
	
	/**
	 * Default Constructor
	 */
	public Restocker(){}
	
	/**
	 * Fetches the password from this restocker
	 * @return the password
	 */
	public String getPassword(){
		return _password;
	}
	
	/**
	 * Fetches the username from this restocker
	 * @return the username
	 */
	public String getUsername(){
		return _username;
	}
	
	public void viewRestockerReport(boolean reportPresent,ArrayList<ArrayList> instructionList){
		//View Restocker Instruction Report
		if(!reportPresent){
			System.out.println("There is no Restocker Report at present.");
			return;
		}
		for(int i =0; i < instructionList.size(); i++){
			System.out.print("Instruction " + i + ": ");
			for( int j = 0; j < instructionList.get(i).size(); j++){
				System.out.print(instructionList.get(i).get(j) + ", ");
			}
			System.out.println();
		}
	}
	
	public ArrayList<String> getInstructionStringList(VendingMachine machine){
		ArrayList<ArrayList> instructionList = new ArrayList<ArrayList>();
		ArrayList<String> instructions = new ArrayList<String>();
		//checks to see if a report path has been uploaded
		boolean reportPresent = false;
		String report = machine.getRestockerReport();
		if(report.equals("")){
			reportPresent = false;
			//TODO I may want to return the empty list here
			return instructions;
		}else{
			reportPresent = true;
			File file = new File(report);
			BufferedReader bufRdr;
			try {
				bufRdr = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				return null;
			}
			String line = null;
			 
			//read each line of text file
			try {
				while((line = bufRdr.readLine()) != null){
					StringTokenizer st = new StringTokenizer(line,",");
					int i = 0;
					ArrayList<String> instruction = new ArrayList<String>();
					while (st.hasMoreTokens()){
						//get next token and store it in the array
						 String s = st.nextToken();
						 instruction.add(s);
						 i++;
					}
					instructionList.add(instruction);
				}
				bufRdr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		for(int i =0; i < instructionList.size();i++){
			String s = (String)instructionList.get(i).get(0);
			instructions.add(s);
		}
		return instructions;
	}
	
	public ArrayList<ArrayList> getInstructionList(VendingMachine machine){
		ArrayList<ArrayList> instructionList = new ArrayList<ArrayList>();
		//checks to see if a report path has been uploaded
		boolean reportPresent = false;
		String report = machine.getRestockerReport();
		if(report.equals("")){
			reportPresent = false;
			//TODO I may want to return the empty list here
			return instructionList;
		}else{
			reportPresent = true;
			File file = new File(report);
			BufferedReader bufRdr;
			try {
				bufRdr = new BufferedReader(new FileReader(file));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
				return null;
			}
			String line = null;
			 
			//read each line of text file
			try {
				while((line = bufRdr.readLine()) != null){
					StringTokenizer st = new StringTokenizer(line,",");
					int i = 0;
					ArrayList<String> instruction = new ArrayList<String>();
					while (st.hasMoreTokens()){
						//get next token and store it in the array
						 String s = st.nextToken();
						 instruction.add(s);
						 i++;
					}
					instructionList.add(instruction);
				}
				bufRdr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return instructionList;
	}
	
	
	
	
	/**
	 * Parses a properly formatted string instruction into machine changes and 
	 * performs those changes to the machine
	 * @param machine the machine that is being restocked/altered by restocker
	 * @param instruction the properly formatted instruction string the be parsed
	 * @return true if everything is carried out properly
	 */
	public boolean executeInstruction(VendingMachine machine, ArrayList<String> instruction){
		int instructionID = getInt(instruction.get(1));
		switch(instructionID){
		case 0:
			//Change cost
			int machineID = getInt(instruction.get(2));
			int itemID = getInt(instruction.get(3));
			double itemCost = getDouble(instruction.get(4));
			
			if((machineID != -1) && (itemID != -1) && (itemCost!= -1)){
				machine.changeCost(itemID, itemCost);
			}else{
				System.out.println("Item cost for: " +instruction.get(3)+ " could not be changed");
			}
			break;
		case 1:
			//remove some quantity
			int reMachineID = getInt(instruction.get(2));
			int reItemID = getInt(instruction.get(3));
			int reQuantity = getInt(instruction.get(4));
			
			if((reMachineID != -1) && (reItemID != -1) && (reQuantity!= -1)){
				machine.removeItem(reItemID, reQuantity);
			}else{
				System.out.println("Remove quantity for: " + instruction.get(3) + " could not be changed");
			}
			break;
		case 2:
			//add some quantity
			int adMachineID = getInt(instruction.get(2));
			int adItemID = getInt(instruction.get(3));
			int adQuantity = getInt(instruction.get(4));
			ArrayList<Integer> adExp = new ArrayList<Integer>();
			for(int i = 5; i < instruction.size(); i++){
				adExp.add(getInt(instruction.get(i)));
			}
			
			if((adMachineID != -1) && (adItemID != -1) && (adQuantity!= -1)){
				if((adExp.size() == adQuantity)){
					machine.addItemQuantity(adItemID, adQuantity, adExp);
				}else{
					System.out.println("Number of expiration dates does not match the number of Items");
				}
			}else{
				System.out.println("Add some quantity for: " + instruction.get(3) + " could not be changed");
			}
			
			break;
		case 3:
			//discontinueItem
			int diMachineID = getInt(instruction.get(2));
			int diItemID = getInt(instruction.get(3));
			
			if((diMachineID != -1) && (diItemID != -1)){
				machine.discontinueItem(diItemID);
			}else{
				System.out.println("Could not discontinue: " + instruction.get(3));
			}
			break;
		case 4:
			//remove money from the machine
			int coMachineID = getInt(instruction.get(2));
			double amount = getDouble(instruction.get(3));
			
			if((coMachineID != -1) && (amount != -1)){
				machine.updateBalance(amount * -1);
			}else{
				System.out.println("Could not remove: " + instruction.get(3) + " from machine " + instruction.get(2));
			}
			
			break;
		case 5:
			//add a new item
			int newMachineID = getInt(instruction.get(2));
			String newItemName = instruction.get(3);
			int newItemID = getInt(instruction.get(4));
			double newCost = getDouble(instruction.get(5));
			int newCur = getInt(instruction.get(6));
			if(newMachineID != -1 && newItemID!= -1 && newCost!= -1 && newCur != -1){
				ArrayList<Integer> newExp = new ArrayList<Integer>();
				for(int i = 7; i < instruction.size(); i++){
					newExp.add(getInt(instruction.get(i)));
				}
				int index =-1;
				for(int i = 0; i <machine.getItemsSize(); i++){
					ArrayList<Item> all = machine.getAllItems();
					if(all.get(i).getItemID() == 0){
						index = i;
						break;
					}
				}
				machine.addNewItem(index, newItemName, newItemID, newCur, newCost, newExp);
			}else{
				System.out.println("Could not add new Item: " + newItemName);
			}
			break;
		default:
			System.out.println("Invalid instruction - restocker");
			break;
		}
		return true;
	}
	
	
	/**
	 * Takes a string and turns it into an integer.  Gives -1 if input string is 
	 * not an integer
	 * @param stringInput
	 * @return the int version of the input string
	 */
	public int getInt(String stringInput){
		boolean validInput = false;
		int intInput = 0;
		
			//check for valid input
			try{
				intInput = Integer.parseInt(stringInput);
				if(intInput >= 0){
					validInput = true;
				}
			}catch(NumberFormatException e){
				System.err.println("Format Exception");
			}//end catch
		if(validInput){
			return intInput;
		}else{
			return -1;
		}
	}//end getInt
	
	/**
	 * Turns string into a double
	 * @param stringInput the string being converted to a double
	 * @return the double version of the string
	 */
	public double getDouble(String stringInput){
		boolean validInput = false;
		double doubleInput = 0;
		
			//check for valid input
			try{
				doubleInput = Double.parseDouble(stringInput);
				if(doubleInput >= 0){
					validInput = true;
				}
			}catch(NumberFormatException e){
				System.err.println("Format Exception");
			}//end catch
		if(validInput){
			return doubleInput;
		}else{
			return -1;
		}
	}//end getDouble
}


