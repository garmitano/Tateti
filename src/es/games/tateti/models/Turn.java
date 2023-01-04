package es.games.tateti.models;

import java.util.Scanner;

public class Turn {
    Scanner sc = new Scanner(System.in);
    private String algo;
    private int activePlayer = 0;
    public static final String TOKEN_X = "X";
    public static final String TOKEN_O = "O";
    public static final String TOKEN_NULL = " ";

    //---------------------------------------------------------------------------------------------------
    private void setAlgo() {
        algo = sc.nextLine();
    }
    public String getAlgo() {
        return algo;
    }

    public int getActivePlayer() {
        return activePlayer = (activePlayer + 1) % 2;

    }

    public void interact() {
        System.out.println("Escribi algo:");
        this.setAlgo();
    }
}