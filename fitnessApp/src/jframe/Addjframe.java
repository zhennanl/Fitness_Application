package jframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import data.jdbc_food;
import data.jdbc_sport;
import javabean.*;

public class Addjframe extends JFrame{
	
	public Addjframe() throws HeadlessException {
		super("Add Item");
		// TODO Auto-generated catch block

		Font font = new Font("Arial", ABORT, 27);

		JPanel mainpnl = new JPanel();
		mainpnl.setLayout(null);

		JLabel lbl = new JLabel("Select Category");
		lbl.setBounds(140, 40, 200, 60);
		lbl.setFont(font);

		JLabel lbl2 = new JLabel("Category");
		lbl2.setBounds(140, 100, 200, 60);
		lbl2.setFont(font);

		JLabel lbl3 = new JLabel("Name");
		lbl3.setBounds(140, 160, 200, 60);
		lbl3.setFont(font);

		JLabel lbl4 = new JLabel("Unit");
		lbl4.setBounds(140, 220, 200, 60);
		lbl4.setFont(font);

		JLabel lbl5 = new JLabel("Calories");
		lbl5.setBounds(140, 280, 200, 60);
		lbl5.setFont(font);

		JComboBox<String> combox = new JComboBox<String>();
		combox.addItem("Exercise");
		combox.addItem("Food");
		combox.setBounds(350, 50, 200, 40);
		combox.setFont(font);
		
		JTextField jt1=new JTextField();
		jt1.setFont(font);
		jt1.setBounds(350, 110, 200, 40);
		
		JTextField jt2=new JTextField();
		jt2.setFont(font);
		jt2.setBounds(350, 170, 200, 40);
		
		JTextField jt3=new JTextField();
		jt3.setFont(font);
		jt3.setBounds(350, 230, 200, 40);
		
		JTextField jt4=new JTextField();
		jt4.setFont(font);
		jt4.setBounds(350, 290, 200, 40);
		
		JButton jbutton = new JButton("Add");
		jbutton.setBounds(230, 350, 150, 50);
		jbutton.setBackground(Color.white);
		jbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated catch block
						
				if(combox.getSelectedIndex() == 0){
					sport spo_ = new sport(jt1.getText(), jt2.getText(), Integer.parseInt(jt4.getText()));
					jdbc_sport.upd(spo_);
					Mainjframe.list_sport.add(spo_);
					Sportjframe.type = new HashMap<>();
			        for (sport spo : Mainjframe.list_sport){
			        	
			        	if (Sportjframe.type.containsKey(spo.getType())){
			        		Sportjframe.type.get(spo.getType()).add(spo.getName());
			        	}else{
			        		List<String> list = new ArrayList<String>();
			        		list.add(spo.getName());
			        		Sportjframe.type.put(spo.getType(),list);
			        	}
			        }
			        Sportjframe.combox.removeAllItems();
					for (String name : Sportjframe.type.keySet()){
						Sportjframe.combox.addItem(name);
					}
					for (String name : Sportjframe.type.get(Sportjframe.type.keySet().iterator().next())){
						Sportjframe.combox_name.addItem(name);
					}
			        
				}else{
					food fod_ = new food(jt1.getText(), jt2.getText(),jt3.getText(), Integer.parseInt(jt4.getText()));
					jdbc_food.upd(fod_);
					Mainjframe.list_food.add(fod_);
					Foodjframe.type = new HashMap<>();
			        for (food fod : Mainjframe.list_food){
			        	
			        	if (Foodjframe.type.containsKey(fod.getType())){
			        		Foodjframe.type.get(fod.getType()).add(fod.getName());
			        	}else{
			        		List<String> list = new ArrayList<String>();
			        		list.add(fod.getName());
			        		Foodjframe.type.put(fod.getType(),list);
			        	}
			        }
			        Foodjframe.combox.removeAllItems();
					for (String name : Foodjframe.type.keySet()){
						Foodjframe.combox.addItem(name);
					}
					for (String name : Foodjframe.type.get(Foodjframe.type.keySet().iterator().next())){
						Foodjframe.combox_name.addItem(name);
					}
				}
			}
		});
		
		mainpnl.add(lbl);
		mainpnl.add(lbl2);
		mainpnl.add(lbl3);
		mainpnl.add(lbl4);
		mainpnl.add(lbl5);
		mainpnl.add(jt1);
		mainpnl.add(jt2);
		mainpnl.add(jt3);
		mainpnl.add(jt4);
		mainpnl.add(jbutton);
		mainpnl.add(combox);

		setContentPane(mainpnl);
		setVisible(true);
		setBounds(600, 300, 640, 490);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}
	
	
}
