package com.techlab.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteContact {
	Scanner in = new Scanner(System.in);
	
	/* Constructor */
	@SuppressWarnings("unused")
	public DeleteContact() throws SQLException {
		System.out.println("\n- Entered Delete Mode -");
		System.out.println("\n->Type \"all\" to delete all the records from the database");
		System.out.println("Type \"FIRST_NAME\", \"LAST_NAME\", \"NUMBER\" or \"EMAIL_ID\" to delete the records as per the field");
		System.out.println("After typing any of the above four commands, specify a value to search and delete by");
		System.out.println("Enter \"exit\" to exit the application");
		System.out.print("\n->Enter a command - ");
		
		String command = in.next();		// Stores the initial command entered
		String value = "";				// Stores the value
		if(command.equals("FIRST_NAME") || command.equals("LAST_NAME") || command.equals("NUMBER") || command.equals("EMAIL_ID")) {
			System.out.print("\nEnter a value - ");
			value = in.next();			// Storing the value from the user
		}
		else if(command.equals("all")) {}
		else if(command.equals("exit")) {
			System.exit(0);
		}
		else {
			System.out.println("Valid command not received");
		}
		System.out.println();
		
		// JDBC Connection Part
		Connection connection = null;
		try {
			// Load and register the driver
			Class.forName("com.mysql.jdbc.Driver");
				
			// Establish a connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swabhav techlabs", "root", "root");
					
			// Create a statement
			Statement stmt = connection.createStatement();
					
			// Execute the query
			if(command.equals("all")){
				int rows = stmt.executeUpdate("delete from CONTACT");
				// Notify the user about the deletion
				System.out.println("All the records within the table CONTACT have been deleted");
			}
			else {
				if(command.equals("NUMBER")) {		// Number is of long datatype
					int rows = stmt.executeUpdate("delete from CONTACT where " + command + " = " + Long.parseLong(value));
				}
				else {
					int rows = stmt.executeUpdate("delete from CONTACT where " + command + " = \"" + value + "\"");
				}
				// Notify the user about the deletion
				System.out.println("The row containing the value " + value + " for the field "+ command + " has been deleted");
			}	
		}
		catch (SQLException | ClassNotFoundException e) {	// In case of exception
			e.printStackTrace();
		}
		
		// Closing the connection
		if(connection != null) {
			connection.close();
		}
		
		System.out.println("\n- Leaving Delete Mode -");
	}
	
}
