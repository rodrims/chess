package chess;

public class Tile {
	int x;
	int y;
	boolean isWhite;
	ChessPiece piece;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
		this.isWhite = !((x + y) % 2 == 0);
		this.piece = null;
	}

	public boolean movePiece(ChessPiece piece) {
		if (piece == null) {

		if (piece.isWhite() == this.piece.isWhite()) {
			return false;
		} else if (!piece.move(this.x, this.y)) {
			return false;
		} else {
			this.piece = piece;
		}

	@Override
	public String toString() {
		String letter = String.valueOf(x + 65);
		String number = Integer.toString(y);
		return letter + number;
	}
}
