package chess;

import java.util.LinkedList;

public class Bishop extends Piece {
    private final String name = "Bishop";
    private final String initial = "B";

    public Bishop(boolean isWhite) {
        super(isWhite);
    }

	@Override
	public boolean legalMove(int oldX, int oldY, int newX, int newY) {
		int dX = newX - oldX;
		int dY = newY - oldY;
        // Checks to see if the absolute value of the delta values are equal.
		return (dX > 0 ? dX : -dX) == (dY > 0 ? dY : -dY);
	}

    @Override
    public LinkedList<Piece> path(int oldX, int oldY, int newX, int newY) {
        return new LinkedList<Piece>(); // TODO: !!!
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
