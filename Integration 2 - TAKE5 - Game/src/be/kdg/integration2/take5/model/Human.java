package be.kdg.integration2.take5.model;

import java.util.Arrays;
import java.util.Scanner;

public class Human extends Player{
    public void showHand(Deck deck){
        System.out.println(Arrays.toString(deck.humanHand));
    }

}