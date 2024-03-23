 import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
// TODO:  FIX THIS - DIGITALITEMS ARE NOT A THING FOR VISITOR AND NON-FACULTY
public class GUI_Home_VisNonFaculty extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static GUI_Home_VisNonFaculty instance;
	private static LibraryDatabase database;
	
	static Account account;
	Account account1;
	
	Date currentDate = new Date();
	double fine = 0.0;
	
	ArrayList<PhysicalItem> userPhysicalItems = new ArrayList<>();

	GUI_RentBook rb;
	
	
	JFrame frame;
	private JPanel contentPane;
	public JPanel panel1 = new JPanel();
	public JPanel userPanel = new JPanel();
	public JPanel panelRentBook = new JPanel();
	public JPanel panelReturnBook = new JPanel();
	public JPanel panelPurchase = new JPanel();
	public JPanel panelFine = new JPanel();
	
	public JLabel lblPhysTitle = new JLabel("Borrowed Physical Items ");
	public JLabel lblDigTitle = new JLabel("Borrowed Course Items ");
	
	public JButton btnRentABook = new JButton("Rent a Book");
	public JButton btnReturnABook = new JButton("Return a Book");
	public JButton btnPurchaseItem = new JButton("Purchase Item");
	public JButton btnSubscribe = new JButton("Subscribe To Newsletter");
	public JButton btnFine = new JButton("Check/Pay Fines");
	
	JPanel panel = new JPanel();
	JButton btnSearch = new JButton("Search");
	
	ArrayList<DigitalItem> digitems;
	

	public static GUI_Home_VisNonFaculty getInstance() throws Exception {
		if (instance == null)
			instance = new GUI_Home_VisNonFaculty(account);

		return instance;
	}
	
	public GUI_Home_VisNonFaculty(Account acc) throws Exception {
		this.account1 = acc;
		notifyFaculty();
		database = LibraryDatabase.getInstance();
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		
		
		
		lblPhysTitle.setForeground(new Color(255, 0, 0, 150));
		lblPhysTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		
		JPanel listPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		listPanel.add(lblPhysTitle);
		
		loggedInHomePage(acc, listPanel);
		
		listPanel.setBounds(275, 0, 600, 600);
		buttonPanel.setBounds(0, 0, 300, 600);
		listPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
		
		btnRentABook.addActionListener(this);
		btnReturnABook.addActionListener(this);
		btnPurchaseItem.addActionListener(this);
		btnSubscribe.setBounds(13, 387, 196, 29);
		btnSubscribe.addActionListener(this);
		panelRentBook.setBounds(13, 255, 128, 39);
		
		panelRentBook.add(btnRentABook);
		panelReturnBook.setBounds(13, 183, 141, 39);
		panelReturnBook.add(btnReturnABook);
		panelPurchase.setBounds(13, 328, 142, 39);
		panelPurchase.add(btnPurchaseItem);
		buttonPanel.setLayout(null);
		
		buttonPanel.add(panelRentBook);
		buttonPanel.add(panelReturnBook);
		buttonPanel.add(panelPurchase);
		//add(buttonPanel);
		getContentPane().add(listPanel);
		getContentPane().add(buttonPanel);
		buttonPanel.add(btnSubscribe);
		panel.setBounds(13, 439, 141, 46);
		
		buttonPanel.add(panel);
		panel.setLayout(null);
		btnSearch.setBounds(6, 0, 117, 29);
		btnSearch.addActionListener(this);

		panelFine.setBounds(13, 120, 141, 39);
		buttonPanel.add(panelFine);
		panelFine.add(btnFine);
		btnFine.addActionListener(this);
		
		panel.add(btnSearch);
		
		setSize(900, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void notifyFaculty() throws Exception {
		String[] name = new String[2];
		name = account1.getEmail().split("@");
		
		if (account1.getAccType().equals("Faculty")) {
			
			digitems = ((Faculty) account).getCourseBookHistory();
			
			for (DigitalItem d : digitems) {
				if(account1.newerEdition(digitems, d) == true) {
					JOptionPane.showMessageDialog(null, d.getName() + " has a newer edition");
				}
			}
		}
	}
	
	private void loggedInHomePage(Account user, JPanel listPanel) {
		
		 ArrayList<PhysicalItem> userPhysicalItems = user.getPhysicalItemList();
		 ArrayList<DigitalItem> userDigitalItems = null;
		 int lengthOfDigItem = 0;



		 
		 if (user.getAccType().equals("Student")) {
			 userDigitalItems = ((Student) user).getDigitalCourseBooks();
			 lengthOfDigItem = ((Student) user).getDigitalCourseBooks().size();
		 }
		 
		 if (user.getAccType().equals("Faculty")) {
			 userDigitalItems = ((Faculty) user).getCourseBookHistory();
			 lengthOfDigItem = ((Faculty) user).getCourseBookHistory().size();
		 }
		 
		 
		 int lengthOfPhysItem = user.getPhysicalItemList().size();
		 
		
		 JPanel[] panelBook = new JPanel[lengthOfPhysItem + lengthOfDigItem];
		 JLabel[] lblNameOfBook = new JLabel[lengthOfPhysItem + lengthOfDigItem];
		 JLabel[] lblNameOfAuthor = new JLabel[lengthOfPhysItem + lengthOfDigItem];
		 JLabel[] lblItemType = new JLabel[lengthOfPhysItem + lengthOfDigItem];
		 JLabel[] lblDueDate = new JLabel[lengthOfPhysItem];
		 JLabel[] lblFine = new JLabel[lengthOfPhysItem];
		
		 JLabel lblTypeItem = new JLabel("Type: ");
		 lblTypeItem.setFont(new Font("Verdana", Font.BOLD, 15));
		 JLabel lblDateDue = new JLabel("Due: ");
		 lblDateDue.setFont(new Font("Verdana", Font.BOLD, 15));
		 JLabel lblFines = new JLabel("");
		 lblFines.setFont(new Font("Verdana", Font.BOLD, 15));
	    	
	    int pbLength = panelBook.length;
	    int lblNameLength = lblNameOfBook.length;
	    
		 for (int i = 0; i < lengthOfPhysItem + lengthOfDigItem; i++) {
			 panelBook[i] = new JPanel();

		 }
	    	
		 for (int i = 0; i < lengthOfPhysItem; i++) {
			 lblNameOfBook[i] = new JLabel(userPhysicalItems.get(i).getName());
			 lblNameOfBook[i].setFont(new Font("Verdana", Font.PLAIN, 15));
			 lblNameOfAuthor[i] = new JLabel(userPhysicalItems.get(i).getAuthor());
			 lblNameOfAuthor[i].setFont(new Font("Verdana", Font.PLAIN, 15));
			 lblItemType[i] = new JLabel(userPhysicalItems.get(i).getItemType());
			 lblItemType[i].setFont(new Font("Verdana", Font.PLAIN, 15));
			 lblDueDate[i] = new JLabel(userPhysicalItems.get(i).getDueDate().toString());
			 lblDueDate[i].setFont(new Font("Verdana", Font.PLAIN, 15));
			 lblFine[i] = new JLabel("$" + String.valueOf(userPhysicalItems.get(i).calculateFine()));
			 lblFine[i].setFont(new Font("Verdana", Font.PLAIN, 15));
			 lblFine[i].setForeground(Color.RED);
		 }
		 
		 for (int i = 0; i < lengthOfPhysItem; i++) {
			 panelBook[i].add(lblNameOfBook[i]);
			 panelBook[i].add(lblNameOfAuthor[i]);
			 panelBook[i].add(lblItemType[i]);
			 panelBook[i].add(lblDueDate[i]);
			 panelBook[i].add(lblFine[i]);
			 
		 }
		 
		 for (int i = 0; i < lengthOfPhysItem; i ++) {
			 listPanel.add(panelBook[i]);
		 }
		 panel1.setSize(100, 600);
		 lblDigTitle.setForeground(new Color(255, 0, 0, 150));
		 lblDigTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));

		 panel1.add(lblDigTitle);

		 listPanel.add(panel1);
	    
		 if (user.getAccType().equals("Faculty") || user.getAccType().equals("Student")) {
			 int k = 0;
			 for (int j = lengthOfPhysItem; j < pbLength; j++) {
				 lblNameOfBook[j] = new JLabel(userDigitalItems.get(k).getName());
				 lblNameOfBook[j].setFont(new Font("Verdana", Font.PLAIN, 15));
				 lblNameOfAuthor[j] = new JLabel(userDigitalItems.get(k).getAuthor());
				 lblNameOfAuthor[j].setFont(new Font("Verdana", Font.PLAIN, 15));
				 lblItemType[j] = new JLabel(userDigitalItems.get(k).getItemType());
				 lblItemType[j].setFont(new Font("Verdana", Font.PLAIN, 15));
				 k++;
			 }
			 
			 for (int j = lengthOfPhysItem; j < pbLength; j++) {
				 panelBook[j].add(lblNameOfBook[j]);
				 panelBook[j].add(lblNameOfAuthor[j]);
				 panelBook[j].add(lblItemType[j]);
			 }
			 
			 for (int j = lengthOfPhysItem; j < pbLength; j++) {
				 listPanel.add(panelBook[j]);
			 }
		 }
		 
		 
//		 for (int i = 0; i < userPhysicalItems.size(); i++) {
//			 userPhysicalItems.get(i).warning((lblDueDate[i].getText()));
//			 
//		 }
		 
		 
		 
		 getContentPane().add(listPanel);
		 
	    	
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	
	    	
	    	// TODO
	    	// Displays list of hard cover books that a user is renting, plus their due dates. DONE
	    	// Prompts warnings for books with due dates less than 24 hours. 
	    	// Prompts DIFF warning if book is past due date.
	    	// Also contains buttons for accessing common user tasks like search, rent, etc.
	    }
	
	
	public static void main(String[] args) throws Exception  {
		Account account = null;
		GUI_Home_VisNonFaculty exampleApp = new GUI_Home_VisNonFaculty(account);
		exampleApp.setSize(900, 600);
		exampleApp.setVisible(true);
		database.loadDigItems(database.digItemsDB, null);
		database.loadPhysItems(database.physItemsDB, null);
		database.loadAccounts();
//		Date tenDaysAgo = Date.
//		dateDifference(Date tenDaysAgo);
	}
	
	 @Override
		public void actionPerformed(ActionEvent e) {
		 
			 if (e.getSource() == btnRentABook) {
				 
				 
				try {
					super.dispose();
					GUI_RentBook window = new GUI_RentBook(account1);
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
					 e1.printStackTrace();
				}
				 
			 }
			 
			 else if (e.getSource() == btnReturnABook) {
				 setVisible(false);
				 GUI_ReturnBook window;
				try {
					window = new GUI_ReturnBook(account1);
					window.setVisible(true);
				 	window.setSize(900, 600); 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			 }
			 
			 else if (e.getSource() == btnPurchaseItem) {
				 setVisible(false);
				 GUI_PurchaseItem window;
				 
				try {
					window = new GUI_PurchaseItem(account1);
					window.setVisible(true);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				 
			 }
			 
			 else if (e.getSource() == btnSubscribe) {
				 setVisible(false);
				 GUI_Subscribe_Newsletter window = new GUI_Subscribe_Newsletter(account1);
				 window.setVisible(true);
				 window.setSize(900, 600); 
			 }
			 
			 else if (e.getSource() == btnSearch) {
				 setVisible(false);
				 try {
					 GUI_Search window = new GUI_Search(account1);
					 window.setVisible(true);
					 window.setSize(900, 600); 
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }

			 else if(e.getSource()==btnFine){
				setVisible(false);
				GUI_Fines f;
				try {
					f = new GUI_Fines(account1);
					f.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			}
				
			 }
			 
			
	}

