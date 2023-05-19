package be.kdg.integration2.take5.model;

import java.util.LinkedList;
import java.util.List;

public abstract class Player {

    private String name;
    private int id;
    public static int aiBullTotal;
    public static int humanBullTotal;

    public static int getAiBullTotal() {
        return aiBullTotal;
    }

    public static int getHumanBullTotal() {
        return humanBullTotal;
    }

    public static void setAiBullTotal(int aiBullTotal) {
        Player.aiBullTotal = aiBullTotal;
    }

    public static void setHumanBullTotal(int humanBullTotal) {
        Player.humanBullTotal = humanBullTotal;
    }

    public static void updateTotalScores(int humanScore, int aiScore) {
        humanBullTotal += humanScore;
        aiBullTotal += aiScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }



    public static int bullValues(LinkedList<Card> cards) {
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

    public void setId() {
        this.id = Leaderboard.getPlayerID(this.name);
    }


}