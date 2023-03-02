package be.kdg.integration2.team20.Domain;

import java.util.List;

public class Human extends Player {
    Deck deck = new Deck();
    private List<Card> hand;

//    public Human(String name, List<Card> hand) {
//        super(name);
//        hand = new ArrayList<>();
//    }

    //used for the Game class so u dont have to return the list too
//    public Human(String name) {
//        super(name);
//    }

    public Human() {
        super();
    }

//    public Card playCard(int number) {
//        return hand.remove(number);
//    }

    @Override
    public int chooseCard() {
        return 0; //specific card gets chosen
    }
//
//    public List<Card> getHand(Deck deck) {  //should I return a list of 10 cards?
//        return hand;
//    }

    @Override
    public String toString() {
        return "Human deck = " + deck +
                ", hand=" + hand +
                ", chooseCard=" + chooseCard() + super.toString();
    }
}