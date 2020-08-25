package com.techlab.contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class AddContact {
	Scanner in = new Scanner(System.in);
	
	/* Constructor */
	public AddContact() throws SQLException{
		System.out.println("\n- Entered Add Mode -");
		System.out.println("\n->Enter the data as per the order - First Name, Last Name, Phone Number and Email ID- ");
		System.out.println("Type \"exit\" in First Name, Last Name or Email ID to exit the application");
		System.out.println("\nPlease enter the First Name - ");
		String fname = in.next();	// Stores the first name
		System.out.println("Please enter the Last Name - ");
		String lname = in.next();	// Stores the last name
		System.out.println("Please enter the Phone Number - ");
		String number = in.next();	// Stores the number
		System.out.println("Please enter the Email ID - ");
		String email = in.next();	// Stores the email
		
		if(fname.equals("exit") || lname.equals("exit") || email.equals("exit")) {
			System.exit(0);
		}
		
		// JDBC Connection Part
		Connection connection = null;
		try {
			// Load and register the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			// Establish a connection
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/swabhav techlabs", "root", "root");
			
			// Create a statement
			Statement stmt = connection.createStatement();
			
			// Conduct an insertion into the table
			@SuppressWarnings("unused")
			int rows = stmt.executeUpdate("insert into CONTACT values(\"" + fname + "\", \"" + lname + "\", " + Long.parseLong(number) + 
					", \"" + email +"\");");
			
			// Notify the user about the update
			System.out.println("Contact information has been added as - \nFirst Name - " + fname + " \nLast Name - " + lname
					+ " \nPhone Number - " + number + " \nEmail ID - " + email);
			
		}
		catch (SQLException | ClassNotFoundException e) {	// In case of exception
			e.printStackTrace();
		}
		
		// Closing the connection
		if(connection != null) {
			connection.close();
		}
		
		System.out.println("\n- Leaving Add Mode -");
	}

}
