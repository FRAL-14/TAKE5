package be.kdg.integration2.take5.model;

import be.kdg.integration2.take5.ui.game.GamePresenter;

public class GameSession {
    Board board = new Board();
    Deck mainDeck = new Deck();
    Human human = new Human();
    AI ai = new AI();
    GamePresenter presenter;


    public Card[] makeBoard() {
        mainDeck.startRound();
        board.initializeRow(mainDeck);
//        presenter.updateView();
        return new Card[0];
    }

    public void startGame() {
        board.playCard(mainDeck, human);
        board.checkLists(human);
        board.playCard(mainDeck, ai);
        board.checkLists(ai);
//        presenter.updateView();
    }

    public Card[] getDeck() {
        return mainDeck.dealPlay(mainDeck.shuffledDeck, 104);
    }

}