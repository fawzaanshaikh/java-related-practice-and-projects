package com.techlab.tictactoe;

public class Board {

	private String[][] cell = new String[3][3];	    // String grid/matrix
	private short i = 0, j = 0;                     // Counter variables
	private final int ROWS = 3, COLUMNS = 3;        // Grid size 
	private Results result;							// Result enumeration
	
	/* Constructor */
	public Board() {
		for(i = 0; i < ROWS; i++) {
			for(j = 0; j < COLUMNS; j++) {
				cell[i][j] = " - ";
			}
		}
	}
	
	/* Member Functions */
	public void displayBoard() {	// Displays the board initially on the screen
		for(i = 0; i < ROWS; i++) {
			for(j = 0; j < COLUMNS; j++) {
				System.out.print(cell[i][j]);
			}
			System.out.println();
		}
	}
	
	public void updateBoard(int place, String mark) throws InvalidMarkPositionException{	// Updates the board to a new value

		for(i = 0; i < ROWS; i++) {
			for(j = 0; j < COLUMNS; j++) {
				if((3 * i + j) == place) {	// Checks position of place corresponding with (i, j) coordinates
					if(cell[i][j] == " - ") {	// Exception checking whether the space is vacant or not
						cell[i][j] = mark;
					}
					else {
						throw new InvalidMarkPositionException("InvalidMarkPositionException");
					}
				}
			}
		}
	
	}
	
	public void checkResultStatus(String player, String mark) {
		ResultAnalyzer resultAnalyzer = new ResultAnalyzer(this.cell);
		
		result = resultAnalyzer.checkStatus();	// Receiving the result enumeration
		
		if(result == Results.WIN) {
			System.out.println(player + " having mark" + mark + "has won! Congratulations, " + player +"!!!");
			System.exit(0);
		}
		else if(result == Results.DRAW) {
			System.out.println("The game has ended as a draw. Thank you for playing!");
			System.exit(0);
		}
		else if(result == Results.PENDING) {
			System.out.println("Mark" + mark + "placed for " + player + ". Wait your turn.\n");
		}
	}
	
}

