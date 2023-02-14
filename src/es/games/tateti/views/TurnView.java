package es.games.tateti.views;

import java.util.Scanner;

import es.games.tateti.models.Board;
import es.games.tateti.models.Coordinates;


public class TurnView {
    Scanner sc = new Scanner(System.in);
    private int[] coordinate = new int[2];
    //private int fila;
    //private int columna;
	private final Board board;
	private final Coordinates coordinates;

	
	public TurnView(Board board, Coordinates coordinates) {
		this.coordinates = coordinates;
		this.board = board;
	}
	
    
	public int[] read(String mensaje) {
	    System.out.println("En que Fila " + mensaje);
	    this.coordinate[0] = sc.nextInt();
	    System.out.println("En que Columna " + mensaje);
	    this.coordinate[1] = sc.nextInt();
		return this.coordinate;
	}
    
    public void interact(String activePlayer) {
	    	System.out.println("Turno del Jugador " + activePlayer);
	    	if(this.board.isMovement()) {
	    		do {//preguntar por movimiento
	    			this.read("esta la ficha que movera: ");
	    		} while (!this.coordinates.isOccupied(this.coordinate[0], this.coordinate[1]));
	    		this.board.moveToken(this.coordinate[0], this.coordinate[1]);
	    		System.out.println("-----------------------------");
	    		do {
	    			this.read("posicionara su ficha: ");
	    		} while (this.coordinates.isOccupied(this.coordinate[0], this.coordinate[1]));
	    		this.board.addToken(this.coordinate[0], this.coordinate[1], activePlayer);
	    	}else {
	    		do {//preguntar por agregado
	    			this.read("posicionara su ficha: ");
	    		} while (this.coordinates.isOccupied(this.coordinate[0], this.coordinate[1]));
	    		this.board.addToken(this.coordinate[0], this.coordinate[1], activePlayer);
	    	}
	    	
	        /*do {
	        	this.read("pocisionara su ficha: ");
	        } while (this.coordinates.isOccupied(this.fila, this.columna) == true);
	        this.board.addToken(this.fila, this.columna, activePlayer);
	   if (this.game.isFinished() == true && !this.board.taTeTiWin() == true) {
	    	System.out.println("Turno del Jugador " + activePlayer);
	        do {
	        	this.board.moveToken(this.fila, this.columna, activePlayer);
	        } while (this.coordinates.isOccupied(this.fila, this.columna) == true);

	   }*/
    }
}
