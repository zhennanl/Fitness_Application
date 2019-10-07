package jframe;


import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

import Main.Main;
import javabean.proposal;
import javabean.record;


public class Datajframe extends JFrame{
	
    /**
     * 
     */
	
	
    private static final long serialVersionUID = 1193245796699646333L;
    private JPanel imagePanel,datePanel,p,p2,p3;
    private JLabel label,l,l2,l3,l4,l5,l6;
    private ImageIcon background;
    private JButton b,b2;
    private JTextField t;
    private JComboBox<String> month_list = new JComboBox<String>();
    private JComboBox<String> day_list = new JComboBox<String>();
    private Font f = new Font("Arial",Font.PLAIN,15);
    private String columns[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    private Date now = new Date();
    private JLabel[] day = new JLabel[42];
    
    public Datajframe(){
        super("Calendar");
        setSize(620,490);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        
        
        
        //Add background image
        background = new ImageIcon("background.jpg");  
        label = new JLabel(background);  
        label.setBounds(0, 0, this.getWidth(), this.getHeight());   
        imagePanel = (JPanel) this.getContentPane();  
        imagePanel.setOpaque(false);  
        this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));  
        
        //Set layout
        l = new JLabel();
        l.setFont(new Font("Arial",Font.ITALIC,40));
        l.setForeground(Color.red);//Set font color
        add(l);
        l.setBounds(5, 5, 80, 45);
        l2 = new JLabel();
        l2.setFont(new Font("Arial",Font.BOLD,20));
        l2.setForeground(Color.red);
        add(l2);
        l2.setBounds(90, 10, 150, 40);
        l3 = new JLabel();
        l3.setFont(new Font("Arial",Font.BOLD,30));
        l3.setForeground(Color.red);
        add(l3);
        l3.setBounds(500, 17, 100, 30);
        
        p = new JPanel();
        add(p);
        p.setBounds(5, 45, 600, 2);
        p.setBorder(BorderFactory.createLineBorder(Color.black));
        
        l4 = new JLabel("Year: ");
        add(l4);
        l4.setBounds(10, 50, 80, 20);
        l4.setFont(f);
        t = new JTextField();
        add(t);
        t.setBounds(60, 50, 60, 20);
        t.setFont(f);
        
        l5 = new JLabel("Month: ");
        add(l5);
        l5.setBounds(130, 50, 80, 20);
        l5.setFont(f);
        l6 = new JLabel("Date: ");
        add(l6);
        l6.setBounds(270, 50, 80, 20);
        l6.setFont(f);
        add(month_list);
        month_list.setBounds(180, 50, 70, 20);
        month_list.setFont(f);
        month_list.setOpaque(false);
        add(day_list);
        day_list.setBounds(320, 50, 70, 20);
        day_list.setFont(f);
        day_list.setOpaque(false);
        
        for(int i = 0;i < 12;i++)
        {
            month_list.addItem(columns[i]);
        }
        
        t.setText("" + Mainjframe.year);
        
        b = new JButton(" Month");
        add(b);
        b.setBounds(430, 50, 80, 20);
        b.setFont(f);
        b.setOpaque(false);
        b2 = new JButton("Next Month");
        add(b2);
        b2.setBounds(520, 50, 80, 20);
        b2.setFont(f);
        b2.setOpaque(false);
        
        p2 = new JPanel();
        add(p2);
        p2.setBounds(15, 85, 580, 1);
        p2.setBorder(BorderFactory.createLineBorder(Color.blue));
        
        p3 = new JPanel();
        p3.setOpaque(false);
        add(p3);
        p3.setBounds(5, 90, 600, 20);
        p3.setLayout(new GridLayout(1,7,2,2));
        JLabel[] week = new JLabel[7];
        week[0] = new JLabel("       SUN");
        week[1] = new JLabel("       MON");
        week[2] = new JLabel("       TUE");
        week[3] = new JLabel("       WED");
        week[4] = new JLabel("        THU");
        week[5] = new JLabel("         FRI");
        week[6] = new JLabel("         SAT");
        for(int i = 0;i < 7;i++)
        {
            week[i].setForeground(Color.black);//Set font color
            week[i].setFont(f);
            p3.add(week[i]);
        }
        
        
        datePanel = new JPanel();
        datePanel.setOpaque(false);
        add(datePanel);
        datePanel.setBounds(5, 110, 610, 340);
        datePanel.setLayout(new GridLayout(6,7,2,5));
        
