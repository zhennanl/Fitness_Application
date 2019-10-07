package jframe;


import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Welcome extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 105850459133405144L;

	public Welcome() throws HeadlessException {
		super("Loading...");
		// TODO Auto-generated method stub
		
		JPanel mainpnl = new JPanel();
		mainpnl.setLayout(null);
		
		JLabel lbl = new JLabel("Welcome to MyFitness Pro!");
		lbl.setFont(new Font("Arial", ABORT, 27));
		lbl.setBounds(100, 120, 400, 50);
		
		JLabel lbl2 = new JLabel("Loading system, please wait.....");
		lbl2.setFont(new Font("Arial", Font.PLAIN, 15));
		lbl2.setBounds(180, 200, 300, 50);
		
		
		mainpnl.add(lbl);
		mainpnl.add(lbl2);
		
		setContentPane(mainpnl);
		setVisible(true);
		setBounds(300, 300, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	
}
