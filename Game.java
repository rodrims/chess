package chess;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Game {
    private static boolean newGame = false;
    private static boolean whiteTurn = true;
	private static Board board = new Board();
    private static Scanner sc = new Scanner(System.in);
    private static Pattern movePatt = Pattern.compile("[a-h][1-8][ ][t][o][ ][a-h][1-8]");

	public static void main(String[] args) {
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

	private static boolean handleInput(String inputString) {
        if (inputString.equals("new game")) {
           newGame();
       } else if (inputString.equals("print board")) {
			board.printBoard();
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

    private static void newGame() {
        board.resetBoard();
        newGame = true;
        whiteTurn = true;
        System.out.println("\nYou've started a new game, white goes first.\n");
		board.printBoard();
    }

    private static void moveCommand(String moveString) {
        Matcher moveMatch = movePatt.matcher(moveString);

        if (moveMatch.matches()) {
            int oldX = moveString.charAt(0) - 'a';
            int oldY = moveString.charAt(1) - '1';
            int newX = moveString.charAt(6) - 'a';
            int newY = moveString.charAt(7) - '1';
            movePiece(oldX, oldY, newX, newY);
        } else {
            System.out.println("No match.");
        }
    }

    private static void movePiece(int oldX, int oldY, int newX, int newY) {
        Piece chosenPiece = board.getPiece(oldX, oldY);

        if (chosenPiece == null) {
            System.out.println("There is no piece on that space.");
        } else if (chosenPiece.isWhite() == whiteTurn) {
			boolean moveSuccess = board.movePiece(oldX, oldY, newX, newY);
			if (moveSuccess) {
				whiteTurn = !whiteTurn;
                board.printBoard();
			} else {
				System.out.println("That is an illegal move.");
			}
		} else {
			String color =  whiteTurn ? "white" : "black";
			System.out.printf("That is not %s's piece.\n", color);
		}
	}
}
