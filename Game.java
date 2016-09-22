package chess;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Game {
    private static boolean newGame = false; // TODO: What was this for again?
    private static boolean whiteTurn = true;
	private static Board board = new Board();
    private static Scanner sc = new Scanner(System.in);
    private static Pattern patt = Pattern.compile("[a-h][1-8] to [a-h][1-8]");

	public static void main(String[] args) throws IOException, InterruptedException {
		boolean exit = false;
		String command = "";

		System.out.println("Welcome to Console Chess!");
		System.out.println("Enter your commands or 'help' for help: ");
        newGame();

		do {
            if (sc.hasNext()) {
                command = sc.nextLine().trim();
                exit = handleInput(command);
            } else {
                System.out.println();
            }
		} while(!exit);
	}

	private static boolean handleInput(String inputString) throws IOException, InterruptedException {
        if (inputString.equals("new game")) {
           newGame();
       } else if (inputString.equals("print board")) {
			printBoard();
        } else if (inputString.equals("help")) {
            System.out.println(
                "new game - starts a new game\n"
                + "print board - displays a refreshed view of the board\n"
                + "help - shows this dialog\n"
                + "move a1 to a2 - will execute the move described\n"
                + "exit - will quit console chess");
        } else if (inputString.length() > 5 ? inputString.substring(0, 5).equals("move ") : false) {
            moveCommand(inputString.substring(5));
        } else if (inputString.equals("exit")) {
            System.out.println("Console Chess will now exit.");
            return true;
        } else {
            System.out.println("That command is not recognized.");
        }
		return false;
	}

    private static void newGame() throws IOException, InterruptedException {
        board.resetBoard();
        newGame = true;
        whiteTurn = true;
        System.out.println("You've started a new game, white goes first.");
		printBoard();
    }

    private static void moveCommand(String moveString) throws IOException, InterruptedException {
        // This matcher is delcared here since it needs to be re-initialized
        // for every different string (I think). So it's easier to declare and
        // initialize here in one step than in multiple convoluted ones.
        Matcher matcher = patt.matcher(moveString);

        if (matcher.matches()) {
            // TODO magic numbers here
            int oldX = moveString.charAt(0) - 'a';
            int oldY = moveString.charAt(1) - '1';
            int newX = moveString.charAt(6) - 'a';
            int newY = moveString.charAt(7) - '1';
			if (!movePiece(oldX, oldY, newX, newY)) {
				System.out.println("That move is illegal");
			} else {
				printBoard();
			}
        } else {
            System.out.println("That is not a valid move command.");
        }
    }

    private static boolean movePiece(int oldX, int oldY, int newX, int newY) {
		if (board.hasPiece(oldX, oldY)) {
			if (board.pieceIsWhite(oldX, oldY) == whiteTurn) {
				return board.movePiece(oldX, oldY, newX, newY);
			}
		}

		return false;
	}

	private static void printBoard() throws IOException, InterruptedException {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		System.out.println(board.toString());
	}
}
