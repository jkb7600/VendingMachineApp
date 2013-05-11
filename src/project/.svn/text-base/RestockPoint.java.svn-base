package project;
/**
 * $Log$
 * $Id$
 * $Revision$
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Holds info for a restocking action, used for manager info collection
 * @author FTM
 */
public class RestockPoint implements Serializable{
	
	//name of the instruction
	private String _name;
	
	//the instruction, a phrase describing a required action for the restocker
	private ArrayList<String> _instruction = new ArrayList<String>();
	
	//the date that the restocker checked off this instruction
	private Date _date;
	
	/**
	 * Default constructor, makes generic restock data point
	 */
	public RestockPoint(){
		_name = "";
		_date = new Date();
	}
	
	/**
	 * Makes a restock point
	 * @param name the name of the instruction
	 * @param instruction the instruction text
	 */
	public RestockPoint(String name, ArrayList<String> instruction){
		_name = name;
		_instruction = instruction;
		_date = new Date();
	}
	
	/**
	 * Fetches the name
	 * @return the name
	 */
	public String getName(){
		return _name;
	}
	
	/**
	 * Fetches the instructor text that was given to the instructor
	 * @return
	 */
	public ArrayList<String> getInstruction(){
		return _instruction;
	}
	
	/**
	 * Gets the date the instruction was completed
	 * @return
	 */
	public String getDate(){
		return _date.toGMTString();
	}
}
