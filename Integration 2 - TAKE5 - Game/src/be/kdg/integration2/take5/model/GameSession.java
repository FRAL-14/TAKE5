package be.kdg.integration2.take5.model;

import java.util.Arrays;

public class GameSession {
    Board board = new Board();
    Deck mainDeck = new Deck();
    Human human = new Human("human");
    AI ai = new AI();


    public void makeBoard(){
        board.createBoard();
        mainDeck.startRound();
        board.initializeRow(mainDeck);
    }

    public void startGame(){
        board.getLastFilledCells();
        board.findClosestNumber();
        System.out.println(Arrays.toString(board.cardValues));
        board.playCard(mainDeck, human);
        board.checkBoard(human);
        board.getLastFilledCells();
        System.out.println(Arrays.toString(board.cardValues));
        board.playCard(mainDeck, ai);
        board.checkBoard(ai);
    }
}