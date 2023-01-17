package es.games.tateti.models;

import es.games.tateti.utils.ClosedIntervals;

public class Coordinates {
	public static final int ROWS = 3;
    public static final int COLUMNS = 3;
    private ClosedIntervals closedIntervals;
    private Board board;
    

    public Coordinates(Board board) {
    	this.board = board;
    }
    
    
    public boolean isCorrect(int numero) {
    	closedIntervals = new ClosedIntervals(0, Coordinates.COLUMNS);
    	return !closedIntervals.isIncluded(numero);
    }

    public boolean isOccupied(int fila, int columna) {
    	return !board.getGameBoard()[fila-1][columna-1].equals(Board.TOKEN_NULL) ;
    }
}
