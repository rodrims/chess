package chess;

public class Pawn extends Piece {
	private String name = "Pawn";
	private String initial = "P"; // TODO: Eventually get rid of this (Pawns aren't supposed to have an abbreviation)
	private boolean firstMove = true;

	public Pawn(boolean isWhite) {
        super(isWhite);
    }

	public void moved() {
		firstMove = false;
	}

	@Override
	public boolean legalMove(int oldX, int oldY, int newX, int newY) {
		// Checks if x is same and y is 1 off in correct direction.
        int dY = newY - oldY;

        if (oldX != newX) {
            return false;
        } else if (firstMove) {
            return this.isWhite() ? dY == 1 || dY == 2 : dY == -1 || dY == -2;
        } else {
            return this.isWhite() ? dY == 1 : dY == -1;
        }
	}

	@Override
	public Tile[] path(int oldX, int oldY, int newX, int newY) {
		return null; // TODO: !!!
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getInitial() {
		return initial;
	}
}
