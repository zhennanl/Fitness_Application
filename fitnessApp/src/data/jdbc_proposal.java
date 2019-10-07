package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabean.proposal;
import jframe.Mainjframe;

public class jdbc_proposal {

	public static List<proposal> getlist() {

		List<proposal> list = new ArrayList<proposal>();
		ResultSet rs = Mainjframe.db.getrs("SELECT * FROM proposal");
		try {
			while (rs.next()) {
				proposal pro = new proposal(rs.getInt(1), rs.getInt(2), rs.getInt(3));
				list.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static void insort(proposal pro) {
			
			Mainjframe.db.updata("INSERT INTO proposal VALUES ("+pro.getYear()+","+pro.getMonth()+","+pro.getDay()+")");
			
	}
	
	public static void del(proposal pro){	
		
		Mainjframe.db.updata("DELETE FROM proposal WHERE  year="+pro.getYear()+" and mouth="+pro.getMonth()+" and date="+pro.getDay());
		
	}	
	
}
