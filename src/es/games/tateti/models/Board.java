package es.games.tateti.models;

import java.util.Scanner;

public class Board {
	Scanner sc = new Scanner(System.in);
    public static final String TOKEN_X = "X";
    public static final String TOKEN_O = "O";
    public static final String TOKEN_NULL = " ";
    private String[] tokens = new String[2];
    private String[][] gameBoard = new String[Coordinates.ROWS][Coordinates.COLUMNS];
	private Game game;
	private Coordinates coordinates;
    
    
    public Board() {
    	this.setToken();
    }
    
    
    public void setToken() {
    	tokens[0] = Board.TOKEN_O;
        tokens[1] = Board.TOKEN_X;
    }
    public String[] getTokens() {
    	return tokens;
    }
    
    public String[][] getGameBoard() {
        return gameBoard;
    }

    public void resetBoard() {
        for (int i = 0; i < Coordinates.ROWS; i++) {
            for (int j = 0; j < Coordinates.COLUMNS; j++) {
                gameBoard[i][j] = Board.TOKEN_NULL;
            }
        }
    }
 
	public boolean taTeTiWin() {
		String invertedDiagonal = "";
		String diagonal = "";
		String row = "";
		String column = "";
		for (int i = 0; i < Coordinates.ROWS; i++) {
            for (int j = 0; j < Coordinates.COLUMNS; j++) {
            	if (i == j) {
            		diagonal += this.getGameBoard()[i][j];
            	}
            	if (i + j == 2) {
            		invertedDiagonal += this.getGameBoard()[i][j];
            	}
            	row += this.getGameBoard()[i][j];
            	column += this.getGameBoard()[j][i];
            }
            if (row.equals("XXX") || row.equals("OOO") || 
            	column.equals("XXX") || column.equals("OOO") || 
            	diagonal.equals("XXX") || diagonal.equals("OOO") ||
            	invertedDiagonal.equals("XXX") || invertedDiagonal.equals("OOO")) {
            	return true;
            }
            row = "";
            column = "";
		}
		return false;
	}
    
    public void addToken(int fila, int columna, String activePlayer) {
    	this.gameBoard[fila-1][columna-1] = activePlayer;
    }
    
    public void moveToken(int fila, int columna, String activePlayer) {
    	int nuevaFila = 0;
    	int nuevaColumna = 0;
    	do {
    		if (!this.coordinates.isOccupied(fila, columna) == true) {
    			this.gameBoard[fila][columna] = Board.TOKEN_NULL;
    			this.gameBoard[nuevaFila][nuevaColumna] = activePlayer; 
    		}
    	} while (this.game.isFinished() == true && !this.taTeTiWin() == true);
    }
}
