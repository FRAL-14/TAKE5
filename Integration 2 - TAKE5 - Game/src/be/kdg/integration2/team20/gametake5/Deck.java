package be.kdg.integration2.team20.gametake5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    Random rand = new Random();
    List<Card> cards = new ArrayList<>(104); //make treeset

    // shuffle cards
    public static void shuffle() {
        Collections.shuffle(cards);
    }

    //deal cards
    public Card deal() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }
}