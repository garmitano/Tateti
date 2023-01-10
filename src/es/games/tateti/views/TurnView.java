package es.games.tateti.views;

import java.util.Scanner;
import es.games.tateti.models.Turn;
import es.games.tateti.models.Board;

public class TurnView {
    Scanner sc = new Scanner(System.in);
    private int fila;
    private int columna;
	private final Turn turn;
	private final Board board;

	
	public TurnView(Turn turn, Board board) {
		this.turn = turn;
		this.board = board;
	}
	
	
    public void interact() {
    	String activePlayer = this.turn.getActivePlayer();
    	System.out.println("Turno del Jugador " + activePlayer);
        do {
	        do {
	        	System.out.println("En que Fila posicionara su ficha: ");
	        	this.fila = sc.nextInt();
	        } while (this.board.isCorrect(this.fila));
	        do {
	        	System.out.println("En que Columna posicionara su ficha: ");
	        	this.columna = sc.nextInt();
	        } while (this.board.isCorrect(this.columna));
        } while (this.board.isOccupied(this.fila, this.columna) == true);
        
        System.out.println("[" + this.fila + ", " + this.columna + "]");
        this.board.addToken(this.fila, this.columna, activePlayer);
    }
}
