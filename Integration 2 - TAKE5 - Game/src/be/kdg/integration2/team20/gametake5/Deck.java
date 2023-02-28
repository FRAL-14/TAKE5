package be.kdg.integration2.team20.gametake5;

import java.util.*;

public class Deck {
    Random rand = new Random();
    List<Card> cards = new ArrayList<>(104); //make treeset
    TreeSet<Card> cardSet = new TreeSet(Comparator.comparing(Card::getCardID));

    // shuffle cards
    public void shuffle() {
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