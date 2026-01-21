import java.util.Scanner;

public class TicTacToeGame {
    private static final int SIZE = 3;
    private static char[][] board = new char[SIZE][SIZE];
    private static final Scanner scanner = new Scanner(System.in);

    private static String playerX;
    private static String playerO;

    private static int scoreX = 0;
    private static int scoreO = 0;

    public static void main(String[] args) {
        printWelcomeMessage();
        playerX = getPlayerName("Enter Player X name: ");
        playerO = getPlayerName("Enter Player O name: ");

        boolean playAgain;
        do {
            initializeBoard();
            playGame();
            playAgain = askPlayAgain();
        } while (playAgain);

        printFinalScores();
        System.out.println("Thanks for playing Tic Tac Toe!");
        scanner.close();
    }

    private static String getPlayerName(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static void playGame() {
        char currentPlayer = 'X';
        int moves = 0;
        boolean gameEnded = false;

        while (!gameEnded) {
            displayBoard();
            String currentPlayerName = (currentPlayer == 'X') ? playerX : playerO;
            System.out.println(currentPlayerName + "'s turn (" + currentPlayer + ")");

            int row = -1, col = -1;
            while (true) {
                row = getValidNumber("Enter row (0-" + (SIZE-1) + "): ", 0, SIZE-1);
                col = getValidNumber("Enter column (0-" + (SIZE-1) + "): ", 0, SIZE-1);

                if (board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    break;
                } else {
                    System.out.println("❌ Cell already taken. Choose another position.");
                }
            }

            moves++;

            if (checkWinner(currentPlayer)) {
                displayBoard();
                System.out.println("🎉 " + currentPlayerName + " wins!");
                updateScore(currentPlayer);
                gameEnded = true;
            } else if (moves == SIZE * SIZE) {
                displayBoard();
                System.out.println("🤝 It's a draw!");
                gameEnded = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private static int getValidNumber(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void displayBoard() {
        System.out.println("\nCurrent Board:");
        System.out.print("    ");
        for (int j = 0; j < SIZE; j++) {
            System.out.print(j + "   ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < SIZE - 1) System.out.print("|");
            }
            System.out.println();

            if (i < SIZE - 1) {
                System.out.print("   ");
                for (int j = 0; j < SIZE; j++) {
                    System.out.print("---");
                    if (j < SIZE - 1) System.out.print("+");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    private static boolean checkWinner(char player) {
        // rows
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // columns
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j] == player && board[1][j] == player && board[2][j] == player) {
                return true;
            }
        }

        // diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

        return false;
    }

    private static void updateScore(char winner) {
        if (winner == 'X') scoreX++;
        else scoreO++;
    }

    private static void printFinalScores() {
        System.out.println("\n🏆 Final Scores:");
        System.out.println(playerX + " (X): " + scoreX);
        System.out.println(playerO + " (O): " + scoreO);
    }

    private static boolean askPlayAgain() {
        while (true) {
            System.out.print("\nDo you want to play again? (y/n): ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                continue;
            }

            // Take only the first character safely
            char choice = input.charAt(0);

            if (choice == 'y') {
                return true;
            }
            if (choice == 'n') {
                return false;
            }

            // Optional: also accept full words
            if (input.startsWith("yes")) return true;
            if (input.startsWith("no"))  return false;

            System.out.println("Please enter y or n (or yes/no).");
        }
    }

    private static void printWelcomeMessage() {
        System.out.println("=================================");
        System.out.println("        TIC TAC TOE GAME         ");
        System.out.println("=================================");
        System.out.println("Instructions:");
        System.out.println("- Two players take turns (X and O)");
        System.out.println("- Enter row and column (0 to " + (SIZE-1) + ")");
        System.out.println("- First to get 3 in a row wins");
        System.out.println("- Example: enter 1 then press Enter, then 2");
        System.out.println("=================================\n");
    }
}