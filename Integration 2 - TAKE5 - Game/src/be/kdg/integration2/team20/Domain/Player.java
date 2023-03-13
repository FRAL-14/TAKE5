package be.kdg.integration2.team20.Domain;

import java.util.Scanner;

public abstract class Player {

    Card[] playHand;
    Card playedCard;
    private String name;


    public abstract Card playCard();
    public abstract void showHand(Deck deck);

    public void askName(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = scan.nextLine();
        System.out.println("Welcome " + name);
    }

    public Player(String name) {
        this.name = name;
    }
    public abstract String getType();

}
