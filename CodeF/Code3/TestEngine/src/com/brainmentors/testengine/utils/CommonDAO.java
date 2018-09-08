package com.brainmentors.testengine.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public interface CommonDAO {
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection con = null;
		ResourceBundle rb = ResourceBundle.getBundle("config");
		
		Class.forName(rb.getString("driver"));  // throw new ClassNotFoundException()
		con = DriverManager.getConnection(rb.getString("url"),
				rb.getString("userid"), rb.getString("password"));
		return con;
	}
}
