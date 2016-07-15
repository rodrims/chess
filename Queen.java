package chess;

public class Queen extends Piece {
    private final String name = "Queen";
    private final String initial = "Q";

    public Queen(boolean isWhite) {
        super(isWhite);
    }

	@Override
	public boolean legalMove(int oldX, int oldY, int newX, int newY) {
		int dX = newX - oldX;
		int dY = newY - oldY;
        if (dX == 0) {
            return dY != 0;
        } else if (dY == 0) {
            return true;
        } else {
            return (dX > 0 ? dX : -dX) == (dY > 0 ? dY : -dY);
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
