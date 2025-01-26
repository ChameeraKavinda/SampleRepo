package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private  static final String DB_URL="jdbc:mysql://localhost:3306/?user=root";
	private static final String DB_USER="root";
	private static final String DB_PASSWORD="";
	
	private static DBConnection instance;
	private Connection conn;

	
	private DBConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public static DBConnection getInstance() {
		if(instance==null) {
			synchronized (DBConnection.class) {
				if (instance==null) {
					instance=new DBConnection();
					
				}
				
			}
		}
		return instance;
	}



	public Connection getConn() {
		return conn;
	}



	
}
