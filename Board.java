package chess;

public class Board {
	private final int SIZE = 8;
	private Piece[][] board = new Piece[SIZE][SIZE];

    public Board() {
		super();
    }

	public void clearBoard() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = null;
			}
		}
	}

	public void resetBoard() {
		clearBoard();

		// The magic numbers here simply correspond to the starting position of
		// pieces on a 8x8 board.
		for (int i = 0; i < 8; i++) {
			board[i][1] = new Pawn(true, i, 1);
			board[i][6] = new Pawn(false, i, 6);
		}

		board[0][0] = new Rook(true, 0, 0);
		board[7][0] = new Rook(true, 7, 0);
		board[0][7] = new Rook(false, 0, 7);
		board[7][7] = new Rook(false, 7, 7);

		board[1][0] = new Knight(true, 1, 0	);
		board[6][0] = new Knight(true, 6, 0);
		board[1][7] = new Knight(false, 1, 7);
		board[6][7] = new Knight(false, 6, 7);

		board[2][0] = new Bishop(true, 2, 0);
		board[5][0] = new Bishop(true, 5, 0);
		board[2][7] = new Bishop(false, 2, 7);
		board[5][7] = new Bishop(false, 5, 7);

		board[4][0] = new King(true, 4, 0);
		board[4][7] = new King(false, 4, 7);

		board[3][0] = new Queen(true, 3, 0);
		board[3][7] = new Queen(false, 3, 7);
	}

	public boolean hasPiece(int x, int y) {
		return board[x][y] != null;
	}

	public boolean pieceIsWhite(int x, int y) {
		return board[x][y].isWhite();
	}

	public boolean movePiece(int oldX, int oldY, int newX, int newY) {
        Piece from = board[oldX][oldY];
        Piece to = board[newX][newY];
		int[][] path = from.path(newX, newX);

		// Position is a tile on the board with [0] being x and [1] being y
		if (path != null) {
			for (int[] position : path) {
				System.out.printf("\nPiece at: %d, %d", position[0], position[1]);
				if (board[position[0]][position[1]] != null) {
					return false;
				}
			}
		}
		
		if (to == null) {
			if (board[oldX][oldY].moveTo(newX, newY)) {
				return putPiece(oldX, oldY, newX, newY);
			}
		} else if (!from.sameColor(to)) {
			if (board[oldX][oldY].captureAt(newX, newY)) {
				return putPiece(oldX, oldY, newX, newY);
			}
		}

		return false;
	}

	@Override
    public String toString() {
		String boardString = "";

        for (int j = SIZE; j > 0; j--) {
			boardString += "\n  +---+---+---+---+---+---+---+---+";
            boardString += String.format("\n%d ", j);
            for (int i = 0; i < SIZE; i++) {
                boardString += "|";
                boardString += positionToString(i, j - 1);
            }
			boardString += "|";
        }

		boardString += "\n  +---+---+---+---+---+---+---+---+";
		boardString += "\n    a   b   c   d   e   f   g   h\n";

		return boardString;
    }

	/*
	 * PRIVATE HELPER METHODS
	 */

	private boolean putPiece(int oldX, int oldY, int newX, int newY) {
		board[newX][newY] = board[oldX][oldY];
		board[oldX][oldY] = null;
		// Always returns true for the purposes of movePiece()
		return true;
	}

	private String positionToString(int x, int y) {
		if (board[x][y] != null) {
			return " " + board[x][y].toString();
		}

		return "   ";
	}
}
