package chess;

public abstract class ChessPiece {
	protected short x;
	protected short y;
	protected boolean isWhite;

	public ChessPiece(short x, short y, boolean isWhite) {
		this.x = x;
		this.y = y;
		this.isWhite = isWhite;
	}

	public abstract boolean legalMove(short start[], short end[]);

	public boolean isWhite() {
		return isWhite;
	}
}
