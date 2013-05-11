package project;
/**
 * $Log$
 * $Id$
 * $Revision$
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * The input interface for a manager user.  Includes the ability to reach into
 * the functionality that a manager is allowed to perform on the system with.
 * @author FTM
 */
public class Manager implements Serializable{
	
	//The manager's username that is checked against for login
	private String _username;
	
	//The manager's password that is checked against for login
	private String _password;
	
	private ArrayList<Manager> managerLoginList;
	
	//This is the machine that this customer will be performing on.
	private VendingMachine currentMachine;
	
	//This is the system that the customer's machine is contained in
	//  (this is used to plug customer statistics into the statistics)
	private VendingSystem vendingSystem;
	
	public Manager(VendingSystem system, VendingMachine machine){
		this.login(machine);
		vendingSystem = system;
		managerLoginList = vendingSystem.getManagerList();
		
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
	 * Creates a manager interface object
	 * @param username the username for this new manager
	 * @param password the password for this new manager
	 */
	public Manager(String username, String password){
		_username = username;
		_password = password;
	}
	
	/**
	 * Runs through any manager use case
	 * @param system the system the manager is performing in
	 * @param scan The input scanner
	 */
	public void runManager(VendingSystem system, Scanner scan){
		

		boolean endLoop = false;
		
		while(!endLoop){
			String list = " \n0. Logout\n1. Add Machine \n2. Delete Machine \n3. Upload Restocker Report " +
			   "\n4. View Machine State (Inventory, Expired Items, Restocker Notes)\n5. Add New Manager\n6. Delete Manager \n7. Add New Restocker\n8. Delete Restocker\n9. Statistics";
			int userChoice = getInt(list, scan);
			switch(userChoice){
			case 0:
				//Quits
				endLoop = true;
				break;
			
			case 1: 
			//Add Machine procedure for a manager
				manager_addMachine(system, scan);
				break;
			
			case 2:
			//Delete Machine procedure for manager	
				manager_deleteMachine(system, scan);
				break;
			
			case 3:
			//Add Restocker Report procedure for the manager.  
				addReport(system, scan);
				break;
			
			case 4:
			//MACHINE STATE
				viewMachineState(system, scan);
				break;
				
			case 5:
			//Add Manager Profile
				manager_addProfile(system, scan);
				break;
				
			case 6:
			//Remove Manager Profile
				manager_removeProfile(system, scan);
				break;
			case 7:
			//Add Restocker Profile
				addRestockerProfile(system, scan);
				break;
				
			case 8:
			//Remove Restocker Profile
				removeRestockerProfile(system, scan);
				break;
				
			case 9:
			//View Statistics
				viewStats(system,scan);
				break;
				
			default:
				break;
			}//end switch
		}//end while
	}
	
	
	public boolean manager_checkValidLogin(String username, String password){
		
		for(int i=0; i < managerLoginList.size(); i++){
			if(managerLoginList.get(i).getUsername().equals(username)){
				if(managerLoginList.get(i).getPassword().equals(password)){
					return true;
				}
			}
		}
		return false;
	}
	
	public void manager_addMachine(VendingSystem system, Scanner scan){
		//here manager specifies initial conditions for the new machine
		//This part is dependent on the user input interface (C-Line vs GUI)
		boolean goodMachineID;
		boolean goodInput = false;
		int newID = -1;
		while(!goodInput){
			goodMachineID = true;
			newID = getInt("Enter Machine ID:", scan);
			for(int i =0; i < system.machines.size(); i++){
				if(newID == system.machines.get(i).getMachineID()){
					goodMachineID = false;
					break;
				}
			}
			if(goodMachineID){
				goodInput = true;
			}else{
				System.out.println("Machine ID Already Used");
			}
		}
		goodInput= false;
		boolean goodSize;
		int newRows = 0;
		int newCols = 0;
		int newDepth = 0;
		double newBalance = 0.0;
		while(!goodInput){
			goodSize = true;
			newRows = getInt("Enter Rows:", scan);
			newCols = getInt("Enter Columns: ", scan);
			newDepth = getInt("Enter Depth: ", scan);
			newBalance = getDouble("Enter Amount of Money in the Machine", scan);
			if(newRows > 0 && newCols> 0 && newDepth > 0){
				goodInput = true;
			}else{
				System.out.println("These Attributes must be greater than zero");
			}
		}
		
		
		boolean continueItem = true;
		ArrayList<Item> newItemList = new ArrayList<Item>();
		//manager enters any amount of initial items here to the system until
		//satisfied
		int itemCount =0;
		while((continueItem)&&(itemCount<=(newCols*newRows))){
			System.out.println("Would you like to add another item to the machine? (y/n)");
			String yesorno = scan.nextLine();
			if(yesorno.equals("")){
				
			}else{
				char charArray[] = yesorno.toLowerCase().toCharArray();
				if(charArray[0]==('n')){
					continueItem = false;//<- line added by Joe
					//break;			//<- line removed by Joe
				}else if(charArray[0]==('y')){
					//here manager enters item specs (quantity, exp date, etc)
					String newName = "";
					int newItemID = -1;
					goodInput = false;
					while(!goodInput){
						System.out.println("Enter Item Name:");
						newName = scan.nextLine();
						newItemID = getInt("Enter Item ID: ", scan);
						if(system.itemsList.containsValue(newItemID) && system.itemsList.containsKey(newName)){
							if(newItemID == system.itemsList.get(newName)){
								//good
								goodInput = true;
							}else{
								System.out.println("That name is not associated with that ID");
							}
						}
						else if(system.itemsList.containsValue(newItemID)){
							if(!system.itemsList.containsKey(newName)){
								System.out.println("This ID is being used for another item");
							}
						}else if(system.itemsList.containsKey(newName)){
							if(!system.itemsList.containsValue(newItemID)){
								System.out.println("That ID is not assciated with that name");
							}
						}
						else{
							system.itemsList.put(newName, newItemID);
							goodInput = true;
						}
					}
					int newCur =0;
					boolean goodCurrent = false;
					while(!goodCurrent){
						newCur = getInt("Enter Current Number of Item", scan);
						if(newCur > newDepth){
							System.out.println("You are adding more items than the depth you specified");
						}else{
							goodCurrent = true;
						}
					}
					
					
					
					double newCost = getDouble("Enter the Cost of the Item", scan);
				
					ArrayList<Integer> dates = new ArrayList<Integer>();
					int i =0;
					while(i < newCur){
						
						int date = getInt("Enter the Expiration Date of " + newName + " number " + i, scan);
						if(date > 0){
							dates.add(date);
							i++;
						}else{
							System.out.println("Invalid date");
						}
					}
					Item newItem = new Item(newName, newItemID, newCur, newCost, dates);
					newItemList.add(newItem);
					itemCount +=1;
				}else{
					System.out.println("Invalid Input");
				}
			}
			
			
		}
		VendingMachine newMachine = new VendingMachine(newID, newRows,newCols, newDepth, newBalance, newItemList, system.startTime);
		system.addNewMachine(newMachine);	
	}
	public void manager_addMachine_GUI(VendingSystem system, int id, int rows, int cols, int depth, double money){
		ArrayList<Item> emptyItemList = new ArrayList<Item>();
		for(int x = 0; x < rows*cols; x++){
			emptyItemList.add(new Item());
		}
		system.addNewMachine(new VendingMachine(id, rows, cols, depth, money, emptyItemList, system.startTime));
	}
	public void manager_addItem_GUI(VendingMachine tempMachine, int index, String name, int ID, int numOf, double cost, int exp){
		ArrayList<Integer> expList = new ArrayList<Integer>();
		for(int x = 0; x < numOf; x++){
			expList.add(exp);
		}
		tempMachine.addNewItem(index, name, ID, numOf, cost, expList);
	}
	
	
	public void manager_deleteMachine(VendingSystem system, Scanner scan){
		//grab machine choice to remove
		int IDtoDelete = getInt("Enter the ID of the Machine to Delete",scan);
		int machinesChecked = 0;
		//scan machine list if machine choice exists and is valid for removal
		for(int i =0; i < system.machines.size(); i++){
			if(system.machines.get(i).getMachineID() == IDtoDelete){
				System.out.println("Machine " + system.machines.get(i).getMachineID() +" deleted");
				system.machines.remove(i);
				break;
			}
			machinesChecked +=1;
		}
		if(machinesChecked == system.machines.size()){
			System.out.println("Machine not found");
		}		
	}
	public void manager_deleteMachine_GUI(VendingSystem system, int IDtoDelete)
	{
		for(int i =0; i < system.machines.size(); i++){
			if(system.machines.get(i).getMachineID() == IDtoDelete){
				system.machines.remove(i);
				break;
			}
		}
		
	}
	
	public void addReport(VendingSystem system, Scanner scan){
		//Updates the restock report in the machine
			int machineNumber = -1;
			boolean validMachineNum = false;
			
			while(!validMachineNum){
				machineNumber = getInt("Enter Machine ID to upload to:", scan);
				try{
					system.machines.get(machineNumber);
					validMachineNum = true;
				}catch(IndexOutOfBoundsException e){
					System.out.println("Machine: "+ machineNumber +" does not exist");
				}//end try
			}//end while
			
			System.out.println("Enter path to the Report .csv file:");
			String path = scan.nextLine();
			while(!new File(path).isFile() && !path.equals("exit")){
				System.out.println("File does not exist");
				System.out.println("Enter valid file path or <exit> to exit.");
				path = scan.nextLine();
			}
			system.machines.get(machineNumber).setRestockerReport(path);
			System.out.println("Report Uploaded to Machine "+machineNumber);
		
		
	}
	
	public void viewMachineState(VendingSystem system, Scanner scan){
		int index = -1;
		int machineID = getInt("Enter the ID of the Machine to view: ", scan);
		boolean machineExists = false;
		for(int i =0; i < system.machines.size(); i++){
			if(machineID == system.machines.get(i).getMachineID()){
				index = i;
				machineExists = true;
			}
		}
		if(machineExists){
			machineState(system.machines.get(index), system.startTime, scan);
		}else{
			System.out.println("Machine does not exist");
		}	
	}
	
	public void manager_addProfile(VendingSystem system, Scanner scan){
		System.out.print("Enter the new Username: ");
		String newManager = scan.nextLine();
		System.out.print("Enter the new password: ");
		String managerPassword = scan.nextLine();
		system.addManager(newManager, managerPassword, scan);
	}
	
	public void manager_removeProfile(VendingSystem system, Scanner scan){
		System.out.print("Enter the username to delete: ");
		String delManager = scan.nextLine();
		system.removeManager(delManager);		
	}
	
	public void addRestockerProfile(VendingSystem system, Scanner scan){
		System.out.print("Enter the new Username: ");
		String newRestocker = scan.nextLine();
		System.out.print("\nEnter the new password: ");
		String restockerPassword = scan.nextLine();
		system.addRestocker(newRestocker, restockerPassword, scan);	
	}
	
	public void removeRestockerProfile(VendingSystem system, Scanner scan){
		System.out.print("Enter the username to delete: ");
		String delRestocker = scan.nextLine();
		system.removeRestocker(delRestocker);
	}
	
	public void viewStats(VendingSystem system, Scanner scan){
		system.stats();
	}

	/**
	 * An input fetcher method to ask for and check for integer user input
	 * from command line
	 * @param prompt The message you will display / The question being asked
	 * @param scan the Scanner object that handles command line input
	 * @return the inputted integer from user.
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
				System.out.println("Invalid Input-manager");
			}//end catch
		}//end while
		return intInput;
	}//end getInt
	
	/**
	 * An input fetcher method to ask for and check for "double" type user input
	 * from command line
	 * @param prompt The message you will display / The question being asked
	 * @param scan the Scanner object that handles command line input
	 * @return the inputted double from user.
	 */
	public double getDouble(String prompt, Scanner scan){
		boolean validInput = false;
		double doubleInput = 0;
		String stringInput;
		scan.reset();
		
		//loop until input is valid
		while(!validInput){
			System.out.println(prompt);
			stringInput = scan.nextLine();
			//check for input validity
			try{
				doubleInput = Double.parseDouble(stringInput);
				if(doubleInput >= 0){
					validInput = true;
				}else{
					System.out.println("Enter positive value");
				}
			}catch(NumberFormatException e){
				System.out.println("Invalid Input manager1");
			}//end catch
		}//end while
		return doubleInput;
	}//end getDouble
	
	/**
	 * Fetches the password from this object
	 * @return the password
	 */
	public String getPassword(){
		return _password;
	}
	
	public void setPassword(String password){
		_password = password;
	}
	
	/**
	 * Fetches the username from this object
	 * @return the username
	 */
	public String getUsername(){
		return _username;
	}
	
	public void setUsername(String username){
		_username = username;
	}
	
	/**
	 * Text display interface for the desired machine
	 * @param machine the machine we are peeking inside of
	 * @param startTime the time the system was booted up
	 * @param scan the input scanner for taking/reading input
	 */
	public void machineState(VendingMachine machine,long startTime, Scanner scan){
		boolean endLoop = false;
		while(!endLoop){
			int choice = getInt("1. View Inventory\n2. View Expired Items\n3. View Restocker Notes\n0. Back", scan);
			switch(choice){
			case 0:
			//Quit
				endLoop = true;
				break;
			case 1:
			//Display Machine Item Inventory
				machine.printAllItems();
			case 2:
			//Display Expired Items in this machine
				boolean foundExpired = false;
				ArrayList<Item> allItems = machine.getAllItems();
				for(int i = 0; i < machine.getItemsSize(); i++){
					int expiredAmount = allItems.get(i).amountOfExpired(startTime);
					if(expiredAmount != 0){
						foundExpired = true;
						System.out.println(allItems.get(i).getName() + " has " + 
								           expiredAmount + " expired item(s).");
					}
				}
				if(!foundExpired){
					System.out.println("There are no expired items in the machine");
				}
				break;
			case 3:
			//Display any restocker feedback notes
				System.out.println("Restocker notes from Machine " + machine.getMachineID()+ ":\n" 
												+ machine.getRestockerNotes());
				break;
			default:
				break;
			}
		}//end while
	}
}//end class
