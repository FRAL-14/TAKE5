package be.kdg.integration2.team20.Domain;

import java.util.HashMap;
import java.util.HashSet;

public class Board {
    HashMap<String, Integer> board;

    public HashMap<String, Integer> createBoard() {
        board = new HashMap<>();
        for (int row = 1; row <= 4; row++) {
            for (int col = 1; col <= 6; col++) {
                String key = "row" + row + "col" + col;
                board.put(key, 0);
            }
        }
        return board;
    }

    public void startRound(Deck deck){
        board.put("row1col1", deck.boardValues[0]);
        board.put("row2col1",deck.boardValues[1]);
        board.put("row3col1",deck.boardValues[2]);
        board.put("row4col1",deck.boardValues[3]);
    }


    public boolean checkSquare ( int row, int col, HashSet<String > board){
        String square = row + "," + col;
        return !board.contains(square); // returns true if square is not in the board       //shouldnt it return true or false on whether the square is filled (has a card) or is empty? -amal
    }


    public void test(){
        System.out.println("card in square in is " + board.get("row1col1"));
    }



}
