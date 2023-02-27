package be.kdg.integration2.team20.gametake5;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
    Human player1 = new Human();
    AI player2 = new AI();
    LeaderBoard board = new LeaderBoard();

//public Card shuffleCards(){
//return new Card();
//}

    private ArrayList<Integer> cards;

    public Game() {
        cards = new ArrayList<>();
        for (int i = 1; i <= 104; i++) {
            cards.add(i);
        }
    } // add cards

    public void startGameSession(Player player1) {
        GameSession gamesession = new GameSession();
        gamesession.addPlayer(player1);
        gamesession.start();
    }

    public void endGameSession() {
        System.out.println("Return to menu");
        System.exit(1);
    }
}