package be.kdg.integration2.take5.model;

import be.kdg.integration2.take5.ui.CardView;
import be.kdg.integration2.take5.ui.game.GamePresenter;

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
        board.initializeRow(mainDeck);
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

    public Card getBoardCard(int i) {
        return rows[i].getFirst();
    }

    public void startGame() {
        board.playCard(mainDeck, human);
        board.checkLists(human);
        board.playCard(mainDeck, ai);
        board.checkLists(ai);
    }

    public Card[] getDeck() {
        return mainDeck.dealPlay(mainDeck.shuffledDeck, 104);
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

    public LinkedList<Card>[] getRows() {
        return rows;
    }

    public void setRows(LinkedList<Card>[] rows) {
        this.rows = rows;
    }

}