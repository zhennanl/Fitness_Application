package jframe;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import data.jdbc_record;
import data.jdbc_user;
import javabean.record;
import javabean.sport;

public class Sportjframe extends JFrame {

	public static JTable table;
	public static JComboBox<String> combox = new JComboBox<String>();
	public static JComboBox<String> combox_name = new JComboBox<String>();
	public static Map<String,List<String>> type = new HashMap<>();
	
	public Sportjframe(){
		setLayout(null);
		
		Font font = new Font("Arial", ABORT, 27);
		
		JPanel pnlm = new JPanel();
		pnlm.setLayout(null);
		pnlm.setBounds(285, 15, 620, 500);
		pnlm.setBackground(Color.white);
		
		table = new JTable();
		JScrollPane scrollPane1 = new JScrollPane(table);
		scrollPane1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.setBounds(0, 0, 620, 500);
        pnlm.add(scrollPane1);
        
        JPanel pnlleft = new JPanel();
        pnlleft.setBounds(0, 0, 300, 572);
        pnlleft.setLayout(null);
        
        
        for (sport spo : Mainjframe.list_sport){
        	
        	if (type.containsKey(spo.getType())){
        		type.get(spo.getType()).add(spo.getName());
        	}else{
        		List<String> list = new ArrayList<String>();
        		list.add(spo.getName());
        		type.put(spo.getType(),list);
        	}
        }
        
        
        for (String name : type.keySet()){
        	combox.addItem(name);
        }
        
		combox.setBounds(90,65,155,50);
		combox.setFont(font);
		pnlleft.add(combox);
		combox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				if(e.getStateChange() == ItemEvent.SELECTED){
					combox_name.removeAllItems();
					for (String name : type.get(e.getItem())){
						combox_name.addItem(name);
					}
					
				}
			}
		});
        
		for (String name : type.get(type.keySet().iterator().next())){
			combox_name.addItem(name);
		}
		
		combox_name.setBounds(90,150,155,50);
		combox_name.setFont(font);
		pnlleft.add(combox_name);
        
        JTextField txt1 = new JTextField(200);
        txt1.setBounds(90, 235, 155, 50);
        pnlleft.add(txt1);
        
        JLabel lbl1 = new JLabel("Category: ");
        lbl1.setBounds(15,65,155,50);
        lbl1.setFont(font);
        pnlleft.add(lbl1);
        
        JLabel lbl2 = new JLabel("Name: ");
        lbl2.setBounds(15,150,155,50);
        lbl2.setFont(font);
        pnlleft.add(lbl2);
        
        JLabel lbl3 = new JLabel("Number of Sets: ");
        lbl3.setBounds(15,235,155,50);
        lbl3.setFont(font);
        pnlleft.add(lbl3);
        
        
        
        JButton btn1 = new JButton("Save record");
        btn1.setBackground(Color.white);
        btn1.setBounds(90, 340, 100, 50);
        btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				for (sport spo : Mainjframe.list_sport){
					if(combox.getSelectedItem().toString().equals(spo.getType())&&combox_name.getSelectedItem().toString().equals(spo.getName())){
						record rec = new record(Mainjframe.year, Mainjframe.mouth, Mainjframe.date, 0, spo.getType(), spo.getName(), Integer.parseInt(txt1.getText()), spo.getKcal());
						jdbc_record.add(Mainjframe.year, Mainjframe.mouth, Mainjframe.date, 0, spo.getType(), spo.getName(), txt1.getText(), spo.getKcal());
						Mainjframe.list_rec.add(rec);
						Mainjframe.update_spo();
					}
				}
				
				JOptionPane.showMessageDialog(null, "Exercise Added!");
			}
		});
        pnlleft.add(btn1);  
        
        JButton btn2 = new JButton("Add Item");
        btn2.setBackground(Color.white);
        btn2.setBounds(90, 430, 100, 50);
        btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Mainjframe.addjframe.setVisible(true);
			}
		});
        pnlleft.add(btn2);    
        
        table.addMouseListener(new MouseListener() {
				
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(table.getSelectedColumn()==5){
					int n = JOptionPane.showConfirmDialog(null, "Are you sure to delete this record?", "Delete",JOptionPane.YES_NO_OPTION);

					if (n==0){
						jdbc_record.del(Mainjframe.year, Mainjframe.mouth, Mainjframe.date, table.getValueAt(table.getSelectedRow(),2).toString());
						Mainjframe.list_rec = jdbc_record.getlist();
						Mainjframe.update_spo();
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});
        
		getContentPane().add(pnlm);
		getContentPane().add(pnlleft);
		setBounds(600,300, 930, 572);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
}

}