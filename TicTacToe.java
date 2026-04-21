import java.util.Scanner;

/**
 * UC2 performs a random toss to decide who plays first and assigns
 * symbols (X or O) to the human and computer accordingly.
 */
public class TicTacToe {

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    /**
     * Entry point of the program. Reads slot input and prints it back
     * to verify correct user input handling.
     */
    public static void main(String[] args) {
        tossAndAssignSymbols();
        displayTossResult();
        
        int slot = getUserSlot();
        System.out.println("Slot entered: " + slot);
        
        int row = getRowFromSlot(slot);
        int col = getColFromSlot(slot);
        
        System.out.println("\nRow: " + row);
        System.out.println("Column: " + col);
    }

    /**
     * Uses random logic to decide the first player and assigns symbols
     * based on the toss outcome. This method initializes the game state.
     */
    static void tossAndAssignSymbols() {
        // Generate a random number (0 or 1) to simulate a coin toss
        int tossResult = (int) (Math.random() * 2);

        // If toss result is 0, human starts first
        if (tossResult == 0) {
            isHumanTurn = true;
            humanSymbol = 'X';
            computerSymbol = 'O';
        }
        // Otherwise, computer starts first
        else {
            isHumanTurn = false;
            humanSymbol = 'O';
            computerSymbol = 'X';
        }
    }

    /**
     * Displays the toss result, indicating who plays first and which
     * symbol is assigned to each player.
     */
    static void displayTossResult() {
        System.out.println("==== TOSS RESULT ====");
        
        if (isHumanTurn) {
            System.out.println("You win the toss!");
            System.out.println("You will play first.");
        } else {
            System.out.println("Computer wins the toss!");
            System.out.println("Computer will play first.");
        }
        
        System.out.println("\n==== SYMBOL ASSIGNMENT ====");
        System.out.println("Your symbol: " + humanSymbol);
        System.out.println("Computer symbol: " + computerSymbol);
        System.out.println("================");
    }

    /**
     * Reads an integer slot value from the user.
     * Input: Scanner object
     * Output: Slot number (1-9)
     * Hint: Validation will be added in later use cases.
     */
    static int getUserSlot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter your slot (1-9): ");
        int slot = scanner.nextInt();
        return slot;
    }

    /**
     * Converts slot number into row index using zero-based indexing.
     * Input: Slot number (1-9)
     * Output: Row index (0-2)
     * Uses division operation: (slot - 1) / 3
     */
    static int getRowFromSlot(int slot) {
        return (slot - 1) / 3;
    }

    /**
     * Converts slot number into column index using modulo operation.
     * Input: Slot number (1-9)
     * Output: Column index (0-2)
     * Uses modulo operation: (slot - 1) % 3
     */
    static int getColFromSlot(int slot) {
        return (slot - 1) % 3;
    }
}
