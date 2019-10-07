package jframe;


import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Arc2D.Float;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import data.jdbc_proposal;
import data.jdbc_record;
import javabean.proposal;
import javabean.record;
import javabean.sport;

public class Statejframe extends JFrame{
	
	public static JTable table_fod = new JTable();
	public static JTable table_spo = new JTable();
	static JLabel lbl1 = new JLabel();
	static JLabel lbl2 = new JLabel();
	static JLabel lbl3 = new JLabel();
	static JLabel lbl4 = new JLabel();
	static JLabel lbl5 = new JLabel();
	static JLabel get_sporttime = new JLabel();
	
	
	static int cal_get = 0;
	static int cal_set = 0;
	Font font = new Font("Arial", ABORT, 27);
	public static JComboBox<String> combox = new JComboBox<String>();
	public static JComboBox<String> combox_name = new JComboBox<String>();
	public static Map<String,List<String>> type = new HashMap<>();
	
	
	public static void updata(){
		lbl1.setText("Date:"+Mainjframe.year+"/"+Mainjframe.mouth+"/"+Mainjframe.date);
		
		int i = 0;
		int j = 0;
		
		for (record rec: Mainjframe.list_rec){
			if (rec.getBol() == 1 && rec.getYear() == Mainjframe.year && rec.getMouth()== Mainjframe.mouth && rec.getDate()== Mainjframe.date){
				i += rec.getKcal()*rec.getNum();
			}else if (rec.getBol() == 0 && rec.getYear() == Mainjframe.year && rec.getMouth()== Mainjframe.mouth && rec.getDate()== Mainjframe.date){
				j += rec.getKcal()*rec.getNum();
			}
		}
		
		lbl2.setText("Calories Intake:"+i+"kcal");
		lbl3.setText("Calories Burned:"+j+"kcal");
		if(Mainjframe.user.getGender()==0){
			switch (Mainjframe.user.getAge()) {
			case 20:
				lbl4.setText("Calories " + Mainjframe.user.getAge()+"-year-old woman needs one day:1700kcal");
				cal_set = 1700;
				break;
			case 30:
				lbl4.setText("Calories " + Mainjframe.user.getAge()+"-year-old woman needs one day:1750kcal");
				cal_set = 1750;
				break;
			case 40:
				lbl4.setText("Calories " + Mainjframe.user.getAge()+"-year-old woman needs one day:1800kcal");
				cal_set = 1800;
				break;
			case 50:
				lbl4.setText("Calories " + Mainjframe.user.getAge()+"-year-old woman needs one day:1850kcal");
				cal_set = 1850;
				break;
			}
			
		}else{
			switch (Mainjframe.user.getAge()) {
			case 20:
				lbl4.setText("Calories " + Mainjframe.user.getAge()+"-year-old man needs one day:2000kcal");
				cal_set = 2000;
				break;
			case 30:
				lbl4.setText("Calories " + Mainjframe.user.getAge()+"-year-old man needs one day:2200kcal");
				cal_set = 2200;
				break;
			case 40:
				lbl4.setText("Calories " + Mainjframe.user.getAge()+"-year-old man needs one day:2300kcal");
				cal_set = 2300;
				break;
			case 50:
				lbl4.setText("Calories " + Mainjframe.user.getAge()+"-year-old man needs one day:2400kcal");
				cal_set = 2400;
				break;
			}
		}
		lbl5.setText("Different in Calories:"+(i-j)+"kcal");
		cal_get = i-j;
	}
	
	
	public Statejframe(){
		
		JPanel pnlmain = new JPanel();
		pnlmain.setLayout(null);
		
		JPanel pnllist = new JPanel();
		pnllist.setLayout(new GridLayout(2, 1));
		pnllist.setBounds(0, 0, 485, 600);
		pnllist.setBackground(Color.white);
		
		JPanel pnltext = new JPanel();
		pnltext.setLayout(new GridLayout(5,1));
		pnltext.setBounds(40, 600, 500, 80);
		
		JScrollPane scrollPane1 = new JScrollPane(table_spo);
		scrollPane1.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pnllist.add(scrollPane1);
        
		JScrollPane scrollPanel2 = new JScrollPane(table_fod);
		scrollPanel2.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pnllist.add(scrollPanel2);
		
		pnltext.add(lbl1);
		pnltext.add(lbl2);
		pnltext.add(lbl3);
		pnltext.add(lbl4);
		pnltext.add(lbl5);
		
//		JButton btn = new JButton("Activity Suggestion");
//		btn.setBounds(170, 300, 120, 60);
//		btn.setBackground(Color.white);
//		btn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		
		JPanel xialia_part = new JPanel();
		xialia_part.setLayout(new GridLayout(1,3));
		xialia_part.setBounds(100, 700, 300, 30);
		
		
		
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
	        
			combox.setBounds(90,65,40,20);
			xialia_part.add(combox);
			
			
			JLabel zhanwei = new JLabel();
			xialia_part.add(zhanwei);
			
			combox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					
					if(e.getStateChange() == ItemEvent.SELECTED){
						combox_name.removeAllItems();
						for (String name : type.get(e.getItem())){
							combox_name.addItem(name);
						}
						
						for (sport spo : Mainjframe.list_sport){
							if(combox.getSelectedItem().toString().equals(spo.getType())&&combox_name.getSelectedItem().toString().equals(spo.getName())){
								if (cal_get > 0 ){		
									int cal_lbl = (int) (cal_get/spo.getKcal());
									get_sporttime.setText(String.valueOf(cal_lbl));
								}else{
									get_sporttime.setText("0");
								}
								
							}
						}

					}
				}
			});
	        
			for (String name : type.get(type.keySet().iterator().next())){
				combox_name.addItem(name);
			}
			
			combox_name.setBounds(90,150,40,20);
			combox_name.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					
					if(e.getStateChange() == ItemEvent.SELECTED){
						for (sport spo : Mainjframe.list_sport){
							if(combox.getSelectedItem().toString().equals(spo.getType())&&combox_name.getSelectedItem().toString().equals(spo.getName())){
								if (cal_get > 0 ){		
									int cal_lbl = (int) (cal_get/spo.getKcal());
									get_sporttime.setText(String.valueOf(cal_lbl));
								}else{
									get_sporttime.setText("0");
								}
								
							}
						}
					}
				}
			});
			xialia_part.add(combox_name);
			
			
		
		
		JPanel down_part = new JPanel();
		down_part.setLayout(new GridLayout(1,3));
		down_part.setBounds(100, 730, 300, 30);
        
        JLabel suggest_sporttime = new JLabel("Recommended time for exercise:");
		down_part.add(suggest_sporttime);
		
		JLabel zhanwei1 = new JLabel();
		down_part.add(zhanwei1);
		
		get_sporttime = new JLabel("0");
		down_part.add(get_sporttime);
		
		
		JPanel down_button = new JPanel();
		down_button.setLayout(new GridLayout(1,3));
		down_button.setBounds(100, 760, 300, 30);
		
		
		JButton finish = new JButton("Exercise Finished");
		finish.setBounds(90,65,40,20);
		down_button.add(finish);
		finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				proposal pro = new proposal(Mainjframe.year, Mainjframe.mouth, Mainjframe.date);
				Mainjframe.list_pro.add(pro);
				jdbc_proposal.insort(pro);
				Mainjframe.update_spo();
			
			}
		});
		
		JLabel zhanwei2 = new JLabel();
		down_button.add(zhanwei2);
		
		JButton no_finish = new JButton("Exercise Unfinished");
		no_finish.setBounds(90,65,40,20);
		no_finish.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				proposal pro = new proposal(Mainjframe.year, Mainjframe.mouth, Mainjframe.date);
				for (int i=0 ; i < Mainjframe.list_pro.size();i++){
					
					proposal pro_index = Mainjframe.list_pro.get(i);
					if (pro_index.getDay() == pro.getDay() && pro_index.getMonth() == pro.getMonth()&& pro_index.getYear() == pro.getYear()){
						Mainjframe.list_pro.remove(i);
					}
				}
				jdbc_proposal.del(pro);
				Mainjframe.update_spo();
			}
		});
		down_button.add(no_finish);
		
		pnlmain.add(pnllist);
		pnlmain.add(pnltext);
//		pnlmain.add(btn);
		pnlmain.add(xialia_part);
		pnlmain.add(down_part);
		pnlmain.add(down_button);
		
		setContentPane(pnlmain);
		setBounds(700,30, 500, 900);
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
		
	}

}
