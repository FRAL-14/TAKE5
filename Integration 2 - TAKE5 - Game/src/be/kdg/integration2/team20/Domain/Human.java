package be.kdg.integration2.team20.Domain;

import java.util.Arrays;
import java.util.Scanner;

public class Human extends Player{

    Deck deck = new Deck();

    public void askName(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        System.out.println("Welcome " + name);
    }

    public Human(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "human";
    }

    public Card playCard(int index) {
        playHand = deck.humanHand;

        if (index < 0 || index >= playHand.length || playHand[index] == null) {
            // Index is out of bounds or the hand array is empty at the given index
            System.out.println("Failed to play card. Invalid index or hand is empty.");
            return null;
        }

        // Get the card number at the given index
        int cardNumber = playHand[index].getValue();

        // Remove the card from the hand array
        for (int i = index; i < playHand.length - 1; i++) {
            playHand[i] = playHand[i + 1];
        }
        playHand[playHand.length - 1] = null;

        // Print success message and return the card object
        System.out.printf("Card played successfully! You played card number %d.\n", cardNumber);
        return playHand[index];
    }

    public void showHand(Deck deck){
        System.out.println(Arrays.toString(deck.humanValues));
    }
}