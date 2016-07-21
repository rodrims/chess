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
        Board board = Game.getBoard();
        LinkedList<Piece> lList = new LinkedList<>();

        if (!legalMove(oldX, oldY, newX, newY)) {
            throw new IllegalArgumentException("The move is not legal.");
        } else {
            int dX = newX - oldX;
    		int dY = newY - oldY;

            /*
             * This variable is a counter to iterate through the number of
             * spaces moved through. dY could also be used here we just need the
             * positive value for how many spaces were moved through.
             */
            int counter = dX > 0 ? dX : -dX;
            /*
             * Both dX and dY will have the same absolute value (because of how
             * bishops move), it is only necessary to get their "direction" i.e.
             * whether they are positive or negative values.
             */
            if (dX > 0 && dY > 0) {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX + i, oldY + i) != null) {
                        lList.add(board.getPiece(oldX + i, oldY + i));
                    }
                }
            } else if (dX > 0 && dY < 0) {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX + i, oldY - i) != null) {
                        lList.add(board.getPiece(oldX + i, oldY + i));
                    }
                }
            } else if (dX < 0 && dY > 0) {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX - i, oldY + i) != null) {
                        lList.add(board.getPiece(oldX + i, oldY + i));
                    }
                }
            } else if (dX < 0 && dY < 0) {
                for (int i = 1; i < counter; i++) {
                    if (board.getPiece(oldX - i, oldY - i) != null) {
                        lList.add(board.getPiece(oldX + i, oldY + i));
                    }
                }
            }
        }

        return lList;
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
