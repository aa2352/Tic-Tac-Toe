/**
 * UC2 performs a random toss to decide who plays first and assigns
 * symbols (X or O) to the human and computer accordingly.
 */
public class TicTacToe {

    static boolean isHumanTurn;
    static char humanSymbol;
    static char computerSymbol;

    /**
     * Entry point of the program. Executes the toss logic and displays
     * the result of turn and symbol assignment.
     */
    public static void main(String[] args) {
        tossAndAssignSymbols();
        displayTossResult();
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
}
