package be.kdg.integration2.team20.Domain;

public class Controller {
    GameSession session = new GameSession();
    Board board = new Board();
    Deck deck = new Deck();
    Human human = new Human();
    Player player1 = new Player();

    public void startGame(){
        board.createBoard();
        player1.askName();
        deck.startRound();
        player1.playCard(deck);
        player1.getPointValue();
        board.startRound(deck);
        deck.test();
        board.test();



    }


}
