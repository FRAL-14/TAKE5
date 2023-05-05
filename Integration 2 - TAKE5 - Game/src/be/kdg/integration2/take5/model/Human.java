package be.kdg.integration2.take5.model;

import java.util.Arrays;
import java.util.Scanner;

public class Human extends Player{
    public void showHand(Deck deck){
        System.out.println(deck.humanHand.toString());
    }


    //Not sure if we need this here, if we don't remove it
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}


}