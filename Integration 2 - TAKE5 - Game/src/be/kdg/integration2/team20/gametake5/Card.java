package be.kdg.integration2.team20.gametake5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Card {

    private int cardID;
    private int amountOfBulls;
    private int cardValue;

    //getters and setters
    public int getcardID() {
        return cardID;
    }

    public void setNumber(int number) {
        this.cardID = number;
    }

    public int getAmountOfBulls() {
        return amountOfBulls;
    }

    public void setAmountOfBulls(int amountOfBulls) {
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
        if (amountOfBulls == 0)
            this.amountOfBulls = 1;
        System.out.println("PointValue is " + amountOfBulls);

        return cardValue;
    }


    public void setCardValue(int value) {
        this.cardValue = value;
    }

    public String getCardID() {
        return String.valueOf(cardID);
    }



    public void cardGroup() {
        List<Card> cards = new ArrayList<>(10); //make treeset

    }
}