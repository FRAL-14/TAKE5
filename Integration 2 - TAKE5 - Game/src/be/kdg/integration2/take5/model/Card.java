package be.kdg.integration2.take5.model;

public class Card implements Comparable<Card> {

    //first create cards in deck, then create constructor

    //in deck youre going to have an arraylist of card objects. ur going to have a method that generates the entire deck
    // its a for loop of i from 1 to 104 and for each i u call the constructor below
    public Card(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

    /**
     * is needed for collection methods
      */
    public int compareTo(Card other) {
        // Compare the values of the Cards
        return value - other.value;
    }


    @Override
    public String toString() {
        return "" + value;
    }


    /**
     * method used to calculate bull value of each card
     * @param card
     * @return
     */
    public static int getPointValue(Card card) {
        if (card.getValue() % 10 == 0) {
            return 3;
        } else if (card.getValue() % 55 == 0) {
            return 7;
        } else if (card.getValue() % 5 == 0) {
            return 2;
        } else if (card.getValue() % 11 == 0) {
            return 5;
        } else {
            return 1;
        }
    } //throw exception if number entered
}