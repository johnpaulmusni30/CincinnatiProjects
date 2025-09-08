import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String[][] board = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean keepPlaying;

        System.out.println("Hello! I'm so glad to see you join us in TicTacToe!");
        System.out.println("If you want to play, please input numbers ranging from 1-3 to choose the row and column you want to put your piece!");
        System.out.println("Have fun!");

        do {
            board();
            String player = "X";
            int turnCount = 0;

            while (true) {
                board2();

                System.out.println(player + "'s move. Pick a spot:");
                int row = -1,
                        col = -1;

                System.out.print("Row (1-3): ");
                if (input.hasNextInt()) {
                    row = input.nextInt() - 1;
                } else {
                    System.out.println("Sorry, but values must be 1-3! Please try again");
                    input.nextLine(); // Clear the invalid input
                    continue;
                }

                System.out.print("Column (1-3): ");
                if (input.hasNextInt()) {
                    col = input.nextInt() - 1;
                } else {
                    System.out.println("Sorry, but values must be 1-3! Please try again");
                    input.nextLine(); // Clear the invalid input
                    continue;
                }

                if (row < 0 || row >= ROW || col < 0 || col >= COL || !board[row][col].equals(" ")) {
                    System.out.println("Hey. That space is occupied! No cheating!");
                    continue;
                }

                board[row][col] = player;
                turnCount++;

                if (turnCount >= 5 && checker(player)) {
                    board2();
                    System.out.println("Congrats, " + player + " wins!");
                    break;
                } else if (turnCount == ROW * COL) {
                    board2();
                    System.out.println("Aw man! It is a draw.");
                    break;
                }

                player = player.equals("X") ? "O" : "X"; // switch players
            }

            System.out.print("Would you like to play another game? (y/n): ");
            keepPlaying = input.next().trim().equalsIgnoreCase("y");

        } while (keepPlaying);

        System.out.println("Thanks for playing! Hope to see you soon!");
        input.close();
    }

    private static void board() {
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                board[r][c] = " ";
            }
        }
    }

    private static void board2() {
        System.out.println();
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                System.out.print(board[r][c]);
                if (c < COL - 1) System.out.print(" | ");
            }
            System.out.println();
            if (r < ROW - 1) System.out.println("--+---+--");
        }
        System.out.println();
    }

    private static boolean checker(String player) {
        for (int i = 0; i < ROW; i++) {
            if (player.equals(board[i][0]) && player.equals(board[i][1]) && player.equals(board[i][2]))
                return true;
        }
        for (int i = 0; i < COL; i++) {
            if (player.equals(board[0][i]) && player.equals(board[1][i]) && player.equals(board[2][i]))
                return true;
        }
        if (player.equals(board[0][0]) && player.equals(board[1][1]) && player.equals(board[2][2]))
            return true;
        if (player.equals(board[0][2]) && player.equals(board[1][1]) && player.equals(board[2][0]))
            return true;

        return false;
    }
}
