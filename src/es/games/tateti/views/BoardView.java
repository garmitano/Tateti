package es.games.tateti.views;

import es.games.tateti.models.Board;
import es.games.tateti.models.Game;

public class BoardView {
    private final Board board;
    private Game game; 

    
    public BoardView(Board board, Game game) {
        this.board = board;
        this.game = game;
    }

    
    public void showTitle() {
        System.out.println("Ta Te Ti");
    }

    public void showBoard() {
        System.out.print("-------------\n");
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                System.out.print("| " + this.board.getGameBoard()[i][j] + " ");
            }
            System.out.print("|\n-------------\n");
        }
    }
    
    public void showResult(String activePlayer) {
    	if (this.game.isFinished() == true) {
    		
    		System.out.print("El ganador es: " + activePlayer + "\n");
    	} else {
    		System.out.println("Empate");
    	}
    		
    }

}