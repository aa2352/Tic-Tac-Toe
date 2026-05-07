import java.util.Scanner;
import java.util.Arrays;

/**
 * TicTacToe - UC8 controls the continuous game loop and alternates
 * turns until the game ends.
 * 
 * Key Concepts:
 * - While Loop: Continuous game loop that runs until win or draw
 * - Game State Flags: isHumanTurn, gameOver
 * - Turn Switching: Alternates between human and computer
 */
public class TicTacToe {
    // Game state flags
    static boolean isHumanTurn = true;
    static boolean gameOver = false;
    
    // Game board representation
    static char[] board = new char[9];
    
    // Scanner for user input
    static Scanner scanner = new Scanner(System.in);
    
    /**
     * Entry point of the program. Demonstrates the structure
     * of a continuous game loop.
     */
    public static void main(String[] args) {
        // Initialize the board
        initializeBoard();
        
        System.out.println("=== Welcome to TicTacToe (UC8: Continuous Turn-Based Loop) ===");
        
        // Continuous game loop - UC8
        while (!gameOver) {
            // Display current board state
            displayBoard();
            
            if (isHumanTurn) {
                // Human player's turn
                System.out.println("Human's turn (X)");
                getHumanMove();
            } else {
                // Computer player's turn
                System.out.println("Computer's turn (O)");
                getComputerMove();
            }
            
            // Check for win or draw
            if (checkWin('X')) {
                System.out.println("Human wins!");
                gameOver = true;
            } else if (checkWin('O')) {
                System.out.println("Computer wins!");
                gameOver = true;
            } else if (checkDraw()) {
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
                // Switch turn for next iteration
                isHumanTurn = !isHumanTurn;
            }
        }
        
        // Display final board state
        displayBoard();
        System.out.println("Game Over!");
        scanner.close();
    }
    
    /**
     * Initializes the game board with empty spaces.
     */
    private static void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
    }
    
    /**
     * Displays the current state of the board.
     */
    private static void displayBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i * 3 + j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println("---------");
        }
        System.out.println();
    }
    
    /**
     * Gets the human player's move and updates the board.
     */
    private static void getHumanMove() {
        int position;
        boolean validMove = false;
        
        while (!validMove) {
            System.out.print("Enter position (1-9): ");
            
            try {
                position = scanner.nextInt();
                
                if (position >= 1 && position <= 9 && board[position - 1] == ' ') {
                    board[position - 1] = 'X';
                    validMove = true;
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }
    
    /**
     * Gets the computer player's move and updates the board.
     */
    private static void getComputerMove() {
        // Simple AI: find first available position
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                board[i] = 'O';
                System.out.println("Computer chose position " + (i + 1));
                break;
            }
        }
    }
    
    /**
     * Checks if a player has won the game.
     * 
     * @param player The player symbol ('X' or 'O')
     * @return true if the player has won, false otherwise
     */
    private static boolean checkWin(char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i * 3] == player && 
                board[i * 3 + 1] == player && 
                board[i * 3 + 2] == player) {
                return true;
            }
        }
        
        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[j] == player && 
                board[j + 3] == player && 
                board[j + 6] == player) {
                return true;
            }
        }
        
        // Check diagonals
        if (board[0] == player && board[4] == player && board[8] == player) {
            return true;
        }
        if (board[2] == player && board[4] == player && board[6] == player) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Checks if the game is a draw (board is full and no winner).
     * 
     * @return true if the game is a draw, false otherwise
     */
    private static boolean checkDraw() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }
}
