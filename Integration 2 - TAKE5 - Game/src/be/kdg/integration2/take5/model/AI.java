package be.kdg.integration2.take5.model;

import java.util.*;




//TODO removing a row when a card is too low doesnt work for ai yet!!!

public class AI extends Player {

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
    private void playMiddleCardsBeforeHighAndLow() {
        LinkedList<Card> hand = showHand();
        ArrayList<Card> middleCards = new ArrayList<>();
        ArrayList<Card> highCards = new ArrayList<>();
        ArrayList<Card> lowCards = new ArrayList<>();

        // Separate the cards into middle, high, and low
        for (Card card : hand) {
            if (card.getValue() >= 40 && card.getValue() <= 60) {
                middleCards.add(card);
            } else if (card.getValue() > 60) {
                highCards.add(card);
            } else {
                lowCards.add(card);
            }
        }

        // Play the middle cards first
        for (Card card : middleCards) {
            playAICard(card);
            hand.remove(card);
        }

        // Play the high cards next
        for (Card card : highCards) {
            playAICard(card);
            hand.remove(card);
        }

        // Play the low cards last
        for (Card card : lowCards) {
            playAICard(card);
            hand.remove(card);
        }
    }

    private void playAICard(Card card) {
    }


    private LinkedList<Card> showHand() {
        return deck.getAiHand();
    }


    /**
     * gets aiHand and chooses the most fitting card for each row, it then takes the 4 cards and
     * checks which card has the highest/lowest bullValue
     * @return card with the highest amount of bulls
     */
    public Card chooseCard(Deck deck, Board board) {
        LinkedList<Card> closestHigherCards = new LinkedList<>();
        LinkedList<Card> tooLowCards = new LinkedList<>();
        LinkedList<Card> hand = deck.getAiHand();

        for (Card card : hand) {
            if (card.getValue() > board.getRow1().getLast().getValue() && (closestHigherCards.isEmpty() || card.getValue() < closestHigherCards.getFirst().getValue())) {
                closestHigherCards.clear();
                closestHigherCards.add(card);
            }
            if (card.getValue() > board.getRow2().getLast().getValue() && (closestHigherCards.isEmpty() || card.getValue() < closestHigherCards.getFirst().getValue())) {
                closestHigherCards.clear();
                closestHigherCards.add(card);
            }
            if (card.getValue() > board.getRow3().getLast().getValue() && (closestHigherCards.isEmpty() || card.getValue() < closestHigherCards.getFirst().getValue())) {
                closestHigherCards.clear();
                closestHigherCards.add(card);
            }
            if (card.getValue() > board.getRow4().getLast().getValue() && (closestHigherCards.isEmpty() || card.getValue() < closestHigherCards.getFirst().getValue())) {
                closestHigherCards.clear();
                closestHigherCards.add(card);
            }
            if (cardIsLower(card, board)){
                tooLowCards.add(card);
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

        for (Card card : tooLowCards) {
            int bulls = card.getPointValue(card);
            if (bulls > highestBulls) {
                highestBulls = bulls;
                cardWithHighestBulls = card;
            }
        }


        return cardWithHighestBulls;
    }


    /**
     * method to check if card is lower than all cards on board, used as condition to perform other actions
     * @param card is the card being played by the AI
     * @param board the current object of board being used during the game
     * @return is true if the card played is indeed lower than all the other cards on the board
     */
    public boolean cardIsLower(Card card, Board board){
        return card.getValue() < board.getRow1().getLast().getValue() && card.getValue() < board.getRow2().getLast().getValue() && card.getValue() < board.getRow3().getLast().getValue() && card.getValue() < board.getRow4().getLast().getValue();
    }

}