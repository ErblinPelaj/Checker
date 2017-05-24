
import java.io.*;//It is inclueded because of the throwExceptions 
import java.util.*;//Scanner is part of this package

//Class Moving is responsible for all the moving that happens in this Checker game.
public class Moving{
   
    private char whosemove; // Stores the checkerboard, with chars 'r','b','_'
    private int redcheckers; // Number of red checkers on the board
    private int bluecheckers; //Number of blue ones.
    Board w= new Board();//Creates an object of class Board.

public Moving(){

redcheckers =12;//Initialize redcheckers.
bluecheckers=12;//initialize bluecheckers.
whosemove='r';

}

  public void printBoard() {
	int i,j;
	System.out.println("x 1 2 3 4 5 6 7 8");
	for (i=0;i<w.SIZE;i++) {
	    System.out.print((i+1) + "  ");
	    for (j=1;j<w.SIZE;j++) {
		System.out.print(w.board[j][i] + " ");
	    }
	    System.out.println();
	}
	System.out.println("y");
   }
   

    // This method executes one move.
   public void getNextMove() throws IOException {
   
      Scanner sc = new Scanner(System.in);
   
      if (whosemove=='r')
         System.out.println("It is red's turn..");
      else
         System.out.println("It is blue's turn.");
   
      boolean moved = false;
   // Loops until legal move is entered.
      while (!moved) {
       // Reads in square to move from and to.
         System.out.println("Enter from the square you want to move from,");
         System.out.print("as a 2-digit number. (e.g. if you were moving from");
         System.out.println(" x=1,y=3, enter 13)");
         int movefrom = sc.nextInt();
      
         System.out.print("Enter the square that you want to move to, ");
         System.out.println("in the same manner.");
         int moveto = sc.nextInt();
      
       // Checks to see if move is valid, if so, executes it.
         if (validMove(movefrom,moveto)) {
            executeMove(movefrom,moveto);
            moved = true;
         }
         else
            System.out.println("That was an invalid move, try again.");
      }
   
   // Update whosemove it is.
      if (whosemove == 'r')
         whosemove = 'b';
      else
         whosemove = 'r';
   }

   public boolean validMove(int movefrom, int moveto) {

	// Gets array indeces corresponding to the move, from parameters.
	int xfrom = movefrom/10 - 1;
	int yfrom = movefrom%10 - 1;
	int xto = moveto/10 - 1;
	int yto = moveto%10 - 1;
	
	// Check if indeces in range, if not, return false.
	if (xfrom < 0 || xfrom > 7 || yfrom < 0 || yfrom > 7 ||
	    xto < 0 || xto > 7 || yto < 0 || yto > 7) 
	    return false;

	// Check to see you are moving your piece to a blank square.
	else if (w.board[xfrom][yfrom]==whosemove && w.board[xto][yto]=='_') {

	    // Checks case of simple move
	    if (Math.abs(xfrom-xto)==1) {
		if ((whosemove == 'r') && (yto - yfrom == 1))
		    return true;
		else if ((whosemove == 'b') && (yto - yfrom == -1))
		    return true;
	    }
	    
	    // Checks case of a jump
	    else if (Math.abs(xfrom-xto)==2) {
		if (whosemove == 'r' && (yto - yfrom == 2) && 
		    w.board[(xfrom+xto)/2][(yfrom+yto)/2] == 'b')
		    return true;
		else if (whosemove == 'b' && (yto - yfrom == -2) && 
		    w.board[(xfrom+xto)/2][(yfrom+yto)/2] == 'r')
		    return true;
	    }
	}
	// If move is neither a simple one or a jump, it is not legal.
	return false;
    }
    
    // Executes a move.
   public void executeMove(int movefrom, int moveto) {
   // Gets array indexes corresponding to the move, from parameters.
      int xfrom = movefrom/10 - 1;
      int yfrom = movefrom%10 - 1;
      int xto = moveto/10 - 1;
      int yto = moveto%10 - 1;
   
   // Change appropriate board elements and decrement redcheckers or
   // blackcheckers if necessary.
      w.board[xfrom][yfrom] = '_';
      w.board[xto][yto] = whosemove;
      if (Math.abs(xto - xfrom) == 2) {
         w.board[(xfrom+xto)/2][(yfrom+yto)/2] = '_';
         if (whosemove == 'r')
            redcheckers--;
         else
            bluecheckers--;
      }
   
   }

    // Checks to see if game is over based on number of checkers left.
   public boolean gameOver() {
      return (redcheckers == 0 || bluecheckers == 0);
   }

    // Returns the winner,by its color.
   public String winnerIs() {
      if (redcheckers == 0)
         return "blue";
      else
         return "red";
   }
}
