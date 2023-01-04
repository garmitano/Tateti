package es.games.tateti.views;

import es.games.tateti.models.Board;
import es.games.tateti.models.Turn;

public class BoardView {
    private final Board board;

    public BoardView(Board board) {
        this.board = board;
    }

    public void showTitle() {
        System.out.println("Ta Te Ti");
    }

    public void showBoard() {
        System.out.print("-------------\n");
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                board.getGameBoard()[i][j] = Turn.TOKEN_NULL;
                System.out.print("| " + board.getGameBoard()[i][j] + " ");
            }
            System.out.print("|\n-------------\n");
        }
    }

}