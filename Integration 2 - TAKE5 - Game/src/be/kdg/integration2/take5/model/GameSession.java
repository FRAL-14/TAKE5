package be.kdg.integration2.take5.model;

import java.util.Arrays;

public class GameSession {
    Board board = new Board();
    Deck mainDeck = new Deck();
    Human human = new Human("human");
    AI ai = new AI();


    public void makeBoard(){
        mainDeck.startRound();
        board.initializeRow(mainDeck);
    }

    public void startGame(){
        board.printBoard();
        board.playCard(mainDeck, human);
        board.checkLists(human);
        board.printBoard();
        board.playCard(mainDeck, ai);
        board.checkLists(ai);
    }
}