/**
 * $Id$
 * 
 * $Log$
 * 
 * $Revision$
 */

package project;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.*;

/**
 * This a user friendly view for a customer user for French Toast Mafia
 * vending machine software.
 * @author Joe Fuchs
 * @author Justin Bennet
 * @author FTM
 */
public class CustomerGUI{
	
	/**
	 * Test program for the GUI
	 * @param args
	 */

	
	
	////This is the model that provides funcionality for performing use case
	//actions on vending machines
	private Customer customerModel;
	
	//The main window for this customer GUI
	private JFrame frame;
	
	//-------------------------------------------------------------------------
	//The following are panels used to break up the layout of the GUI
	//-------------------------------------------------------------------------
	private JPanel north;
	private JPanel south;
	private JPanel east;
	private JPanel west;
	
	//top layer of the east panel
	private JPanel northEast;
	
	//bottom layer of the east panel
	private JPanel southEast;
	
	//top layer of the southEast panel
	private JPanel se1;
	
	//middle layer of the southEast panel
	private JPanel se2;
	
	//bottom layer of the southEast panel
	private JPanel se3;
	//-------------------------------------------------------------------------
	
	
	//The display list of items in a vending machine to choose from
	private JList items;
	
	//Pressed to place a purchase on the selected item from 'items'
	private JButton select;
	
	//Resets balance to zero
	private JButton refund;
	
	//Logs out of the machine
	private JButton Exit;
	
	//25$ cent button.  This enters one quarter into the machine
	private MoneyInsertButton Cent;
	
	//Enters one dollar into the machine
	private MoneyInsertButton Dollar;
	
	//Enters 5 dollars into the machine
	private MoneyInsertButton FDollar;
	
	//Displays the machine's ID
	private JLabel machineID;
	
	//Label for BalanceText
	private JLabel Balance;
	
	//Displays the machine's customer balance
	private JTextField BalanceText;
	
	//Friendly message display for when customers purchase items
	private JTextPane MessageText;
	
	private JScrollPane listScrollPane;
	private Border blackline;
		
	/**
	 * Constructs a GUI for a customer user
	 * @param system The vending machine system that contains machine
	 * @param machine The machine this customer is logging into
	 */
	public CustomerGUI(VendingSystem system, final VendingMachine machine){
		
		this.customerModel = new Customer(system, machine);
		this.initFrame();
		//TODO: make sure this thing is visible
	}
	
