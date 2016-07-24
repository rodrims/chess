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
        Board board = Game.getBoard();
        LinkedList<Piece> lList = new LinkedList<>();

        if (!legalMove(oldX, oldY, newX, newY)) {
            throw new IllegalArgumentException("The move is not legal.");
        } else {
            int dX = newX - oldX;
            int dY = newY - oldY;

            if (dX > 0) {
                for (int i = 1; i < dX; i++) {
                    if (board.getPiece(oldX + i, oldY) != null) {
                        lList.add(board.getPiece(oldX + i, oldY));
                    }
                }
            } else if (dX < 0) {
                for (int i = -1; i > dX; i--) {
                    if (board.getPiece(oldX + i, oldY) != null) {
                        lList.add(board.getPiece(oldX + i, oldY));
                    }
                }
            } else if (dY > 0) {
                for (int i = 1; i < dY; i++) {
                    if (board.getPiece(oldX, oldY + i) != null) {
                        lList.add(board.getPiece(oldX, oldY + i));
                    }
                }
            } else if (dY < 0) {
                for (int i = -1; i > dY; i--) {
                    if (board.getPiece(oldX, oldY + i) != null) {
                        lList.add(board.getPiece(oldX, oldY + i));
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
