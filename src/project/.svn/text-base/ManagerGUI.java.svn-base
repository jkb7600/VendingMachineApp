/**
 * 
 */
package project;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * This a user friendly view for a manager for French Toast Mafia
 * vending machine software.
 * @author McKay Clawson
 * @author Lenny Kerznowski
 * @author Michael Oliveros
 * @author FTM
 */
public class ManagerGUI implements Serializable{
	
	////This is the model that provides functionality for performing use case
	//actions on vending machines
	private Manager managerModel;
	private VendingSystem _system;

	/**
	 * Test program for the GUI
	 * @param args
	 */

	
	
	
	//The main window for the Manager GUI
	private JFrame managerFrame;
	private JPanel managerOptionList;
	private JButton b_addMachine;
	private JButton b_deleteMachine;
	private JButton b_uploadReport;
	private JButton b_machineState;
	private JButton b_addManager;
	private JButton b_deleteManager;
	private JButton b_addRestocker;
	private JButton b_deleteRestocker;
	private JButton b_viewStats;
	private JButton b_logOut;
	
	
	//General variables
	private JList<Integer> machineIDList;
	private JList<Integer> itemIndexList;
	private JList<String> itemNameList;
	private JTextArea errorField;
	
	//JFrame for addMachine GUI
	private JFrame addMachineGUI;
	private JTextField t_ID, t_rows, t_cols, t_depth, t_money;
	private JFrame addItemsGUI;
	private JPanel center, east;
	private JTextField iID, iName, iCost, iNum, iExp;
	private int tempMachineID, currentIndex;
	private String currentItemName;
	private JFrame quitFrameGUI;
	private JFrame newItemGUI;
	private JFrame finalizeGUI;
	
	
	//JFrame for deleteMachine GUI
	private JFrame deleteMachineGUI;
	
	//JFrame for uploadReportGUI
	private JFrame uploadReportGUI;
	private JTextField filePath;
	private JFrame UP_selectMachineGUI;
	
	//JFrame for MachineState GUI
	private JFrame machineStateGUI;
	private JFrame printInventoryGUI;
	private JFrame printExpiredGUI;
	private JFrame printNotesGUI;
	private JFrame MS_selectMachineGUI;
	private int ID;
	
	//Related variables for the addManager GUI
	private JFrame addManagerGUI;
	private JTextField am_t_username;
	private JPasswordField am_t_password;
	private JTextArea am_t_listManagers;
	
	//Related variables for the deleteManager GUI
	private JFrame deleteManagerGUI;
	private JTextField dm_t_username;
	private JTextArea dm_t_listManagers;
	
	//Related variables for the addRestocker GUI
	private JFrame addRestockerGUI;
	private JTextField ar_t_username;
	private JPasswordField ar_t_password;
	private JTextArea ar_t_listRestockers;
	
	//Related variables for the deleteRestocker GUI
	private JFrame deleteRestockerGUI;
	private JTextField dr_t_username;
	private JTextArea dr_t_listRestockers;
	
	//Stats Stuff
	private JFrame statsWindow;
	private JButton viewAgs;
	private JPanel statsPanel;
	private JButton machineBar;
	private JFrame barWindow;
	private JPanel barPanel;
	private JTextArea barText;
	private JScrollPane barScroll;
	
