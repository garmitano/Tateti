package es.games.tateti.models;

public class Game {
	private Board board;
	
	
	public Game(Board board) {
		this.board = board;
	}
	
	
    public boolean isFinished() {
    	int contador = 0;
    	for (int i = 0; i < Coordinates.ROWS; i++) {
            for (int j = 0; j < Coordinates.COLUMNS; j++) {
            	if(!this.board.getGameBoard()[i][j].contains(Board.TOKEN_NULL)) {
            		contador++;
            	}
            }
    	}
    	if(this.board.taTeTiWin() || contador == 6) {
    		return true;
    	}else {
    		return false;
    	}
    }
}
