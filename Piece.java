package chess;

import static java.lang.Math.abs;

public abstract class Piece {
	protected static String name;
	protected static String letter;
	protected boolean isWhite;
	protected int x;
	protected int y;

	public Piece(String name, String letter, boolean isWhite) {
		this.name = name;
		this.letter = letter;
		this.isWhite = isWhite;
	}

	public Piece(String name, String letter, boolean isWhite, int x, int y) {
		this(name, letter, isWhite);
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return this.letter;
	}

	public  String getLetter() {
		return this.letter;
	}

    public boolean isWhite() {
        return isWhite;
    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

    public boolean sameColor(Piece other) {
        return this.isWhite == other.isWhite;
    }

	public boolean moveTo(int newX, int newY) {
		if (legalPosition(newX, newY)) {
			this.x = newX;
			this.y = newY;
			return true;
		}

		return false;
	}

	/*
	 * Returns whether the position is a legal one for capturing.
	 */
	public boolean captureAt(int newX, int newY) {
		return legalPosition(newX, newY);
	}

	/*
	 * Returns a path of coordinates the move would take the piece through.
	 */
 	public int[][] path(int newX, int newY) {
		// I avoid these, but not impossible to continue if !legalPosition().
		if (!legalPosition(newX, newY)) {
			throw new IllegalArgumentException("Cannot compute path.");
		}

		int[][] path;
		// Stand for "delta x" and "delta y".
		int dX = newX - x;
		int dY = newY - y;
		// Gives an increment variable so whether dX and dY are positive or
		// negative can be disregarded.
		int incX = dX == 0 ? 0 : dX > 0 ? 1 : -1;
		int incY = dY == 0 ? 0 : dY > 0 ? 1 : -1;

		// Distance is the number of positions, minus one, moved through. This
		// is calculated using Math.abs.
		int distance = (dX != 0 ? abs(dX) : abs(dY)) - 1;
		if (distance == 0) {
			path = null;
		} else {
			path = new int[distance][2];
			int currX = x + incX;
			int currY = y + incY;
			for (int i = 0; i < distance; i++) {
				path[i][0] = currX;
				path[i][1] = currY;
				currX += incX;
				currY += incY;
			}
		}

		return path;
	}

	@Override

	public String toString() {
		return (isWhite ? "w" : "b") + letter; 
	}

	/*
	 * ___ABSTRACT METHODS___
	 */

	/*
	 * Returns whether the position is legal based on the current position.
	 */
	protected abstract boolean legalPosition(int newX, int newY);
}
