package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class RestockerLaunch {
	//the system of machines that the customer can pick from
		private VendingSystem system;
		
		private Restocker restocker;
		
		//the window for this launcher GUI
		private JFrame frame;
		
		//the north panel of this GUI
		private JPanel north;
		
		//the west panel of this GUI, will have a selection list
		private JPanel west;
		
		//the east panel of this GUI, will have buttons
		private JPanel east;
		
		//A list of machines within the system that the customer can pick from
		private JList selectionList;
		
		//The button used to make a selection with
		private JButton loginButt;
		
		//The button used to exit the customer launcher (this) without selecting
		//a machine
		private JButton exitButt;
		
		//The scroller for the machine selection list
		private JScrollPane listScrollPane;
		
		//border for good appearance
		private Border blackline;

		
		/**
		 * Test program for this customer GUI launcher
		 * @param args not applicable
		 */
		
		
		/**
		 * Makes the customer launch GUI.
		 */
		public RestockerLaunch(VendingSystem system, Restocker restocker){
			this.system = system;
			this.restocker = restocker;
			
			initFrame();
		}
		
		/**
		 * builds and initializes the frame for this GUI
		 */
		private void initFrame(){
			frame = new JFrame("Vending Machine Restocker");
			frame.setResizable(true);
			
			//init components
			blackline = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
			initSelectionList();
			initLoginButt();
			initExitButt();
			
			initPosition();
		}
		
		/**
		 * initializes the position of the components within this GUI
		 * @pre the components should be constructed and initialized before 
		 *   this call
		 */
		private void initPosition(){
			
			//Here we initialize the window/panel layout before we establish
			//buttons and put those buttons into these panels
			north = new JPanel();
			east = new JPanel();
			west = new JPanel();
			
			//Here we size the frame
			frame.setLayout(new BorderLayout());
			frame.setSize(350,300);
			frame.setVisible(true);
					
			makeWest();
			makeEast();
			
			//construct the North Panel
			north.setLayout(new GridLayout(1,1));
			BufferedImage myPicture = null;
			try {
				myPicture = ImageIO.read(new File("FTM (350x88).jpg"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
			north.add( picLabel );
			//north.add(new JLabel("FTM VENDING LOGO GOES HERE------------------->"));
			north.setVisible(true);
			
			//Finish the frame
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.add(west, BorderLayout.WEST);
			frame.add(east, BorderLayout.CENTER);//for resizability
			frame.add(north, BorderLayout.NORTH);
			
			frame.setVisible(true);
		}
		
		/**
		 * Initializes the JList of machines
		 */
		private void initSelectionList(){
			//construct the item list and fill it with item choices
			selectionList = new JList();
			
			refreshList();
			
			//allow only a single selection
			selectionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			//This moves cursor in the items list listener
			selectionList.addListSelectionListener(new ListSelectionListener() {
			      public void valueChanged(ListSelectionEvent evt) {
			        if (evt.getValueIsAdjusting())
			          return;
			        loginButt.setEnabled(true);
			      }
			    });
			
			//Here we initialize the scroll pane for the items list
			listScrollPane = new JScrollPane(selectionList, 
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
					JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);		
		}
		
		/**
		 * Initializes the login button
		 */
		private void initLoginButt(){
			loginButt = new JButton("Login");
			//don't let selection until they pick a machine
			loginButt.setEnabled(false);
			//add action listener
			loginButt.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e){
	            	MachineStringWrapper userChoice = (MachineStringWrapper) selectionList.getSelectedValue();
	            	//TODO 
	            	RestockerGUI transactionMenu = new RestockerGUI(system,userChoice.machine, restocker);
	            	//hide the launcher while menu is open
	            	close();
	            }
	        }); 
		}
		
		/**
		 * Initializes the exit button
		 */
		private void initExitButt(){
			exitButt = new JButton("Exit");
			exitButt.setEnabled(true);
			exitButt.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					close();
				}
			});
		}
		
		/**
		 * Resets the machine list's contents.  Refreshes the list.
		 */
		private void refreshList(){
			ArrayList<MachineStringWrapper> machList = 
					MachineStringWrapper.convert(system.machines);
			
			MachineStringWrapper[] a = new MachineStringWrapper[machList.size()]; 
			//^^argument for line below
			MachineStringWrapper[] listData = machList.toArray(a);
			
			selectionList.clearSelection();
			selectionList.setListData(listData);
		}
		
		/**
		 * Cleans up this object and closes it.  This should close the window.
		 */
		private void close(){
			frame.dispose();
		}
		
		/**
		 * provides a wrapper for a vending machine that provides a toString
		 * method that is appropriate for this GUI.  
		 * @author Joe
		 */
		private static class MachineStringWrapper{
			
			//The machine being wrapped
			public VendingMachine machine;
			
			/**
			 * constructs a 
			 */
			public MachineStringWrapper(VendingMachine v){
				machine = v;
			}
			
			/**
			 * Wraps a list of machines into a list of this object
			 * @param list A list of Machines to be turned into a list of wrapped
			 * ones
			 * @return the new wrapper list
			 * @post the input list is not changed
			 */
			public static ArrayList<MachineStringWrapper> convert(ArrayList<VendingMachine> list){
				ArrayList<MachineStringWrapper> w = new ArrayList<MachineStringWrapper>();
				for (VendingMachine v : list){
					w.add(new MachineStringWrapper(v));
				}
				return w;
			}
			
			/**
			 * Provides a string representation for a vending machine that is 
			 * appropriate for this GUI
			 * @return a user friendly string form of the machine
			 */
			public String toString(){
				return ("Machine #: " + machine.getMachineID());
			}
		}
		
		/**
		 * makes the west panel, fills it with the machine list
		 * @pre the buttons must be initialized
		 */
		private void makeWest(){
			GridBagConstraints c = new GridBagConstraints();
			west.setLayout(new GridBagLayout());
			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1.0;
			c.weighty = .5;
			c.ipadx = 100;
			west.setSize(300, 300);
			west.setBorder(blackline);
			west.setVisible(true);
			west.add(listScrollPane , c);
		}

		/**
		 * makes the east panel, fills it out with the two buttons
		 * @pre the buttons must be initialized
		 */
		private void makeEast(){
			GridBagConstraints c = new GridBagConstraints();
			JPanel bottom = new JPanel();
			JPanel top = new JPanel();
			top.setLayout(new GridBagLayout());
			bottom.setLayout(new GridBagLayout());
			east.setLayout(new GridBagLayout());
			c.weightx = 1.0;
			c.weighty = 0.0;
			c.gridwidth = 200;
			c.ipady = 50;
			c.ipadx = 69;
			c.fill = GridBagConstraints.HORIZONTAL;
			east.setSize(100, 200);
			top.add(loginButt, c);
			top.setBorder(blackline);
			bottom.add(exitButt, c);
			bottom.setBorder(blackline);
			c.gridy = 0;
			east.add(top,c);
			c.gridy = 1;
			east.add(bottom,c);
			east.setVisible(true);
			
//			east.setLayout(new GridLayout(2,1));
//			east.add(loginButt);
//			east.add(exitButt);
//			east.setVisible(true);
		}
}
