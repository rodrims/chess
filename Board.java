package chess;

public class Board {
	private final int SIZE = 8;
	private Tile[][] board = new Tile[SIZE][SIZE];

    public Board() {
        for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				board[i][j] = new Tile(i, j);
			}
        }
    }

	public void clearBoard() {
		for (Tile[] tileArr : board) {
			for (Tile tile : tileArr) {
				tile.clearPiece();
			}
		}
	}

	public void resetBoard() {
		clearBoard();

        /*
         * Lots of magic numbers here that simply represent where on a
         * chessboard these pieces go
         */
		for (int i = 0; i < 8; i++) {
			board[i][1].setPiece(new Pawn(true));
			board[i][6].setPiece(new Pawn(false));
		}

		board[0][0].setPiece(new Rook(true));
		board[7][0].setPiece(new Rook(true));
		board[0][7].setPiece(new Rook(false));
		board[7][7].setPiece(new Rook(false));

		board[1][0].setPiece(new Knight(true));
		board[6][0].setPiece(new Knight(true));
		board[1][7].setPiece(new Knight(false));
		board[6][7].setPiece(new Knight(false));

		board[2][0].setPiece(new Bishop(true));
		board[5][0].setPiece(new Bishop(true));
		board[2][7].setPiece(new Bishop(false));
		board[5][7].setPiece(new Bishop(false));

		board[4][0].setPiece(new King(true));
		board[4][7].setPiece(new King(false));

		board[3][0].setPiece(new Queen(true));
		board[3][7].setPiece(new Queen(false));
	}

	public Piece getPiece(int x, int y) throws IllegalArgumentException {
		if (x < 0 || x > SIZE - 1 || y < 0 || y > SIZE - 1) {
			throw new IllegalArgumentException("Coordinates ouside of range of board.");
		} else {
			return board[x][y].getPiece();
		}
	}

	public boolean movePiece(int oldX, int oldY, int newX, int newY) {
        Tile from = board[oldX][oldY];
        Tile to = board[newX][newY];

        if (!from.hasPiece()) {
            System.out.println("There is no piece there.");
            return false;
        } else if (Game.whiteTurn != from.getPiece().isWhite()) {
            System.out.println("That is not your piece.");
        } else if (from.movePieceTo(to)) { // TODO: Check for a clear path
            to.setPiece(from.getPiece());
            from.clearPiece();
            to.getPiece().moved();
            return true; // Possibly return the removed piece (?)
        } else {
            System.out.println("Something else went wrong.");
			return false;
        }
	}

    public void printBoard() {
        for (int j = SIZE - 1; j >= 0; j--) {
            System.out.print("+---+---+---+---+---+---+---+---+\n");
            for (int i = 0; i < SIZE; i++) {
                System.out.print("|");
                System.out.print(board[i][j].toString());
            }
            System.out.print("|");
        }
        System.out.print("+---+---+---+---+---+---+---+---+\n");
    }
}
