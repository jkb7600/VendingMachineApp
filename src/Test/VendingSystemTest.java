package Test;
import java.util.ArrayList;

import project.Item;
import project.Manager;
import project.Restocker;
import project.VendingMachine;
import project.VendingSystem;
import junit.framework.TestCase;

/**
 * VendingMachine Test Class
 */
public class VendingSystemTest extends TestCase {
	VendingSystem system;
	VendingMachine machine1;
	Item item1;
	ArrayList<Item> items;
	ArrayList<Integer> expDates;
	private ArrayList<Manager> managerList;
	private ArrayList<Restocker> restockerList;
	
	public VendingSystemTest(String arg0) {
		super(arg0);
	}
	public void setUp(){
		expDates = new ArrayList<Integer>();
		expDates.add(1);
	
		item1 = new Item("name",1,1,1,expDates);
		items = new ArrayList<Item>();
		items.add(item1);
		
		machine1 = new VendingMachine(1,1,1,1,1,items,0);
		
		system = new VendingSystem();
		
		managerList = system.getManagerList();
		restockerList = system.getRestockerList();
		
		//System.out.println(system.machines.size());
		
	}
	/**
	 * Tests that machines are added
	 */
	public void testAddNewMachine(){
		int start = system.machines.size();
		 system.addNewMachine(machine1);
		assertEquals("Size of one item list should be +1.",start+1,system.machines.size());
	}
	/**
	 * Lists Current machines in the list
	 */
	public void testListCurrentMachines(){
		ArrayList<VendingMachine> temp = system.listCurrentMachines();
		assertEquals("Should size should match system size",system.machines.size(),temp.size());
	}
	/**
	 * Tests that Managers are added
	 */
	public void testAddManager(){
		int beforeSize = managerList.size();
		String manager = "meo6014";
		String password = "yes";
		system.addManager(manager, password);
		int afterSize = managerList.size();
		assertEquals("Manager has been added",afterSize,beforeSize + 1);
	}
	/**
	 * Tests that Managers are removed
	 */
	public void testRemoveManager(){
		String manager = "meo6014";
		String password = "yes";
		system.addManager(manager,password);
		int beforeSize = managerList.size();
		system.removeManager(manager);
		int afterSize = managerList.size();
		assertEquals("Manager has been removed",afterSize,beforeSize-1);
	}
	/**
	 * Tests that Restockers are added
	 */
	public void testAddRestocker(){
		int beforeSize = restockerList.size();
		String restocker = "mike";
		String password = "no";
		system.addRestocker(restocker,password);
		int afterSize = restockerList.size();
		assertEquals("Restocker has been added",afterSize,beforeSize + 1);
	}
	/**
	 * Tests that Restockers are removed
	 */
	public void testRemoveRestockerProfile(){
		String restocker = "mike";
		String password = "no";
		system.addRestocker(restocker,password);
		int beforeSize = restockerList.size();
		system.removeRestocker(restocker);
		int afterSize = restockerList.size();
		assertEquals("Restocker has been removed",afterSize,beforeSize-1);		
	}
	/**
	 * Tests that items are initialized
	 */
	public void testInitializeItem(){
		system.initalizeItemList();
		//System.out.println(system.itemsList.size());
		assertEquals("Size of itemList Hash map is constructed.",37,system.itemsList.size() );
	}	
}
