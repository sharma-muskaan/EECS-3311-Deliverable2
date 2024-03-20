import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Home_GUI_VisNonFaculty extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static Home_GUI_VisNonFaculty instance;
	private static LibraryDatabase database;
	static Account account;
	
	JFrame frame;
	private JPanel contentPane;
	private JTextField textField, textField_1;

	public static Home_GUI_VisNonFaculty getInstance() throws Exception {
		if (instance == null)
			instance = new Home_GUI_VisNonFaculty(account);

		return instance;
	}
	
	public Home_GUI_VisNonFaculty(Account acc) throws Exception {
		database = LibraryDatabase.getInstance();
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel listPanel = new JPanel();
		
		loggedInHomePage(acc, listPanel);
		
		listPanel.setBounds(275, 0, 600, 600);
		listPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(listPanel);
		setSize(900, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	 private void loggedInHomePage(Account user, JPanel listPanel) {
		 System.out.println("entered loggedinhomepage");
		 ArrayList<PhysicalItem> userPhysicalItems = user.getPhysicalItemList();
		 ArrayList<DigitalItem> userDigitalItems = user.getDigitalItemList();
		 
		 int lengthOfPhysItem = user.getPhysicalItemList().size();
		 int lengthOfDigItem = user.getDigitalItemList().size();
		 
		 for (int i = 0; i < lengthOfPhysItem; i ++) {
			 System.out.println(userPhysicalItems.get(i).getName());
		 }
		 
		 
		 JPanel[] panelBook = new JPanel[lengthOfPhysItem + lengthOfDigItem];
		 JLabel[] lblNameOfBook = new JLabel[lengthOfPhysItem + lengthOfDigItem];
		 JLabel[] lblNameOfAuthor = new JLabel[lengthOfPhysItem + lengthOfDigItem];
		 JLabel[] lblItemType = new JLabel[lengthOfPhysItem + lengthOfDigItem];
		 JLabel[] lblDueDate = new JLabel[lengthOfPhysItem];
	    	
	    	
		 
	    	
		 for (int i = 0; i < lengthOfPhysItem; i++) {
			 panelBook[i] = new JPanel();
		 }
	    	
		 for (int i = 0; i < lengthOfDigItem; i++) {
			 panelBook[i] = new JPanel();
		 }
	    	
		 for (int i = 0; i < lengthOfPhysItem; i++) {
			 lblNameOfBook[i] = new JLabel(userPhysicalItems.get(i).getName());
			 lblNameOfAuthor[i] = new JLabel(userPhysicalItems.get(i).getAuthor());
			 lblItemType[i] = new JLabel(userPhysicalItems.get(i).getItemType());
			 lblDueDate[i] = new JLabel(userPhysicalItems.get(i).getDueDate().toString());
		 }
	    	
		 for (int i = 0; i < lengthOfDigItem; i++) {
			 lblNameOfBook[i] = new JLabel(userDigitalItems.get(i).getName());
			 lblNameOfAuthor[i] = new JLabel(userDigitalItems.get(i).getAuthor());
			 lblItemType[i] = new JLabel(userDigitalItems.get(i).getItemType());
		 }
	    	
		 for (int i = 0; i < lengthOfPhysItem; i++) {
			 panelBook[i].add(lblNameOfBook[i]);
			 panelBook[i].add(lblNameOfAuthor[i]);
			 panelBook[i].add(lblItemType[i]);
			 panelBook[i].add(lblDueDate[i]);
		 }
	    	
		 for (int i = 0; i < lengthOfDigItem; i++) {
			 panelBook[i].add(lblNameOfBook[i]);
			 panelBook[i].add(lblNameOfAuthor[i]);
			 panelBook[i].add(lblItemType[i]);
		 }
	    	
		 for (int i = 0; i < lengthOfPhysItem + lengthOfDigItem; i ++) {
			 listPanel.add(panelBook[i]);
		 }
		 
		 add(listPanel);
		 
		 
	    	
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	    	
	    	// TODO
	    	// Displays list of hard cover books that a user is renting, plus their due dates.
	    	// Prompts warnings for books with due dates less than 24 hours.
	    	// Prompts DIFF warning if book is past due date.
	    	// Also contains buttons for accessing common user tasks like search, rent, etc.
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws Exception  {
		Account account = null;
		Home_GUI_VisNonFaculty exampleApp = new Home_GUI_VisNonFaculty(account);
		exampleApp.setSize(900, 600);
		exampleApp.setVisible(true);
		database.loadDigItems(database.digItemsDB, null);
		database.loadPhysItems(database.physItemsDB, null);
		database.loadAccounts();
	}
}
