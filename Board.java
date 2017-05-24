/** Class Board creates an two dimensional array connsisting characters that identify if there is a redchecker,bluechecker or there is no checker.
  *It also puts checkers on their starting position */
public class Board {

   public final static int SIZE = 8;//Constant field variable that is used to give the board the proper size.
   public  char[][] board; //Creates a two dimensional array of characters.
  
  //Constucter gives the size to array
   public Board() {
   
      board = new char[SIZE][SIZE];
    
    //Initialize the board with red and blue checkers in starting positions.
      int i,j;
      for (i=0;i<SIZE;i++)
         for (j=0;j<SIZE;j++)
            board[i][j] = '_';
   
      for (i=1;i<SIZE;i+=2) {
         board[i][1] = 'r';
         board[i][5] = 'b';
         board[i][7] = 'b';
      }
      for (i=0;i<SIZE;i+=2) {
         board[i][0] = 'r';
         board[i][2] = 'r';
         board[i][6] = 'b';
      }
   }
}
    
    
 
    

