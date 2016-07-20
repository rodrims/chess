package chess;

import java.util.LinkedList;

public class Rook extends Piece {
    private final String name = "Rook";
    private final String initial = "R";

    public Rook(boolean isWhite) {
        super(isWhite);
    }

	@Override
	public boolean legalMove(int oldX, int oldY, int newX, int newY) {
        if (oldX == newX) {
            return oldY != newY;
        } else if (oldY == newY) {
            return oldX != newX;
        } else {
            return false;
        }
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
