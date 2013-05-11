package project;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The entry point to the vending machine system.  One launch users from here.
 * @author FTM
 */
public class Main implements Serializable {
	
	
	//The input scanner used for grabbing command line input
	private static Scanner scan = new Scanner(System.in);
	
	//The main entry point for the vending machine system.
	public static void main(String[] args){
		VendingSystem system = null;
		String filename = "system.ser";
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
			system = (VendingSystem) ois.readObject();
		} catch (FileNotFoundException e1) {
			system = new VendingSystem();
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Machine system starts up
		if(system == null){
			system = new VendingSystem();
		}
		boolean breakLoop = false;
		int menuAnswer;
		
		
		//User selector menu
		while(!breakLoop)
		{
			menuAnswer = getInt("Who is the current user?\n"+
								"0 - Exit\n1 - Customer\n2 - Restocker\n3 - Manager", scan);
			
			switch(menuAnswer){
			case 1: // Run customer
				int machineID;
				boolean cu_continueLoop = true;
				
				while(cu_continueLoop){
					System.out.println("Please enter the Machine ID you are at, or -1 to exit");
					system.printCurrentMachines();
					machineID = getInt("", scan);
					
					if(machineID == -1){ 
						cu_continueLoop = false; 
					}else{
						for(int x = 0; x < system.machines.size(); x++){
							if(machineID == system.machines.get(x).getMachineID()){
								cu_continueLoop = false;
								Customer c = new Customer();
								c.runCustomer(system.machines.get(x),scan);
								break;
							}
						}//End for
						if(cu_continueLoop){
							System.out.println("Invalid Machine Number");
						}
					}//End if
					
				}//End while
				break;
				
			case 2:	// Login to Restocker
				String re_username = "";
				String re_password = "";
				boolean re_continueLoop = true;
				
				System.out.println("Please enter your user name and password, or <exit>");
				while(re_continueLoop){
					System.out.print("User Name: ");
					re_username = scan.nextLine();
					if(re_username.equals("exit") || re_username.equals("Exit")){
						re_continueLoop = false;
					}else{
						System.out.print("Password: ");
						re_password = scan.nextLine();
								Restocker r = system.restockerExists(re_password,re_username);
								if( r == null){
									re_continueLoop = true;
								}
								boolean re_machine_continueLoop = true;
								while(re_machine_continueLoop){
									system.printCurrentMachines();
									machineID = getInt("Please enter the Machine ID you are at, or -1 to exit", scan);
									if(machineID == -1){ 
										re_machine_continueLoop = false; 
									}else{
										re_machine_continueLoop = system.machineExists(machineID);
										if(!re_machine_continueLoop){
											System.out.println("Invalid Machine Number");
										}else{
											//TODO add runRestocker somehow
										}
									}//End if
									
								}//End while

								break;
							}
					}//End for
						
					if(re_continueLoop){
						System.out.println("Invalid username and/or password");
					}

				break;
			
			case 3: // Login to Manager
				String ma_username = "";
				String ma_password = "";
				boolean ma_continueLoop = true;
				
				System.out.println("Please enter your user name and password, or <exit>");
				while(ma_continueLoop){
					System.out.print("User Name: ");
					ma_username = scan.nextLine();
					if(ma_username.equals("exit") || ma_username.equals("Exit")){
						ma_continueLoop = false;
					}else{
						System.out.print("Password: ");
						ma_password = scan.nextLine();
						//TODO replace with some function boolean managerExists();
						/*
						for(int x = 0; x < managerList.size(); x++){
							if(ma_username.equals(managerList.get(x).getUsername()) && 
									ma_password.equals(managerList.get(x).getPassword()) ){
								ma_continueLoop = false;
								managerList.get(x).runManager(system, scan);
								break;
							}
						}//End for
						*/
						if(ma_continueLoop){
							System.out.println("Invalid username and/or password");
						}
					}//End if else
				}// End while
				break;
				
			case 0: // Exit
				breakLoop = true;
				break;
				
			default:
				System.out.println("Not a valid option");
				break;
			}
			
		}
		
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream( new FileOutputStream(filename));
			oos.writeObject(system);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Thanks for using French Toast Vending");
	}
	
	/**
	 * Takes and guarantees integer input from the user
	 * @param prompt the Display message for input
	 * @param scan the input scanner that grabs the input from command line
	 * @return
	 */
	public static int getInt(String prompt, Scanner scan){
		boolean validInput = false;
		int intInput = 0;
		String stringInput;
		scan.reset();
		
		//loop until input is valid
		while(!validInput){
			System.out.println(prompt);
			stringInput = scan.nextLine();
			//check for valid input
			try{
				intInput = Integer.parseInt(stringInput);
				if(intInput >= -1){
					validInput = true;
				}else{
					System.out.println("Please Enter A Non-Negative Number");
				}
			}catch(NumberFormatException e){
				System.out.println("Invalid Input");
			}//end catch
		}//end while
		return intInput;
	}
	
	
	
}
