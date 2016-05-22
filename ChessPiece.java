package chess;

public abstract class ChessPiece {
	protected String name;
	protected boolean isWhite;

	public ChessPiece(String name, boolean isWhite) {
		this.name = name;
		this.isWhite = isWhite;
	}

	public abstract boolean legalMove(int oldX, int oldY, int newX, int newY);

	public boolean isWhite() {
		return isWhite;
	}

	public String getName() {
		return name;
	}
}
