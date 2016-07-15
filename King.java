package chess;

public class King extends Piece {
    private final String name = "King";
    private final String initial = "K";
    private boolean firstMove = true;

    public King(boolean isWhite) {
        super(isWhite);
    }

    public void moved() {
        firstMove = false;
    }

	@Override
	public boolean legalMove(int oldX, int oldY, int newX, int newY) {
		int dX = newX - oldX;
		int dY = newY - oldY;
        if (dX == 0) {
            return (dY > 0 ? dY : - dY) == 1;
        } else if ((dX > 0 ? dX : -dX) == 1) {
            return (dY > 0 ? dY : -dY) <= 1;
        } else {
            return false;
        }
        // TODO: Implement castling check;
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