        for(int i = 0;i < 42;i++)
        {
            day[i] = new JLabel("");
            day[i].setForeground(Color.red);//Set font color
            //day[i].setBorder(BorderFactory.createLineBorder(Color.black));
            day[i].setFont(new Font("Jokerman",Font.BOLD,15));
            datePanel.add(day[i]);
        }
        
        Calendar cale = null;
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        int dow = cale.get(Calendar.DAY_OF_WEEK);//Get what day is the first day of the month

        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        int maxDate = cale.get(Calendar.DAY_OF_MONTH);//Get how many days in this month
        
        int today = Mainjframe.date;
        
        for(int i = 0;i < maxDate;i++)
        {
        	day_list.addItem(String.valueOf(i+1));
        }
        day_list.setSelectedIndex( today-1);
        
        int ptr = 1;
        int ptr2 = dow -1;
        int m = Mainjframe.mouth + 1;
        month_list.setSelectedIndex( m-1);
        
        for(int i = 0;i < maxDate;i++)
        {
            day[ptr2].setText("     " + ptr);
            for (record rec : Mainjframe.list_rec){
            	
            	if (rec.getYear() == Integer.valueOf(t.getText()).intValue() && rec.getMouth() == month_list.getSelectedIndex()+1 && rec.getDate() == ptr){
            		day[ptr2].setForeground(Color.BLUE);
            	}
            	
            }
            for (proposal pro : Mainjframe.list_pro){
            	
            	if (pro.getYear() == Integer.valueOf(t.getText()).intValue() && pro.getMonth() == month_list.getSelectedIndex()+1 && pro.getDay() == ptr){
            		day[ptr2].setForeground(Color.green);
            	}
            	
            }
            if(ptr == today)
            {
                day[ptr2].setForeground(Color.black);
                day[ptr2].setFont(new Font("Jokerman",Font.BOLD,20));
                day[ptr2].setText("  " + ptr);
                day[ptr2].setBorder(BorderFactory.createLineBorder(new Color(220,20,60)));
            }
            ptr++;
            ptr2++;
        }
        
        //Initialize information on top
        
        l.setText("" + m);
        //Set the selected month of the drop-down list as the current month
        
        
        switch (m) {
        case 1:
            l2.setText("January");
            break;
        case 2:
            l2.setText("February");
            break;
        case 3:
            l2.setText("March");
            break;
        case 4:
            l2.setText("April");
            break;
        case 5:
            l2.setText("May");
            break;
        case 6:
            l2.setText("June");
            break;
        case 7:
            l2.setText("July");
            break;
        case 8:
            l2.setText("August");
            break;
        case 9:
            l2.setText("September");
            break;
        case 10:
            l2.setText("October");
            break;
        case 11:
            l2.setText("November");
            break;
        case 12:
            l2.setText("December");
            break;
        }
        
        
        
