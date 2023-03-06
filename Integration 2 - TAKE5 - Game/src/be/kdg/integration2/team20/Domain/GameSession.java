package be.kdg.integration2.team20.Domain;

import java.util.Scanner;

public class GameSession {
    public static void main(String[] args) {
        CardID[] deck = shuffle(CardID.values());
        CardID[] shuffleCards = deal(deck, 24);
        shufflePlayCards(shuffleCards);

        //what we now should do is not create everything here, but in the classes they belong to,
        //so that later we can call them from inside the GameSession class
        //(eg the Card[] humanHand should be in the Human class, etc)
        CardID[] humanHand = dealPlay(shuffleCards, 10);
        CardID[] aiHand = dealPlay(shuffleCards, 10);
        CardID[] boardHand = dealPlay(shuffleCards, 4);

        System.out.println("Player cards: " + Arrays.toString(humanHand));
        System.out.println("Ai cards: " + Arrays.toString(aiHand));
        System.out.println("Board cards: " + Arrays.toString(boardHand));

    }
}
