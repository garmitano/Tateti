package es.games.tateti.models;

import java.util.Scanner;

public class Turn {
    Scanner sc = new Scanner(System.in);
    private String algo;
    private int activePlayer = 0;
    public static final String TOKEN_X = "X";
    public static final String TOKEN_O = "O";
    public static final String TOKEN_NULL = " ";
    private String[] tokens = new String[2];

    
    public Turn() {
    	this.setToken();
    }
    
    
    public void setToken() {
    	tokens[0] = Turn.TOKEN_O;
        tokens[1] = Turn.TOKEN_X;
    }
    
    private void setAlgo() {
        algo = sc.nextLine();
    }
    public String getAlgo() {
        return algo;
    }

    public String getActivePlayer() {
    	activePlayer = (activePlayer + 1) % 2;
    	return tokens[activePlayer];
    }

    public void interact() {
        System.out.println("Escribi algo: " + this.getActivePlayer());
        this.setAlgo();
    }
}