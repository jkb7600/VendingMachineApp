package Test;
import java.util.ArrayList;
import java.util.Scanner;

import project.Item;
import project.VendingMachine;
import project.VendingSystem;

import junit.framework.TestCase;

/**
 * Customer Test Class
 */
public class CustomerTest extends TestCase {
	
	VendingMachine currentMachine;
	VendingSystem vendingSystem;
	ArrayList<Item> itemList = new ArrayList<Item>();
	Item item = new Item();
	ArrayList<Integer> _expDates = new ArrayList<Integer>();
	ArrayList<Integer> _expDates2 = new ArrayList<Integer>();

	public CustomerTest(String arg0) {
		super(arg0);
	}

	protected void setUp()  {
		_expDates.add(200);
		_expDates.add(200);
		item = new Item("Snickers", 1, 2, 1.00, _expDates);
		itemList.add(item);
		
		_expDates2.add(0);
		item = new Item("Twix", 2, 1, 1.00, _expDates2);
		itemList.add(item);
		
		currentMachine = new VendingMachine(0, 2, 2, 4, 10.00, itemList, 0);
	}
	/**
	 * Tests if money inserted by customer
	 * equals balance read by vending machine
	 */
	public void testInsertMoney() {
		//money inserted
		double moneyInserted = currentMachine.getCustomerBalance();
		currentMachine.addMoney(5);
		//store new balance
		double Balance = currentMachine.getCustomerBalance();
		assertEquals("Money inserted equals the Customer Balance", Balance ,moneyInserted + 5);
	}
	
	/**
	 * Tests that balance in machine is reset to 0
	 */
	public void testRefund() {
		currentMachine.setCustomerBalance(5);
		double currentBalance = currentMachine.getCustomerBalance();
		currentMachine.addMoney(-1 * currentBalance);
		currentBalance = currentMachine.getCustomerBalance();
		assertEquals("Balance equals 0 in machine",currentBalance,0.0);
	}	
}
