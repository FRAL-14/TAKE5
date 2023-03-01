package be.kdg.integration2.team20.Domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public abstract class Player {
    private String name;
    List<Card> hand = new ArrayList<>(10);
    TreeSet<Card> cardSet = new TreeSet<>(Comparator.comparing(Card::getCardID));   //not sure if this is correct

    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
    }

//    public Player(String name, ArrayList<Integer> hand) {
//        this.name = name;
//        hand = new ArrayList<>();
//    }


    public Player() {
    }

    public Player(String name, ArrayList<Integer> hand) {
    }

    public abstract int chooseCard();

    //methods to pick and remove card
//    public void addCardToHand(Card card) {
//        hand.add(card);
//    }
//
//    public void removeCardFromHand(int number) {
//        hand.remove(number);
//    }

    public List<Card> getHand() {
        for (Card card : hand) {
            System.out.println("Card ID: " + card.getCardID() + card.getAmountOfBulls());
        }
        return hand;
    }

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

//    public List<Integer> getCards() {
//        return cards;
//    }
//
//    public void addCard(int card) {
//        cards.add(card);
//    }


    //why?
    Card[] cards = new Card[10];
    int[] amountOfBulls = new int[10];
//    int calc = ScoreCard.calculateScore(cards, amountOfBulls);
//   int shuffle = Deck.shuffle(cards);


}