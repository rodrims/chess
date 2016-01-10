package chess;

public abstract class ChessPiece {
	protected boolean isWhite;

	public ChessPiece(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public abstract boolean legalMove(int oldX, int oldY, int newX, int newY);

	public boolean isWhite() {
		return isWhite;
	}
}
