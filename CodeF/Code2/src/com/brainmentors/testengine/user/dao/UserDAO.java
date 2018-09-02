package com.brainmentors.testengine.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class UserDAO {
	public static void main(String[] args)  {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// Step -1 Load a Driver
		try {
			// com.mysql.jdbc.Driver
			// oracle.jdbc.driver.OracleDriver
			ResourceBundle rb = ResourceBundle.getBundle("config");
		//Class.forName("org.postgresql.Driver");  // throw new ClassNotFoundException()
		Class.forName(rb.getString("driver"));
			System.out.println("Driver Loaded...");
		// Step -2 Create Connection
		
		
		// url = jdbc:postgresql://<database_host>:<port>/<database_name>
		// url = jdbc:mysql://hostname:3306/dbname
		// url = jdbc:oracle:thin:@localhost:1521:SID
		
		con = DriverManager.getConnection(rb.getString("url"),
				rb.getString("userid"), rb.getString("password"));
		if(con!=null) {
			System.out.println("Connection Created...");
		}
		// DB Query
		 pstmt = con.prepareStatement("select * from users");
		 rs = pstmt.executeQuery();
		while(rs.next()) {
			System.out.println("Userid "+rs.getString("userid")
			+" Password "+rs.getString("password"));
		}
		
		}
		
		catch(ClassNotFoundException e) {
			System.out.println("Contact to System Admin ....");
		}
		catch(SQLException e) {
			System.out.println("DB Level Problem ");
		}
		catch(Exception e) {
			System.out.println("Some Mis Problem Start.");
		}
		finally {
			try {
				if(rs!=null) {
			rs.close();
				}
				if(pstmt!=null) {
			pstmt.close();
				}
				if(con!=null) {
			con.close();
				}
			}
			catch(SQLException e) {
				System.out.println("Exception During Close");
			}
		}
	}

}
