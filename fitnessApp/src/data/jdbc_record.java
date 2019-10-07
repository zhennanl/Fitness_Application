package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabean.*;
import jframe.Mainjframe;

public class jdbc_record {

	public static List<record> getlist(){
		
		List<record> list = new ArrayList<record>();
		
		ResultSet rs = Mainjframe.db.getrs("select * from Record");
		try {
			while (rs.next()) {
				record rec = new record(rs.getInt(1), rs.getInt(2),rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
				list.add(rec);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	public static void del(int year,int mouth,int date,String name){	
		Mainjframe.db.updata("DELETE FROM record WHERE  year="+year+" and mouth="+mouth+" and date="+date+" and name = '"+name+"'");
	}	
	
	public static void add(int year,int mouth,int date,int bol,String type,String name,String num,int kcal){	
		Mainjframe.db.updata("INSERT INTO Record VALUES ("+year+","+mouth+","+date+","+bol+",'"+type+"','"+name+"',"+num+","+kcal+")");
	}	

}
