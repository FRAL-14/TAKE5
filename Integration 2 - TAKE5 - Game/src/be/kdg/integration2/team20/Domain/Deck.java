package be.kdg.integration2.team20.Domain;

import java.util.*;

public class Deck {
    Random rand = new Random();
    List<Card> cards = new ArrayList<>(104); //make treeset
    TreeSet<Card> cardSet = new TreeSet(Comparator.comparing(Card::getCardID));

    //forloop

    public void deck() {
        for (int i = 1; i <= 104; i++) {
            cardID = i;
            list.add(new Card(getCardID(), getAmountOfBulls()));
        }
    }

//
//    for (Card card: cards) {
//        list.add(card);
//    }

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