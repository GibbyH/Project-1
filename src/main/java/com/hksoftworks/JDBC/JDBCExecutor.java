package com.hksoftworks.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExecutor {

	private static final String USERNAME = "SYS as SYSDBA";
	private static final String PASSWORD = "Revature123";
	private static final String CONN_STRING = "jdbc:oracle:thin:@localhost:1521:ORCL";
	
	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("Connected!");
		} catch (SQLException e) {
			System.err.println(e);
		} finally {
			if(conn != null)
				conn.close();
		}
	}
	
}
