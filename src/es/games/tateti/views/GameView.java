package es.games.tateti.views;

import java.util.Scanner;
import es.games.tateti.models.Board;
import es.games.tateti.models.Coordinates;
import es.games.tateti.models.Turn;

public class GameView {
	public Scanner sc = new Scanner(System.in);
	private String answer = "";
	private boolean error;
    private final BoardView boardView;
    private final TurnView turnView;
    private final Turn turn;
    private final Board board;
	private final Coordinates coordinates;
	

    public GameView() {
    	this.turn = new Turn();
        this.board = new Board();
        this.boardView = new BoardView(this.board);
		this.coordinates = new Coordinates(this.board);
        this.turnView = new TurnView(this.board, this.coordinates);
    }
    
    
	public boolean isAfirmative() {
		return answer.equalsIgnoreCase("si");
	}
	public boolean isNegative() {
		return answer.equalsIgnoreCase("no");
	}
	
	public boolean read() {
		do {
			System.out.println("Desea jugar otra vez?");
			this.answer = sc.nextLine(); 
			error = !this.isAfirmative() && !this.isNegative();
			if (error) {
				System.out.println("Debe completar con si o no");
			}
		} while (error);
		return error;
	}

    public void playGames() { 
    	do {
    		this.playGame();
    	}while(this.read() == this.isNegative());
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