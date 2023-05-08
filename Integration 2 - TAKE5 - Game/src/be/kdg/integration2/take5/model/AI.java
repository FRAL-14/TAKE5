package be.kdg.integration2.take5.model;
import java.util.*;

public class AI extends Player{

private Deck deck;
    // rule to play check whether the AI has the lowest card (1) and if yes to play it
    private void playLowestCardIfAvailable() {
        //  Check the lowest card
        Card lowestCard = null;
        LinkedList<Card> hand = showHand();
        for (Card card : hand) {
            if (card.getValue() == 1 && (lowestCard == null || card.compareTo(lowestCard) < 0)) {
                lowestCard = card;
            }
        }
        if (lowestCard != null) {
            // AI has the lowest card, play it first
            System.out.println("Playing lowest card: " + lowestCard.getValue());
            hand.remove(lowestCard);
        }
    }


    // rule to play middle cards before high and low cards
//    private void playMiddleCardsBeforeHighAndLow() {
//        LinkedList<Card> hand = showHand();
//        ArrayList<Card> middleCards = new ArrayList<Card>();
//        ArrayList<Card> highCards = new ArrayList<Card>();
//        ArrayList<Card> lowCards = new ArrayList<Card>();
//
//        // Separate the cards into middle, high, and low
//        for (Card card : hand) {
//            if (card.getValue() >= 40 && card.getValue() <= 60) {
//                middleCards.add(card);
//            } else if (card.getValue() > 60) {
//                highCards.add(card);
//            } else {
//                lowCards.add(card);
//            }
//        }
//
//        // Play the middle cards first
//        for (Card card : middleCards) {
//            playAICard(card);
//            hand.remove(card);
//        }
//
//        // Play the high cards next
//        for (Card card : highCards) {
//            playAICard(card);
//            hand.remove(card);
//        }
//
//        // Play the low cards last
//        for (Card card : lowCards) {
//            playAICard(card);
//            hand.remove(card);
//        }
//    }

    private void playAICard(Card card) {
    }


    private LinkedList<Card> showHand() {
        return deck.getAiHand();
    }

}