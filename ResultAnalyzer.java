package com.techlab.tictactoe;

public class ResultAnalyzer {
	
	private String[][] cell = new String[3][3];	    // Stores the grid from the Board class
	private int i = 0, j = 0;	                    // Counter variables
	private final int ROWS = 3;
	private final int COLUMNS = 3;
	
	/* Constructor */
	public ResultAnalyzer(String[][] cell) {
		this.cell = cell;
	}
	
	/* Member Functions */
	public Results checkStatus() {
		
		// Vertical check
		for(j = 0; j < COLUMNS; j++) {
			if((cell[0][j] != " - ") && (cell[1][j] != " - ") && (cell[2][j] != " - ")) {	// Checks that wrong result of " - " is not counted as a win
				if((cell[0][j] == cell[1][j]) && (cell[1][j] == cell[2][j])) {	    		// Checks if the column is same
					return Results.WIN;
				}
			}
		}
		
		// Horizontal check
		for(i = 0; i < ROWS; i++) {
			if((cell[i][0] != " - ") && (cell[i][1] != " - ") && (cell[i][2] != " - ")) {	// Checks that wrong result of " - " is not counted as a win
				if((cell[i][0] == cell[i][1]) && (cell[i][1] == cell[i][2])) {				// Checks if row is same
					return Results.WIN;
				}
			}
		}
		
		// Diagonal check (Top left to bottom right)
		if((cell[0][0] != " - ") && (cell[1][1] != " - ") && (cell[2][2] != " - ")) {
			if((cell[0][0] == cell[1][1]) && (cell[1][1] == cell[2][2])){
				return  Results.WIN;
			}
		}
		
		// Diagonal check (Top right to bottom left)
		if((cell[0][2] != " - ") && (cell[1][1] != " - ") && (cell[2][0] != " - ")) {
			if((cell[0][2] == cell[1][1]) && (cell[1][1] == cell[2][0])){
				return Results.WIN;
			}
		}
		
		// Finally check for draw
		int mark_count = 0;				// Counts the number of marks present in the grid
		for(i = 0; i < ROWS; i++) {
			for(j = 0; j < COLUMNS; j++) {
				if(cell[i][j] != " - ") {
					mark_count++;
				}
			}
		}
		
		if(mark_count == ROWS * COLUMNS) {		// If there are 9 (ROWS * COLUMNS) marks in the grid, then the whole 
			return Results.DRAW;				// grid is filled with marks but no winner since the program has 
		}										// reached this part of the code, hence DRAW
		
		return Results.PENDING;		// Return PENDING if none of the other conditions are met and continue the game
		
	}

}
