package Test;
import java.util.ArrayList;

import project.Statistics;

import junit.framework.TestCase;

/**
 *  Statistics Test Class
 */
public class StatisticsTest extends TestCase {
Statistics stat;
ArrayList<String> instruction;
	public StatisticsTest(String arg0) {
		super(arg0);
	}
	
	protected void setUp()  {
		stat = new Statistics();
		instruction = new ArrayList<String>();
		instruction.add("TEST INSTRUCTION");
	}
	/**
	 * Tests that stats are added correctly
	 */
	public void testAddStat(){
		int startSize = stat.getDataStatList().size();
		stat.addStat("test", 1, 1, 1);
		assertEquals("Stat list should increas size by 1.", startSize +1, stat.getDataStatList().size());
	}
	/**
	 * Tests that Restocker stats are added correctly
	 */
	public void testAddRestock(){
		
		int startSize = stat.getRestockStatList().size();
		stat.addRestock("Bill", instruction);
		assertEquals("Stat list should increas size by 1.", startSize +1, stat.getRestockStatList().size());
		
	}
	

}
