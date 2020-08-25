/* Code by :- Fawzaan Shaikh
 * Completed on :- 11/08/2020
 * Project Title :- Tic-Tac-Toe
 */

package com.techlab.tictactoe;

import java.util.Scanner;

public class TicTacToeTest {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);	// Scanner class to take input
		
		System.out.println("|--------------Tic Tac Toe Game Made in Java--------------|");
		System.out.println("\nType in \"help\" for more information on the game");
		System.out.println("Type \"play\" to start playing tic-tac-toe");
		System.out.println("Type \"exit\" to exit the application\n");
		
		String command;	   // Stores the command that is input by the user 
		while(true) {
			command = in.next();
			if(command.equals("help")) {
				displayHelp();
			}
			else if(command.equals("play")) {
				startPlay();
			}
			else if(command.equals("exit")) {
				System.out.println("Thank you for playing Tic-Tac-Toe");
				break;
			}
			else {
				System.out.println("Please enter a valid command");    // If user inputs command other than said above
			}
		}
		
		in.close(); // Closes the Scanner class
	}
	
	/* Static Functions */
	public static void displayHelp() {
		System.out.println("1) Tic-tac-toe is a two player game where each player picks one mark - \'X\' or \'O\'");
		System.out.println("2) Each player gets a chance per turn to place their mark on the 3x3 grid by entering a number");
		System.out.println("3) A win is decided for a player whose mark takes up consecutive 3 spaces veritcally, horizontally or diagonally");
		System.out.println("4) If all spaces in the grid are filled by marks with no winner, then the game ends as a draw");
		System.out.println("5) The numbering system is as follows :-\n\t0 1 2\n\t3 4 5\n\t6 7 8");
		System.out.println("Have Fun!");
	}
	
	// Heart Of The Program
	public static void startPlay() {

		System.out.println("Type \"exit\" to exit the game anytime\n");
		Scanner in = new Scanner(System.in);
		String mark1, mark2;	// Stores the mark chosen by the player 1 and player 2 receives their mark respectively
		System.out.println("Player 1, choose a mark - Cross = \'X\' or Naught = \'O\'");
		mark1 = in.next();
		
		while(true) {
			if(mark1.equals("X") || mark1.equals("x")) {
				System.out.println("Player 1 has mark - Cross\'X\'");
				System.out.println("Player 2 has mark - Naught\'O\'");
				mark1 = " X ";
				mark2 = " O ";
				break;
			}
			else if(mark1.equals("O") || mark1.equals("o")) {
				System.out.println("Player 1 has mark - Naught\'O\'");
				System.out.println("Player 2 has mark - Cross\'X\'");
				mark1 = " O ";
				mark2 = " X ";
				break;
			}
			else {
				System.out.println("Please enter a valid mark");	// If the user inputs anything other than 'X', 'x', 'O' or 'o'
			}
		}
		
		Board board = new Board();	
		board.displayBoard();	// Displays the initial board on the screen
		String position;	// Stores whether the user inputs a position or the command "exit"
		
		while(true) {
			System.out.println("Enter a position, Player 1 -");
			position = in.next();
			if(position.equals("exit")) {	// If the player enters "exit"
				System.out.println("Thank you for playing Tic-Tac-Toe");
				System.exit(0);
				break;
			}
			else if(Integer.parseInt(position) < 0 || Integer.parseInt(position) > 8) {		// If user enters a number not in 0-8 range
				System.err.println("Please enter a number between 0 to 8, or the command \"exit\"");
			}
			else {
				try {	// Try-catch block for the exception of vacant space
					board.updateBoard(Integer.parseInt(position), mark1);	// Update the board with new values
					board.displayBoard();									// Display the board on the screen
					board.checkResultStatus("Player 1", mark1);				// Check the status after the move
				} catch(Exception e) {
					System.err.println("Cannot play this move due to : " + e);
				}
			}
			
			System.out.println("Enter a position, Player 2 -");
			position = in.next();
			if(position.equals("exit")) {	// If the player enters "exit"
				System.out.println("Thank you for playing Tic-Tac-Toe");
				System.exit(0);
				break;
			}
			else if(Integer.parseInt(position) < 0 || Integer.parseInt(position) > 8) {		// If user enters a number not in 0-8 range
				System.err.println("Please enter a number between 0 to 8, or the command \"exit\"");
			}
			else {
				try {
					board.updateBoard(Integer.parseInt(position), mark2);	// Update the board with new values
					board.displayBoard();									// Display the board on the screen
					board.checkResultStatus("Player 2", mark2);				// Check the status after the move
				} catch(Exception e) {
					System.err.println("Cannot play this move due to : " + e);
				}
			}
		}
			
		in.close();	  // Closes the Scanner class
		
	}

}
