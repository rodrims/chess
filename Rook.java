package chess;

public class Rook extends ChessPiece {
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
}
