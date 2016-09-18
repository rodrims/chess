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

	// TODO this shouldn't be used as it allows the caller to be able to call
	// the piece's moveTo() function without actually moving the piece on the
	// board.
	public Piece getPiece(int x, int y) {
		if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
			throw new IllegalArgumentException("Coordinates ouside board.");
		} else {
			return board[x][y];
		}
	}

    /*
     * The piece chosen is guaranteed to be the correct color of the current
     * player whose turn it is. The position is also guaranteed to have a piece.
     */
	public boolean movePiece(int oldX, int oldY, int newX, int newY) {
		boolean retVal = true;
        Piece from = board[oldX][oldY];
        Piece to = board[newX][newY];
		int[][] path = from.path(newX, newX);

		// Position represents a position on the board and the first and second
		// elements respectively represent that position's x and y values.
		if (path != null) {
			for (int[] position: path) {
				if (board[position[0]][position[1]] != null) {
					return false;
				}
			}
		}
		
		// TODO Maybe put in a putPiece() helper method so no repeat code?
		if (to == null) {
			if (board[oldX][oldY].moveTo(newX, newY)) {
				board[newX][newY] = board[oldX][oldY];
				board[oldX][oldY] = null;
				return true;
			}
		} else if (!from.sameColor(to)) {
			if (board[oldX][oldY].captureAt(newX, newY)) {
				board[newX][newY] = board[oldX][oldY];
				board[oldX][oldY] = null;
				return true;
			}
		}

		return false;
	}

    public void printBoard() {
        for (int j = SIZE - 1; j >= 0; j--) {
            System.out.print("\n  +---+---+---+---+---+---+---+---+\n");
            System.out.printf("%d ", j + 1);
            for (int i = 0; i < SIZE; i++) {
                System.out.print("|");
                System.out.printf(board[i][j].toString());
            }
            System.out.print("|");
        }
        System.out.print("\n  +---+---+---+---+---+---+---+---+");
        System.out.print("\n    a   b   c   d   e   f   g   h\n");
    }
}
