package chess;

public class Board {
	private ChessPiece[][] tiles = new ChessPiece[8][8];

	public void clearBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tiles[i][j] = null;
			}
		}
	}

	public void resetBoard() {
		clearBoard();
		
		for (int i = 0; i < 8; i++) {
			tiles[i][1] = new Pawn(i, 1, true);
			tiles[i][6] = new Pawn(i, 1, false);
		}

		tiles[0][0] = new Rook(0, 0, true);
		tiles[7][0] = new Rook(7, 0, true);
		tiles[0][7] = new Rook(0, 7, false);
		tiles[7][7] = new Rook(7, 7, false);
		
		tiles[1][0] = new Knight(1, 0, true);
		tiles[6][0] = new Knight(6, 0, true);
		tiles[1][7] = new Knight(1, 7, false);
		tiles[6][7] = new Knight(6, 7, false);
		
		tiles[2][0] = new Bishop(2, 0, true);
		tiles[5][0] = new Bishop(5, 0, true);
		tiles[2][7] = new Bishop(2, 7, false);
		tiles[5][7] = new Bishop(5, 7, false);

		tiles[3][0] = new King(3, 0, true);
		tiles[4][7] = new King(4, 7, false);

		tiles[4][0] = new Queen(4, 0, true);
		tiles[3][7] = new Queen(3, 7, false);
	}

	public boolean movePiece(int x, int y, int newX, int newY) {
		if (tiles[x][y] == null) {
			return false;
		} else if (tiles[newX][newY] == null) {
			if (tiles[x][y].move(newX, newY)) {
				tiles[newX][newY] = tiles[x][y];
				tiles[x][y] = null;
				return true;
			} else {
				return false;
			}
		} else if (tiles[x][y].isWhite == tiles[newX][newY].isWhite) {
			return false;
		} else {
			if (tiles[x][y].move(newX, newY)) {
				tiles[newX][newY] = tiles[x][y];
				tiles[x][y] = null;
				return true;
			} else {
				return false;
			}
		}
	}
}
