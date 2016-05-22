package chess;

public class Bishop extends ChessPiece {
    public Bishop(boolean isWhite) {
        super("Bishop", isWhite);
    }

	@Override
	public boolean legalMove(int oldX, int oldY, int newX, int newY) {
		int dX = newX - oldX;
		int dY = newY - oldY;
        // Checks to see if the absolute value of the delta values are equal.
		return (dX > 0 ? dX : -dX) == (dY > 0 ? dY : -dY);
	}
}
