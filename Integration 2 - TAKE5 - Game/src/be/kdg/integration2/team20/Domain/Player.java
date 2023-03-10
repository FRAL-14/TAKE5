package be.kdg.integration2.team20.Domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    //    Deck deck=new Deck();
    private String name;
    List<Card> deck = new ArrayList<>(104);
    List<Card> hand;
//    TreeSet<Card> cardSet = new TreeSet<>(Comparator.comparing(Card::getCardID));   //not sure if this is correct

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>(10);
    }

    public Player() {
    }


    public abstract int chooseCard();

//    public void addCardToHand(Card card) {
//        hand.add(card);
//    }

//    public void removeCardFromHand(int number) {
//        number=1;
//        hand.remove(number);
//    }

    //basically the same as deal method in Deck
//    public Card getHand() {
//        // remove the first 10 cards from the deck and add them to the player's hand
//        for (int i = 0; i < 10; i++) {
//            hand.add(deck.remove(0)); //will give fail cus deck is empty
//        }
//        return (Card) this.hand;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Player name = " + name + ", hand=" + hand;
    }
}