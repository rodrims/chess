package chess;

public abstract class Piece {
	private boolean isWhite;

	public Piece(boolean isWhite) {
		this.isWhite = isWhite;
	}

    public boolean isWhite() {
        return isWhite;
    }

    public boolean sameColor(Piece other) {
        return this.isWhite == other.isWhite;
    }

	public void moved() {
		return; // This will be overriden only in certain instances
	}

	/*
	 * Abstract methods
	 */
	public abstract boolean legalMove(int oldX, int oldY, int newX, int newY);

 	public abstract Tile[] path(int oldX, int oldY, int newX, int newY);

 	public abstract String getName();

 	public abstract String getInitial();
}
