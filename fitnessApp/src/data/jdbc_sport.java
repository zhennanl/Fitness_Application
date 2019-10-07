package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabean.User;
import javabean.proposal;
import javabean.sport;
import jframe.Mainjframe;

public class jdbc_sport {

	public static void upd(sport spo){
		
		Mainjframe.db.updata("INSERT INTO sport VALUES ('"+spo.getType()+"','"+spo.getName()+"',"+spo.getKcal()+")");
		
	}
	
public static List<sport> getlist(){
		
		List<sport> list = new ArrayList<sport>();
		
		ResultSet rs = Mainjframe.db.getrs("SELECT * FROM sport");
		
		try {
			while (rs.next()) {
				sport spo = new sport(rs.getString(1), rs.getString(2), rs.getInt(3));
				list.add(spo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
}
