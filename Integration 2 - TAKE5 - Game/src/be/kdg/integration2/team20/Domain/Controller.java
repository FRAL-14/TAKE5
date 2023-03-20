package be.kdg.integration2.team20.Domain;

import java.util.Arrays;

public class Controller {
    Board board = new Board();
    Deck mainDeck = new Deck();
    Human human = new Human("human");
    AI ai = new AI("ai");

    public void startGame(){
        board.createBoard();
        mainDeck.startRound();
        board.startRound(mainDeck);
        board.getLastFilledCells();
        board.findClosestNumber();
        System.out.println(Arrays.toString(mainDeck.boardHand));
        board.playCard(mainDeck);
        board.checkBoard();
        board.getLastFilledCells();
        board.playCard(mainDeck);

    }
}