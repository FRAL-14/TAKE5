package be.kdg.integration2.team20.Domain;

import java.util.Arrays;
import java.util.Scanner;

public class Player {
    private String name;
    int[] playHand;
    int card;
    private int amount;

    public void askName(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scan.nextLine();
        System.out.println("Welcome " + name);
    }

//    public void processArray(Deck deck) {
//        playHand = deck.intValues;
//
//        for (int i = 0; i < playHand.length; i++) {
//            System.out.print(playHand[i] + " ");
//        }
//    }


    public boolean playCard(Deck deck) {
        playHand = deck.humanValues;
        System.out.println("This is your hand: " + Arrays.toString(playHand));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the card you want to play: ");
        card = scanner.nextInt();
        if (card == 0){
            System.out.println("Failed to play card - card 0 is not playable");
            return false;
        }
        for (int i = 0; i < playHand.length; i++) {
            if (playHand[i] == card) {
                // Remove the card from the array by shifting all subsequent elements to the left
                for (int j = i; j < playHand.length - 1; j++) {
                    playHand[j] = playHand[j + 1];
                }
                playHand[playHand.length - 1] = 0; // Set the last element to 0 to avoid duplicates
                System.out.println("Successfully played card " + card);
                return true;
            }

        }
        System.out.println("Failed to play card " + card + " - card not found");
        return false;

    }

    public int getPointValue(){
        if (card % 10 == 0) {
            this.amount += 1;//why += and not just =
        } else if (card % 5 == 0) {
            this.amount += 2;
        } else if (card % 11 == 0) {
            this.amount += 5;
        } else if (amount == 0)
            this.amount = 1;
        System.out.println("This card has " + amount + " bull(s)");

        return 0;
    }


//    public void printHand(){
//        System.out.println(playHand);
//    }

}

