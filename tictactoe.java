import java.util.Scanner;

class tictactoe {
  public static void main(String[] args) {
    char[][] board = new char[3][3];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board.length; col++) {
        board[row][col] = ' ';
      }
    }

    char player = 'X';
    boolean gameOver = false;
    Scanner scanner = new Scanner(System.in);

    while (!gameOver) {
      printBoard(board);
      System.out.print("Player " + player + " enter: ");
      int row = scanner.nextInt();
      int col = scanner.nextInt();
      System.out.println();

      if (board[row][col] == ' ') {
        board[row][col] = player; // place the element
        gameOver = haveWon(board, player);
        if (gameOver) {
          System.out.println("Player " + player + " has won: ");
        } 
         else if(!haveWon(board, player) && isBoardFull(board)){
            System.out.println("Haha Game Draw!!!");
            break;
            }

        else {
          player = (player == 'X') ? 'O' : 'X';
        }
      } else {
        System.out.println("Invalid move. Try again with something else!");
      }
    }
    printBoard(board);
  }

  public static boolean haveWon(char[][] board, char player) {
    // checking if the rows are making condition true
    for (int row = 0; row < board.length; row++) {
      if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
        return true;
      }
    }

    //  checking if the columns are making condition true
    for (int col = 0; col < board[0].length; col++) {
      if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
        return true;
      }
    }

    //  checking if the diagonal are making condition true
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
      return true;
    }

    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
      return true;
    }
    return false;// if condition do not match
  }
  public static boolean isBoardFull(char board[][]){// function for draw condition
    for(int i=0; i<board.length; i++){
    for(int j=0; j<board[0].length; j++){
    if(board[i][j] == ' '){
    return false;
    }
    }
    }
    return true;
    }
  public static void printBoard(char[][] board) {// Function to print board
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board[row].length; col++) {
        System.out.print(board[row][col] + " | ");
      }
      System.out.println();
    }
  }
}