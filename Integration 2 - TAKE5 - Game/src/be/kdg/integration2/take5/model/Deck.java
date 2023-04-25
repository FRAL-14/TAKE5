package be.kdg.integration2.take5.model;

import be.kdg.integration2.take5.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Deck {
    ArrayList<Card> humanHand;
    ArrayList<Card> aiHand;
    ArrayList<Card> boardHand;
    int roundCounter = 0;
    ArrayList<Card> cards = new ArrayList<>();

    public Deck(){
        for (int i = 1; i < 105; i++){
            cards.add(new Card(i));
        }
    }

    public void shufflePlayCards(ArrayList<Card> cards) {
        Random rand = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }




    public ArrayList<Card> dealPlay(ArrayList<Card> deck, int numCards) {
        if (numCards > deck.size()) {
            throw new IllegalArgumentException("Not enough cards in the deck.");
        }

        ArrayList<Card> dealtCards = new ArrayList<>();
        for (int i = 0; i < numCards; i++) {
            dealtCards.add(i, deck.get(i));
            deck.remove(deck.get(i));
        }

        return dealtCards;
    }




    public void initialiseHand(){
        shufflePlayCards(cards);
        humanHand = dealPlay(cards,10);
        aiHand = dealPlay(cards, 10);
        boardHand = dealPlay(cards, 4);
        Collections.sort(humanHand);
        Collections.sort(aiHand);
    }

    //TODO: shouldnt startRound() maybe be in for example Controller/GameSession
    public void startRound() {
        initialiseHand();
        roundCounter++;
    }

    public void print(){
        System.out.println(cards.toString());
        System.out.println(humanHand.toString());
        System.out.println(aiHand.toString());
        System.out.println(boardHand.toString());
    }

}