package be.kdg.integration2.team20.Domain;

public class Controller {
    Board board = new Board();
    Deck mainDeck = new Deck();
    Human human = new Human("human");
    AI ai = new AI("ai");

    public void startGame(){
        board.createBoard();
        mainDeck.startRound();
        board.startRound(mainDeck);
        human.showHand(mainDeck);
        ai.showHand(mainDeck);
//        board.test();
//        board.checkBoard();
        board.getLastFilledCells();
        board.findClosestNumber();
        board.playCard(mainDeck);
        board.checkBoard();
        board.eureka(mainDeck);
    }
}