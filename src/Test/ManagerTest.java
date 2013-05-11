package Test;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import project.Item;
import project.Manager;
import project.RestockPoint;
import project.Restocker;
import project.Statistics;
import project.VendingMachine;
import project.VendingSystem;

import junit.framework.TestCase;

/**
 * Manager Test Class
 */
public class ManagerTest extends TestCase {
	
	private ArrayList<Manager> managerLoginList;
	private ArrayList<Restocker> restockerLoginList;
	private VendingMachine machine;
	private VendingSystem vendingSystem;
	public TreeMap<String, Integer> itemsList;
	public long startTime;
	ArrayList<Item> initialItems;
	
	private Statistics statistics;

	public ManagerTest(String arg0) {
		super(arg0);
	}

	protected void setUp(){
		vendingSystem = new VendingSystem();
		managerLoginList = vendingSystem.getManagerList();
		restockerLoginList = vendingSystem.getRestockerList();
		itemsList = new TreeMap<String, Integer>();
		startTime = (System.nanoTime()/1000000000)/60;
		vendingSystem.initalizeItemList();
		initialItems = new ArrayList<Item>();
		machine = new VendingMachine(60,1,1,1,10.00,initialItems,startTime);	
		statistics = new Statistics();
	}
	/**
	 * Tests that a machine has been added
	 */
	public void testManagerAddMachine(){
		int beforeSize = vendingSystem.listCurrentMachines().size();
		vendingSystem.addNewMachine(machine);
		int afterSize = vendingSystem.listCurrentMachines().size();
		assertEquals("Machine has been added",afterSize,beforeSize + 1);
	}
	/**
	 * Tests that a report has been added
	 */
	public void testAddReport(){
		String name = "report";
		ArrayList<String> instruction = new ArrayList<String>();
		instruction.add("do it");
		int beforeSize = statistics.getRestockStatList().size();
		statistics.addRestock(name, instruction);
		int afterSize = statistics.getRestockStatList().size();
		assertEquals("Report has been added", afterSize, beforeSize + 1);
	}
	/**
	 * Tests that a manager profile has been added
	 */
	public void testManagerAddProfile(){
		int beforeSize = managerLoginList.size();
		String manager = "meo6014";
		String password = "yes";
		vendingSystem.addManager(manager, password);
		int afterSize = managerLoginList.size();
		assertEquals("Manager Profile has been added",afterSize,beforeSize + 1);
	}
	/**
	 * Tests that a Manager profile has been removed
	 */
	public void testManagerRemoveProfile(){
		String manager = "meo6014";
		String password = "yes";
		vendingSystem.addManager(manager,password);
		int beforeSize = managerLoginList.size();
		vendingSystem.removeManager(manager);
		int afterSize = managerLoginList.size();
		assertEquals("Manager Profile has been removed",afterSize,beforeSize-1);
	}
	/**
	 * Tests that a Restocker Profile has been added
	 */
	public void testAddRestockerProfile(){
		int beforeSize = restockerLoginList.size();
		String restocker = "mike";
		String password = "no";
		vendingSystem.addRestocker(restocker,password);
		int afterSize = restockerLoginList.size();
		assertEquals("Restocker Profile has been added",afterSize,beforeSize + 1);
	}
	/**
	 * Tests that a Restocker Profile has been removed
	 */
	public void testRemoveRestockerProfile(){
		String restocker = "mike";
		String password = "no";
		vendingSystem.addRestocker(restocker,password);
		int beforeSize = restockerLoginList.size();
		vendingSystem.removeRestocker(restocker);
		int afterSize = restockerLoginList.size();
		assertEquals("Restocker Profile has been removed",afterSize,beforeSize-1);		
	}
}
