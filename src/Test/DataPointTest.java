package Test;
import java.util.Date;

import project.DataPoint;

import junit.framework.TestCase;

/**
 * DataPoint Test Class
 */
public class DataPointTest extends TestCase {
 DataPoint point;
 DataPoint point2;

	public DataPointTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		point = new DataPoint();
		point2 = new DataPoint("test",1,1,1);
	}
	/**
	 * Tests Getter Methods
	 */
	public void testGetName(){
		assertEquals("Name equals name instantiated","", point.getName());
		assertEquals("Name equals name instantiated","test",point2.getName());
	}
	
	public void testGetItemID(){
		assertEquals("ID equals ID given",0, point.getItemID() );
		assertEquals("ID equals ID given",1, point2.getItemID() );
	}
	
	public void testGetMachineID(){
		assertEquals("Machine ID equals Machine ID given",0, point.getMachineID() );
		assertEquals("Machine ID equals Machine ID given",1, point2.getMachineID() );
		
	}
	public void testGetItemIndex(){
		assertEquals("Index equals Index given",0, point.getItemIndex() );
		assertEquals("Index equals Index given",1, point2.getItemIndex() );
	}
}
