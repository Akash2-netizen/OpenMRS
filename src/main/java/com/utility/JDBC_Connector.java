package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JDBC_Connector {
	
	static String url="jdbc:mysql://localhost:3306/employees";
	static String userName="root";
	static String password="Akash1999";
	static String query="select * from employees";
	
	private static void getAllRowData() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/employees";
		String username = "root";
		String passWord ="yourpassword";
		String query = "SELECT * FROM employees.employees limit 10";

		Connection connection = DriverManager.getConnection(url, username, passWord);
		Statement createStatement = connection.createStatement();
		ResultSet executeQuery = createStatement.executeQuery(query);

		while(executeQuery.next()) {
			int int1 = executeQuery.getInt(1);
			System.out.println(int1);
			Date date = executeQuery.getDate(2);
			System.out.println(date);
			String string = executeQuery.getString(3);
			System.out.println(string);
		}

	}
	    
	private void getAllData() {
		
	}
	
	
	
}
