package es.games.tateti.views;

import es.games.tateti.models.Board;
import es.games.tateti.models.Turn;
import es.games.tateti.utils.YesNoDialog;

public class GameView {
    private final BoardView boardView;
    private final Turn turn;
    private final Board board;
	private final YesNoDialog yesNoDialog;


    public GameView() {
        this.board = new Board();
        this.boardView = new BoardView(this.board);
        this.turn = new Turn();
        this.yesNoDialog = new YesNoDialog();
    }


    public void playGames() { 
    	do {
    		this.playGame();
    	}while(this.yesNoDialog.read() == this.yesNoDialog.isNegative());
    }
    
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