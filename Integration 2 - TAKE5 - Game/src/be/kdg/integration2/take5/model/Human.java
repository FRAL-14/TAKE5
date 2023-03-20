package be.kdg.integration2.take5.model;

import java.util.Arrays;
import java.util.Scanner;

public class Human extends Player{
    private String name;

    public void askName(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scan.nextLine();
        System.out.println("Welcome " + name);
    }

    public void showHand(Deck deck){
        System.out.println(Arrays.toString(deck.humanHand));
    }

    public Human(String name) {
        this.name = name;
    }

}