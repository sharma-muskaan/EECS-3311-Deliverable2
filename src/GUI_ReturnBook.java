import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class GUI_ReturnBook extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static LibraryDatabase database;
	private JPanel contentPane;
	
	static Account acc1 = null;
	Account acc;
	
	JButton btnNewButton_1 = new JButton("Return");
	JButton btnNewButton = new JButton("Back");
	JButton btnShowBooks = new JButton("Show Borrowed Items");
	
	JPanel panel_1 = new JPanel();
	JPanel panel_2 = new JPanel();
	
	ArrayList<PhysicalItem> borrowedBooks = new ArrayList<>();
	ArrayList<PhysicalItem> userPhysItems = new ArrayList<>();
	
	Vector<String> physicalItemStrings = new Vector<>();
	
	JComboBox<String> listBorrowedItems;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_ReturnBook frame = new GUI_ReturnBook(acc1);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public GUI_ReturnBook(Account acc) throws Exception {
		this.acc = acc;
		
		database = LibraryDatabase.getInstance();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 888, 65);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return A Book");
		lblNewLabel.setBounds(327, 6, 232, 37);
		lblNewLabel.setForeground(new Color(216, 84, 86));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblNewLabel);
		
		
		panel_1.setBounds(6, 83, 888, 483);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Books You Have Checked Out:");
		lblNewLabel_1.setForeground(new Color(216, 84, 86));
		lblNewLabel_1.setBounds(41, 29, 312, 33);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(lblNewLabel_1);
		
//		JComboBox comboBox = new JComboBox();
//		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Book1", "Book2", "Book3"}));
//		comboBox.setBounds(59, 197, 736, 27);
//		panel_1.add(comboBox);
		
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(124, 369, 154, 70);
		panel_1.add(btnNewButton);


		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton_1.setBounds(595, 369, 154, 70);
		panel_1.add(btnNewButton_1);
		
		btnShowBooks.addActionListener(this);
		btnShowBooks.setBounds(350, 33, 197, 29);
		panel_1.add(btnShowBooks);
		panel_1.setBounds(109, 129, 557, 200);

		
		setVisible(true);
	}
	
	public void showBorrowedBooks(Account acc) throws Exception {
		String[] emailSplit = new String[2];
		emailSplit = acc.getEmail().split("@");
		database.loadPhysItems(borrowedBooks, emailSplit[0]);

		for(PhysicalItem p: borrowedBooks){
			physicalItemStrings.add(p.getName());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton) {
			dispose();
			try {
				GUI_Home_VisNonFaculty newFrame = new GUI_Home_VisNonFaculty(acc);
				newFrame.setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		else if (e.getSource() == btnShowBooks) {
			try {
				showBorrowedBooks(acc);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			listBorrowedItems = new JComboBox<String>(physicalItemStrings);
			listBorrowedItems.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
			listBorrowedItems.setBounds(68, 145, 733, 63);
			panel_1.add(listBorrowedItems);
			setVisible(true);
		}
	}

}
