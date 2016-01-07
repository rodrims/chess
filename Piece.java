package chess;

public abstract class Piece {
	protected int x;
	protected int y;
	
	Piece(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public abstract boolean move(int x, int y);
}
