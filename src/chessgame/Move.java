package chessgame;

public class Move {

    private final Cell start; //move object will not be modified, as every move will create new object itself instead of tampering existing one
    private final Cell end;

    public Move(Cell start, Cell end) {
        this.start = start;
        this.end = end;
    }

    public Cell getStart() { return start; }

    public Cell getEnd() { return end; }
}
