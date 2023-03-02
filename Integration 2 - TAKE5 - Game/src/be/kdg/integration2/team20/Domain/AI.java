package be.kdg.integration2.team20.Domain;

import java.util.*;

public class AI extends Player {
    final String name = "AI";
//    private List<Card> hand;

    public AI() {
    }

    public AI(String name) {
        super();
        name = name;
    }

    @Override
    public int chooseCard() {
        Random rdm = new Random(); //random card gets chosen
        return 0;
    }

    //added because the AI also has a hand, so its a method shared from the abstract class that both Human and AI have.
//    public List<Card> getHand(Deck deck) {
//        return hand;
//    }

    @Override
    public String toString() {
        return "AI deck = " + deck +
                ", hand = " + hand +
                ", chooseCard = " + chooseCard() + super.toString();
    }
}