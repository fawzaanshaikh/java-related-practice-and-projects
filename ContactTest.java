/* Code by :- Fawzaan Shaikh
 * Completed on :- 
 * Title :- Contact Database 
 */


package com.techlab.contact;

import java.sql.SQLException;
import java.util.Scanner;

public class ContactTest {
	
	public static void main(String args[]) throws SQLException, ClassNotFoundException {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("[------------ Contact Database Application ------------]"); 
		System.out.println("\nType \"syntax\" to view syntax and information");
		System.out.println("Type \"contact\" to activate the contact mode");
		System.out.println("Type \"exit\" to exit the application\n");
		
		String command;
		
		while(true) {
			System.out.println("Please enter a command - ");
			command = in.next();		// The command from the user is stored here
			
			// The command is checked and respectively sent to the function or an action is carried out respectively
			if(command.equals("syntax")) {
				displaySyntax();
			}
			else if(command.equals("contact")) {
				contact();
			}
			else if(command.equals("exit")) {
				System.exit(0);
				break;
			}
			else {
				System.out.println("Please enter a valid command");
			}
		}
		
		in.close();
		
	}
	
	/* External Functions */
	public static void displaySyntax() {
		System.out.println("\nThere are three commands within this application which can be read - \"display\", \"add\" and \"delete\"");
		System.out.println("\"display\" command displays the current contact table on the console");
		System.out.println("\"add\" command adds contact information to the database");
		System.out.println("\"update\" command updates an already existing record");
		System.out.println("\"delete\" deletes records from the database\n");
	}
	
	public static void contact() throws SQLException, ClassNotFoundException {
		System.out.println("\n-- Contact Mode Entered --");
		 
		Scanner in = new Scanner(System.in);
		String command;
		while(true) {
			System.out.println("\n->Enter a command from \"display\", \"add\", \"update\" and \"delete\", to display, add or delete records -");
			System.out.println("Enter \"exit\" to exit the application");
			command = in.next();
			
			if(command.equals("display")) {
				new DisplayContact();
			}
			else if(command.equals("add")) {
				new AddContact();
			}
			else if(command.equals("update")) {
				new UpdateContact();
			}
			else if(command.equals("delete")) {
				new DeleteContact();
			}
			else if(command.equals("exit")) {
				System.exit(0);
				break;
			}
			else {
				System.out.println("Please enter a valid command");
			}
		}
		
		in.close();
		}
	
}