        int y = Mainjframe.year;
        l3.setText("" + y);
        
        
        //Add listeners
        month_list.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent e){
                    Calendar cale = null;
                    String year;
                    boolean flag = true;
                    if(e.getStateChange() == ItemEvent.SELECTED)
                    {
                        year = t.getText();
                        if(year.equals(""))
                        {
                            JOptionPane.showMessageDialog(null,"Year cannot be empty!");
                        }
                        else
                        {
                            for(int i = 0;i < year.length();i++)
                            {
                                if(year.charAt(i) >= 48 && year.charAt(i) <= 57){}
                                else
                                {
                                    JOptionPane.showMessageDialog(null,"Please enter the year in the correct format!");
                                    flag = false;
                                    break;
                                }
                            }
                            
                            if(flag)
                            {
                                String date = "";
                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                int y = Integer.valueOf(year).intValue();
                                int m = month_list.getSelectedIndex() + 1;
                                cale = Calendar.getInstance();
                                date = "" + year + "-" + m + "-" + 1;
                                try {
                                    cale.setTime(format.parse(date));
                                } catch (ParseException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                }
                                int dow = cale.get(Calendar.DAY_OF_WEEK);//Get what day is the first day of the month
                                
                                cale.roll(Calendar.DATE, -1);//Date rolls back one day, which represents the last day
                                int maxDate = cale.get(Calendar.DAY_OF_MONTH);//Get how many days in this month
                                int ptr = 1;
                                int ptr2 = dow -1;
                                int today = day_list.getSelectedIndex()+1;
                                //Reset everything; get new input
                                for(int i = 0;i < 42;i++)
                                {
                                    day[i].setText("");
                                    day[i].setForeground(Color.red);//Set font color
                                    day[i].setFont(new Font("Jokerman",Font.BOLD,15));
                                    day[i].setBorder(null);
                                }
                                
                                for(int i = 0;i < maxDate;i++)
                                {
                                    day[ptr2].setText("     " + ptr);
                                    for (record rec : Mainjframe.list_rec){
                                    	
                                    	if (rec.getYear() == Integer.valueOf(t.getText()).intValue() && rec.getMouth() == month_list.getSelectedIndex()+1 && rec.getDate() == ptr){
                                    		day[ptr2].setForeground(Color.BLUE);
                                    	}
                                    	
                                    }
                                    for (proposal pro : Mainjframe.list_pro){
                                    	
                                    	if (pro.getYear() == Integer.valueOf(t.getText()).intValue() && pro.getMonth() == month_list.getSelectedIndex()+1 && pro.getDay() == ptr){
                                    		day[ptr2].setForeground(Color.green);
                                    	}
                                    	
                                    }
                                    if(ptr == today)
                                    {
                                        if(y == Mainjframe.year && m == month_list.getSelectedIndex() +1)
                                        {
                                            day[ptr2].setForeground(Color.black);
                                            day[ptr2].setFont(new Font("Jokerman",Font.BOLD,20));
                                            day[ptr2].setText("  " + ptr);
                                            day[ptr2].setBorder(BorderFactory.createLineBorder(new Color(220,20,60)));
                                        }
                                    }
                                    ptr++;
                                    ptr2++;
                                }
                                
                                //Reset l, l2, l3 information
                                l.setText("" + m);                            
                                switch (m) {
                                case 1:
                                    l2.setText("January");
                                    break;
                                case 2:
                                    l2.setText("February");
                                    break;
                                case 3:
                                    l2.setText("March");
                                    break;
                                case 4:
                                    l2.setText("April");
                                    break;
                                case 5:
                                    l2.setText("May");
                                    break;
                                case 6:
                                    l2.setText("June");
                                    break;
                                case 7:
                                    l2.setText("July");
                                    break;
                                case 8:
                                    l2.setText("August");
                                    break;
                                case 9:
                                    l2.setText("September");
                                    break;
                                case 10:
                                    l2.setText("October");
                                    break;
                                case 11:
                                    l2.setText("November");
                                    break;
                                case 12:
                                    l2.setText("December");
                                    break;
                                }
                                l3.setText("" + y);
                            }
                        }
                    }
                }
         });
        day_list.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                Calendar cale = null;
                String year;
                boolean flag = true;
                if(e.getStateChange() == ItemEvent.SELECTED)
                {
                    year = t.getText();
                    if(year.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Year cannot be empty!");
                    }
                    else
                    {
                        for(int i = 0;i < year.length();i++)
                        {
                            if(year.charAt(i) >= 48 && year.charAt(i) <= 57){}
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Please enter the year in the correct format!");
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag)
                        {
                            String date = "";
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            int y = Integer.valueOf(year).intValue();
                            int m = month_list.getSelectedIndex() + 1;
                            cale = Calendar.getInstance();
                            date = "" + year + "-" + m + "-" + 1;
                            try {
                                cale.setTime(format.parse(date));
                            } catch (ParseException e1) {
                            	// TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            int dow = cale.get(Calendar.DAY_OF_WEEK);//Get what day is the first day of the month
                            
                            cale.roll(Calendar.DATE, -1);//Date rolls back one day, which represents the last day
                            int maxDate = cale.get(Calendar.DAY_OF_MONTH);//Get how many days in this month
                            int ptr = 1;
                            int ptr2 = dow -1;
                            int today = day_list.getSelectedIndex()+1;
                            //Reset everything; get new input
                            for(int i = 0;i < 42;i++)
                            {
                                day[i].setText("");
                                day[i].setForeground(Color.red);//Set font color
                                day[i].setFont(new Font("Jokerman",Font.BOLD,15));
                                day[i].setBorder(null);
                            }
                            
                            for(int i = 0;i < maxDate;i++)
                            {
                                day[ptr2].setText("     " + ptr);
                                for (record rec : Mainjframe.list_rec){
                                	
                                	if (rec.getYear() == Integer.valueOf(t.getText()).intValue() && rec.getMouth() == month_list.getSelectedIndex()+1 && rec.getDate() == ptr){
                                		day[ptr2].setForeground(Color.BLUE);
                                	}
                                	
                                }
                                for (proposal pro : Mainjframe.list_pro){
                                	
                                	if (pro.getYear() == Integer.valueOf(t.getText()).intValue() && pro.getMonth() == month_list.getSelectedIndex()+1 && pro.getDay() == ptr){
                                		day[ptr2].setForeground(Color.green);
                                	}
                                	
                                }
                                if(ptr == today)
                                {
                                    if(y == Mainjframe.year && m == month_list.getSelectedIndex() +1)
                                    {
                                        day[ptr2].setForeground(Color.black);
                                        day[ptr2].setFont(new Font("Jokerman",Font.BOLD,20));
                                        day[ptr2].setText("  " + ptr);
                                        day[ptr2].setBorder(BorderFactory.createLineBorder(new Color(220,20,60)));
                                    }
                                }
                                ptr++;
                                ptr2++;
                            }
                            
                            //Reset l, l2, l3 information
                            l.setText("" + m);                            
                            switch (m) {
                            case 1:
                                l2.setText("January");
                                break;
                            case 2:
                                l2.setText("February");
                                break;
                            case 3:
                                l2.setText("March");
                                break;
                            case 4:
                                l2.setText("April");
                                break;
                            case 5:
                                l2.setText("May");
                                break;
                            case 6:
                                l2.setText("June");
                                break;
                            case 7:
                                l2.setText("July");
                                break;
                            case 8:
                                l2.setText("August");
                                break;
                            case 9:
                                l2.setText("September");
                                break;
                            case 10:
                                l2.setText("October");
                                break;
                            case 11:
                                l2.setText("November");
                                break;
                            case 12:
                                l2.setText("December");
                                break;
                            }
                            l3.setText("" + y);
                        }
                    }
                }
            }
     });
        // month
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Calendar cale = null;
                String year;
                boolean flag = true;
                
                year = t.getText();
                if(year.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Year cannot be empty!");
                }
                else
                {
                    for(int i = 0;i < year.length();i++)
                    {
                        if(year.charAt(i) >= 48 && year.charAt(i) <= 57){}
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Please enter the year in the correct format!");
                            flag = false;
                            break;
                        }
                    }
                    
                    if(flag)
                    {
                        String date = "";
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        int y = Integer.valueOf(t.getText()).intValue();
                        int m = month_list.getSelectedIndex();
                        if(m==0)
                        {
                            m = 12;//The month before January is December 
                            y -= 1;//Previous year
                        }
                        cale = Calendar.getInstance();
                        date = "" + year + "-" + m + "-" + 1;
                        try {
                            cale.setTime(format.parse(date));
                        } catch (ParseException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        int dow = cale.get(Calendar.DAY_OF_WEEK);//Get what day is the first day of the month
                        
                        cale.roll(Calendar.DATE, -1);//Date rolls back one day, which represents the last day
                        int maxDate = cale.get(Calendar.DAY_OF_MONTH);//Get how many days in this month
                        int ptr = 1;
                        int ptr2 = dow -1;
                        int today = day_list.getSelectedIndex()+1;
                        //Reset l, l2, l3 information
                        for(int i = 0;i < 42;i++)
                        {
                            day[i].setText("");
                            day[i].setForeground(Color.red);//Set font color
                            day[i].setFont(new Font("Jokerman",Font.BOLD,15));
                            day[i].setBorder(null);
                        }
                        
                        for(int i = 0;i < maxDate;i++)
                        {
                            day[ptr2].setText("     " + ptr);
                            for (record rec : Mainjframe.list_rec){
                            	
                            	if (rec.getYear() == Integer.valueOf(t.getText()).intValue() && rec.getMouth() == month_list.getSelectedIndex()+1 && rec.getDate() == ptr){
                            		day[ptr2].setForeground(Color.BLUE);
                            	}
                            	
                            }
                            for (proposal pro : Mainjframe.list_pro){
                            	
                            	if (pro.getYear() == Integer.valueOf(t.getText()).intValue() && pro.getMonth() == month_list.getSelectedIndex()+1 && pro.getDay() == ptr){
                            		day[ptr2].setForeground(Color.green);
                            	}
                            	
                            }
                            if(ptr == today)
                            {
                                if(y == now.getYear() + 1900 && m == month_list.getSelectedIndex()+1)
                                {
                                    day[ptr2].setForeground(Color.black);
                                    day[ptr2].setFont(new Font("Jokerman",Font.BOLD,20));
                                    day[ptr2].setText("  " + ptr);
                                    day[ptr2].setBorder(BorderFactory.createLineBorder(new Color(220,20,60)));
                                }
                            }
                            ptr++;
                            ptr2++;
                        }
                        
                        //Reset l, l2, l3 information
                        t.setText("" + y);
                        l.setText("" + m);
                        //Set the selected month of the drop-down list to the current month
                        month_list.setSelectedIndex( m-1 );
                        switch (m) {
                        case 1:
                            l2.setText("January");
                            break;
                        case 2:
                            l2.setText("February");
                            break;
                        case 3:
                            l2.setText("March");
                            break;
                        case 4:
                            l2.setText("April");
                            break;
                        case 5:
                            l2.setText("May");
                            break;
                        case 6:
                            l2.setText("June");
                            break;
                        case 7:
                            l2.setText("July");
                            break;
                        case 8:
                            l2.setText("August");
                            break;
                        case 9:
                            l2.setText("September");
                            break;
                        case 10:
                            l2.setText("October");
                            break;
                        case 11:
                            l2.setText("November");
                            break;
                        case 12:
                            l2.setText("December");
                            break;
                        }
                        l3.setText("" + y);
                    }
                }         
            }
        });
        
        //Next month
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Calendar cale = null;
                String year;
                boolean flag = true;
                
                year = t.getText();
                if(year.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Year cannot be empty!");
                }
                else
                {
                    for(int i = 0;i < year.length();i++)
                    {
                        if(year.charAt(i) >= 48 && year.charAt(i) <= 57){}
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Please enter the year in the correct format!");
                            flag = false;
                            break;
                        }
                    }
                    
                    if(flag)
                    {
                        String date = "";
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        int y = Integer.valueOf(year).intValue();
                        int m = month_list.getSelectedIndex();
                        if(m==11)
                        {
                            m = 1;//The month before January is December 
                            y += 1;//Previous year
                        }
                        else
                        {
                            m +=2;
                        }

                        cale = Calendar.getInstance();
                        date = "" + year + "-" + m + "-" + 1;
                        try {
                            cale.setTime(format.parse(date));
                        } catch (ParseException e1) {
                            // TODO Auto-generated catch block
                            e1.printStackTrace();
                        }
                        int dow = cale.get(Calendar.DAY_OF_WEEK);//Get what day is the first day of the month

                        
                        cale.roll(Calendar.DATE, -1);//Date rolls back one day, which represents the last day
                        int maxDate = cale.get(Calendar.DAY_OF_MONTH);//Get how many days in this month

                        int ptr = 1;
                        int ptr2 = dow -1;
                        int today = day_list.getSelectedIndex()+1;
                        //Reset everything; get new input
                        for(int i = 0;i < 42;i++)
                        {
                            day[i].setText("");
                            day[i].setForeground(Color.red);//Set font color
                            day[i].setFont(new Font("Jokerman",Font.BOLD,15));
                            day[i].setBorder(null);
                        }
                        
                        for(int i = 0;i < maxDate;i++)
                        {
                            day[ptr2].setText("     " + ptr);
                            for (record rec : Mainjframe.list_rec){
                            	
                            	if (rec.getYear() == Integer.valueOf(t.getText()).intValue() && rec.getMouth() == month_list.getSelectedIndex()+1 && rec.getDate() == ptr){
                            		day[ptr2].setForeground(Color.BLUE);
                            	}
                            	
                            }
                            for (proposal pro : Mainjframe.list_pro){
                            	
                            	if (pro.getYear() == Integer.valueOf(t.getText()).intValue() && pro.getMonth() == month_list.getSelectedIndex()+1 && pro.getDay() == ptr){
                            		day[ptr2].setForeground(Color.green);
                            	}
                            	
                            }
                            if(ptr == today)
                            {
                                if(y == now.getYear() + 1900 && m == month_list.getSelectedIndex() +1)
                                {
                                    day[ptr2].setForeground(Color.black);
                                    day[ptr2].setFont(new Font("Jokerman",Font.BOLD,20));
                                    day[ptr2].setText("  " + ptr);
                                    day[ptr2].setBorder(BorderFactory.createLineBorder(new Color(220,20,60)));
                                }
                            }
                            ptr++;
                            ptr2++;
                        }
                        
                        //Reset l, l2, l3 information
                        t.setText("" + y);
                        l.setText("" + m);
                        //Set the selected month of the drop-down list to the current month
                        month_list.setSelectedIndex( m-1 );
                        switch (m) {
                        case 1:
                            l2.setText("January");
                            break;
                        case 2:
                            l2.setText("February");
                            break;
                        case 3:
                            l2.setText("March");
                            break;
                        case 4:
                            l2.setText("April");
                            break;
                        case 5:
                            l2.setText("May");
                            break;
                        case 6:
                            l2.setText("June");
                            break;
                        case 7:
                            l2.setText("July");
                            break;
                        case 8:
                            l2.setText("August");
                            break;
                        case 9:
                            l2.setText("September");
                            break;
                        case 10:
                            l2.setText("October");
                            break;
                        case 11:
                            l2.setText("November");
                            break;
                        case 12:
                            l2.setText("December");
                            break;
                        }
                        l3.setText("" + y);
                    }
                } 
            }
        });
        
        this.addKeyListener(new KeyMonitor());
        p3.addKeyListener(new KeyMonitor());
        t.addKeyListener(new KeyMonitor());
        imagePanel.setFocusable(true);
        imagePanel.addKeyListener(new KeyMonitor());
        b.addKeyListener(new KeyMonitor());
        b2.addKeyListener(new KeyMonitor());
        month_list.addKeyListener(new KeyMonitor());
        setVisible(false);
        Mainjframe.date = day_list.getSelectedIndex()+1;
        Mainjframe.mouth = month_list.getSelectedIndex()+1;
        Mainjframe.year = Integer.valueOf(t.getText()).intValue();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                Mainjframe.date = day_list.getSelectedIndex()+1;
                Mainjframe.mouth = month_list.getSelectedIndex()+1;
                Mainjframe.year = Integer.valueOf(t.getText()).intValue();
            }
        });
    }
    
    class KeyMonitor extends KeyAdapter{
        public void keyPressed(KeyEvent e){
               int key = e.getKeyCode();
               if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
               {
                   Calendar cale = null;
                    String year;
                    boolean flag = true;
                    
                    year = t.getText();
                    if(year.equals(""))
                    {
                        JOptionPane.showMessageDialog(null,"Year cannot be empty!");
                    }
                    else
                    {
                        for(int i = 0;i < year.length();i++)
                        {
                            if(year.charAt(i) >= 48 && year.charAt(i) <= 57){}
                            else
                            {
                                JOptionPane.showMessageDialog(null,"Please enter the year in the correct format!");
                                flag = false;
                                break;
                            }
                        }
                        
                        if(flag)
                        {
                            String date = "";
                            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                            int y = Integer.valueOf(t.getText()).intValue();
                            int m = month_list.getSelectedIndex();
                            
                            if(key == KeyEvent.VK_LEFT)//Previous month
                            {
                                if(m==0)
                                {
                                    m = 12;//The month before January is December 
                                    y -= 1;//Previous year
                                }
                            }
                            else if(key == KeyEvent.VK_RIGHT)//Next month
                            {
                                if(m==11)
                                {
                                    m = 1;//The month before January is December 
                                    y += 1;//Next year
                                }
                                else
                                {
                                    m +=2;
                                }
                            }    
                            

                            cale = Calendar.getInstance();
                            date = "" + year + "-" + m + "-" + 1;
                            try {
                                cale.setTime(format.parse(date));
                            } catch (ParseException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            int dow = cale.get(Calendar.DAY_OF_WEEK);//Get what day is the first day of the month

                            
                            cale.roll(Calendar.DATE, -1);//Date rolls back one day, which represents the last day
                            int maxDate = cale.get(Calendar.DAY_OF_MONTH);//Get how many days in this month

                            int ptr = 1;
                            int ptr2 = dow -1;
                            int today = day_list.getSelectedIndex()+1;
                            //Reset everything; get new input
                            for(int i = 0;i < 42;i++)
                            {
                                day[i].setText("");
                                day[i].setForeground(Color.red);//Set font color
                                day[i].setFont(new Font("Jokerman",Font.BOLD,15));
                                day[i].setBorder(null);
                            }
                            
                            for(int i = 0;i < maxDate;i++)
                            {
                                day[ptr2].setText("     " + ptr);
                                for (record rec : Mainjframe.list_rec){
                                	
                                	if (rec.getYear() == Integer.valueOf(t.getText()).intValue() && rec.getMouth() == month_list.getSelectedIndex()+1 && rec.getDate() == ptr){
                                		day[ptr2].setForeground(Color.BLUE);
                                	}
                                	
                                }
                                for (proposal pro : Mainjframe.list_pro){
                                	
                                	if (pro.getYear() == Integer.valueOf(t.getText()).intValue() && pro.getMonth() == month_list.getSelectedIndex()+1 && pro.getDay() == ptr){
                                		day[ptr2].setForeground(Color.green);
                                	}
                                	
                                }
                                if(ptr == today)
                                {
                                    if(y == now.getYear() + 1900 && m == month_list.getSelectedIndex()+1)
                                    {
                                        day[ptr2].setForeground(Color.black);
                                        day[ptr2].setFont(new Font("Jokerman",Font.BOLD,20));
                                        day[ptr2].setText("  " + ptr);
                                        day[ptr2].setBorder(BorderFactory.createLineBorder(new Color(220,20,60)));
                                    }
                                }
                                ptr++;
                                ptr2++;
                            }
                            
                            //Reset l, l2, l3 information
                            t.setText("" + y);
                            l.setText("" + m);
                            //Set the selected month of the drop-down list to the current month
//                            if(key == KeyEvent.VK_LEFT)//Previous month
//                            {
//                                
//                            }
//                            else if(key == KeyEvent.VK_RIGHT)//Next month
//                            {
//                                
//                            }
                            month_list.setSelectedIndex( m-1 );
                            switch (m) {
                            case 1:
                                l2.setText("January");
                                break;
                            case 2:
                                l2.setText("February");
                                break;
                            case 3:
                                l2.setText("March");
                                break;
                            case 4:
                                l2.setText("April");
                                break;
                            case 5:
                                l2.setText("May");
                                break;
                            case 6:
                                l2.setText("June");
                                break;
                            case 7:
                                l2.setText("July");
                                break;
                            case 8:
                                l2.setText("August");
                                break;
                            case 9:
                                l2.setText("September");
                                break;
                            case 10:
                                l2.setText("October");
                                break;
                            case 11:
                                l2.setText("November");
                                break;
                            case 12:
                                l2.setText("December");
                                break;
                            }
                            l3.setText("" + y);
                        }
                    } 
               }
              
           }
        
    }
    
}