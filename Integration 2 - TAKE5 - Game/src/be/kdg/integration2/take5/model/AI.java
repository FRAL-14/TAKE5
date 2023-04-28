package be.kdg.integration2.take5.model;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

public class AI extends Player{

    public void showHand(Deck deck){
        System.out.println(deck.aiHand.toString());
    }

//    Rule, not done yet PLEASE don't delete it

//    public void playLowestCardIfAvailable() {
//        //  Sort the cards
//        Collections.sort(getHand(), Comparator.comparing(Card::getValue));
//
//        //  Check the lowest card
//        Card lowestCard = getHand().get(0);
//        if (lowestCard.getValue() == 1) {
//            // AI has the lowest card, play it first
//            System.out.println("Playing lowest card: " + lowestCard.getValue());
//            getHand().remove(lowestCard);
//        }
//    }

}