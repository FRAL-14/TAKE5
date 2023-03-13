package be.kdg.integration2.team20.Domain;


public class Controller {
    Board board = new Board();
    Deck mainDeck = new Deck();
    Human human = new Human("human");
    AI ai = new AI("ai");
    Card card;

    public void startGame(){
        board.createBoard();
        human.askName();
        mainDeck.startRound();
        human.playCard();
        card.getPointValue(human.playedCard);
        board.startRound(mainDeck);
        human.showHand(mainDeck);
        ai.showHand(mainDeck);
    }
}