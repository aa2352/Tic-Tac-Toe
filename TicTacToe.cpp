#include <iostream>
#include <array>

using namespace std;

/**
 * TicTacToe - UC8 controls the continuous game loop and alternates
 * turns until the game ends.
 */
class TicTacToe {
private:
    // Game state flags
    static bool isHumanTurn;
    static bool gameOver;
    
    // Game board representation
    static array<char, 9> board;
    
public:
    /**
     * Entry point of the program. Demonstrates the structure
     * of a continuous game loop.
     */
    static void main() {
        // Initialize the board
        initializeBoard();
        
        // Continuous game loop - UC8
        while (!gameOver) {
            // Display current board state
            displayBoard();
            
            if (isHumanTurn) {
                // Human player's turn
                cout << "Human's turn (X)" << endl;
                getHumanMove();
            } else {
                // Computer player's turn
                cout << "Computer's turn (O)" << endl;
                getComputerMove();
            }
            
            // Check for win or draw
            if (checkWin('X')) {
                cout << "Human wins!" << endl;
                gameOver = true;
            } else if (checkWin('O')) {
                cout << "Computer wins!" << endl;
                gameOver = true;
            } else if (checkDraw()) {
                cout << "It's a draw!" << endl;
                gameOver = true;
            } else {
                // Switch turn for next iteration
                isHumanTurn = !isHumanTurn;
            }
        }
        
        // Display final board state
        displayBoard();
        cout << "Game Over!" << endl;
    }
    
private:
    /**
     * Initializes the game board with empty spaces.
     */
    static void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = ' ';
        }
    }
    
    /**
     * Displays the current state of the board.
     */
    static void displayBoard() {
        cout << "\n";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cout << board[i * 3 + j];
                if (j < 2) cout << " | ";
            }
            cout << "\n";
            if (i < 2) cout << "---------\n";
        }
        cout << "\n";
    }
    
    /**
     * Gets the human player's move and updates the board.
     */
    static void getHumanMove() {
        int position;
        bool validMove = false;
        
        while (!validMove) {
            cout << "Enter position (1-9): ";
            cin >> position;
            
            if (position >= 1 && position <= 9 && board[position - 1] == ' ') {
                board[position - 1] = 'X';
                validMove = true;
            } else {
                cout << "Invalid move! Try again." << endl;
            }
        }
    }
    
    /**
     * Gets the computer player's move and updates the board.
     */
    static void getComputerMove() {
        // Simple AI: find first available position
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                board[i] = 'O';
                cout << "Computer chose position " << (i + 1) << endl;
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
    static bool checkWin(char player) {
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
    static bool checkDraw() {
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ') {
                return false;
            }
        }
        return true;
    }
};

// Initialize static members
bool TicTacToe::isHumanTurn = true;
bool TicTacToe::gameOver = false;
array<char, 9> TicTacToe::board;

/**
 * Main entry point
 */
int main() {
    TicTacToe::main();
    return 0;
}
