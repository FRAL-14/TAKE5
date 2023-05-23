package be.kdg.integration2.take5.model;

import be.kdg.integration2.take5.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Deck {
    LinkedList<Card> cards = new LinkedList<>();
    LinkedList<Card> humanHand;
    LinkedList<Card> aiHand;
    LinkedList<Card> boardHand;
    int roundCounter = 0;


    /**
     * Deck gets initialised with 104 cards all with a value from 1 to 104
     */
    public Deck() {
        for (int i = 0; i < 104; i++) {
            int cardValue = i + 1;
            cards.add(new Card(cardValue));
        }
    }

    public LinkedList<Card> getCards(){
        return cards;
    }

    public LinkedList<Card> getHumanHand() {
        return humanHand;
    }

    public LinkedList<Card> getAiHand() {
        return aiHand;
    }


    /**
     * DealPlay takes cards from the deck and randomly assigns to a hand while removing them from the initial stack as well
     * @param cards
     * @param numCards
     * @return
     */
    public static LinkedList<Card> dealPlay(LinkedList<Card> cards, int numCards) {
        if (numCards > cards.size()) {
            throw new IllegalArgumentException("Not enough cards in the deck.");
        }

        LinkedList<Card> dealtCards = new LinkedList<>();
        for (int i = 0; i < numCards; i++) {
            dealtCards.add(cards.get(i));
        }

        // Remove the dealt cards from the deck LinkedList
        for (int i = 0; i < numCards; i++) {
            cards.removeFirst();
        }

        return dealtCards;
    }


    /**
     * method to shuffle deck of cards and distribute them randomly to players hands and to board to start the game,
     * hands are also sorted in order from small to big
     */
    public void initialiseHand(){
        Collections.shuffle(cards);
        humanHand = dealPlay(cards,10);
        aiHand = dealPlay(cards, 10);
        boardHand = dealPlay(cards, 4);
        Collections.sort(humanHand);
        Collections.sort(aiHand);
    }


    /**
     * startRound method to be called in gameSession and increase the roundCounter by one, as soon as 10 cards
     * from each hand have been played a new round starts if game is not finished
     */
    //TODO: shouldnt startRound() maybe be in for example Controller/GameSession
    public void startRound() {
        initialiseHand();
        roundCounter++;
    }

    public void newRound(LinkedList<Card> activeCards){
        humanHand.clear();
        aiHand.clear();
        for (Card card : activeCards) {
            cards.remove(card);
        }
        Collections.shuffle(cards);
        humanHand = dealPlay(cards,10);
        aiHand = dealPlay(cards, 10);
        Collections.sort(humanHand);
        Collections.sort(aiHand);
    }

}