package es.games.tateti.models;

public class Board {
    public static final int ROWS = 3;
    public static final int COLUMNS = 3;
    private String[][] gameBoard = new String[Board.ROWS][Board.COLUMNS];
    //---------------------------------------------------------------------------------------------------
    public Board() {}

    //---------------------------------------------------------------------------------------------------
    public String[][] getGameBoard() {
        return gameBoard;
    }

    public void resetBoard() {
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                gameBoard[i][j] = Turn.TOKEN_NULL;
            }
        }
    }

    public boolean isFinished(String algo) {
        if(algo.equals("L")) {
            return true;
        } else {
            return false;
        }
    }


}
