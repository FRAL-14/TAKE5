package be.kdg.integration2.team20.Domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    //this was an example
//    CardID c;

//    public void makeboard(){
//
//        shuffle(CardID.values());
//
//
//    }
    static Random rand = new Random();


    public static CardID[] shuffle(CardID[] cards) {
        List<CardID> cardList = Arrays.asList(cards);
        for (int i = cardList.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Collections.swap(cardList, i, j);
        }
        return cardList.toArray(cards);
    }

    public static CardID[] deal(CardID[] cards, int numCards) {
        CardID[] dealtCards = new CardID[numCards];
        for (int i = 0; i < numCards; i++) {
            dealtCards[i] = cards[i * 2];
        }
        return dealtCards;
    }


    public static void shufflePlayCards(CardID[] cards) {
        Random rand = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            CardID temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }

    public static CardID[] dealPlay(CardID[] deck, int numCards) {
        if (numCards > deck.length) {
            throw new IllegalArgumentException("Not enough cards in the deck.");
        }

        CardID[] dealtCards = new CardID[numCards];
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
}