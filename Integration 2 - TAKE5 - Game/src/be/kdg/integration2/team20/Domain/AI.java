package be.kdg.integration2.team20.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AI extends Player {
    final String name = "AI";
    private List<Card> hand;

    public AI() {
    }

    public AI(String name, List<Card> hand) {
        super(name);
        hand = new ArrayList<>();
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