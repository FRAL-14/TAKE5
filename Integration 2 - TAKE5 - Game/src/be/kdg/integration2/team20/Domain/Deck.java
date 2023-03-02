package be.kdg.integration2.team20.Domain;

import java.util.*;

public class Deck {
    Card card = new Card();
    Random rand = new Random();
    List<Card> cards = new ArrayList<>(104); //make treeset
//    TreeSet<Card> cardSet = new TreeSet(Comparator.comparing(Card::getCardID));

    //forloop to go through all the cards in the deck
    public List<Card> deck() {
        for (CardValue cardval : CardValue.values()) {
            cards.add(new Card(card.getCardID(), card.amountOfBulls));
        }
        return cards;
    }

    //Collections.shuffle(cards);
    // shuffle cards
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //deal cards
    public Card deal() {
        if (cards.isEmpty()) {
            return null;
        }
        return dealtCards;
    }

    private CardValue removeCard() {
        boolean cardsDealt = false;
        if (!cardsDealt) {
            for (int i = 0; i < 10; i++) {
                if (!cards.isEmpty()) {
                    cards.remove(0);

                }
            }
        }
        return removeCard();
    }

    @Override
    public String toString() {
        return "Deck card=" + card +
                ", rand=" + rand +
                ", cards=" + cards +
                ", deck=" + deck();
    }
}