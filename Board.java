package chess;

public class Board {
	private Tile[][] board = new Tile[8][8];

    public Board() {
        for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Tile(i, j);
			}
        }
    }    

	public void clearBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j].setPiece(null);
			}
		}
	}

	public void resetBoard() {
		clearBoard();
		
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

	public boolean movePiece(int oldX, int oldY, int newX, int newY) {
        Tile from = board[oldX][oldY];
        Tile to = board[newX][newY];

		if (from.canMovePieceThere(to)) {
            to.setPiece(from.getPiece());
            from.setPiece(null);
            return true;
        } else {
				return false;
        }
        // TODO: Implement use of {@code : moved()} methods
	}
}
