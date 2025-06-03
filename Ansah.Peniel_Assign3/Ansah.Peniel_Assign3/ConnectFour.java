import java.util.Scanner;
public class ConnectFour1 {
    private static char currentPlayer = 'R';

    public static void main(String[] args) {
        // Declare and create an array for the board.
        char[][] board = new char[6][7];
        // call the method drawboard to display the board.
        drawBoard(board);
        // A method to keep playing when game is not over.
        while (!isGameOver(board)) {
            // Call the method make move to put the character in the cell chosen by the player.
            makeMove(board);
            // Switch player
            if (currentPlayer == 'R') {
                currentPlayer = 'Y';
              } else {
                currentPlayer = 'R';
              }
         
        }
    }

    // A helper method to draw the board
    public static void drawBoard(char[][] array) {
        for (int i = 0; i < array.length; i++) {
          for (int j = 0; j < array[i].length; j++) {
            System.out.print("|");
            //Check if the cell is empty and display an empty space.
            if (array[i][j] == '\u0000') {
              System.out.print(" ");
            } else {
                // If the cell is not empty, display the character there.
              System.out.print(array[i][j]);
            }
            System.out.print(" ");
          }
          System.out.println("|");
        }
      }

    // A method to put the character in the cell
    public static void makeMove(char[][] board) {
        // Show which player's turn it is.
        System.out.println("Player " + currentPlayer + "'s turn");
        // Get the column chosen by the player
        int column = getUserMove();
        int row =0;

        for(int i = board.length-1 ; i >= 0; i--){
             row = i;
            if (board[i][column]!='\u0000'){
                continue;
            }
             board[i][column] = currentPlayer;
             
             drawBoard(board);
             break;
        }    
            // Check if there is a win, declare the winner and exit the game.
        if (checkForWin(board, row, column)) {
            System.out.println("Player " + currentPlayer + " wins!");
            System.exit(0); 
        }
        // Check if the board is full with no win, declare a draw and exit the game.
        if (isBoardFull(board)) {
            System.out.println("The game is a draw!");
            System.exit(0); 
        }
    }
    
    // A method to get the user to choose the cell of choice
    public static int getUserMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter column (0-6) to drop your piece: ");
        int column = scanner.nextInt(); 
        return column;
    }

    // Return true if there is game is over and false if game is not over.
    public static boolean isGameOver(char[][] board) {
        return checkForWin(board, 0, 0) || isBoardFull(board);
    }

    // Return true if there is a win and false if there is no no win.
    public static boolean checkForWin(char[][] board, int row, int column) {
        return checkHorizontal(board, row) || checkVertical(board, column) || checkDiagonalLeft(board) ||checkDiagonalRight(board);
    }

    // A method to check if there are four same colors horizontally
    public static boolean checkHorizontal(char[][] board, int row) {
        // Get the color of the first cell in the specified row
        char color = board[row][0];
        // Initialize a count to keep track of consecutive cells with the same color
        int count = 1;
        // Iterate through the cells in the specified row starting from the second cell (index 1)
        for (int j = 1; j < board[row].length; j++) {
            // Check if the current cell has the same color as the previous cell and is not empty
            if (board[row][j] == color && color != '\u0000') {
                // Increment the count of consecutive cells with the same color
                count++;
                // If there are four consecutive cells with the same color, return true
                if (count == 4) {
                    return true;
                }
            } else {
                // If the current cell has a different color than the previous cell or is empty,update the color and reset the count to 1
                color = board[row][j];
                count = 1;
            }
        }
        // If no four consecutive cells with the same color were found, return false
        return false;
    }
    

// A method to check if there are four same colors vertically
public static boolean checkVertical(char[][] board, int column) {
    // Get the color of the first cell in the specified column
    char color = board[0][column];
    // Initialize a count to keep track of consecutive cells with the same color
    int count = 1; 
    for (int k = 1; k < board.length; k++) {
        // Check if the current cell has the same color as the previous cell and is not empty
        if (board[k][column] == color && color != '\u0000') {
            // Increment the count of consecutive cells with the same color
            count++;
            // If there are four consecutive cells with the same color, return true
            if (count == 4) {
                return true;
            }
        } else {
            // If the current cell has a different color than the previous cell or is empty,update the color and reset the count to 1
            color = board[k][column];
            count = 1;
        }
    }
    
    // If no four consecutive cells with the same color were found, return false
    return false;
}

   
public static boolean checkDiagonalLeft(char[][] board) {
    for (int i = 0; i < board.length - 1; i++) {
        for (int j = 0; j < board[0].length; j++) {
            // Initialize the row and column variables for the current diagonal
            int startRow = i;
            int startColumn = j;
            // Initialize the color and count variables for the current diagonal
            char color = board[startRow][startColumn];
            int count = 1;
            // Iterate though all the diagonals until the end of the board or a different color is found
            while (startRow < board.length - 1 && startColumn < board[0].length - 1) {
                // Increment the row and column variables
                startRow++;
                startColumn++;
                // Check if the next cell is the same as the current color and not empty
                if (board[startRow][startColumn] == color && color != '\u0000') {
                // Increment the count
                count++;
                // Check if the count is 4
                if (count == 4) {
                    // Return true if a win is found
                    return true;
                    }
                } else {
                    // Reset the color and count if a different color or null is found
                    color = board[startRow][startColumn];
                    count = 1;
                }
                
            }
        }
    }
    // Return false if no win is found
    return false;
}

public static boolean checkDiagonalRight(char[][] board) {
    for (int i = board.length - 1; i >=0; i--) {
        for (int j = 0; j < board[0].length; j++) {
            // Initialize the row and column variables for the current diagonal
            int startRow = i;
            int startColumn = j;
            // Initialize the color and count variables for the current diagonal
            char color = board[startRow][startColumn];
            int count = 1;
            // Iterate through all the diagonals until the end of the board or a different color is found
            while (startRow > 0 && startColumn < board[0].length - 1) {
                // Decrement the row and increment the column variables
                startRow--;
                startColumn++;
                    // Check if the next cell is the same as the current color and not empty
                    if (board[startRow][startColumn] == color && color != '\u0000') {
                        // Increment the count by one
                        count++;
                        // Check if the count is 4 or more
                        if (count >= 4) {
                            // Return true if a win is found
                            return true;
                        }
                    } else {
                        // Reset the color and count if a different color or null is found
                        color = board[startRow][startColumn];
                        count = 1;
                    }
            }
        }
    }
    // Return false if no win is found
    return false;
}
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '\u0000') {
                    return false; // There's an empty cell, so board is not full
                }
            }
        }
        return true; // All cells are occupied, so board is full
    }
}
