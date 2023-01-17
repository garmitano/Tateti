package es.games.tateti.views;

import java.util.Scanner;
import es.games.tateti.models.Board;
import es.games.tateti.models.Coordinates;

public class TurnView {
    Scanner sc = new Scanner(System.in);
    private int fila;
    private int columna;
	private final Board board;
	private final Coordinates coordinates;

	
	public TurnView(Board board, Coordinates coordinates) {
		this.coordinates = coordinates;
		this.board = board;
	}
	
	
    public void interact(String activePlayer) {
    	System.out.println("Turno del Jugador " + activePlayer);
        do {
	        do {
	        	System.out.println("En que Fila posicionara su ficha: ");
	        	this.fila = sc.nextInt();
	        	System.out.println("En que Columna posicionara su ficha: ");
	        	this.columna = sc.nextInt();
	        } while (this.coordinates.isCorrect(this.columna) && this.coordinates.isCorrect(this.fila));
        } while (this.coordinates.isOccupied(this.fila, this.columna) == true);
        System.out.println("[" + this.fila + ", " + this.columna + "]");
        this.board.addToken(this.fila, this.columna, activePlayer);
    }
}
