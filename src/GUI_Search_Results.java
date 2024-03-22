import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GUI_Search_Results extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	JPanel listPanel = new JPanel();
	
	static Account account;
	Account acc;
	
	static ArrayList<Item> listItem = null;
	ArrayList<Item> itemList;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Search_Results frame = new GUI_Search_Results(listItem, account);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI_Search_Results(ArrayList<Item> itemList, Account acc) {
		this.acc = acc;
		this.itemList = itemList;
		
		
		
		showSearchResults(itemList);
		setSize(900, 600);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		

		
	}
	
	public void showSearchResults(ArrayList<Item> itemList) {
		int lengthOfItemList = itemList.size();
		
		JPanel[] panelItem = new JPanel[lengthOfItemList];
		JLabel[] lblItemName = new JLabel[lengthOfItemList];
		JLabel[] lblItemAuthor = new JLabel[lengthOfItemList];
		JLabel[] lblItemEdition = new JLabel[lengthOfItemList];
		
		int piLength = panelItem.length;
		
		for (int i = 0; i < lengthOfItemList; i++) {
			panelItem[i] = new JPanel();

		 }
		
		for (int i = 0; i < lengthOfItemList; i++) {
			lblItemName[i] = new JLabel(itemList.get(i).getName());
			lblItemName[i].setFont(new Font("Verdana", Font.PLAIN, 15));
			lblItemAuthor[i] = new JLabel(itemList.get(i).getAuthor());
			lblItemAuthor[i].setFont(new Font("Verdana", Font.PLAIN, 15));
			lblItemEdition[i] = new JLabel(itemList.get(i).getEdition());
			lblItemEdition[i].setFont(new Font("Verdana", Font.PLAIN, 15));
		}
		
		for (int i = 0; i < lengthOfItemList; i++) {
			panelItem[i].add(lblItemName[i]);
			panelItem[i].add(lblItemAuthor[i]);
			panelItem[i].add(lblItemEdition[i]);
			 
		 }
		
		for (int i = 0; i < lengthOfItemList; i ++) {
			 listPanel.add(panelItem[i]);
		 }
		 
		
		 getContentPane().add(listPanel);
		 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
