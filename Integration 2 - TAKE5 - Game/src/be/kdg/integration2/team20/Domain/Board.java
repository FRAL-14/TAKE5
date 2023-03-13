package be.kdg.integration2.team20.Domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Board {
    HashMap<String, Integer> board;

    Human human = new Human("Human");
    AI ai = new AI("ai");
    Card card;

    public HashMap<String, Integer> createBoard() {
        board = new HashMap<>();
        for (int row = 1; row <= 4; row++) {
            for (int col = 1; col <= 6; col++) {
                String key = "row" + row + "col" + col;
                board.put(key, card.getValue());
            }
        }
        return board;
    }

    public void startRound(Deck deck){
        board.put("row1col1", deck.boardHand[0]);
        board.put("row2col1",deck.boardValues[1]);
        board.put("row3col1",deck.boardValues[2]);
        board.put("row4col1",deck.boardValues[3]);
    }

        public boolean checkSquare ( int row, int col, HashSet<String > board){
            String square = row + "," + col;
            return !board.contains(square); // returns true if square is not in the board       //shouldn't it return true or false on whether the square is filled (has a card) or is empty? -amal
        }

    public void checkRow(Map<String, Integer> board, Player player) {
        for (int i = 1; i <= 4; i++) {
            boolean rowFilled = true;
            for (int j = 1; j <= 6; j++) {
                String key = "row" + i + "col" + j;
                if (!board.containsKey(key) || board.get(key) == null) {
                    rowFilled = false;
                    break;
                }
            }
            if (rowFilled) {
                Card[] extracted = new Card[5];   //what is exactly the extracted?
                for (int j = 1; j <= 5; j++) {
                    String key = "row" + i + "col" + j;
                    extracted[j-1] = Card.withValue(board.get(key));
                    board.remove(key);
                }
                int temp = board.get("row" + i + "col6");
                board.remove("row" + i + "col6");
                for (int j = 6; j > 1; j--) {
                    board.put("row" + i + "col" + j, board.get("row" + i + "col" + (j-1)));
                    board.remove("row" + i + "col" + (j-1));
                }
                board.put("row" + i + "col1", temp);
                // Do something with extracted array
                String playerType = player.getType();
                for (int c = 0; c<5; c++){
                    if (playerType.equals("human")){
                        int bull = Card.getPointValue(extracted[c]);
                        int totalBull =+ bull;
                    } else if (playerType.equals("ai")){
                        int bull = Card.getPointValue(extracted[c]);
                        int totalBull =+ bull;
                    }
                }
            }
        }
    }

    public HashMap<String, String> getLastSquaresWithValues(HashMap<String, String> map) {
        HashMap<String, String> lastSquares = new HashMap<>();
        int numCols = 6;

        for (int i = 1; i <= 4; i++) { // iterate through each row
            String lastSquareWithValue = null;
            for (int j = numCols; j >= 1; j--) { // iterate through each column in the row
                String key = "row" + i + "col" + j;
                if (map.containsKey(key)) {
                    lastSquareWithValue = key;
                    break;
                }
            }
            if (lastSquareWithValue != null) {
                lastSquares.put("row" + i, lastSquareWithValue);
            }
        }

        return lastSquares;
    }
        public void test(){
            System.out.println(board.get("row1col1"));
        }
}