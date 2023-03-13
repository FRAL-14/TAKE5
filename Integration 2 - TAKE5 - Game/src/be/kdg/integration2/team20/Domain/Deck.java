package be.kdg.integration2.team20.Domain;


import java.util.Arrays;
import java.util.Random;

public class Deck {
    Card[] shuffledDeck = dealPlay(Card.values(),104);
    Card[] humanHand;
    Card[] aiHand;
    Card[] boardHand;
    int roundCounter = 0;



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
        Arrays.sort(humanHand);
        Arrays.sort(aiHand);
    }


    public void startRound() {
        initialiseHand();
        roundCounter++;
    }

}