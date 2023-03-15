package be.kdg.integration2.team20.Domain;

import java.util.Arrays;
import java.util.Scanner;

public class AI extends Player{

    public AI(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "ai";
    }

    public void showHand(Deck deck){
        System.out.println(Arrays.toString(deck.aiHand));
    }
}
