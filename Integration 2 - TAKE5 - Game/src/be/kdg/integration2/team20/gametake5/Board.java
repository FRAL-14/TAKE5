package be.kdg.integration2.team20.gametake5;
import java.util.ArrayList;
import java.util.HashSet;

public class Board {

    //maybe work with HashMap, HasSet etc to indicate if a place has a value(??)

    private HashSet<String> board;

    public Board() {
            board = new HashSet<String>();

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 6; col++) {
                String square = row + "," + col;
                board.add(square);
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
        return !board.contains(square); // returns true if square is not in the board
    }

    public class Row {
        public Card card = new Card();
        public ArrayList<Card> cardsInRow = new ArrayList<Card>();
        public int rowBullsValue;
        public int rowID;

        public void takeCard(Card card) {
            this.card = card;
            cardsInRow.add(card);
            System.out.println("card " + card.getCardID() + " given to row " + rowID + " in spot " + cardsInRow.size());

        }
    }
}
