package Test;
import java.util.ArrayList;

import project.Item;
import junit.framework.TestCase;

/**
 * Item Test Class
 */
public class ItemTest extends TestCase {
	ArrayList<Integer> _expDates = new ArrayList<Integer>();
	ArrayList<Integer> _expDates2 = new ArrayList<Integer>();
	
	Item item;
	
	public ItemTest(String arg0) {
		super(arg0);
	}

	protected void setUp(){
		_expDates.add(200);
		_expDates.add(0);
		_expDates2.add(400);
		_expDates2.add(500);
		item = new Item("Panda",12,2,1,_expDates);
		
		
	}
	
	/**
	 * Tests expiration dates are cleared
	 */
	public void testClearExp(){
		item.clearExp();
		assertEquals("Should clear the expDates", 0 , item.getExpDates().size());
		setUp();
	}
	/**
	 * Tests the amount of expired items
	 */
	public void testAmountOfExpired(){

		try {//put thread to sleep for 1 second to ensure the one item is expired
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("returns 1 Item expired.",1, item.amountOfExpired((System.nanoTime()/1000000000)/60));
	}
	/**
	 * Tests if an item is expired
	 */
	public void testIfIsExpired(){
		
		assertEquals("returns true expired.",true, item.isExpired((System.nanoTime()/1000000000)/60));
		//assertEquals("returns true expired.",false, item.isExpired((System.nanoTime()/1000000000)/60));
		
	}
	/**
	 * Adds expiration dates to items
	 */
	public void testAddExpDates(){
		item.clearExp();
		//had to add a from a different array, there was some link between the first
		//and the item that cause a change in both when you clear.
		item.addExpDates(_expDates2);
		assertEquals("ExpSize should be 2.",2, item.getExpDates().size());
	}
	/**
	 * Removes expiration dates from items
	 */
	public void testRemoveExpDates(){
		int start = item.getExpSize();
		item.removeExpDates(1);
		assertEquals("ExpSize should be one less.",start - 1, item.getExpSize());
	}
}
