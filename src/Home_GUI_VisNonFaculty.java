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
	private static LibraryHomePage homePage;
	private static LibraryDatabase database;
	
	JFrame frame;
	private JPanel contentPane;
	private JTextField textField, textField_1;

	public static Home_GUI_VisNonFaculty getInstance() {
		if (instance == null)
			instance = new Home_GUI_VisNonFaculty();

		return instance;
	}
	
	public Home_GUI_VisNonFaculty() {
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel listPanel = new JPanel();
		JLabel lbl1 = new JLabel("1");
		listPanel.add(lbl1);
		listPanel.setBounds(275, 0, 600, 600);
		listPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(listPanel);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	 private void loggedInHomePage(Account user) {
		 
		 ArrayList<PhysicalItem> userPhysicalItems = user.getPhysicalItemList();
		 ArrayList<DigitalItem> userDigitalItems = user.getDigitalItemList();
		 JPanel[] panelBook = new JPanel[20];
		 JLabel[] lblNameOfBook = new JLabel[20];
		 JLabel[] lblNameOfAuthor = new JLabel[20];
		 JLabel[] lblItemType = new JLabel[20];
		 JLabel[] lblDueDate = new JLabel[20];
	    	
	    	
		 int lengthOfPhysItem = user.getPhysicalItemList().size();
		 int lengthOfDigItem = user.getDigitalItemList().size();
	    	
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
	    	
		 for (int i = 0; i < 20; i ++) {
			 add(panelBook[i]);
		 }
	    	
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
//	    	System.out.println("Login completed!\n");
//	    	System.out.println("Rentals:");
//	    	for (PhysicalItem p : userPhysicalItems) {
//	    		System.out.println("Name: " + p.getName());
//	    		System.out.println("Author: " + p.getAuthor());
//	    		System.out.println("Item Type: " + p.getItemType());
//	    		System.out.println("Due Date: " + p.getDueDate() + "\n");
//	    	}
//	    	
//	    	System.out.println("E-Books:");
//	    	for (DigitalItem d : userDigitalItems) {
//	    		System.out.println("Name: " + d.getName());
//	    		System.out.println("Author: " + d.getAuthor());
//	    		System.out.println("Item Type: " + d.getItemType() + "\n");
//	    	}
//	    	
//	    	System.exit(0);
	    	
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
	
	public static void main(String[] args) {
		
		Home_GUI_VisNonFaculty exampleApp = new Home_GUI_VisNonFaculty();
		exampleApp.setSize(900, 600);
		exampleApp.setVisible(true);
	}
}
