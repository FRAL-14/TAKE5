package be.kdg.integration2.team20.gametake5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Card {

    private int cardID;
    private int amountOfBulls;
    private int cardValue;

    //list of cards put into a treeset that will save the ID of the card and the amount of Bulls (still have to figure out how to add the points as keys)
    List<Card> hand = new ArrayList<>(10); //made treeset
    TreeSet<Card> cardSet = new TreeSet<>(Comparator.comparing(Card::getCardID));   //not sure if this is correct

    //getters and setters
    public int getcardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public int getAmountOfBulls() {
        return amountOfBulls;
    }

    public void setAmountOfBulls(int amountOfBulls) {
        this.amountOfBulls = amountOfBulls;
    }

    public Card(){

    }
    public Card(int cardID, int amountOfBulls) {
        this.cardID = cardID;
        this.amountOfBulls = amountOfBulls;
    }

    public int getCardValue(int cardID) {
        this.cardID = cardID;
        if (cardID % 5 == 0) {
            this.amountOfBulls += 2;
        }
        if (cardID % 10 == 0) {
            this.amountOfBulls += 1;
        }
        if (cardID % 11 == 0) {
            this.amountOfBulls += 5;
        }
        if (amountOfBulls == 0) //dont make sense :(((
            this.amountOfBulls = 1;
        System.out.println("PointValue is " + amountOfBulls);

        return cardValue;
    }


    public void setCardValue(int value) {
        this.cardValue = value;
    }

    public String getCardID() {
        return String.valueOf(cardID); //    why is it a String if it was an int in the attribute list?, just confused
    }


    public void hand() {

        for (Card card: hand) {
            System.out.println("Card ID: " + getCardID());
        }
    }
}