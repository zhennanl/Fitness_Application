package data;

import java.sql.ResultSet;
import java.sql.SQLException;

import javabean.User;
import jframe.Mainjframe;

public class jdbc_user {

public static User getuser(){
				
		ResultSet rs = Mainjframe.db.getrs("select * from user");
		try {
			rs.next();
			User user = new User(rs.getString(1), rs.getInt(2), rs.getInt(3));
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
public static void upd(User user){
	
	Mainjframe.db.updata("UPDATE user set age = "+user.getAge()+", gender = "+user.getGender());

}
	
}
