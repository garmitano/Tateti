package es.games.tateti.models;

public class Turn {
    private int activePlayer = 0;
    final Board board;
    
    
    public Turn() {
    	this.board = new Board();
    }
    

    public String getActivePlayer() {
    	activePlayer = (activePlayer + 1) % 2;
    	return this.board.getTokens()[activePlayer];
    }
}