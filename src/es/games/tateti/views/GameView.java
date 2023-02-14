package es.games.tateti.views;

import es.games.tateti.models.Board;
import es.games.tateti.models.Coordinates;
import es.games.tateti.models.Turn;
import es.games.tateti.utils.YesNoDialog;

public class GameView {
    private final BoardView boardView;
    private final TurnView turnView;
    private final Turn turn;
    private final Board board;
	private final YesNoDialog yesNoDialog;
	private final Coordinates coordinates;


    public GameView() {
    	this.turn = new Turn();
        this.board = new Board();
        this.boardView = new BoardView(this.board);
		this.coordinates = new Coordinates(this.board);
        this.turnView = new TurnView(this.board, this.coordinates);
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
        } while(!this.board.taTeTiWin());
        this.boardView.showResult(activePlayer);
    }
}