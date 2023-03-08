package be.kdg.integration2.team20.Domain;

import java.util.Arrays;
import java.util.Random;
import be.kdg.integration2.team20.Domain.Card.*;

public class Deck {
    Card[] shuffledDeck = dealPlay(Card.values(),104);
    Card[] humanHand;
    Card[] aiHand;
    Card[] boardHand;
    int[] aiValues;
    int[] humanValues;
    int[] boardValues;



    public static void shufflePlayCards(Card[] cards) {
        Random rand = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }




    public static Card[] dealPlay(Card[] deck, int numCards) {
        if (numCards > deck.length) {
            throw new IllegalArgumentException("Not enough cards in the deck.");
        }

        Card[] dealtCards = new Card[numCards];
        for (int i = 0; i < numCards; i++) {
            dealtCards[i] = deck[i];
        }

        // Remove the dealt cards from the deck array
        for (int i = numCards; i < deck.length; i++) {
            deck[i - numCards] = deck[i];
        }
        deck = Arrays.copyOf(deck, deck.length - numCards);
        return dealtCards;
    }




    public void initialiseHand(){
        shufflePlayCards(shuffledDeck);
        humanHand = dealPlay(shuffledDeck,10);
        aiHand = dealPlay(shuffledDeck, 10);
        boardHand = dealPlay(shuffledDeck, 4);
    }




    public void convertHands(){
        humanValues = new int[humanHand.length];
        for (int i = 0; i < humanHand.length; i++) {
            humanValues[i] = humanHand[i].getValue();
        }
        aiValues = new int[aiHand.length];
        for (int i = 0; i < aiHand.length; i++) {
            aiValues[i] = aiHand[i].getValue();
        }
        boardValues = new int[boardHand.length];
        for (int i = 0; i < boardHand.length; i++) {
            boardValues[i] = boardHand[i].getValue();
        }
    }




    public void startRound() {
        initialiseHand();
        convertHands();
    }

    public void test(){
        System.out.println("first card on the board is " + boardValues[0]);
    }



}