	/**
	 * Constructs a GUI for a manager
	 * @param system The vending machine system that contains machine
	 * @param machine The machine this customer is logging into
	 */
	public ManagerGUI(VendingSystem system, Manager m){
		
		
		_system =system;
		managerModel = m;
		initManagerFrame();
	}

	
	/**
	 * initialized the frame of the Manager machine
	 */
	private void initManagerFrame(){
		managerFrame = new JFrame("Manager: " + managerModel.getUsername());
		managerFrame.setResizable(false);
		managerFrame.setLayout(new BorderLayout());
		
		//Initialize window panel
		managerOptionList = new JPanel();
		managerOptionList.setLayout(new GridLayout(9,1));
		
		initAddMachine();
		initDeleteMachine();
		initUploadReport();
		initMachineState();
		initAddManager();
		initDeleteManager();
		initAddRestocker();
		initDeleteRestocker();
		initViewStats();
		initLogOut();
		
		//Add Buttons to Manager OptionList
		managerOptionList.add(b_addMachine);
		managerOptionList.add(b_deleteMachine);
		managerOptionList.add(b_uploadReport);
		managerOptionList.add(b_machineState);
		managerOptionList.add(b_addManager);
		managerOptionList.add(b_deleteManager);
		managerOptionList.add(b_addRestocker);
		managerOptionList.add(b_deleteRestocker);
		managerOptionList.add(b_viewStats);
		managerFrame.add(managerOptionList, BorderLayout.CENTER);
		managerFrame.add(b_logOut, BorderLayout.SOUTH);
		JPanel north = new JPanel();
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("FTM (350x88).jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
		north.add( picLabel );
		managerFrame.add(north,BorderLayout.NORTH);
		//set up JFRAME sizing
		managerFrame.setSize(350, 500);
		managerFrame.setLocation(100, 100);
		managerFrame.setVisible(true);
		managerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	
	/**
	 * Initializes the AddMachine Button
	 */
	private void initAddMachine(){
		b_addMachine = new JButton("Add New Machine");
		//add action listener
		b_addMachine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(false);
				initAddMachineGUI();
			}
		});
	}
	private void initAddMachineGUI(){
		addMachineGUI = new JFrame("Add New Machine");
		addMachineGUI.setLayout(new BorderLayout());
		
		JPanel west = new JPanel();
		west.setLayout(new BorderLayout());
		JPanel machineLabel = new JPanel();
		machineLabel.setLayout(new FlowLayout());
		machineLabel.add(new JLabel("Existing ID's"));
		machineIDList = new JList<Integer>();
		refreshMachineIDList();

		machineIDList.setCellRenderer(new DefaultListCellRenderer() {
		    public Component getListCellRendererComponent(JList list, Object value, int index,
		            boolean isSelected, boolean cellHasFocus) {
		        super.getListCellRendererComponent(list, value, index, false, false);
		        return this;
		    }
		});
		
		JScrollPane s_machineIDList = new JScrollPane(machineIDList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		west.add(machineLabel, BorderLayout.NORTH);
		west.add(s_machineIDList, BorderLayout.CENTER);
		addMachineGUI.add(west, BorderLayout.WEST);
		
		JPanel addMain = new JPanel();
		addMain.setLayout(new GridLayout(7,1));
		
		JPanel info = new JPanel();
		info.setLayout(new FlowLayout());
		info.add(new JLabel("New Machine Information"));
		
		JPanel rowID = new JPanel();
		rowID.setLayout(new FlowLayout());
		JLabel l_ID = new JLabel("Machine ID:");
		t_ID = new JTextField(10);
		rowID.add(l_ID);
		rowID.add(t_ID);
		
		JPanel rowRows = new JPanel();
		rowRows.setLayout(new FlowLayout());
		JLabel l_rows = new JLabel(" # of Rows:");
		t_rows = new JTextField(10);
		rowRows.add(l_rows);
		rowRows.add(t_rows);
		
		JPanel rowCols = new JPanel();
		rowCols.setLayout(new FlowLayout());
		JLabel l_cols = new JLabel(" # of Columns:");
		t_cols = new JTextField(10);
		rowCols.add(l_cols);
		rowCols.add(t_cols);
		
		JPanel rowDepth = new JPanel();
		rowID.setLayout(new FlowLayout());
		JLabel l_depth = new JLabel("Depth #:");
		t_depth = new JTextField(10);
		rowDepth.add(l_depth);
		rowDepth.add(t_depth);
		
		JPanel rowMoney = new JPanel();
		rowID.setLayout(new FlowLayout());
		JLabel l_money = new JLabel("Money:");
		t_money = new JTextField(10);
		rowMoney.add(l_money);
		rowMoney.add(t_money);
		
		errorField = new JTextArea("   <Input Error Field>", 3, 25);
		errorField.setPreferredSize(errorField.getPreferredSize());
		errorField.setEditable(false);
		
		addMain.add(info);
		addMain.add(rowID);
		addMain.add(rowRows);
		addMain.add(rowCols);
		addMain.add(rowDepth);
		addMain.add(rowMoney);
		addMain.add(errorField);
		addMachineGUI.add(addMain, BorderLayout.CENTER);
		
		
		JPanel options = new JPanel();
		JButton next = new JButton("Next Step");
		JButton exit = new JButton("Exit");
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(true);
				addMachineGUI.dispose();
			}
		});
		
		next.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				int id, rows, cols, depth;
				double money;
				String errors = "";
				
				try{
					id = Integer.parseInt(t_ID.getText());
					if(_system.machineExists(id)){
						errors += "- ID is already in use\n";
					}
				}catch(NumberFormatException er){
					errors += "- ID is not an Integer\n";
				}
				
				try{
					rows = Integer.parseInt(t_rows.getText());
					if(rows <= 0){
						errors += "- Rows needs to be at least 1\n";
					}
				}catch(NumberFormatException er){
					errors += "- Rows is not an Integer\n";
				}
				
				try{
					cols = Integer.parseInt(t_cols.getText());
					if(cols <= 0){
						errors += "- Columns needs to be at least 1\n";
					}
				}catch(NumberFormatException er){
					errors += "- Columns is not an Integer\n";
				}
				
				try{
					depth = Integer.parseInt(t_depth.getText());
					if(depth <= 0){
						errors += "- Depth needs to be at least 1\n";
					}
				}catch(NumberFormatException er){
					errors += "- Depth is not an Integer\n";
				}
				
				try{
					money = Double.parseDouble(t_money.getText());
					if(money < 0){
						errors += "- Money must be positive\n";
					}
				}catch(NumberFormatException er){
					errors += "- Money is not a Double\n";
				}
				
				
				if(errors.equals("")){
					managerModel.manager_addMachine_GUI(_system, 
							Integer.parseInt(t_ID.getText()), 
							Integer.parseInt(t_rows.getText()),
							Integer.parseInt(t_cols.getText()),
							Integer.parseInt(t_depth.getText()),
							Double.parseDouble(t_money.getText()));
					tempMachineID = Integer.parseInt(t_ID.getText());
					initAddItemsGUI();
					addMachineGUI.dispose();
				}
				else{
					errorField.setText(errors);
				}
				
			}
		});
		
		options.add(next);
		options.add(exit);
		addMachineGUI.add(options, BorderLayout.SOUTH);
		
		addMachineGUI.setSize(400, 400);
		addMachineGUI.setLocation(400, 100);
		addMachineGUI.setVisible(true);
		addMachineGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addMachineGUI.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				managerFrame.setVisible(true);
			}
		});
		
	}
	
	private void initAddItemsGUI(){
		addItemsGUI = new JFrame("Machine " + tempMachineID + ": Add Items");
		addItemsGUI.setLayout(new BorderLayout());
		
		
		JPanel west = new JPanel();
		west.setLayout(new BorderLayout());
		
		JLabel l_items = new JLabel("Item Slot Index's");
		
		itemIndexList = new JList<Integer>();
		refreshItemIndexList(tempMachineID);
		itemIndexList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemIndexList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				if(evt.getValueIsAdjusting()){
					currentIndex = (Integer) itemIndexList.getSelectedValue();
					Item tempItem = _system.getMachine(tempMachineID).getAllItems().get(currentIndex-1);
					if(tempItem.getItemID() == 0){
						iID.setText("");
						iName.setText("");
						iCost.setText("");
						iNum.setText("");
						iExp.setText("");
					}else{
						iID.setText("" + tempItem.getItemID());
						iName.setText("" + tempItem.getName());
						iCost.setText("" + tempItem.getCost());
						iNum.setText("" + tempItem.getCurrentNum());
						iExp.setText("" + _system.getMachine(tempMachineID).getAllItems().get(currentIndex-1).getExpDates().get(0));
					}
					east.setVisible(true);
					center.setVisible(true);
					return;
				}
			}
		});
		JScrollPane s_itemIndexList = new JScrollPane(itemIndexList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		west.add(l_items, BorderLayout.NORTH);
		west.add(s_itemIndexList, BorderLayout.CENTER);
		addItemsGUI.add(west, BorderLayout.WEST);
		
		
		// East
		east = new JPanel();
		east.setLayout(new BorderLayout());
		JLabel l_names = new JLabel("Existing Items");
		
		itemNameList = new JList<String>();
		refreshSystemItemsList();
		itemNameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		itemNameList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				if(evt.getValueIsAdjusting()){
					currentItemName = (String) itemNameList.getSelectedValue();
					iID.setText(_system.getItemList().get(currentItemName).toString());
					iName.setText(currentItemName);
					iCost.setText("");
					iNum.setText("");
					iExp.setText("");
					return;
				}
			}
		});
		JScrollPane s_itemNameList = new JScrollPane(itemNameList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		east.add(s_itemNameList, BorderLayout.CENTER);
		east.add(l_names, BorderLayout.NORTH);
		east.setVisible(false);
		addItemsGUI.add(east, BorderLayout.EAST);
		
		
		
		center = new JPanel();
		center.setLayout(new FlowLayout());
		JPanel itemInfo = new JPanel();
		itemInfo.setLayout(new GridLayout(6,1));
		
		JPanel infoID = new JPanel();
		infoID.setLayout(new FlowLayout());
		JLabel l_ID = new JLabel("Item ID:");
		iID = new JTextField(10);
		infoID.add(l_ID);
		infoID.add(iID);
		
		JPanel infoName = new JPanel();
		infoName.setLayout(new FlowLayout());
		JLabel l_name = new JLabel("Item Name:");
		iName = new JTextField(10);
		infoName.add(l_name);
		infoName.add(iName);
		
		JPanel infoCost = new JPanel();
		infoCost.setLayout(new FlowLayout());
		JLabel l_Cost = new JLabel("Item Cost:");
		iCost = new JTextField(10);
		infoCost.add(l_Cost);
		infoCost.add(iCost);
		
		JPanel infoNum = new JPanel();
		infoName.setLayout(new FlowLayout());
		JLabel l_num = new JLabel("# of Items:");
		iNum = new JTextField(10);
		infoNum.add(l_num);
		infoNum.add(iNum);
		
		JPanel infoExp = new JPanel();
		infoExp.setLayout(new FlowLayout());
		JLabel l_exp = new JLabel("Expiration:");
		iExp = new JTextField(10);
		infoExp.add(l_exp);
		infoExp.add(iExp);
		
		errorField = new JTextArea("    <Input Error Field>", 3, 25);
		errorField.setPreferredSize(errorField.getPreferredSize());
		errorField.setEditable(false);
		
		itemInfo.add(infoID);
		itemInfo.add(infoName);
		itemInfo.add(infoCost);
		itemInfo.add(infoNum);
		itemInfo.add(infoExp);
		itemInfo.add(errorField);
		center.add(itemInfo, BorderLayout.CENTER);
		
		JPanel options = new JPanel();
		options.setLayout(new GridLayout(1,2));
		
		JButton save = new JButton("Save Item");
		save.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				TreeMap<String,Integer> allItems = _system.getItemList();
				boolean newItem = true;
				int id = 0, num = 0, exp = 0;
				String name;
				double cost;
				String errors = "";
				
				try{
					id = Integer.parseInt(iID.getText());
					if(id < 1){
						errors += "- ID cannot be less than 1\n";
					}
					if(allItems.containsValue(id)){
						newItem = false;
					}
				}catch(NumberFormatException er){
					errors += "- ID is not an Integer\n";
				}
				
				name = iName.getText();
				if(!newItem){
					if(!allItems.containsKey(name)){
						errors += "- Name does not match ID's Name\n";
					}else{
						if(id != allItems.get(name)){
							errors += "- Name does not match ID's Name\n";
						}
					}
				}
				if(newItem){
					if(allItems.containsKey(name)){
						errors += "- Name already in use\n";
					}
				}
				
				try{
					cost = Double.parseDouble(iCost.getText());
					if(cost < 0){
						errors += "- Cost must be positive\n";
					}else{
						if(cost % 0.25 != 0){
							errors += "- Cost must be a multiple of .25\n";
						}
					}
				}catch(NumberFormatException er){
					errors += "- Cost is not a Double\n";
				}
				
				try{
					num = Integer.parseInt(iNum.getText());
					if(num < 0){
						errors += "- Num must be positive\n";
					}else{
						if(num > _system.getMachine(tempMachineID).getDepth()){
							errors += "- Num cannot exceed Depth: " +
									   _system.getMachine(tempMachineID).getDepth() + "\n";
						}
					}
				}catch(NumberFormatException er){
					errors += "- Num is not a Integer\n";
				}
				
				try{
					exp = Integer.parseInt(iExp.getText());
					if(exp < 0){
						errors += "- Num must be positive\n";
					}else{
	
					}
				}catch(NumberFormatException er){
					errors += "- Exp is not a Integer\n";
				}
				
				
				//Creates Item after no errors
				if(errors.equals("")){
					if(!newItem){
						managerModel.manager_addItem_GUI(_system.getMachine(tempMachineID), currentIndex-1, 
								                         iName.getText(),
								                         Integer.parseInt(iID.getText()),
								                         Integer.parseInt(iNum.getText()),
								                         Double.parseDouble(iCost.getText()),
								                         Integer.parseInt(iExp.getText()));
						errorField.setText("   Item sucessfully added!");
					}else{
						newItemGUI = new JFrame("Create New Item?");
						newItemGUI.setLayout(new BorderLayout());
						
						JTextArea warning = new JTextArea(3,50);
						String warningText = "Warning, you are creating a New Item. \n" +
								             " Please make sure all information is correct!\n\n" +
								             "Do you wish to continue?";
						warning.setText(warningText);
						warning.setEditable(false);
						newItemGUI.add(warning, BorderLayout.CENTER);
						
						JPanel options = new JPanel();
						options.setLayout(new GridLayout(1,2));
						JButton no = new JButton("Cancel");
						no.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								newItemGUI.dispose();
							}
						});
						JButton yes = new JButton("Create Item");
						yes.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e){
								_system.addNewSystemItem(iName.getText(), Integer.parseInt(iID.getText()));
								managerModel.manager_addItem_GUI(_system.getMachine(tempMachineID), currentIndex-1, 
				                         iName.getText(),
				                         Integer.parseInt(iID.getText()),
				                         Integer.parseInt(iNum.getText()),
				                         Double.parseDouble(iCost.getText()),
				                         Integer.parseInt(iExp.getText()));
								errorField.setText("   Item sucessfully added and created!");
								refreshSystemItemsList();
								refreshItemIndexList(tempMachineID);
								newItemGUI.dispose();
							}
						});
						options.add(yes);
						options.add(no);
						newItemGUI.add(options, BorderLayout.SOUTH);
						
						newItemGUI.setSize(300,150);
						newItemGUI.setLocation(500, 150);
						newItemGUI.setVisible(true);
						newItemGUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
						
					}
				}else{
					errorField.setText(errors);
				}
				
				refreshSystemItemsList();
				refreshItemIndexList(tempMachineID);
			}
		});
		JButton finalize = new JButton("Finalize Machine");
		finalize.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				finalizeGUI = new JFrame("Finalize Machine?");
				finalizeGUI.setLayout(new BorderLayout());
				
				JTextArea warning = new JTextArea(3, 50);
				String warningText = "Warning, this will Finalize and save the machine\n" +
						             " Please make sure all information is correct!\n\n" +
						             "Do you wish to continue?";
				warning.setText(warningText);
				warning.setEditable(false);
				finalizeGUI.add(warning, BorderLayout.CENTER);
				
				JPanel options = new JPanel();
				options.setLayout(new GridLayout(1,2));
				JButton no = new JButton("Cancel");
				no.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						finalizeGUI.dispose();
					}
				});
				JButton yes = new JButton("Finalize");
				yes.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						managerFrame.setVisible(true);
						addItemsGUI.dispose();
						finalizeGUI.dispose();
					}
				});
				options.add(yes);
				options.add(no);
				finalizeGUI.add(options, BorderLayout.SOUTH);
				
				finalizeGUI.setSize(300,150);
				finalizeGUI.setLocation(500, 150);
				finalizeGUI.setVisible(true);
				finalizeGUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
		options.add(save);
		options.add(finalize);
		center.add(options, BorderLayout.SOUTH);
		center.setVisible(false);
		addItemsGUI.add(center, BorderLayout.CENTER);
		
		addItemsGUI.setSize(600, 400);
		addItemsGUI.setLocation(400, 100);
		addItemsGUI.setVisible(true);
		addItemsGUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		addItemsGUI.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				quitFrameGUI = new JFrame("Warning...");
				quitFrameGUI.setLayout(new BorderLayout());
				
				JTextArea warning = new JTextArea(3, 50);
				String warningText = "Warning, quitting without finalizing \n" +
						             "    will cause the machine to be erased.\n\n" +
						             "Do you wish to continue?";
				warning.setText(warningText);
				warning.setEditable(false);
				quitFrameGUI.add(warning, BorderLayout.CENTER);
				
				JPanel options = new JPanel();
				options.setLayout(new GridLayout(1,2));
				JButton no = new JButton("Cancel");
				no.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						quitFrameGUI.dispose();
					}
				});
				JButton yes = new JButton("Quit");
				yes.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						managerModel.manager_deleteMachine_GUI(_system, tempMachineID);
						managerFrame.setVisible(true);
						addItemsGUI.dispose();
						quitFrameGUI.dispose();
					}
				});
				options.add(yes);
				options.add(no);
				quitFrameGUI.add(options, BorderLayout.SOUTH);
				
				quitFrameGUI.setSize(250,150);
				quitFrameGUI.setLocation(450, 150);
				quitFrameGUI.setVisible(true);
				quitFrameGUI.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}
	private void refreshItemIndexList(int tempID){
		ArrayList<VendingMachine> machineList = _system.listCurrentMachines();
		ArrayList<Item> itemList = new ArrayList<Item>();
		for(int x = 0; x < machineList.size(); x++){
			if(machineList.get(x).getMachineID() == tempID){
				itemList = machineList.get(x).getAllItems();
			}
		}
		
		int size = itemList.size();
		Integer[] itemIndexData = new Integer[size];
		for(int x = 0; x < size; x++){
			itemIndexData[x] = x+1;
		}
		itemIndexList.clearSelection();
		itemIndexList.setFixedCellHeight(20);
		itemIndexList.setFixedCellWidth(40);
		itemIndexList.setVisibleRowCount(-1);
		itemIndexList.setListData(itemIndexData);
	}
	private void refreshSystemItemsList(){
		ArrayList<String> nameList = new ArrayList<String>();
		Map<String,Integer> itemList = new TreeMap<String,Integer>();
		itemList = _system.getItemList();
		for(Map.Entry<String,Integer> item: itemList.entrySet()){
			nameList.add(item.getKey());
		}
		
		int size = nameList.size();
		String[] itemNameData = new String[size];
		for(int x = 0; x < size; x++){
			itemNameData[x] = nameList.get(x);
		}
		itemNameList.clearSelection();
		itemNameList.setFixedCellHeight(20);
		itemNameList.setFixedCellWidth(100);
		itemNameList.setVisibleRowCount(-1);
		itemNameList.setListData(itemNameData);
	}
	
	
	/**
	 * Initializes the deleteMachine Button
	 */
	private void initDeleteMachine(){
		b_deleteMachine = new JButton("Delete Machine");
		//add action listener
		b_deleteMachine.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(false);
				initDeleteMachineGUI();
			}
		});
	}
	private void initDeleteMachineGUI(){
		deleteMachineGUI = new JFrame("Delete Machine");
		deleteMachineGUI.setLayout(new BorderLayout());
		
		
		JScrollPane s_machineIDList = setMachineIDList();
		deleteMachineGUI.add(s_machineIDList, BorderLayout.CENTER);
		
		JPanel p_optionsList = new JPanel();
		p_optionsList.setLayout(new GridLayout(1,2));
		JButton b_remove = new JButton("Remove Machine");
		JButton b_exit = new JButton("Exit");
		
		b_exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(true);
				deleteMachineGUI.dispose();
			}
		});
		
		b_remove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(! machineIDList.isSelectionEmpty()){
					ID = (Integer) machineIDList.getSelectedValue();
					managerModel.manager_deleteMachine_GUI(_system, ID);
				}
				refreshMachineIDList();
					
			}
		});
		
		p_optionsList.add(b_remove);
		p_optionsList.add(b_exit);
		deleteMachineGUI.add(p_optionsList, BorderLayout.SOUTH);
		deleteMachineGUI.setSize(400, 200);
		deleteMachineGUI.setLocation(400, 100);
		deleteMachineGUI.setVisible(true);
		deleteMachineGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		deleteMachineGUI.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				managerFrame.setVisible(true);
			}
		});

	}
	
	
	/**
	 * Initializes UploadReport Button
	 */
	private void initUploadReport(){
		b_uploadReport = new JButton("Upload Restocker Report");
		//add action listener
		b_uploadReport.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				initUR_SelectMachineGUI();
			}
		});
	}
	private void initUR_SelectMachineGUI(){
		UP_selectMachineGUI = new JFrame("Upload Report");
		UP_selectMachineGUI.setLayout(new BorderLayout());
		//Label
		JLabel topLabel = new JLabel("List of Machine ID's");
		
		UP_selectMachineGUI.add(topLabel, BorderLayout.NORTH);
		//Initialize MachineID list
		machineIDList = new JList<Integer>();
		refreshMachineIDList();
		// Makes sure you can only make a single selection
		machineIDList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Add action Listener
		machineIDList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				if(evt.getValueIsAdjusting())
					return;
			}
		});
		
		JScrollPane s_machineIDList = new JScrollPane(machineIDList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		UP_selectMachineGUI.add(s_machineIDList, BorderLayout.CENTER);
		
		//Initialize window panel
		JPanel p_optionsList = new JPanel();
		p_optionsList.setLayout(new GridLayout(1,2));
		JButton b_select = new JButton("Select");
		JButton b_exit = new JButton("Exit");
		
		//Add action listener for exit button
		b_exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(true);
				UP_selectMachineGUI.dispose();
			}
		});
		//Add action listener to select button
		b_select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(! machineIDList.isSelectionEmpty()){
					tempMachineID = (Integer) machineIDList.getSelectedValue();
					UP_selectMachineGUI.setVisible(false);
					UP_selectMachineGUI.dispose();
					initUploadReportGUI();
				}
					
			}
		});
		//Add buttons to optionList
		p_optionsList.add(b_select);
		p_optionsList.add(b_exit);
		UP_selectMachineGUI.add(p_optionsList, BorderLayout.SOUTH);
		UP_selectMachineGUI.setSize(250, 200);
		UP_selectMachineGUI.setLocation(400, 100);
		UP_selectMachineGUI.setVisible(true);
		UP_selectMachineGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		UP_selectMachineGUI.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				managerFrame.setVisible(true);
			}
		});
		
	}
	private void initUploadReportGUI(){
		uploadReportGUI = new JFrame("Upload Restocker Report: Machine " + tempMachineID);
		uploadReportGUI.setLayout(new BorderLayout());
		
		JPanel north = new JPanel();
		north.setLayout(new FlowLayout());
		JLabel uploadLabel = new JLabel("Please enter the Restocker Report file path:");
		north.add(uploadLabel);
		uploadReportGUI.add(north, BorderLayout.NORTH);
		
		JPanel center = new JPanel();
		JLabel pathLabel = new JLabel("Path: ");
		center.setLayout(new FlowLayout());
		filePath = new JTextField(30);
		center.add(pathLabel);
		center.add(filePath);
		uploadReportGUI.add(center, BorderLayout.CENTER);
		
		JPanel south = new JPanel();
		south.setLayout(new FlowLayout());
		JButton upload = new JButton("Upload");
		JButton exit = new JButton("Exit");
		
		//Add action listener for exit button
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(true);
				uploadReportGUI.dispose();
			}
		});
		//Add action listener to select button
		upload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!filePath.getText().equals("")){
					_system.getMachine(tempMachineID).setRestockerReport(filePath.getText());
					managerFrame.setVisible(true);
					uploadReportGUI.dispose();
				}
			}
		});
		south.add(upload);
		south.add(exit);
		uploadReportGUI.add(south, BorderLayout.SOUTH);
		
		uploadReportGUI.setSize(400, 150);
		uploadReportGUI.setLocation(400, 100);
		uploadReportGUI.setVisible(true);
		uploadReportGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		uploadReportGUI.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				managerFrame.setVisible(true);
			}
		});
	}
	
	
	/**
	 * Initializes the MachineState Button
	 */
	private void initMachineState(){
		b_machineState = new JButton("View Machine State");
		//add action listener
		b_machineState.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(false);
				initMS_SelectMachineGUI();
			}
		});
	}
	/**
	 * Initializes the Manager SelectMachineGUI
	 */
	private void initMS_SelectMachineGUI(){
		MS_selectMachineGUI = new JFrame("Machine State Information");
		MS_selectMachineGUI.setLayout(new BorderLayout());
		//Label
		JLabel topLabel = new JLabel("List of Machine ID's");
		
		MS_selectMachineGUI.add(topLabel, BorderLayout.NORTH);
		//Initialize MachineID list
		machineIDList = new JList<Integer>();
		refreshMachineIDList();
		// Makes sure you can only make a single selection
		machineIDList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//Add action Listener
		machineIDList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				if(evt.getValueIsAdjusting())
					return;
			}
		});
		
		JScrollPane s_machineIDList = new JScrollPane(machineIDList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		MS_selectMachineGUI.add(s_machineIDList, BorderLayout.CENTER);
		
		//Initialize window panel
		JPanel p_optionsList = new JPanel();
		p_optionsList.setLayout(new GridLayout(1,2));
		JButton b_select = new JButton("Select");
		JButton b_exit = new JButton("Exit");
		
		//Add action listener for exit button
		b_exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(true);
				MS_selectMachineGUI.dispose();
			}
		});
		//Add action listener to select button
		b_select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(! machineIDList.isSelectionEmpty()){
					ID = (Integer) machineIDList.getSelectedValue();
					MS_selectMachineGUI.setVisible(false);
					MS_selectMachineGUI.dispose();
					initMachineStateGUI();
				}
					
			}
		});
		//Add buttons to optionList
		p_optionsList.add(b_select);
		p_optionsList.add(b_exit);
		MS_selectMachineGUI.add(p_optionsList, BorderLayout.SOUTH);
		MS_selectMachineGUI.setSize(250, 200);
		MS_selectMachineGUI.setLocation(400, 100);
		MS_selectMachineGUI.setVisible(true);
		MS_selectMachineGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		MS_selectMachineGUI.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				managerFrame.setVisible(true);
			}
		});
		
	}
	
	/**
	 * Initializes the MachineState GUI	
	 */
	private void initMachineStateGUI(){
		//Initialize frame for GUI
		machineStateGUI = new JFrame("Machine " + ID);
		machineStateGUI.setLayout(new BorderLayout());
		JPanel options = new JPanel();
		options.setLayout(new GridLayout(3,1));
		
		// Initialize buttons for Machine State GUI
		JButton b_inventory = new JButton("View Inventory");
		JButton b_expired = new JButton("View Expired Items");
		JButton b_notes = new JButton("View Restocker Notes");
		JButton b_exit = new JButton("Exit");
		
		//add action listener to exit button
		b_exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(true);
				machineStateGUI.dispose();
			}
		});
		
		//add action listener for inventory button
		b_inventory.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				printInventoryGUI = new JFrame("Machine " + ID + ": Inventory");
				printInventoryGUI.setLayout(new BorderLayout());
				ArrayList<VendingMachine> tempMachineList = _system.listCurrentMachines();
				ArrayList<Item> itemList = new ArrayList<Item>();
				for(int x = 0; x < tempMachineList.size(); x++){
					if(ID == tempMachineList.get(x).getMachineID()){
						itemList = tempMachineList.get(x).getAllItems();
					}
				}
				String printString = "";
				for(int x = 0; x < itemList.size(); x++){
					printString += "\n";
					if(itemList.get(x).getItemID() == 0){
						printString += "<empty slot>";
					}else{
						printString += itemList.get(x).toString();
					}
				}
				JTextArea printBox = new JTextArea(printString);
				JScrollPane s_printBox = new JScrollPane(printBox);
				
				//Initialize Exit button
				JButton b_exit = new JButton("Exit");
				b_exit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						printInventoryGUI.setVisible(false);
						printInventoryGUI.dispose();
					}
				});
				
				printInventoryGUI.add(b_exit, BorderLayout.SOUTH);
				printInventoryGUI.add(s_printBox, BorderLayout.CENTER);
				printInventoryGUI.setSize(300, 600);
				printInventoryGUI.setLocation(400, 100);
				printInventoryGUI.setVisible(true);
				printInventoryGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		//add action listener
		b_expired.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				printExpiredGUI = new JFrame("Machine " + ID + ": Expired");
				printExpiredGUI.setLayout(new BorderLayout());
				ArrayList<VendingMachine> tempMachineList = _system.listCurrentMachines();
				ArrayList<Item> itemList = new ArrayList<Item>();
				for(int x = 0; x < tempMachineList.size(); x++){
					if(ID == tempMachineList.get(x).getMachineID()){
						itemList = tempMachineList.get(x).getAllItems();
					}
				}
				String printString = "";
				for(int x = 0; x < itemList.size(); x++){
					int expiredAmount = itemList.get(x).amountOfExpired(_system.startTime);
					
					if(expiredAmount > 0){
						printString += "\n" + itemList.get(x).getName() +
								" has " + expiredAmount + " expired item(s).";
					}
				}
				//Initializes a JTextArea 
				JTextArea printBox = new JTextArea(printString);
				JScrollPane s_printBox = new JScrollPane(printBox);
				
				JButton b_exit = new JButton("Exit");
				b_exit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						printExpiredGUI.setVisible(false);
						printExpiredGUI.dispose();
					}
				});
				
				printExpiredGUI.add(b_exit, BorderLayout.SOUTH);
				printExpiredGUI.add(s_printBox, BorderLayout.CENTER);
				printExpiredGUI.setSize(300, 600);
				printExpiredGUI.setLocation(400, 100);
				printExpiredGUI.setVisible(true);
				printExpiredGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		//add action listener
		b_notes.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				printNotesGUI = new JFrame("Machine " + ID + ": Restocker Notes");
				printNotesGUI.setLayout(new BorderLayout());
				ArrayList<VendingMachine> tempMachineList = _system.listCurrentMachines();
				String printString = "";
				
				for(int x = 0; x < tempMachineList.size(); x++){
					if(ID == tempMachineList.get(x).getMachineID()){
						printString = tempMachineList.get(x).getRestockerNotes();
					}
				}
				
				JTextArea printBox = new JTextArea(printString);
				JScrollPane s_printBox = new JScrollPane(printBox);
				
				JButton b_exit = new JButton("Exit");
				b_exit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						printNotesGUI.setVisible(true);
						printNotesGUI.dispose();
					}
				});
				
				printNotesGUI.add(b_exit, BorderLayout.SOUTH);
				printNotesGUI.add(s_printBox, BorderLayout.CENTER);
				printNotesGUI.setSize(300, 600);
				printNotesGUI.setLocation(400, 100);
				printNotesGUI.setVisible(true);
				printNotesGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		
		options.add(b_inventory);
		options.add(b_expired);
		options.add(b_notes);
		machineStateGUI.add(options, BorderLayout.CENTER);
		machineStateGUI.add(b_exit, BorderLayout.SOUTH);
		
		machineStateGUI.setSize(300, 200);
		machineStateGUI.setLocation(400, 100);
		machineStateGUI.setVisible(true);
		machineStateGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		machineStateGUI.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				managerFrame.setVisible(true);
			}
		});
	}
	
	
	
	/**
	 * Initializes addManager button
	 */
	private void initAddManager(){
		b_addManager = new JButton("Add New Manager");
		//add action listener
		b_addManager.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(false);
				initAddManagerGUI();
				
			}
		});
	}
	/**
	 * Initializes addManager GUI
	 */
	private void initAddManagerGUI(){
		
		//Initializes new JFrame
		addManagerGUI = new JFrame("Add New Manager");
		addManagerGUI.setLayout(new BorderLayout());
		
		//Initializes window panel for user input
		JPanel p_userInput = new JPanel();
		p_userInput.setLayout(new GridLayout(4,1));
		
		//Initializes window panel for userNameOptions
		JPanel p_usernameOptions = new JPanel();
		p_usernameOptions.setLayout(new FlowLayout());
		
		// Initializes window panel for passwordOptions
		JPanel p_passwordOptions = new JPanel();
		p_passwordOptions.setLayout(new FlowLayout());
		
		//Initializes window panel for listManagers
		JPanel p_listManagers = new JPanel();
		p_listManagers.setLayout(new FlowLayout());
		
		//Text Area for listManagers
		am_t_listManagers = new JTextArea(5, 10);
		
		//scroll pane for listManagers
		JScrollPane s_listManagers = new JScrollPane();
		
		//Label for username
		JLabel l_username = new JLabel("Username: ");
		
		//TextField for username
		am_t_username = new JTextField(10);
		
		//Label for password
		JLabel l_password = new JLabel("Password: ");
		am_t_password = new JPasswordField(10);
		
		// Initializes panel for addManagerOptions
		JPanel p_addManagerOptions = new JPanel();
		p_addManagerOptions.setLayout(new GridLayout(1,2));
		
		// initializes buttons
		JButton b_create = new JButton("Create");
		JButton b_exit = new JButton("Exit");
		
		refreshAddManagerNameList();
		s_listManagers = new JScrollPane(am_t_listManagers,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		// Label for Manager Information
		JLabel l_newManagerInfo = new JLabel("        New Manager Information");
		p_userInput.add(l_newManagerInfo);
		
		p_usernameOptions.add(l_username);
		p_usernameOptions.add(am_t_username);
		p_userInput.add(p_usernameOptions);
		p_passwordOptions.add(l_password);
		p_passwordOptions.add(am_t_password);
		p_userInput.add(p_passwordOptions);
		
		//add action listener
		b_create.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String inputUser = am_t_username.getText();
				char[] tempPass = am_t_password.getPassword();
				
				String inputPass = "";
				for(int x = 0; x < tempPass.length; x++){
					inputPass += tempPass[x];
				}
				
				if(!inputUser.equals("")){
					if(!inputPass.equals("")){
						_system.addManager(inputUser, inputPass);
						refreshAddManagerNameList();
					}
				}
			}
		});
		
		b_exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(true);
				addManagerGUI.dispose();
			}
		});
		
		p_addManagerOptions.add(b_exit);
		p_addManagerOptions.add(b_create);
		p_userInput.add(p_addManagerOptions);
		
		addManagerGUI.add(s_listManagers, BorderLayout.WEST);
		addManagerGUI.add(p_userInput, BorderLayout.CENTER);
		addManagerGUI.setSize(400, 200);
		addManagerGUI.setLocation(400, 100);
		addManagerGUI.setVisible(true);
		addManagerGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addManagerGUI.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				managerFrame.setVisible(true);
			}
		});
	}
	/**
	 * Refreshes AddManagerNameList
	 */
	private void refreshAddManagerNameList(){
		ArrayList<Manager> managerList = _system.getManagerList();
		String nameList = "";
		for(int x = 0; x < managerList.size(); x++){
			nameList += managerList.get(x).getUsername();
			if(x != managerList.size()-1){
				nameList += "\n";
			}
		}
		am_t_listManagers.setText(nameList);
		am_t_listManagers.setEditable(false);
	}
	
	
	/**
	 * Initializes the deleteManager button
	 */
	private void initDeleteManager(){
		b_deleteManager = new JButton("Delete Manager");
		//add action listener
		b_deleteManager.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(false);
				initDeleteManagerGUI();
			}
		});
	}
	/**
	 * Initializes deleteManager GUI
	 */
	private void initDeleteManagerGUI(){
		deleteManagerGUI = new JFrame("Delete Existing Manager");
		deleteManagerGUI.setLayout(new BorderLayout());
		
		//Initializes window panel for userInput
		JPanel p_userInput = new JPanel();
		p_userInput.setLayout(new GridLayout(3,1));
		
		//Initializes window panel for usernameOptions
		JPanel p_usernameOptions = new JPanel();
		p_usernameOptions.setLayout(new FlowLayout());
		
		//Initializes window panel for passwordOptions
		JPanel p_passwordOptions = new JPanel();
		p_passwordOptions.setLayout(new FlowLayout());
		
		//Initialize window panel for listManagers
		JPanel p_listManagers = new JPanel();
		p_listManagers.setLayout(new FlowLayout());
		
		//TextArea for listManagers
		dm_t_listManagers = new JTextArea(5, 10);
		
		//ScrollPane for listManagers
		JScrollPane s_listManagers = new JScrollPane();
		
		//Label for username
		JLabel l_username = new JLabel("Username: ");
		
		//TextField for username
		dm_t_username = new JTextField(10);
		
		//Initialize window panel for deleteManagerOptions
		JPanel p_deleteManagerOptions = new JPanel();
		p_deleteManagerOptions.setLayout(new GridLayout(1,2));
		
		//Initializes buttons
		JButton b_delete = new JButton("Delete");
		JButton b_exit = new JButton("Exit");
		
		refreshDeleteManagerNameList();
		s_listManagers = new JScrollPane(dm_t_listManagers,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//Label for deleteManagerInfo
		JLabel l_deleteManagerInfo = new JLabel("        <username> - To be deleted.");
		p_userInput.add(l_deleteManagerInfo);
		
		p_usernameOptions.add(l_username);
		p_usernameOptions.add(dm_t_username);
		p_userInput.add(p_usernameOptions);
		
		//add action listener
		b_delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String inputUser = dm_t_username.getText();
				
				if(!inputUser.equals("")){
					if(!inputUser.equals(managerModel.getUsername())){
						_system.removeManager(inputUser);
						refreshDeleteManagerNameList();
					}
				}
			}
		});
		
		//add action listener
		b_exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(true);
				deleteManagerGUI.dispose();
			}
		});
		
		p_deleteManagerOptions.add(b_exit);
		p_deleteManagerOptions.add(b_delete);
		p_userInput.add(p_deleteManagerOptions);
		
		deleteManagerGUI.add(s_listManagers, BorderLayout.WEST);
		deleteManagerGUI.add(p_userInput, BorderLayout.CENTER);
		deleteManagerGUI.setSize(400, 150);
		deleteManagerGUI.setLocation(400, 100);
		deleteManagerGUI.setVisible(true);
		deleteManagerGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		deleteManagerGUI.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				managerFrame.setVisible(true);
			}
		});
	}
	/**
	 * Refreshes the ManagerNameList
	 */
	private void refreshDeleteManagerNameList(){
		ArrayList<Manager> managerList = _system.getManagerList();
		String nameList = "";
		for(int x = 0; x < managerList.size(); x++){
			nameList += managerList.get(x).getUsername();
			if(x != managerList.size()-1){
				nameList += "\n";
			}
		}
		dm_t_listManagers.setText(nameList);
		dm_t_listManagers.setEditable(false);
	}
	
	
	/**
	 * Initializes the Restocker button
	 */
	private void initAddRestocker(){
		b_addRestocker = new JButton("Add Restocker");
		//add action listener
		b_addRestocker.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(false);
				initAddRestockerGUI();
			}
		});
	}
	/**
	 * Initializes the AddRestocker GUI
	 */
	private void initAddRestockerGUI(){
		
		//Initialize the Frame for Restocker GUI
		addRestockerGUI = new JFrame("Add New Restocker");
		addRestockerGUI.setLayout(new BorderLayout());
		
		//Initialize window panel for userInput
		JPanel p_userInput = new JPanel();
		p_userInput.setLayout(new GridLayout(4,1));
		
		//Initialize window panel for usernameOptions
		JPanel p_usernameOptions = new JPanel();
		p_usernameOptions.setLayout(new FlowLayout());
		
		//Initialize window panel for passwordOptions
		JPanel p_passwordOptions = new JPanel();
		p_passwordOptions.setLayout(new FlowLayout());
		
		//Initialize window panel for listRestockers
		JPanel p_listRestockers = new JPanel();
		p_listRestockers.setLayout(new FlowLayout());
		
		//TextArea for listRestockers
		ar_t_listRestockers = new JTextArea(5, 10);
		
		//ScrollPane for listRestockers
		JScrollPane s_listRestockers = new JScrollPane();
		
		//Label for username
		JLabel l_username = new JLabel("Username: ");
		
		//TextField for username
		ar_t_username = new JTextField(10);
		
		//Label for password
		JLabel l_password = new JLabel("Password: ");
		
		//PasswordField
		ar_t_password = new JPasswordField(10);
		
		//Initialize window panel for addRestockerOptions
		JPanel p_addRestockerOptions = new JPanel();
		p_addRestockerOptions.setLayout(new GridLayout(1,2));
		
		//Initialize Buttons
		JButton b_create = new JButton("Create");
		JButton b_exit = new JButton("Exit");
		
		refreshRestockerNameList();
		s_listRestockers = new JScrollPane(ar_t_listRestockers,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//Label for newRestockerInfo
		JLabel l_newRestockerInfo = new JLabel("        New Restocker Information");
		p_userInput.add(l_newRestockerInfo);
		
		p_usernameOptions.add(l_username);
		p_usernameOptions.add(ar_t_username);
		p_userInput.add(p_usernameOptions);
		p_passwordOptions.add(l_password);
		p_passwordOptions.add(ar_t_password);
		p_userInput.add(p_passwordOptions);
		
		//add action listener
		b_create.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String inputUser = ar_t_username.getText();
				char[] tempPass = ar_t_password.getPassword();
				
				String inputPass = "";
				for(int x = 0; x < tempPass.length; x++){
					inputPass += tempPass[x];
				}
				
				if(!inputUser.equals("")){
					if(!inputPass.equals("")){
						_system.addRestocker(inputUser, inputPass);
						refreshRestockerNameList();
					}
				}
			}
		});
		
		//add action listener
		b_exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(true);
				addRestockerGUI.dispose();
			}
		});
		
		p_addRestockerOptions.add(b_exit);
		p_addRestockerOptions.add(b_create);
		p_userInput.add(p_addRestockerOptions);
		
		addRestockerGUI.add(s_listRestockers, BorderLayout.WEST);
		addRestockerGUI.add(p_userInput, BorderLayout.CENTER);
		addRestockerGUI.setSize(400, 200);
		addRestockerGUI.setLocation(400, 100);
		addRestockerGUI.setVisible(true);
		addRestockerGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		addRestockerGUI.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				managerFrame.setVisible(true);
			}
		});
	}
	/**
	 * Refreshes RestockerNameList
	 */
	private void refreshRestockerNameList(){
		ArrayList<Restocker> restockerList = _system.getRestockerList();
		String nameList = "";
		for(int x = 0; x < restockerList.size(); x++){
			nameList += restockerList.get(x).getUsername();
			if(x != restockerList.size()-1){
				nameList += "\n";
			}
		}
		ar_t_listRestockers.setText(nameList);
		ar_t_listRestockers.setEditable(false);
	}
	
	
	/**
	 * Initializes deleteRestocker button
	 */
	private void initDeleteRestocker(){
		
		//Initialize deleteRestocker button
		b_deleteRestocker = new JButton("Delete Restocker");
		//add action listener
		b_deleteRestocker.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(false);
				deleteRestockerGUI();
				
			}
		});
	}
	/**
	 * Initializes deleteRestocker GUI
	 */
	private void deleteRestockerGUI(){
		
		//Initialize Frame for deleteRestocker GUI
		deleteRestockerGUI = new JFrame("Delete Existing Restocker");
		deleteRestockerGUI.setLayout(new BorderLayout());
		
		//Initialize window panel for userInput
		JPanel p_userInput = new JPanel();
		p_userInput.setLayout(new GridLayout(3,1));
		
		//Initialize window panel for usernameOptions
		JPanel p_usernameOptions = new JPanel();
		p_usernameOptions.setLayout(new FlowLayout());
		
		//Initialize window panel for passwordOptions
		JPanel p_passwordOptions = new JPanel();
		p_passwordOptions.setLayout(new FlowLayout());
		
		//Initialize window panel for listRestocker
		JPanel p_listRestockers = new JPanel();
		p_listRestockers.setLayout(new FlowLayout());
		
		//TextArea for listRestockers
		dr_t_listRestockers = new JTextArea(5, 10);
		
		//ScrollPane for listRestockers
		JScrollPane s_listRestockers = new JScrollPane();
		
		//Label for username
		JLabel l_username = new JLabel("Username: ");
		
		//TextField for username
		dr_t_username = new JTextField(10);
		
		//Initialize window panel for deleteRestocker
		JPanel p_deleteRestockerOptions = new JPanel();
		p_deleteRestockerOptions.setLayout(new GridLayout(1,2));
		//Initialize buttons
		JButton b_delete = new JButton("Delete");
		JButton b_exit = new JButton("Exit");
		
		refreshDeleteRestockerNameList();
		s_listRestockers = new JScrollPane(dr_t_listRestockers,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		//Label for deleteRestockerInfo
		JLabel l_deleteRestockerInfo = new JLabel("        <username> - To be deleted.");
		p_userInput.add(l_deleteRestockerInfo);
		
		p_usernameOptions.add(l_username);
		p_usernameOptions.add(dr_t_username);
		p_userInput.add(p_usernameOptions);
		
		//add action listener
		b_delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String inputUser = dr_t_username.getText();
				
				if(!inputUser.equals("")){
					_system.removeRestocker(inputUser);
					refreshDeleteRestockerNameList();
				}
			}
		});
		// add action listener
		b_exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(true);
				deleteRestockerGUI.dispose();
			}
		});
		
		p_deleteRestockerOptions.add(b_exit);
		p_deleteRestockerOptions.add(b_delete);
		p_userInput.add(p_deleteRestockerOptions);
		
		deleteRestockerGUI.add(s_listRestockers, BorderLayout.WEST);
		deleteRestockerGUI.add(p_userInput, BorderLayout.CENTER);
		deleteRestockerGUI.setSize(400, 150);
		deleteRestockerGUI.setLocation(400, 100);
		deleteRestockerGUI.setVisible(true);
		deleteRestockerGUI.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		deleteRestockerGUI.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				managerFrame.setVisible(true);
			}
		});
	}
	/**
	 * Refreshes DeleteRestockerNameList
	 */
	private void refreshDeleteRestockerNameList(){
		ArrayList<Restocker> restockerList = _system.getRestockerList();
		String nameList = "";
		for(int x = 0; x < restockerList.size(); x++){
			nameList += restockerList.get(x).getUsername();
			if(x != restockerList.size()-1){
				nameList += "\n";
			}
		}
		dr_t_listRestockers.setText(nameList);
		dr_t_listRestockers.setEditable(false);
	}
	
	/**
	 * Initializes ViewStats button
	 */
	private void initViewStats(){
		
		//Initializes ViewStats button
		b_viewStats = new JButton("View Statistics");
		
		//add action listener
		b_viewStats.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				statsWindow = new JFrame("Analytics Viewer");
				statsPanel = new JPanel();
				statsPanel.setLayout(new FlowLayout());
				initAgs();
				initBar();
				
				statsPanel.add(viewAgs);
				statsPanel.add(machineBar);
				statsWindow.add(statsPanel);
				statsWindow.setVisible(true);
				statsWindow.setSize(200,200);
				
				/*
				DefaultPieDataset pieset = new DefaultPieDataset();
				pieset.setValue("one", new Integer(10));
				pieset.setValue("two", new Integer(10));
				pieset.setValue("three", new Integer(10));
				pieset.setValue("four", new Integer(10));
				JFreeChart chart = ChartFactory.createPieChart( "Pie Chart", pieset,true,true,true);
				ChartFrame frame = new ChartFrame("Pie Chart1", chart);
				frame.setVisible(true);
				frame.setSize(450,500);
				_system.stats();
				*/
				
				
			}
		});
	}
	
	/**
	 * Intializes the Aggregate button
	 */
	public void initAgs(){
		viewAgs = new JButton("View System Aggregates");
		viewAgs.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				HashMap<Integer,Integer> ags = _system.getAgs();
				Set<Integer> agsKeys = ags.keySet();
				DefaultPieDataset pieset = new DefaultPieDataset();
				for(int key : agsKeys){
					pieset.setValue("Machine ID: " +key + ",\nTotal Items: " + ags.get(key), ags.get(key));
					
				}
				JFreeChart chart = ChartFactory.createPieChart( "Total Purchases By Machine", pieset,true,true,true);
				PiePlot piePlot =(PiePlot)chart.getPlot();
				piePlot.setSimpleLabels(true); 
				piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator());
				ChartFrame frame = new ChartFrame("Total Purchases By Machine", chart);
				frame.setVisible(true);
				frame.setSize(450,500);
			}
		});
	}
	
	/**
	 * Intializes the machine bar chart button
	 *
	 */
	public void initBar(){
		
		
		
		machineBar = new JButton("View Machine Aggregates");
		machineBar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				barWindow = new JFrame("Usage Stats");
				barPanel = new JPanel();
				barText = new JTextArea();
				barText.setEditable(false);
				barWindow.setSize(450,600);
				
				
				ArrayList<String> itemStats; 
				for(int i =0; i< _system.machines.size();i++){
					barText.append("#############    MachineID: "+ _system.machines.get(i).getMachineID() + "    ##############\n\n");
					itemStats = _system.getBar(_system.machines.get(i).getMachineID());
					for(int j =0; j<itemStats.size();j++){
						barText.append(itemStats.get(j)+"\n");
					}
					barText.append("\n\n");
				}
				barScroll = new JScrollPane(barText);
				barWindow.add(barScroll);
				barWindow.setVisible(true);
			}
		});
	}
	
	/**
	 * Initializes LogOut button
	 */
	private void initLogOut(){
		b_logOut = new JButton("Log Out");
		//add action listener
		b_logOut.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				managerFrame.setVisible(false);
				managerFrame.dispose();
			}
		});
	}
	
	
	
	/**
	 * MachineIDList functions (set and refresh)
	 */
	private JScrollPane setMachineIDList(){
		machineIDList = new JList<Integer>();
		refreshMachineIDList();
		machineIDList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		machineIDList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				if(evt.getValueIsAdjusting())
					return;
			}
		});
		
		JScrollPane s_machineIDList = new JScrollPane(machineIDList,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		return s_machineIDList;
	}
	private void refreshMachineIDList(){
		ArrayList<VendingMachine> machineList = _system.listCurrentMachines();
		VendingMachine temp = new VendingMachine();
		
		for(int x = 0; x < machineList.size()-1; x++){
			for(int y = x+1; y < machineList.size(); y++){
				if(machineList.get(x).getMachineID() > machineList.get(y).getMachineID()){
					temp = machineList.get(x);
					machineList.set(x, machineList.get(y));
					machineList.set(y, temp);
				}
			}
		}
		
		
		int size = machineList.size();
		Integer[] machineIDData = new Integer[size];
		for(int x = 0; x < size; x++){
			machineIDData[x] = machineList.get(x).getMachineID();
		}
		machineIDList.clearSelection();
		machineIDList.setFixedCellHeight(20);
		machineIDList.setFixedCellWidth(40);
		machineIDList.setVisibleRowCount(-1);
		machineIDList.setLayoutOrientation(JList.VERTICAL_WRAP);
		machineIDList.setListData(machineIDData);
	}
	
	
	
	
}
