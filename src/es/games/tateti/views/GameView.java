package es.games.tateti.views;

import es.games.tateti.models.Board;
import es.games.tateti.models.Game;
import es.games.tateti.models.Turn;
import es.games.tateti.utils.YesNoDialog;

public class GameView {
    private final BoardView boardView;
    private final TurnView turnView;
    private final Turn turn;
    private final Board board;
	private final YesNoDialog yesNoDialog;
	private final Game game;


    public GameView() {
    	this.turn = new Turn();
        this.board = new Board();
        this.game = new Game(this.board);
        this.boardView = new BoardView(this.board, this.game);
        this.turnView = new TurnView(this.board);
        this.yesNoDialog = new YesNoDialog();
    }


    public void playGames() { 
    	do {
    		this.playGame();
    	}while(this.yesNoDialog.read() == this.yesNoDialog.isNegative());
    }
    
    public void playGame() {
    	String activePlayer;
    	this.boardView.showTitle();
        this.board.resetBoard();
        this.boardView.showBoard();
        do {
        	activePlayer = this.turn.getActivePlayer();
            this.turnView.interact(activePlayer);
            this.boardView.showBoard();
        } while(this.game.isFinished() != true);
        this.boardView.showResult(activePlayer);
    }
}