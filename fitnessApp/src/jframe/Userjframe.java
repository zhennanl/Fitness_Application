package jframe;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import data.jdbc_user;
import javabean.record;

public class Userjframe extends JFrame{
	
	public Userjframe() throws HeadlessException {
		super("Set User Profile");
		// TODO Auto-generated method stub

		Font font = new Font("Arial", ABORT, 27);

		JPanel mainpnl = new JPanel();
		mainpnl.setLayout(null);

		JLabel lbl = new JLabel("Choose age");
		lbl.setBounds(140, 40, 200, 60);
		lbl.setFont(font);

		JLabel lbl2 = new JLabel("Choose gender");
		lbl2.setBounds(400, 40, 200, 60);
		lbl2.setFont(font);

		JRadioButton jrb1 = new JRadioButton("Male"); // Create a radio button
		jrb1.setBounds(400, 140, 200, 60);
		jrb1.setFont(font);
		JRadioButton jrb2 = new JRadioButton("Female");
		jrb2.setBounds(400, 240, 200, 60);
		jrb2.setFont(font);
		ButtonGroup bg = new ButtonGroup();

		if (Mainjframe.user.getGender() == 0) {
			jrb2.setSelected(true);
		} else {
			jrb1.setSelected(true);
		}

		bg.add(jrb1);
		bg.add(jrb2);

		JRadioButton jrb3 = new JRadioButton("20-29 years old"); // Create a radio button
		jrb3.setBounds(140, 100, 200, 60);
		jrb3.setFont(font);
		JRadioButton jrb4 = new JRadioButton("30-39 years old");
		jrb4.setBounds(140, 160, 200, 60);
		jrb4.setFont(font);
		JRadioButton jrb5 = new JRadioButton("40-49 years old");
		jrb5.setBounds(140, 220, 200, 60);
		jrb5.setFont(font);
		JRadioButton jrb6 = new JRadioButton("50-59 years old");
		jrb6.setBounds(140, 280, 200, 60);
		jrb6.setFont(font);
		ButtonGroup bg2 = new ButtonGroup();

		switch (Mainjframe.user.getAge()) {
		case 20:
			jrb3.setSelected(true);
			break;
		case 30:
			jrb4.setSelected(true);
			break;
		case 40:
			jrb5.setSelected(true);
			break;
		case 50:
			jrb6.setSelected(true);
			break;
		}

		bg2.add(jrb3);
		bg2.add(jrb4);
		bg2.add(jrb5);
		bg2.add(jrb6);

		mainpnl.add(jrb1);
		mainpnl.add(jrb2);
		mainpnl.add(jrb3);
		mainpnl.add(jrb4);
		mainpnl.add(jrb5);
		mainpnl.add(jrb6);
		mainpnl.add(lbl);
		mainpnl.add(lbl2);

		setContentPane(mainpnl);
		setVisible(true);
		setBounds(600, 300, 640, 490);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				if(jrb1.isSelected()){
					Mainjframe.user.setGender(1);
				}else{
					Mainjframe.user.setGender(0);
				}
				if(jrb3.isSelected()){
					Mainjframe.user.setAge(20);
				}
				if(jrb4.isSelected()){
					Mainjframe.user.setAge(30);
				}
				if(jrb5.isSelected()){
					Mainjframe.user.setAge(40);
				}
				if(jrb6.isSelected()){
					Mainjframe.user.setAge(50);
				}
				
				jdbc_user.upd(Mainjframe.user);
			
			}
		});
	}

}

