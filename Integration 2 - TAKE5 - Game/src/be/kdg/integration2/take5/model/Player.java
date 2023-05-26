package be.kdg.integration2.take5.model;

import java.util.LinkedList;
import java.util.List;

public abstract class Player {

    private String name;
    private int id;
    public int aiBullTotal = 0;
    public int humanBullTotal = 0;

    public int getAiBullTotal() {
        return aiBullTotal;
    }

    public int getHumanBullTotal() {
        return humanBullTotal;
    }

    public void setAiBullTotal(int aiBullTotal) {
        this.aiBullTotal = this.aiBullTotal + aiBullTotal;
    }

    public void setHumanBullTotal(int humanBullTotal) {
        this.humanBullTotal = this.humanBullTotal + humanBullTotal;
    }

    public void resetBullTotal(){
        this.humanBullTotal = 0;
        this.aiBullTotal = 0;
    }

    public void updateTotalScores(int humanScore, int aiScore) {
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


    /**
     * method to calculate bullValues of a List
     * @param cards
     * @return
     */
    public int bullValues(LinkedList<Card> cards) {
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