package data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabean.food;
import javabean.proposal;
import javabean.sport;
import jframe.Mainjframe;

public class jdbc_food {

	public static void upd(food fod){
		
		Mainjframe.db.updata("INSERT INTO food VALUES ('"+fod.getType()+"','"+fod.getName()+"','"+fod.getUnit()+"',"+fod.getKcal()+")");
			
	}
	
public static List<food> getlist(){
		
		List<food> list = new ArrayList<food>();
		
		ResultSet rs = Mainjframe.db.getrs("SELECT * FROM food");
		try {
			while (rs.next()) {
				food fod = new food(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(fod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
}
