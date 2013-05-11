package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;


import javax.swing.*;

public class LauncherGUI implements Serializable {
	private JFrame win;
	private JButton customer;
	private JButton restocker;
	private JButton manager;
	private JButton exit;
	
	
	//Login Stuff
	private JFrame res_loginFrame;
	private JPanel res_usernameOptions;
	private JLabel res_l_username;
	private JTextField res_tf_username;
	private JPanel res_passwordOptions;
	private JLabel res_l_password;
	private JPasswordField res_tf_password;
	private JPanel res_loginOptions;
	private JButton res_b_quit;
	private JButton res_b_login;
	private JPanel res_loginFields;
	private Restocker res_restockerModel;
	private ArrayList<Restocker> res_restockerLoginList;
	
	private JFrame man_loginFrame;
	private JPanel man_usernameOptions;
	private JLabel man_l_username;
	private JTextField man_tf_username;
	private JPanel man_passwordOptions;
	private JLabel man_l_password;
	private JPasswordField man_tf_password;
	private JPanel man_loginOptions;
	private JButton man_b_quit;
	private JButton man_b_login;
	private JPanel man_loginFields;
	private Manager man_managerModel;
	private ArrayList<Manager> man_managerLoginList;
	
	private static VendingSystem system = null;
	private static String filename = "system.ser";
	public LauncherGUI(final VendingSystem system){
		
		win = new JFrame("French Toast Vending Interface Launcher");
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.addWindowListener(new java.awt.event.WindowAdapter(){
			public void windowClosing(java.awt.event.WindowEvent e){
				ObjectOutputStream oos;
        		try {
        			oos = new ObjectOutputStream( new FileOutputStream(filename));
        			oos.writeObject(system);
        			oos.close();
        		} catch (FileNotFoundException e1) {
        		
        			e1.printStackTrace();
        		} catch (IOException e1) {
        			
        			e1.printStackTrace();
        		}
			}
		});
		JPanel launcher = new JPanel();
		launcher.setLayout(new GridLayout(3,1));
		initCustomer(system);
		initRestocker(system);
		initManager(system);
		initExit();
		launcher.add(customer);
		launcher.add(restocker);
		launcher.add(manager);
		win.add(launcher, BorderLayout.CENTER);
		win.add(exit, BorderLayout.SOUTH);
		win.setVisible(true);
		win.setSize(250,250);
	}
	
