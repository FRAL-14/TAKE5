package be.kdg.integration2.team20.Domain;

import java.util.*;

public class Deck {
    //    Card card = new Card();
    Random rand = new Random();
    List<Card> cards = new ArrayList<>(104); //make treeset
//    TreeSet<Card> cardSet = new TreeSet(Comparator.comparing(Card::getCardID));

    //forloop to go through all the cards in the deck
    /*public List<Card> deck() {
        for (CardValue cardval : CardValue.values()) {
            cards.add(new Card(card.getCardID(), card.getAmountOfBulls()));
        }
        return cards;
    }*/

//    public List<CardID> deck(){
//        for (CardID card: cards) {
//
//        }
//    }

    private ArrayList<CardID> deck;

    public Deck() {
        this.cards = new ArrayList<Card>();
        for (CardID cardID : CardID.values()) {
            cards.add(new Card(cardID));
        }
//        deck = new ArrayList<CardID>();
//         Fill deck with cards
//        for (CardID card : CardID.values()) {
//            for (int i = 0; i < 2 * CardID.values().length; i++) {
//                deck.add(card);
//            }
    }

    /*  public CardValue[] shuffle(CardValue[] cards) {
        List<CardValue> cardList = Arrays.asList(cards);
        for (int i = cardList.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Collections.swap(cardList, i, j);
        }
        return cardList.toArray(cards);
    }*/
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

    private CardID removeCard() {
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
        return "Deck: cards=" + cards;
    }
}