package jframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import data.jdbc;
import data.jdbc_food;
import data.jdbc_proposal;
import data.jdbc_record;
import data.jdbc_sport;
import data.jdbc_user;
import javabean.User;
import javabean.food;
import javabean.proposal;
import javabean.record;
import javabean.sport;

public class Mainjframe extends JFrame {

	/**
	 * 
	 */

	/**
	 * @throws HeadlessException
	 */
	/**
	 * @throws HeadlessException
	 */
	/**
	 * @throws HeadlessException
	 */

	public static int mouth = new Date().getMonth();
	public static int date = new Date().getDate();
	public static int year = new Date().getYear() + 1900;
	public static jdbc db = new jdbc();
	public static List<record> list_rec = jdbc_record.getlist();
	public static List<proposal> list_pro = jdbc_proposal.getlist();
	public static User user = jdbc_user.getuser();
	public static List<sport> list_sport = jdbc_sport.getlist();
	public static List<food> list_food = jdbc_food.getlist();
	public static Datajframe datajframe;
	public static Userjframe userjframe;
	public static Addjframe addjframe;
	public static Sportjframe sportjframe;
	public static Foodjframe foodjframe;
	public static Statejframe statejframe;

	public Mainjframe() throws HeadlessException {
		super("Set User Profile");
		// TODO Auto-generated method stub
		
		sportjframe = new Sportjframe();
		sportjframe.setVisible(false);
		datajframe = new Datajframe();
		datajframe.setVisible(false);
		userjframe = new Userjframe();
		userjframe.setVisible(false);
		addjframe = new Addjframe();
		addjframe.setVisible(false);
		foodjframe = new Foodjframe();
		foodjframe.setVisible(false);
		statejframe = new Statejframe();
		statejframe.setVisible(false);

		JPanel mainpnl = new JPanel();
		mainpnl.setLayout(new GridLayout(3, 2));

		JPanel datapnl = new JPanel();
		JButton btn_data_sel = new JButton("View Calendar");
		btn_data_sel.setSize(300, 200);
		btn_data_sel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				datajframe.setVisible(true);
			}
		});
		btn_data_sel.setBackground(Color.WHITE);
		datapnl.add(btn_data_sel);


		JPanel userpnl = new JPanel();
		JButton btn_user_sel = new JButton("User Info");
		btn_user_sel.setSize(300, 200);
		btn_user_sel.setBackground(Color.WHITE);
		btn_user_sel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				userjframe.setVisible(true);
			}
			
		});
		userpnl.add(btn_user_sel);

		JPanel dietpnl = new JPanel();
		JButton btn_diet_add = new JButton("Add Food");
		btn_diet_add.setSize(300, 200);
		btn_diet_add.setBackground(Color.WHITE);
		btn_diet_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				update_fod();
				foodjframe.setVisible(true);
			}
		});
		dietpnl.add(btn_diet_add);

		JPanel motionpnl = new JPanel();
		JButton btn_motion_add = new JButton("Add Exercise");
		btn_motion_add.setSize(300, 200);
		btn_motion_add.setBackground(Color.WHITE);
		btn_motion_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				update_spo();
				sportjframe.setVisible(true);
			}
		});
		motionpnl.add(btn_motion_add);

		JPanel Statepnl = new JPanel();
		JButton btn_State_sel = new JButton("Calculate Calories"); 
		btn_State_sel.setSize(300, 200);
		btn_State_sel.setBackground(Color.WHITE);
		btn_State_sel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				update_fod();
				update_spo();
				statejframe.updata();
				statejframe.setVisible(true);
			}
		});
		Statepnl.add(btn_State_sel);

		JPanel addpnl = new JPanel();
		JButton btn_add_add = new JButton("Add Activity");
		btn_add_add.setSize(300, 200);
		btn_add_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				addjframe.setVisible(true);
			}
		});
		btn_add_add.setBackground(Color.WHITE);
		addpnl.add(btn_add_add);
		

		mainpnl.add(userpnl);
		mainpnl.add(datapnl);
		mainpnl.add(dietpnl);
		mainpnl.add(motionpnl);
		mainpnl.add(Statepnl);
		mainpnl.add(addpnl);

		setContentPane(mainpnl);
		setVisible(true);
		setBounds(300, 300, 600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void update_spo(){
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		for (record rec: Mainjframe.list_rec){
			if (rec.getBol() == 0 && rec.getYear() == Mainjframe.year && rec.getMouth()== Mainjframe.mouth && rec.getDate()== Mainjframe.date){
				Vector<String> hang=new Vector<String>();
				hang.add(rec.getYear()+"/"+rec.getMouth()+"/"+rec.getDate());		
				hang.add(rec.getType());
				hang.add(rec.getName());
				hang.add(String.valueOf(rec.getNum()));
				hang.add(String.valueOf(rec.getKcal()));
				hang.add("X");
				rowData.add(hang);
			}
 	    }
		Vector<String> columnNames=new Vector<String>();
		columnNames.add("Date");
	    columnNames.add("Category");
	    columnNames.add("Name");
	    columnNames.add("Number of Sets");
	    columnNames.add("Calories");
	    columnNames.add("");
		Sportjframe.table.setModel(new DefaultTableModel(rowData, columnNames));
		Statejframe.table_spo.setModel(new DefaultTableModel(rowData, columnNames));
	}
	
	public static void update_fod(){
		Vector<Vector<String>> rowData = new Vector<Vector<String>>();
		for (record rec: Mainjframe.list_rec){
			if (rec.getBol() == 1 && rec.getYear() == Mainjframe.year && rec.getMouth()== Mainjframe.mouth && rec.getDate()== Mainjframe.date){
				Vector<String> hang=new Vector<String>();
				hang.add(rec.getYear()+"/"+rec.getMouth()+"/"+rec.getDate());		
				hang.add(rec.getType());
				hang.add(rec.getName());
				hang.add(String.valueOf(rec.getNum()));
				hang.add(String.valueOf(rec.getKcal()));
				hang.add("X");
				rowData.add(hang);
			}
		}
		Vector<String> columnNames=new Vector<String>();
		columnNames.add("Date");
		columnNames.add("Category");
		columnNames.add("Name");
		columnNames.add("Amount"); // Number for exercise
		columnNames.add("Calories");
		columnNames.add("");
		Foodjframe.table.setModel(new DefaultTableModel(rowData, columnNames));
		Statejframe.table_fod.setModel(new DefaultTableModel(rowData, columnNames));
	}

}
