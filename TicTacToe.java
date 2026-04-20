public class TicTacToe {
    public static void main(String[] args) {
        // Create a 3x3 board represented as a 2D array
        char[][] board = new char[3][3];
        
        // Initialize the board with empty cells (using '-' as placeholder)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
        
        // Display the board on the console
        System.out.println("Welcome to Tic-Tac-Toe Game!");
        displayBoard(board);
    }
    
    // Function to display the board
    public static void displayBoard(char[][] board) {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}