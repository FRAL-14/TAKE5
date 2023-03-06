package be.kdg.integration2.team20.Domain;

public class Controller {

    GameSession session = new GameSession();
    Board board = new Board();
    Deck deck = new Deck();
    Human human = new Human();

    public void start() {
        GameSession session = new GameSession();
        Deck deck = new Deck();
//        deck.makeboard(); was an example
        Deck.shuffle(CardID.values());
        Deck.deal(CardID.values(),24);  //24 cards r gonna be dealt right?
        //take turns
        //hand human
        //hand ai
    }

}
