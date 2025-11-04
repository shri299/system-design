package chessgame;

import chessgame.piece.Piece;

import java.util.Scanner;

public class Game {

    private final Board board;

    private Player whitePlayer, blackPlayer;
    private Player currentPlayer;

    public Game() {
        this.board = new Board();
    }

    public void setPlayers(String playerWhiteName, String playerBlackName) {
        this.whitePlayer = new Player(playerWhiteName, Color.WHITE);
        this.blackPlayer = new Player(playerBlackName, Color.BLACK);
        this.currentPlayer = whitePlayer;
    }

    public void start(){
        while(!isGameOver()){
            Player player = currentPlayer;
            System.out.println("Turn for: "+player.getName());
            //Take the input(srs and dest row col) from the user and return move
            Move move = getPlayerMove(player);
            try {
                board.movePiece(move);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Try again!");
                continue;
            }
            // Switch to the next player
            switchTurn();
        }

        //call the display result function : look for checkmate and stalemate
    }

    private void switchTurn() {
        currentPlayer = currentPlayer == whitePlayer ? blackPlayer : whitePlayer;
    }

    private Move getPlayerMove(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source row: ");
        int sourceRow = scanner.nextInt();
        System.out.print("Enter source column: ");
        int sourceCol = scanner.nextInt();
        System.out.print("Enter destination row: ");
        int destRow = scanner.nextInt();
        System.out.print("Enter destination column: ");
        int destCol = scanner.nextInt();

        Piece piece = board.getPiece(sourceRow, sourceCol);
        if (piece == null || piece.getColor() != player.getColor()) {
            throw new IllegalArgumentException("Invalid piece selection!");
        }

        return new Move(board.getCell(sourceRow, sourceCol), board.getCell(destRow, destCol));
    }

    private boolean isGameOver() {
        //add your checkmate and stalemate logic here
        return false;
    }
}
