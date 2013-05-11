package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;


public class RestockerGUI implements Serializable {
	private JFrame win;
	private JPanel mainRestockerPanel;
	private JScrollPane reportScrollPane;
	private JList insList;
	private JButton complete;
	private JButton logout;
	private JButton addNote;
	private JButton oldNote;
	private JLabel instruction;
	private JTextPane textie;
	private Restocker currentRestocker;
	private VendingMachine _machine;
	private VendingSystem _system;
	private ArrayList<ArrayList> alist;
	public RestockerGUI(VendingSystem system, VendingMachine machine, Restocker r){
		currentRestocker = r;
		_machine = machine;
		_system = system;
		alist = currentRestocker.getInstructionList(_machine);

		this.initGUI();
	}
	
	
	
	public void initGUI(){
		//init
		this.win = new JFrame("Restokcer GUI - French Toast Vending");
		win.setSize(500,500);
		mainRestockerPanel = new JPanel();
		mainRestockerPanel.setLayout(new BorderLayout());
		
		//banner
		JPanel north = new JPanel();
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("FTM (640x160).jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel picLabel = new JLabel(new ImageIcon( myPicture ));
		north.add( picLabel );
		//JLabel label = new JLabel("Temp North Banner");
		//north.add(label);
		mainRestockerPanel.add(north, BorderLayout.NORTH);
		
		//Scroll
		initInsList();
		mainRestockerPanel.add(reportScrollPane, BorderLayout.WEST);
		
		//CenterPanel
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3,1));
		//options -> Center.Center
		JPanel options = new JPanel();
		options.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		//c.weighty = .5;
		c.ipady = 40;  
		c.gridx = 0;
		c.gridy = 0;
		//CompleteTask ->Options ->Center.Center
		initComplete();
		//complete.setBackground(Color.);
		complete.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		options.add(complete,c);
		//Logout ->Options ->Center.Center
		c.gridx = 0;
		c.gridy = 1;
		String instrucText = "**Completing Task will update the back end to reflect physical changes made";
		instruction =  new JLabel();
		instruction.setText("<html><div style=\"text-align: center;\">"+ instrucText +"</html>");
		options.add(instruction, c);
		
		
		center.add(options);
		
		
		//Textfield (South)
		JPanel south = new JPanel();
		south.setLayout(new BorderLayout());
		textie = new JTextPane();
		textie.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		initAddNote();
		initOldNote();
		JPanel southButtons = new JPanel();
		southButtons.setLayout(new GridLayout(1,2));
		southButtons.add(addNote);
		southButtons.add(oldNote);
		south.add(textie, BorderLayout.CENTER);
		south.add(southButtons,BorderLayout.SOUTH);
		center.add(south);
		
		JPanel center3rd = new JPanel();
		center3rd.setLayout(new GridBagLayout());
		c.gridx = GridBagConstraints.RELATIVE;
		//c.weightx = .5;
		c.gridy = GridBagConstraints.RELATIVE;
		initLogout();
		logout.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		center3rd.add(logout,c);
		center.add(center3rd);
		
		mainRestockerPanel.add(center, BorderLayout.CENTER);
		win.add(mainRestockerPanel);
		
		win.setSize(650, 650);
        win.setLocation(50, 50);
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	

	
	
	
	public void initComplete(){
		complete = new JButton("Complete Task");
		//complete.setBackground(Color.);
		complete.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		complete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	
            	if (! insList.isSelectionEmpty()){
            		String selectedIns = (String) insList.getSelectedValue();
            		boolean success = false;
            		int index = -1;
            		for(int i =0; i < alist.size();i++){	
            			if(alist.get(i).get(0).equals(selectedIns)){
            				success = currentRestocker.executeInstruction(_machine, alist.get(i));
            				index = i;
            			}
            		}
                	if (success && index >= 0){
                		alist.remove(index);
                		refreshInstructions();	
                	}
            	}
            }
        }); 
	}
	
	public void initInsList(){
		insList = new JList();
		refreshInstructions();
		reportScrollPane = new JScrollPane(insList, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
	}
	
	//TODO add comments
	public void refreshInstructions(){
		ArrayList<String> instructions =  new ArrayList<String>();
		for(int i =0; i < alist.size(); i++){
			instructions.add((String)alist.get(i).get(0));
		}
		 //argument for line below
		String[] a = new String[instructions.size()];
		String[] listData = (String[]) (instructions.toArray(a));
		
		insList.clearSelection();
		insList.setListData(listData);
	}
	
	public void initLogout(){
		logout = new JButton("Log Out");
		//add action listener
		logout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				win.setVisible(false);
				win.dispose();
			}
		});
	}
	
	public void initAddNote(){
		addNote = new JButton("Add New Note");
		addNote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	//TODO add action listener
            	String s = textie.getText();
            	_machine.setRestockerNotes(s);
            	textie.setText("");
            }
        }); 
	}
	
	public void initOldNote(){
		oldNote = new JButton("View Old Note");
		oldNote.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	
            	String s = _machine.getRestockerNotes();
            	textie.setText(s);
            }
        }); 
	}
	
	
}
