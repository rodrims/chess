package chess;

public abstract class ChessPiece {
	protected boolean isWhite;

	public ChessPiece(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public abstract boolean legalMove(short start[], short end[]);

	public boolean isWhite() {
		return isWhite;
	}
}
