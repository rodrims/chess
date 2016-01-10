package chess;

public class Tile {
	int x;
	int y;
	boolean tileWhite;
	ChessPiece piece;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		this.tileWhite = !((x + y) % 2 == 0);
		this.piece = null;
	}

    public boolean canMovePieceThere(Tile other) throws IllegalArgumentException {
        if (!this.hasPiece()) {
			throw new IllegalArgumentException("First tile cannot be empty.");
		} else if (piece.legalMove(this.x, this.y, other.x, other.y)) {
            if (!other.hasPiece()) {
                return true;
            } else if (this.piece.isWhite() == other.piece.isWhite()) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

	public boolean hasPiece() {
		return piece != null;
	}

	public ChessPiece getPiece() { // TODO: Need this?
		return piece;
	}

	public void setPiece(ChessPiece piece) { // TODO: Need this?
		this.piece = piece;
	}

	@Override
	public String toString() {
		String letter = String.valueOf(65 + x);
		String number = Integer.toString(y);
		return letter + number;
	}
}