	/**
	 * initialized the frame of the vending machine
	 */
	private void initFrame(){
		frame = new JFrame("Vending Machine Customer");
		frame.setResizable(true);
		
		blackline = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
		
		//Here we initialize the window/panel layout before we establish
		//buttons and put those buttons into these panels
		north = new JPanel();
		south = new JPanel();
		east = new JPanel();
		west = new JPanel();
		west.setBorder(blackline);
		northEast = new JPanel();
		northEast.setBorder(blackline);
		southEast = new JPanel();
		southEast.setBorder(blackline);
		se1 = new JPanel();
		se2 = new JPanel();
		se2.setBorder(blackline);
		se3 = new JPanel();
		
		initItems();
		initSelect();
		initRefund();
		initExit();
		
		//Initialize money-insert buttons
		Cent = new MoneyInsertButton(.25, customerModel);
		Dollar = new MoneyInsertButton(1.00, customerModel);
		FDollar = new MoneyInsertButton(5.00, customerModel); 
		
		//Initialize the machine ID label
		machineID = new JLabel("MACHINE: " + customerModel.getMachineID());
		
		//Initialize the customer balance label
		Balance = new JLabel("Balance: ");
		
		//Initialize the customer balance display
		BalanceText = new JTextField("");
		BalanceText.setEditable(false);
		updateBalanceDisplay();
		
		//Initialize the message box
		initMessageBox();
		
		//set up JFRAME sizing
		frame.setLayout(new BorderLayout());
		frame.setSize(500,500);
		frame.setVisible(true);
		GridBagConstraints c = new GridBagConstraints();
		
		//Construct east panel
			//construct northEast Panel
		northEast.setLayout(new GridLayout(4,1));
		northEast.add(machineID);
		northEast.add(select);
		northEast.add(refund);
		northEast.add(Exit);
		
				//Construct SE components
		se1.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = .5;
		c.gridx= 0;
		c.gridy= 0;
		se1.add(Cent,c);
		c.gridx= 1;
		c.gridy= 0;
		se1.add(Dollar,c);
		c.gridx= 2;
		c.gridy= 0;
		se1.add(FDollar,c);
		//se1.setBackground(Color.YELLOW);
		
		se2.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.HORIZONTAL;
		//c.weightx = .5;
		c.gridx = 0;
		c.gridy = 0;
		se2.add(Balance, c);
		c.weightx = .5;
		c.gridx = 1;
		c.gridy = 0;
		se2.add(BalanceText, c);
		//se2.setBackground(Color.RED);
		
		se3.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.weightx =1;
		c.weighty =1;
		se3.add(MessageText, c);
		//se3.setSize(200,200);
		//se3.setBackground(Color.GREEN);
		
		//Construct southEast Panel
		southEast.setLayout(new GridLayout(3,1));
		southEast.add(se1);
		southEast.add(se2);
		southEast.add(se3);
		
		//construct East Panel
		east.setLayout(new GridLayout(2,1));
		east.setSize(250, 400);
		east.add(northEast);
		east.add(southEast);
		east.setVisible(true);
		
		//construct West Panel
		west.setLayout(new GridBagLayout());
		c.fill = GridBagConstraints.BOTH;
		c.weightx = .5;
		c.weighty = .5;
		west.setSize(250, 400);
		west.setVisible(true);
		west.add(listScrollPane , c);
		
		
		//construct South Panel
		south.setLayout(new GridLayout(1,2));
		south.add(west);
		south.add(east);
		
		//Construct North Panel
		north.setLayout(new GridLayout(1,1));
		north.setSize(100, 100);
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("FTM (500x125).jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
		north.add( picLabel );
		//north.add(new JLabel("TEMP NORTH LABEL"));
		north.setVisible(true);
		
		
		frame.add(north, BorderLayout.NORTH);
		frame.add(south, BorderLayout.CENTER);	
		
		//Closes window operation
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				close();
			}
		});
	}
	
	/**
	 * Initializes the Items list JList
	 */
	private void initItems(){
		//construct the item list and fill it with item choices
		items = new JList();
		refreshItems();
		
		//allow only a single selection
		items.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		//This moves cursor in the items list listener
		items.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent evt) {
		    	MessageText.setText("");
		        if (evt.getValueIsAdjusting())
		          return;
		        //System.out.println("Selected from " + evt.getFirstIndex() + " to " + evt.getLastIndex());
		      }
		    });
		
		//Here we initialize the scroll pane for the items list
		listScrollPane = new JScrollPane(items, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);		
	}

	/**
	 * Initializes the select button
	 */
	private void initSelect(){
		select = new JButton("Select");
		//add action listener
		select.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	if (! items.isSelectionEmpty()){
            		Item selectedItem = (Item) items.getSelectedValue();
                
            		double preChange = customerModel.getBalance();
            		
            		boolean success;
                	success = customerModel.selectItem(selectedItem);
                
                	if (success){
                		refreshItems();
                		MessageText.setText("Inserted $" + 
                		  Double.toString(preChange) + "\n"
                		  + "You bought: " + selectedItem.getName() + "\n"
                		  + "Your change is: $" + 
                		  Double.toString(preChange - selectedItem.getCost()));
                	}else{
                		MessageText.setText("Insufficient Funds");
                	}
            	}else{
            		MessageText.setText("Please Select Item");
            	}
                
                updateBalanceDisplay();
            }
        }); 
	}
	
	/**
	 * Initializes the refund button
	 */
	private void initRefund(){
		refund = new JButton("Refund");
		
		//add action listener
		refund.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //Execute when button is pressed
                MessageText.setText("Your change: " + customerModel.getBalance());
                customerModel.refund();
                updateBalanceDisplay();
            }
        });
	}
	
	/**
	 * Initializes the exit button
	 */
	private void initExit(){
		Exit = new JButton("Exit");
		
		//add action listener
		Exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //Execute when button is pressed
                close();
            }
        }); 
		
	}
	
	/**
	 * 
	 */
	private void initMessageBox(){
		MessageText = new JTextPane();
		MessageText.setEditable(false);
		MessageText.setSize(200,200);
		
		//copied from web, used to center message text: 
		//http://stackoverflow.com/questions/3213045/centering-text-in-a-jtextarea-or-jtextpane-horizontal-text-alignment
		StyledDocument doc = MessageText.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}

	/**
	 * Creates a button for inserting money into a machine
	 * @author Joe
	 * @author FTM
	 */
	private class MoneyInsertButton extends JButton{
		
		//how much this button will insert. Ex) $.25, $1, $5, etc
		private double value;
		
		//the customer back-end model from that the GUI is plugged in to
		private Customer custModel;
		
		/**
		 * Constructs a button for inserting coins into a machine
		 * @param coinVal How much this button is worth
		 */
		public MoneyInsertButton(double coinVal, Customer model){
			super("$" + Double.toString(coinVal));
			this.value = coinVal;
			this.custModel = model;
			this.init();
		}
		
		/**
		 * Initializes this money-insert button.
		 */
		public void init(){
		//add action listener
			this.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					//Execute when button is pressed
					System.out.println("Inserted $" + Double.toString(value));
					custModel.insertMoney(value);
					updateBalanceDisplay();
					MessageText.setText("Inserted $" + value);
            	}
        	});    
		}
		
	}
		
	/**
	 * Updates the items JList to match the current contents of the machine
	 * @pre items must be initialized and equal to a JList<Item>
	 * @post the list will reflect the contents of the machine
	 */
	private void refreshItems(){		
		ArrayList<Item> itemList = customerModel.getAvailableItemList();
		Item[] a = new Item[itemList.size()]; //argument for line below
		Item[] listData = itemList.toArray(a);
		
		items.clearSelection();
		items.setListData(listData);
	}

	/**
	 * Refreshes the balance display
	 */
	private void updateBalanceDisplay(){
		BalanceText.setText(Double.toString(customerModel.getBalance()));
	}
	
	/**
	 * performs cleanup operations that the window will use upon closing
	 */
	private void close(){
		
//		//Displays thank you message and pauses for a moment
//		MessageText.setText("Thank you!\nPlease Come Again!");
//		try{
//			frame.wait(2000);
//		} catch(InterruptedException e){
//			frame.dispose();
//		}
		
		customerModel.logout();
        frame.dispose();
	}
}