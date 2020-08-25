package com.techlab.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateContact {
	
	Scanner in = new Scanner(System.in);
	
	/* Constructor */
	public UpdateContact() throws ClassNotFoundException, SQLException {
		System.out.println("- Entered Update Mode -");
		System.out.println("\nType \"exit\" to exit the application");
		System.out.println("Enter the field required to be changed - ");
		String changeField = in.next();
		System.out.println("Enter the value to be changed to - ");
		String toValue = in.next();
		System.out.println("Enter the condition field - ");
		String conditionField = in.next();
		System.out.println("Enter the condition field's value - ");
		String conditionValue = in.next();
		
		if(changeField.equals("exit") || toValue.equals("exit") || conditionField.equals("exit") || conditionValue.equals("exit")) {
			System.exit(0);
		}
		
		Connection connection = null;
		try {
			// Load and register driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Establishing connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swabhav techlabs", "root", "root");
			
			// Creating statement
			Statement stmt = connection.createStatement();
			
			// Do the update respectively
			if(changeField.equals("NUMBER") && conditionField.equals("NUMBER")) {
				@SuppressWarnings("unused")
				int rows = stmt.executeUpdate("UPDATE contact SET " + changeField + " = " + Long.parseLong(toValue) + " WHERE " 
												+ conditionField + " = " + Long.parseLong(conditionValue) +";");
			}
			else if(changeField.equals("NUMBER")) {
				@SuppressWarnings("unused")
				int rows = stmt.executeUpdate("UPDATE contact SET " + changeField + " = " + Long.parseLong(toValue) + " WHERE " 
												+ conditionField + " = \"" + conditionValue +"\";");
			}
			else if(conditionField.equals("NUMBER")) {
				@SuppressWarnings("unused")
				int rows = stmt.executeUpdate("UPDATE contact SET " + changeField + " = \"" + toValue + "\" WHERE " 
												+ conditionField + " = " + Long.parseLong(conditionValue) +";");
			}
			else {
			@SuppressWarnings("unused")
			int rows = stmt.executeUpdate("UPDATE contact SET " + changeField + " = \"" + toValue + "\" WHERE " 
											+ conditionField + " = \"" + conditionValue +"\";");
			}
			
			// Notify the user of the change
			System.out.println("\nThe field " + changeField + " has its value changed to " + toValue);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(connection != null) {
			connection.close();
		}
		
		System.out.println("\n- Leaving Update Mode -");
	}
	
	
}
