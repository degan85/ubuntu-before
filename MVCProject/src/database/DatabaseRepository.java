package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseRepository implements Repository {
	private final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private final String protocol = "jdbc:derby:";
	private final String dbName = "shopdb";
	private Connection conn;
	
	public DatabaseRepository() throws Exception {
		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(protocol+dbName);
	}
	public Seller findById(String id) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Seller seller = null;
		
		try {
			String query = "select ID, name, email from seller where ID = ?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			if(!rs.next()){
				throw new SQLException("No Data Found!");
			}
			seller = new Seller(rs.getString(1),rs.getString(2),rs.getString(3));
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seller;
	}

	public void add(Seller seller) {
		// TODO Auto-generated method stub

	}

	public void update(Seller seller) {
		// TODO Auto-generated method stub

	}

	public void remove(Seller seller) {
		// TODO Auto-generated method stub

	}

}
