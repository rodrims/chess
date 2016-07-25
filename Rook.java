package chess;

public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super("Rook", "R", isWhite);
    }

	@Override
	protected boolean legalPosition(int oldX, int oldY, int newX, int newY) {
        int dX = newX - oldX;
        int dY = newY - oldY;

        /*
         * A rook moves either vertically or horizontally at one time. So either
         * dX or dY must be zero and both cannot be zero and both cannot be
         * non-zero.
         */
        return (dX == 0) ^ (dY == 0);
	}

    @Override
    public boolean validMove(int oldX, int oldY, int newX, int newY) {
        Board board = Game.getBoard();

        if (this.legalPosition(oldX, oldY, newX, newY)) {
            int dX = newX - oldX;
            int dY = newY - oldY;

            /*
             * This variable is a counter to iterate through the number of
             * spaces moved through. If dX is non-zero then dY must be zero, and
             * if dY is non-zero then dX must be non-zero from the call to
             * legalMove(...) above.
             */
            int counter = dX != 0 ? Math.abs(dX) : Math.abs(dY);

            if (dX > 0) {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX + i, oldY) != null) {
                        return false;
                    }
                }
            } else if (dX < 0) {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX - i, oldY) != null) {
                        return false;
                    }
                }
            } else if (dY > 0) {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX, oldY + i) != null) {
                        return false;
                    }
                }
            } else {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX, oldY - i) != null) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }

        return true;
    }
}
