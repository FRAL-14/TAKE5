package be.kdg.integration2.take5.model;

import java.util.Arrays;

public class AI extends Player{

    public void showHand(Deck deck){
        System.out.println(deck.aiHand.toString());
    }

}