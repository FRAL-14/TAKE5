package be.kdg.integration2.take5.model;
import java.util.*;

public class AI extends Player{

    public void showHand(Deck deck){
        System.out.println(deck.aiHand.toString());
    }





    // rule to play check whether the AI has the lowest card (1) and if yes to play it
    private void playLowestCardIfAvailable() {
        //  Check the lowest card
        Card lowestCard = null;
        ArrayList<Card> hand = showHand();
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



}