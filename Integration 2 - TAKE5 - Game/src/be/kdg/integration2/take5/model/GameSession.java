package be.kdg.integration2.take5.model;

import be.kdg.integration2.take5.ui.CardView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GameSession {
    Board board = new Board();
    Deck mainDeck = new Deck();
    Human human = new Human();
    AI ai = new AI();
    private List<CardView> boardCardViews;
    private LinkedList<Card>[] rows;

    public Card[] makeBoard() {
        mainDeck.startRound();
//        board.initializeRow(mainDeck);
//        presenter.updateView();
        rows = new LinkedList[4];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new LinkedList<>();
        }
        return new Card[0];
    }

    public void displayBoard() {
        for (int i = 0; i < 4; i++) {
            CardView cardView = new CardView(rows[i].getFirst());
            boardCardViews.get(i).getChildren().clear();
            boardCardViews.get(i).getChildren().add(cardView);
        }
    }
// In the Model class:

//    public int findRowToPlace(Card selectedCard) {
//        List<List<Card>> rows = getRows();
//        int minDiff = Integer.MAX_VALUE;
//        int minDiffIndex = 0;
//
//        // Iterate over each row to find the one with the lowest difference
//        for (int i = 0; i < rows.size(); i++) {
//            List<Card> row = rows.get(i);
//            int diff = row.get(row.size() - 1).getValue() - selectedCard.getValue();
//            if (diff >= 0 && diff < minDiff) {
//                minDiff = diff;
//                minDiffIndex = i;
//            }
//        }
//
//        return minDiffIndex;
//    }
//
//    public List<List<Card>> getRows() {
//        return List.of(rows);
//    }

    public Card getBoardCard(int i) {
        return rows[i].getFirst();
    }

    public void startGame() {
//        board.playCard(mainDeck, human);
        board.checkLists(human);
//        board.playCard(mainDeck, ai);
        board.checkLists(ai);
    }

    public ArrayList<Card> getDeck() {
        return mainDeck.dealPlay(mainDeck.cards, 104);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Deck getMainDeck() {
        return mainDeck;
    }

    public void setMainDeck(Deck mainDeck) {
        this.mainDeck = mainDeck;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public AI getAi() {
        return ai;
    }

    public void setAi(AI ai) {
        this.ai = ai;
    }

    public List<CardView> getBoardCardViews() {
        return boardCardViews;
    }

    public void setBoardCardViews(List<CardView> boardCardViews) {
        this.boardCardViews = boardCardViews;
    }

//    public LinkedList<Card>[] getRows() {
//        return rows;
//    }

    public void setRows(LinkedList<Card>[] rows) {
        this.rows = rows;
    }

}