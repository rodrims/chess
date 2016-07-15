package chess;

import java.util.Scanner;

public class Game {
    private static boolean newGame = false;
    private static boolean whiteTurn = true;
	private static Board board = new Board();
    private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
        board.resetBoard();
        board.printBoard();
		// boolean exit = false;
		// String command = "";
        //
		// System.out.println("Welcome to Console Chess!");
		// System.out.println("Enter your commands or 'help' for help: ");
        // newGame();
        //
		// do {
        //     if (sc.hasNext()) {
        //         command = sc.next().trim();
        //         exit = handleConsoleInput(command);
        //     } else {
        //         System.out.println();
        //     }
		// } while(!exit);
	}

	private static boolean handleConsoleInput(String inputString) {
        if (inputString.equals("newGame")) {
           newGame();
        } else if (inputString.equals("printBoard")) {
			board.printBoard();
        } else if (inputString.equals("help")) {
            System.out.println("Currently no help. Whoops.");
        } else if (inputString.equals("move")) {
			// TODO: Will be prone to user errors that crash program
			int oldX = sc.nextInt();
			int oldY = sc.nextInt();
			int newX = sc.nextInt();
			int newY = sc.nextInt();
			movePiece(oldX, oldY, newX, newY);
        } else if (inputString.equals("exit")) {
            System.out.println("Console Chess will now exit.");
            return true;
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

    private static void movePiece(int oldX, int oldY, int newX, int newY) {
        Piece chosenPiece = board.getPiece(oldX, oldY);

        if (chosenPiece.isWhite() != whiteTurn) {
            System.out.println("That is not your piece.");
        }
        if (!(board.getPiece(oldX, oldY).isWhite() != whiteTurn)) {
			boolean moveSuccess = board.movePiece(oldX, oldY, newX, newY);
			if (moveSuccess) {
				whiteTurn = whiteTurn ? false : true;
			} else {
				System.out.println("That is an illegal move.");
			}
		} else {
			String color =  whiteTurn ? "white" : "black";
			System.out.printf("\nIt is not %s's turn.", color);
		}
	}
}
