package be.kdg.integration2.take5.model;

import be.kdg.integration2.take5.model.Card;
import javafx.collections.ObservableList;

import java.util.List;

public class ScoreCalc {
    public static int calculateScore(ObservableList<Card> cards) {

        int totalScore = 0;
        List<Card> cardList = cards.stream().toList();
        for (Card card : cardList) {
            if (card.getValue() % 10 == 0) {
                totalScore += 3;
            } else if (card.getValue() % 55 == 0) {
                totalScore += 7;
            } else if (card.getValue() % 5 == 0) {
                totalScore += 2;
            } else if (card.getValue() % 11 == 0) {
                totalScore += 5;
            } else {
                totalScore += 1;
            }
        }
        return totalScore;
    }
}