package be.kdg.integration2.team20.Domain;

import java.util.*;

public class Board {

    //changed HashSet to HashMap since you can store keys (amountOfBulls) with them,
    //will ask how it should be done - amal
    HashMap<Integer, Set<String>> board;
    public void fillTable() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 6; col++) {
                String square = row + "," + col;    //maybe write this as Square square = new Square(row, col);?
//                board.put(square);
            }
        }
    }
    // place a red game piece on the top-left square
    //board.add("0,0:R");
    //
    // remove a yellow game piece from the center square
    //board.remove("2,2:Y");

    public boolean checkSquare(int row, int col, HashSet<String> board) {
        String square = row + "," + col;
        return !board.contains(square); // returns true if square is not in the board       //shouldnt it return true or false on whether the square is filled (has a card) or is empty? -amal
    }

    public class Row {
        public Card card = new Card();
        public List<Card> cardsInRow = new ArrayList<Card>();
        public int rowBullsValue;
        public int rowID;

        public void takeCard(Card card) {
            this.card = card;
            cardsInRow.add(card);
            System.out.println("card " + card.getCardID() + " given to row " + rowID + " in spot " + cardsInRow.size());

        }
    }
}
