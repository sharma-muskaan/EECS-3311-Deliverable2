import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI_Menu extends JFrame implements ActionListener {

	JFrame frame;
	private JButton btnCustomerMenu,btnExit;
	
	public GUI_Menu() {
		initalize();
	}
	
	private void initalize() {

		// set parameters for a frame
		frame = new JFrame();
		//frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBackground(Color.WHITE);

		// set the label JVKBanking parameters
		JLabel lblJVKBanking = new JLabel("YorkU Library Management");
		lblJVKBanking.setForeground(new Color(255, 0, 0, 150));
		lblJVKBanking.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 39));
		lblJVKBanking.setBounds(200, 23, 800, 56);
		frame.getContentPane().add(lblJVKBanking);

		// set parameters for the customer menu button
		btnCustomerMenu = new JButton("Login/Sign Up");
		btnCustomerMenu.addActionListener(this);
		btnCustomerMenu.setBackground(Color.WHITE);
		btnCustomerMenu.setBounds(300, 250, 130, 56);
		frame.getContentPane().add(btnCustomerMenu);

		// set parameters for the exit button
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		btnExit.setBackground(Color.WHITE);
		btnExit.setBounds(450, 250, 107, 56);
		frame.getContentPane().add(btnExit);

		// set the bounds of the frame, make it visible and set its layout
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setVisible(true);
		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			GUI_Menu window = new GUI_Menu();// making window to new menu
			window.frame.setSize(900, 600);
			window.frame.setVisible(true);// setting the frame as visible
		} catch (Exception e) {// catching any errors
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCustomerMenu ) {

			frame.dispose();// get rid of old frame
			GUI_SignUP_Login window;
			try {
				window = new GUI_SignUP_Login();
				window.setSize(900, 600);
				setVisible(true);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		else if(e.getSource() == btnExit) {
			frame.dispose(); // get rid of old frame
		}
		
	}

}
