package be.kdg.integration2.team20.gametake5;

import java.util.ArrayList;
import java.util.List;

public class Human extends Player {
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
    }

    public Card playCard(int number) {
        return hand.remove(number);
    }

    @Override
    public int chooseCard() {
        return 0; //specific card gets chosen
    }

    public List<Card> getHand() {
        return hand;
    }
}
