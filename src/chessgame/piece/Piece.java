package chessgame.piece;

import chessgame.Board;
import chessgame.Cell;
import chessgame.Color;

public abstract class Piece {
    private final Color color;

    protected Piece(Color color) {
        this.color = color;
    }

    public abstract boolean canMove(Board board, Cell from, Cell to);

    public Color getColor() {
        return this.color;
    }
}
