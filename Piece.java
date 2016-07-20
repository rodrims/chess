package chess;

import java.util.LinkedList;

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

	/*
	 * Returns a collection of all the pieces in the path between the starting
	 * and final point so as to check if the move can be executed in addition to
	 * making sure it is a legal move. Both legal move should return true and
	 * path should return an empty collection for any set of movement points.
	 */
 	public abstract LinkedList<Piece> path(int oldX, int oldY, int newX, int newY);

 	public abstract String getName();

 	public abstract String getInitial();
}
