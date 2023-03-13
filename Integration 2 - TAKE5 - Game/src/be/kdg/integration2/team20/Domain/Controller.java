package be.kdg.integration2.team20.Domain;


public class Controller {
    Board board = new Board();
    Deck mainDeck = new Deck();
    Human human = new Human("human");
    AI ai = new AI("ai");

    public void startGame(){
        board.createBoard();
        human.askName();
        mainDeck.startRound();
        human.playCard();
        board.startRound(mainDeck);
        human.showHand(mainDeck);
        ai.showHand(mainDeck);
    }
}