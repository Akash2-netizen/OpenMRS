package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class JDBC_Connector1 {

	
	private static void getParticularRowData() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/employees";
		String username = "root";
		String passWord ="Akash1999";
		String query = "SELECT * FROM employees.employees";
		//Establishing Connection
		Connection connection = DriverManager.getConnection(url, username, passWord);
		
		//Create a Statement
		Statement createStatement = connection.createStatement();
		ResultSet executeQuery = createStatement.executeQuery(query);
		executeQuery.next();
		
		
		int int1 = executeQuery.getInt(1);
		System.out.println(int1);
		Date date = executeQuery.getDate(2);
		System.out.println(date);
	}
}
