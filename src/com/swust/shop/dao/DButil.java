package com.swust.shop.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
/*
 * JDBC¹¦ÄÜ·â×°£»
 * */

public class DButil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static Connection conn;
	
	static Connection getconnection() throws SQLException {
		String url="jdbc:mysql://127.0.0.1:3306/monkey";
		String user="root";
		String pwd="wen";
		if(conn==null||conn.isClosed()) {
			conn =  DriverManager.getConnection(url, user, pwd);
		}
		return conn;
		}
	static void close(Connection conn,Statement sta,ResultSet rs) throws Exception {
		
		/*
		 * sta.close(); conn.close();
		 */
		}
		
	}



	

