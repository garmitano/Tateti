package es.games.tateti.views;

import java.util.Scanner;

import es.games.tateti.models.Board;
import es.games.tateti.models.Coordinates;


public class TurnView {
    Scanner sc = new Scanner(System.in);
    private int[] coordinate = new int[2];
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
	
	public void movement(String activePlayer) {
		do {
			this.read("posicionara su ficha: ");
		} while (this.coordinates.isOccupied(this.coordinate[0], this.coordinate[1]));
		this.board.addToken(this.coordinate[0], this.coordinate[1], activePlayer);
	}
    
    public void interact(String activePlayer) {
	    	System.out.println("Turno del Jugador " + activePlayer);
	    	if(this.board.isMovement()) {
	    		do {
	    			this.read("esta la ficha que movera: ");
	    		} while (!this.coordinates.isOccupied(this.coordinate[0], this.coordinate[1]));
	    		this.board.moveToken(this.coordinate[0], this.coordinate[1]);
	    		System.out.println("-----------------------------");
	    		this.movement(activePlayer);
	    	}else {
	    		this.movement(activePlayer);
	    	}
    }
}
