package es.games.tateti.models;

import java.util.Scanner;
import es.games.tateti.utils.ClosedIntervals;

public class Board {
    Scanner sc = new Scanner(System.in);
    public static final int ROWS = 3;
    public static final int COLUMNS = 3;
    public static final String TOKEN_X = "X";
    public static final String TOKEN_O = "O";
    public static final String TOKEN_NULL = " ";
    private ClosedIntervals closedIntervals;
    private String[] tokens = new String[2];
    private String[][] gameBoard = new String[Board.ROWS][Board.COLUMNS];
    private String algo;
    
    
    public Board() {
    	this.setToken();
    }
    
    
	public void setAlgo() {
		algo = sc.nextLine();
	}
    public String getAlgo() {
        return algo;
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
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                gameBoard[i][j] = Board.TOKEN_NULL;
            }
        }
    }
 
	public boolean taTeTiWin() {
		String invertedDiagonal = "";
		String diagonal = "";
		String row = "";
		String column = "";
		for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
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
    
    public boolean isCorrect(int numero) {
    	closedIntervals = new ClosedIntervals(0, Board.COLUMNS);
    	return !closedIntervals.isIncluded(numero);
    }

    public boolean isOccupied(int fila, int columna) {
    	return !gameBoard[fila-1][columna-1].equalsIgnoreCase(Board.TOKEN_NULL) ;
    }
    
    public void addToken(int fila, int columna, String activePlayer) {
    	this.gameBoard[fila-1][columna-1] = activePlayer;
    }
    
    
}
