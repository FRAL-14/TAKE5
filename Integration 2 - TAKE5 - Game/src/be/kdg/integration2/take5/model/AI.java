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

    Card row1;
    Card row2;
    Card row3;
    Card row4;


    /**
     * gets aiHand and chooses the most fitting card for each row, it then takes the 4 cards and
     * checks which card has the highest/lowest bullValue
     * @param deck
     * @param board
     * @return
     */
    public Card chooseCard(Deck deck, Board board) {
            LinkedList<Card> closestHigherCards = new LinkedList<>();
            LinkedList<Card> hand = deck.getAiHand();
            row1 = board.getRow1().getLast();
            row2 = board.getRow2().getLast();
            row3 = board.getRow3().getLast();
            row4 = board.getRow4().getLast();

            for (Card card : hand) {
                if (card.getValue() > row1.getValue() && (closestHigherCards.isEmpty() || card.getValue() < closestHigherCards.getFirst().getValue())) {
                    closestHigherCards.clear();
                    closestHigherCards.add(card);
                }
                if (card.getValue() > row2.getValue() && (closestHigherCards.isEmpty() || card.getValue() < closestHigherCards.getFirst().getValue())) {
                    closestHigherCards.clear();
                    closestHigherCards.add(card);
                }
                if (card.getValue() > row3.getValue() && (closestHigherCards.isEmpty() || card.getValue() < closestHigherCards.getFirst().getValue())) {
                    closestHigherCards.clear();
                    closestHigherCards.add(card);
                }
                if (card.getValue() > row4.getValue() && (closestHigherCards.isEmpty() || card.getValue() < closestHigherCards.getFirst().getValue())) {
                    closestHigherCards.clear();
                    closestHigherCards.add(card);
                }
            }

        Card cardWithHighestBulls = null;
        int highestBulls = Integer.MIN_VALUE;

        for (Card card : closestHigherCards) {
            int bulls = card.getPointValue(card);
            if (bulls > highestBulls) {
                highestBulls = bulls;
                cardWithHighestBulls = card;
            }
        }

            return cardWithHighestBulls;
        }
}