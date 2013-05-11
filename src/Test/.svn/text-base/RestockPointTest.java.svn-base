package Test;
import java.util.ArrayList;

import project.RestockPoint;

import junit.framework.TestCase;

/**
 * RestockerPoint Test Class
 */
public class RestockPointTest extends TestCase {
	ArrayList<String> instruction;
	RestockPoint res;
	public RestockPointTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instruction = new ArrayList<String>();
		instruction.add("TEST INSTRUCTION");
		res = new RestockPoint("TEST", instruction);
	}
	/**
	 * Make sure it gets the name
	 */
	public void testGetName(){
		assertEquals("Name equals name", "TEST", res.getName());
	}
	/**
	 * Makes sure it gets the instruction
	 */
	public void testGetInstruction(){
		assertEquals("Instructions = Instructions given", instruction, res.getInstruction());
	}
}
