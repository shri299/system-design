package chessgame.piece;

import chessgame.Board;
import chessgame.Cell;
import chessgame.Color;

public class Bishop extends Piece{

    public Bishop (Color color){
        super(color);
    }
    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        return false;
    }
}
