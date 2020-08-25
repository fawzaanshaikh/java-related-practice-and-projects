package com.techlab.tictactoe;

@SuppressWarnings("serial")
public class InvalidMarkPositionException extends Exception{
	public InvalidMarkPositionException(String exception) {
		super(exception);
	}
}
