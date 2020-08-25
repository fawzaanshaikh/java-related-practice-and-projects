package com.techlab.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayContact {
	Scanner in = new Scanner(System.in);
	
	/* Constructor */
	public DisplayContact() throws SQLException {
		System.out.println("\n- Entered Display Mode -");
		System.out.println("\n->Type \"all\" to display all the records from the database");
		System.out.println("Type \"FIRST_NAME\", \"LAST_NAME\", \"NUMBER\" or \"EMAIL_ID\" to display the records as per the field");
		System.out.println("After typing any of the above four commands, specify a value to search and display by");
		System.out.print("\n->Enter a command - ");
		
		String command = in.next();		// Stores the initial command entered
		String value = "";				// Stores the value
		if(command.equals("FIRST_NAME") || command.equals("LAST_NAME") || command.equals("NUMBER") || command.equals("EMAIL_ID")) {
			System.out.print("\n->Enter a value - ");
			value = in.next();			// Storing the value from the user
		}
		else if(command.equals("all")) {}
		else {
			System.out.println("Valid command not received, displaying values as per \"all\"");
			command = "all";			// Invalid input displays all the results
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
			ResultSet rs = null;
			if(command.equals("all")){
				rs = stmt.executeQuery("select * from CONTACT");
			}
			else {
				if(command.equals("NUMBER")) {	// Number is of long datatype
					rs = stmt.executeQuery("select * from CONTACT where " + command + " = " + Long.parseLong(value));
				}
				else {	// Others are suitable as Strings.
					rs = stmt.executeQuery("select * from CONTACT where " + command + " = " + value);
				}
				
			}
					
			// Display the values
			while(rs.next()) {
				System.out.println(rs.getString("FIRST_NAME") + " | " + rs.getString("LAST_NAME") + " | " + rs.getLong("NUMBER")
									+ " | " + rs.getString("EMAIL_ID"));
			}
					
		}
		catch (SQLException | ClassNotFoundException e) {	// In case of exception
			e.printStackTrace();
		}
		
		// Closing the connection
		if(connection != null) {
			connection.close();
		}
		
		System.out.println("\n- Leaving Display Mode -");
	}

}
