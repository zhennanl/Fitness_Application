package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {

	Connection con = null;
	Statement stmt; // Create statement

	public jdbc() {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:./kcal.db", null, null);
			System.out.print("Connection Successful!");
			stmt = con.createStatement();
		} catch (Exception e) {
			System.out.print("ERROR:" + e.getMessage());
		}
	}

	public ResultSet getrs(String sql) {
		System.out.println(sql);
		try {
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	public boolean updata(String sql) {
		System.out.println(sql);
		try {
			if (stmt.executeUpdate(sql) > 0) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public boolean close() {
		try {
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
