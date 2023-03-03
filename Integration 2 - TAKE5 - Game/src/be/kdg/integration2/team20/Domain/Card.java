package be.kdg.integration2.team20.Domain;

import java.util.*;

public class Card {

    public CardID cardID;
    public int amountOfBulls;
//    public int cardValue;

    //list of cards put into a treeset that will save the ID of the card and the amount of Bulls (still have to figure out how to add the points as keys)
    //   List<Card> cards = new ArrayList<>(104); //made treeset
//    TreeSet<Card> cardSet = new TreeSet<>(Comparator.comparing(Card::getCardID));   //not sure if this is correct

    //getters and setters
    public CardID getCardID() {
        return cardID;
    }

    public void setCardID(CardID cardID) {
        this.cardID = cardID;
    }

    public int getAmountOfBulls() {
        return amountOfBulls;
    }

    public void setAmountOfBulls(int amountOfBulls) {
        this.amountOfBulls = amountOfBulls;
    }

    //empty constr
    public Card() {
    }

    public Card(CardID cardID) {
        this.cardID = cardID;
        this.amountOfBulls = getAmountOfBulls();
    }

//    public void setCardValue(int value) {
//        this.cardValue = value;
//    }

    @Override
    public String toString() {
        return "Card cardID = " + cardID;
    }
}