	private void initExit() {
		exit = new JButton("Exit");
		//add action listener
		exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	
            	ObjectOutputStream oos;
        		try {
        			oos = new ObjectOutputStream( new FileOutputStream(filename));
        			oos.writeObject(system);
        			oos.close();
        		} catch (FileNotFoundException e1) {
        		
        			e1.printStackTrace();
        		} catch (IOException e1) {
        			
        			e1.printStackTrace();
        		}
            	win.dispose();
            }
        }); 
	}

	private void initManager( final VendingSystem system) {
		manager = new JButton("Launch Manager");
		//add action listener
		manager.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	man_managerLoginList = system.getManagerList();
            	initManLoginFrame(system, system.machines.get(0));
            }
        }); 
	}

	private void initRestocker(final VendingSystem system) {
		restocker = new JButton("Launch Restocker");
		
		
		restocker.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	res_restockerLoginList = system.getRestockerList();
            	initResLoginFrame(system, system.machines.get(0));
            }
        }); 
	}

	private void initCustomer(final VendingSystem system) {
		customer = new JButton("Launch Customer");
		//add action listener
		customer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	CustomerLaunch startWindow = new CustomerLaunch(system);
            }
        }); 
	}

	public static void main(String[] args){
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
			system = (VendingSystem) ois.readObject();
			System.out.println("Reading system");
		} catch (FileNotFoundException e1) {
			system = new VendingSystem();
			System.out.println("made new system");
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//Machine system starts up
		
		System.out.println(system.getManagerList().size());
		
		
		new LauncherGUI(system);

	}
	
	
	
	private void initResLoginFrame(VendingSystem system, VendingMachine machine){
		res_loginFrame = new JFrame("Restocker Login");
		res_loginFrame.setResizable(false);
		res_loginFrame.setLayout(new BorderLayout());
		
		res_usernameOptions = new JPanel();
		res_usernameOptions.setLayout(new FlowLayout());
		initResUsernameLabel();
		initResUsernameField();
		res_usernameOptions.add(res_l_username);
		res_usernameOptions.add(res_tf_username);
		
		res_passwordOptions = new JPanel();
		res_passwordOptions.setLayout(new FlowLayout());
		initResPasswordLabel();
		initResPasswordField();
		res_passwordOptions.add(res_l_password);
		res_passwordOptions.add(res_tf_password);
		
		
		res_loginOptions = new JPanel();
		res_loginOptions.setLayout(new GridLayout(1,2));
		initResLogin(system, system.machines.get(0));
		initResQuit();
		res_loginOptions.add(res_b_quit);
		res_loginOptions.add(res_b_login);
		
		res_loginFields = new JPanel();
		res_loginFields.setLayout(new GridLayout(2,1));
		res_loginFields.add(res_usernameOptions);
		res_loginFields.add(res_passwordOptions);
		res_loginFrame.add(res_loginFields, BorderLayout.CENTER);
		res_loginFrame.add(res_loginOptions, BorderLayout.SOUTH);
		
		res_loginFrame.setSize(250, 120);
		res_loginFrame.setLocation(100, 100);
		res_loginFrame.setVisible(true);
		res_loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initResUsernameLabel(){
		res_l_username = new JLabel("Username:");
	}
	private void initResUsernameField(){
		res_tf_username = new JTextField(10);
	}
	
	private void initResPasswordLabel(){
		res_l_password = new JLabel("Password:");
	}
	private void initResPasswordField(){
		res_tf_password = new JPasswordField(10);
		/*
		tf_password.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String inputUser = tf_username.getText();
				char[] tempPass = tf_password.getPassword();
				String inputPass = "";
				
				for(int x = 0; x < tempPass.length; x++){
					inputPass += tempPass[x];
				}
				
				if(restocker_checkValidLogin(inputUser, inputPass)){
					loginFrame.setVisible(false);
					loginFrame.dispose();
					//restockerModel.setUsername(inputUser);
					//restockerModel.setPassword(inputPass);
				}
			}
		});
		*/
	}
	
	private void initResLogin(final VendingSystem system, final VendingMachine machine){
		res_b_login = new JButton("Login");
		res_b_login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String inputUser = res_tf_username.getText();
				char[] tempPass = res_tf_password.getPassword();
				String inputPass = "";
				
				for(int x = 0; x < tempPass.length; x++){
					inputPass += tempPass[x];
				}
				
				if(restocker_checkValidLogin(inputUser, inputPass)){
					for(int i = 0; i < res_restockerLoginList.size(); i++){
						if(res_restockerLoginList.get(i).getUsername().equals(inputUser)){
							if(res_restockerLoginList.get(i).getPassword().equals(inputPass)){
								res_restockerModel = res_restockerLoginList.get(i);
								new RestockerLaunch(system,res_restockerModel);
							}
						}
					}
					res_loginFrame.setVisible(false);
					res_loginFrame.dispose();
				}else{
					res_tf_username.setText("");
					res_tf_password.setText("");
				}
			}
		});
	}
	
	private void initResQuit(){
		res_b_quit = new JButton("Quit");
		res_b_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				res_loginFrame.setVisible(false);
				res_loginFrame.dispose();
			}
		});
	}
	
	public boolean restocker_checkValidLogin(String username, String password){
		for(int i=0; i < res_restockerLoginList.size(); i++){
			if(res_restockerLoginList.get(i).getUsername().equals(username)){
				if(res_restockerLoginList.get(i).getPassword().equals(password)){
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	//TODO
	private void initManLoginFrame(VendingSystem system, VendingMachine machine){
		man_loginFrame = new JFrame("Manager Login");
		man_loginFrame.setResizable(false);
		man_loginFrame.setLayout(new BorderLayout());
		
		man_usernameOptions = new JPanel();
		man_usernameOptions.setLayout(new FlowLayout());
		initManUsernameLabel();
		initManUsernameField();
		man_usernameOptions.add(man_l_username);
		man_usernameOptions.add(man_tf_username);
		
		man_passwordOptions = new JPanel();
		man_passwordOptions.setLayout(new FlowLayout());
		initManPasswordLabel();
		initManPasswordField();
		man_passwordOptions.add(man_l_password);
		man_passwordOptions.add(man_tf_password);
		
		
		man_loginOptions = new JPanel();
		man_loginOptions.setLayout(new GridLayout(1,2));
		initManLogin(system, system.machines.get(0));
		initManQuit();
		man_loginOptions.add(man_b_quit);
		man_loginOptions.add(man_b_login);
		
		man_loginFields = new JPanel();
		man_loginFields.setLayout(new GridLayout(2,1));
		man_loginFields.add(man_usernameOptions);
		man_loginFields.add(man_passwordOptions);
		man_loginFrame.add(man_loginFields, BorderLayout.CENTER);
		man_loginFrame.add(man_loginOptions, BorderLayout.SOUTH);
		
		man_loginFrame.setSize(250, 120);
		man_loginFrame.setLocation(100, 100);
		man_loginFrame.setVisible(true);
		man_loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void initManUsernameLabel(){
		man_l_username = new JLabel("Username:");
	}
	private void initManUsernameField(){
		man_tf_username = new JTextField(10);
	}
	
	private void initManPasswordLabel(){
		man_l_password = new JLabel("Password:");
	}
	private void initManPasswordField(){
		man_tf_password = new JPasswordField(10);
		/*
		tf_password.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String inputUser = tf_username.getText();
				char[] tempPass = tf_password.getPassword();
				String inputPass = "";
				
				for(int x = 0; x < tempPass.length; x++){
					inputPass += tempPass[x];
				}
				
				if(restocker_checkValidLogin(inputUser, inputPass)){
					loginFrame.setVisible(false);
					loginFrame.dispose();
					//restockerModel.setUsername(inputUser);
					//restockerModel.setPassword(inputPass);
				}
			}
		});
		*/
	}
	
	private void initManLogin(final VendingSystem system, final VendingMachine machine){
		man_b_login = new JButton("Login");
		man_b_login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String inputUser = man_tf_username.getText();
				char[] tempPass = man_tf_password.getPassword();
				String inputPass = "";
				
				for(int x = 0; x < tempPass.length; x++){
					inputPass += tempPass[x];
				}
				
				if(manager_checkValidLogin(inputUser, inputPass)){
					for(int i = 0; i < man_managerLoginList.size(); i++){
						if(man_managerLoginList.get(i).getUsername().equals(inputUser)){
							if(man_managerLoginList.get(i).getPassword().equals(inputPass)){
								man_managerModel = man_managerLoginList.get(i);
								new ManagerGUI(system,man_managerModel);
							}
						}
					}
					man_loginFrame.setVisible(false);
					man_loginFrame.dispose();
				}else{
					man_tf_username.setText("");
					man_tf_password.setText("");
				}
			}
		});
	}
	
	private void initManQuit(){
		man_b_quit = new JButton("Quit");
		man_b_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				man_loginFrame.setVisible(false);
				man_loginFrame.dispose();
			}
		});
	}
	
	public boolean manager_checkValidLogin(String username, String password){
		for(int i=0; i < man_managerLoginList.size(); i++){
			if(man_managerLoginList.get(i).getUsername().equals(username)){
				if(man_managerLoginList.get(i).getPassword().equals(password)){
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	
}
