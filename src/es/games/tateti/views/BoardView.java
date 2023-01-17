package es.games.tateti.views;

import es.games.tateti.models.Board;
import es.games.tateti.models.Coordinates;

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
        for (int i = 0; i < Coordinates.ROWS; i++) {
            for (int j = 0; j < Coordinates.COLUMNS; j++) {
                System.out.print("| " + this.board.getGameBoard()[i][j] + " ");
            }
            System.out.print("|\n-------------\n");
        }
    }
    
    public void showResult(String activePlayer) {
    	if (this.board.taTeTiWin() == true) {
    		System.out.print("El ganador es: " + activePlayer + "\n");
    	} else {
    		System.out.println("Empate");
    	}		
    }
}