package chess;

public abstract class Piece {
	private String name;
	private String letter;
	private boolean isWhite;

	public Piece(String name, String letter, boolean isWhite) {
		this.name = name;
		this.letter = letter;
		this.isWhite = isWhite;
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

    public boolean sameColor(Piece other) {
        return this.isWhite == other.isWhite;
    }

	public void moved() {
		return; // This will be overriden/necessary in certain instances
	}

	/*
	 * Abstract methods
	 */

	/*
	 * Returns whether the specified final position is valid for the piece given
	 * the starting position.
	 */
	protected abstract boolean legalPosition(int oldX, int oldY, int newX, int newY);

	/*
	 * Returns whether the speciefied move is a valid one by making sure the
	 * final position is legal as well as the path taken to that position is
	 * empty of other pieces. This method should call the legalPosition(...)
	 * method first.
	 */
 	public abstract boolean validMove(int oldX, int oldY, int newX, int newY);
}
