 import java.io.*;
 public class Checker{
 
 
 public static void main(String args[]) throws IOException {

	


   Moving move = new Moving();//Creates an instance of class Moving
   move.printBoard();//Prints the board
	
	// Loop until game is over.
	while (!move.gameOver()) {
   
	    //Execute a move and prints the board with the move procceded.
	  move.getNextMove();
	  move.printBoard();
	}
   
	// Announces the winner.
	System.out.println("The winner is " + move.winnerIs());
    }
    }
