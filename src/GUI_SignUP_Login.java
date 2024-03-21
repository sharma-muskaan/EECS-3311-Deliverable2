import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI_SignUP_Login extends JFrame implements ActionListener {
	
	private static LibraryDatabase database;
	private JPanel contentPane;
	private JTextField email, password;
	private JButton btnLogin, btnSignup, btnBack;
	private JLabel lblUsername,lblPassword,lblEnterYourUsername;

	
	public GUI_SignUP_Login() throws Exception {
		super("YorkU Library Management");
		database = LibraryDatabase.getInstance();
		System.out.println(database);
		
		getContentPane().setLayout(null);

		// Set up panel
		contentPane = new JPanel();
		//contentPane.setBackground(Color.GREEN);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Add header
		lblEnterYourUsername = new JLabel("Enter Your Username and Password");
		lblEnterYourUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblEnterYourUsername.setForeground(new Color(255, 0, 0, 150));
		lblEnterYourUsername.setBounds(250, 100, 372, 30);
		contentPane.add(lblEnterYourUsername);

		// Add label for user name
		lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblUsername.setForeground(new Color(255, 0, 0, 150));
		lblUsername.setBounds(250, 200, 100, 17);
		contentPane.add(lblUsername);

		// Add label for password
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblPassword.setForeground(new Color(255, 0, 0, 150));
		lblPassword.setBounds(250, 260, 81, 14);
		contentPane.add(lblPassword);

		// Add text field for user name
		email = new JTextField(45);
		email.setBounds(351, 200, 248, 20);
		contentPane.add(email);
		email.setColumns(10);

		// add text field for password
		password = new JTextField(45);
		password.setBounds(351, 260, 248, 20);
		contentPane.add(password);
		password.setColumns(10);

		// Add log in button
		btnLogin = new JButton("Log In");
		btnLogin.setBackground(new Color(216, 191, 216));
		btnLogin.addActionListener(this);	// Add action listener
		btnLogin.setBounds(270, 330, 89, 23);
		contentPane.add(btnLogin);

		// Add back button
		btnBack = new JButton("Back");
		btnBack.setBackground(new Color(216, 191, 216));
		btnBack.setBounds(490, 330, 89, 23);
		btnBack.addActionListener(this);	// Add action listener
		contentPane.add(btnBack);

		// Add sign up button
		btnSignup = new JButton("Sign Up");
		btnSignup.setBackground(new Color(216, 191, 216));
		btnSignup.addActionListener(this);	// Add action listener
		btnSignup.setBounds(380, 330, 89, 23);
		contentPane.add(btnSignup);

		// Set size and location of frame
		setSize(900, 600);  
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) throws Exception {
		// All loaders for main DB assume that CSV files already exist
		// This can be changed later as needed using a branch of the doesListExist method
		GUI_SignUP_Login window = new GUI_SignUP_Login();
		window.setSize(900, 600);
		database.loadDigItems(database.digItemsDB, null);
		database.loadPhysItems(database.physItemsDB, null);
		database.loadAccounts();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBack) {
			setVisible(false);
			GUI_Menu window;
			try {
				window = new GUI_Menu();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // when log out is pressed then it goes to the the transaction menu
			setSize(900, 600);
			setVisible(true); // make the frame/ window visible
		}
		
		if (e.getSource() == btnLogin) {
			Account registeredAccount = null;
	    	while (true) {  
	            try {
	            	// iterating through database to find an account with specific email and password passed in. 
	            	
					registeredAccount = database.iterateDB(email.getText(), password.getText());
					System.out.println("account: " + registeredAccount.getEmail() + " " +  registeredAccount.getPass());
				} 
	            catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	            
	            // if it finds it, break the iteration. 
	            if (registeredAccount != null) {
	            	if (registeredAccount.getAccType().equals("Visitor") || registeredAccount.getAccType().equals("NonFaculty")) {
	            		setVisible(false);
		            	Home_GUI_VisNonFaculty window  = new Home_GUI_VisNonFaculty();
		    			window.setSize(900, 600);
		    			window.setVisible(true);
		            	break;
	            	}
	            	else if(registeredAccount.getAccType().equals("Student")) {
	            		// create student page
	            	}
	            	
	            	else if (registeredAccount.getAccType().equals("Faculty")) {
	            		// create faculty page
	            	}
	            	
	            	else if (email.getText().equals("mgr_access") && password.getText().equals("password")) {
	            		//LibraryManager manager = new LibraryManager(email, password);
	            		// placeholder for management page
	                    //managementPortal(manager);
	            	}
	            	
	            }
	            
	            else {
	            	// place the error message here
	            }
	    	}
	    	
			
		}
		
	}

}