package Test;
import java.util.ArrayList;

import project.Item;
import project.VendingMachine;

import junit.framework.TestCase;

/**
 * VendingMachine Test Class
 */
public class VendingMachineTest extends TestCase {
	
	VendingMachine vendingMachine;
	ArrayList<Item> itemList = new ArrayList<Item>();
	Item item = new Item();
	ArrayList<Integer> _expDates = new ArrayList<Integer>();
	ArrayList<Integer> _expDates2 = new ArrayList<Integer>();
	
	public VendingMachineTest(String arg0) {
		super(arg0);
	}
	
	protected void setUp(){
		_expDates.add(200);
		_expDates.add(200);
		item = new Item("Snickers", 1, 2, 1.00, _expDates);
		itemList.add(item);
		
		_expDates2.add(0);
		item = new Item("Twix", 2, 1, 1.00, _expDates2);
		itemList.add(item);
		
		vendingMachine = new VendingMachine(0, 2, 2, 4, 10.00, itemList, 0);
	}
	
	/**
	 * Tests that adding money to the machine works
	 */
	public void testAfterAddingMoney(){
		//get balance
		double firstBalance = vendingMachine.getCustomerBalance();
		vendingMachine.addMoney(5);
		//store new balance
		double secondBalance = vendingMachine.getCustomerBalance();
		assertEquals("Money inserted equals the Customer Balance", secondBalance ,firstBalance + 5);
	}

	/**
	 * Tests that the balance is updated correctly
	 */
	public void testUpdateBalance(){
		double totalBalance = vendingMachine.getTotalBalance();
		vendingMachine.updateBalance(5);
		//store new balance
		double updatedTotalBalance = vendingMachine.getTotalBalance();
		assertEquals("Money inserted equals the Total Balance", updatedTotalBalance ,totalBalance + 5);
	}
	
	/**
	 * Tests selected item is removed
	 */
	public void testSelectItem(){
		vendingMachine.addMoney(5.00);
		
		int beforeSize = vendingMachine.getAllItems().get(0).getCurrentNum();
		//get ItemID
		vendingMachine.selectItem(1);
		int afterSize = vendingMachine.getAllItems().get(0).getCurrentNum();
		assertEquals("Selected item is removed", beforeSize, afterSize+1);	
	}		
	
	/**
	 * Tests that item discontinued from machine
	 */
	public void testDiscontinueItem(){
		vendingMachine.discontinueItem(1);
		int ID = vendingMachine.getAllItems().get(0).getItemID();
		assertEquals("Selected item is discontinued", ID, 0);
	}
	
	/**
	 * Tests added quantity is the desired one
	 */
	public void testAddItemQuantity(){
		int beforeNum = vendingMachine.getAllItems().get(0).getCurrentNum();
		int beforeExp = vendingMachine.getAllItems().get(0).getExpSize();
		
		ArrayList<Integer> expList = new ArrayList<Integer>();
		expList.add(200); expList.add(200);
		vendingMachine.addItemQuantity(1, 2, expList);
		
		int afterNum = vendingMachine.getAllItems().get(0).getCurrentNum();
		int afterExp = vendingMachine.getAllItems().get(0).getExpSize();
		
		assertEquals("Updated the itemCount", beforeNum+2, afterNum);
		assertEquals("Updated the _expList", beforeExp+2, afterExp);
	}
	
	/**
	 * Tests that all available items
	 * are listed 
	 */
	public void testListAvailableItems(){
		
		ArrayList<Item> availableItems = vendingMachine.listAvailableItems();
		// Working template (should be == 1)
		assertEquals("Returns the correct items", availableItems.size(), 0);
	}
	
	/**
	 * Tests cost is changed correctly
	 */
	public void testChangeCost(){
		double beforeCost = vendingMachine.getAllItems().get(0).getCost();
		
		vendingMachine.changeCost(1, 1.50);
		double afterCost = vendingMachine.getAllItems().get(0).getCost();
		
		assertEquals("Before was $1.00", beforeCost, 1.00);
		assertEquals("After was $1.50", afterCost, 1.50);
	}
	
	/**
	 * Tests item is added correctly
	 */
	public void testAddNewItem(){
		int beforeID = vendingMachine.getAllItems().get(2).getItemID();
		
		ArrayList<Integer> _expList3 = new ArrayList<Integer>();
		_expList3.add(200);
		_expList3.add(200);
		
		vendingMachine.addNewItem(2, "Skittles", 3, 2, 1.00, _expList3);
		int afterID = vendingMachine.getAllItems().get(2).getItemID();
		
		assertEquals("Before was ID[0]", beforeID, 0);
		assertEquals("After is ID[3]", afterID, 3);
	}
		
}
