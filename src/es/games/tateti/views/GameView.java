package es.games.tateti.views;


import es.games.tateti.models.Board;
import es.games.tateti.models.Turn;

public class GameView {
    private final BoardView boardView;
    private final Turn turn;
    private final Board board;

//---------------------------------------------------------------------------------------------------

    public GameView() {
        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn();
    }

//---------------------------------------------------------------------------------------------------

    public void playGame() {
        this.boardView.showTitle();
        this.board.resetBoard();
        this.boardView.showBoard();
        do {
            this.turn.interact();
            this.boardView.showBoard();
        } while(this.board.isFinished(this.turn.getAlgo()) != true);
    }
}