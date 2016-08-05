package chess;

public class Tile {
	int x;
	int y;
	boolean isWhite;
	Piece piece;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		this.isWhite = (x + y) % 2 != 0;
		this.piece = null;
	}

    public boolean movePieceTo(Tile other) {
        if (!this.hasPiece()) {
			throw new IllegalArgumentException("The first tile is empty.");
		} else if (piece.validMove(this.x, this.y, other.x, other.y)) {
            if (!other.hasPiece()) {
                return true;
            } else if (this.piece.sameColor(other.piece)) {
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

	public Piece getPiece() {
		return piece;
	}

	public Piece setPiece(Piece piece) {
        if (piece == null) {
            throw new IllegalArgumentException("Cannot set tile to null.");
        }

        Piece temp = this.piece;
        this.piece = piece;
        return temp;
	}

    public Piece clearPiece() {
        Piece temp = this.piece;
        this.piece = null;
        return temp;
    }

	@Override
	public String toString() {
		if (this.hasPiece()) {
			String letter = Character.toString((char) ('a' + this.x));
			String number = Integer.toString(1 + this.y);
			return this.piece.getLetter() + letter + number;
		} else {
			return isWhite ? "###" : "   ";
		}
	}
}
