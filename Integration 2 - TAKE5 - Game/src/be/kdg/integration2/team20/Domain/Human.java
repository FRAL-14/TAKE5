package be.kdg.integration2.team20.Domain;

import java.util.Arrays;

public class Human extends Player{



    public Human(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "human";
    }


    public void showHand(Deck deck){
        System.out.println(Arrays.toString(deck.humanHand));
    }
}