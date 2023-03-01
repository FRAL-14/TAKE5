package be.kdg.integration2.team20.Domain;

import java.util.*;

public class AI extends Player{

    public AI(String name, ArrayList<Integer> hand) {
        super(name, hand);
    }

    public AI() {

    }

    @Override
    public int chooseCard() {
        Random rdm = new Random(); //random card gets chosen
return 0;
    }

    //added because the AI also has a hand, so its a method shared from the abstract class that both Human and AI have.
//    public List<Card> getHand() {
//        return hand;
//    }

}