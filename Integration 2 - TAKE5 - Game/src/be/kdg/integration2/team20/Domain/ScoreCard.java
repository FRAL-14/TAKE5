package be.kdg.integration2.team20.Domain;


public class ScoreCard {
    private int score;

    public static int calculateScore(int[] cards, int[] amountOfBulls) {    //when changed to treeset, try to call the card and values separately and remove the arguments
        int totalScore = 0;
        for (int i = 0; i < amountOfBulls.length; i++) {
            totalScore += cards[amountOfBulls[i]];       //when list cards changed to treeset, add the keys to each other
        }
        return totalScore;
    }

}