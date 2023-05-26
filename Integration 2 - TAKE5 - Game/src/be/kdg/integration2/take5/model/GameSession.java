package be.kdg.integration2.take5.model;

import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class GameSession {

    private Leaderboard leaderboard;
    int turn = 0;
    Deck mainDeck = new Deck();
    Player player;
    Board board = new Board(mainDeck);
    Human human = new Human("human");
    AI ai = new AI();
    private List<Double> moveDurations;
    private double averageDuration;
    private List<Double> outliers;
    private XYChart.Series<Number, Number> durationData;

    /**
     * Calculates the average move duration of the current game session.
     *
     * @return The average move duration, or 0.0 if no moves have been made yet.
     */
    public double getAverageDuration() {
        if (moveDurations.isEmpty()) {
            return 0.0;
        } else {
            double sum = 0.0;
            for (double duration : moveDurations) {
                sum += duration;
            }
            return sum / moveDurations.size();
        }
    }

    /**
     * Calculates the outliers of move durations in the current game session.
     *
     * @return A string containing a comma-separated list of outliers, or "None" if there are no outliers.
     */
    public String getOutliers() {
        double median = getMedianDuration();
        double medianAbsoluteDeviation = getMedianAbsoluteDeviation(median);
        double outlierThreshold = median + (10 * medianAbsoluteDeviation);

        List<Double> outliers = new ArrayList<>();
        for (Double duration : moveDurations) {
            if (duration > outlierThreshold) {
                outliers.add(duration);
            }
        }

        if (outliers.isEmpty()) {
            return "None";
        } else {
            return outliers.stream()
                    .map(duration -> String.format("%.2f", duration))
                    .collect(Collectors.joining(", "));
        }
    }

    /**
     * Calculates the median move duration of the current game session.
     *
     * @return The median move duration.
     */
    private double getMedianDuration() {
        List<Double> sortedDurations = new ArrayList<>(moveDurations);
        Collections.sort(sortedDurations);

        if (sortedDurations.size() % 2 == 0) {
            int midIndex = sortedDurations.size() / 2;
            double midValue1 = sortedDurations.get(midIndex - 1);
            double midValue2 = sortedDurations.get(midIndex);
            return (midValue1 + midValue2) / 2.0;
        } else {
            int midIndex = sortedDurations.size() / 2;
            return sortedDurations.get(midIndex);
        }
    }

    /**
     * Calculates the median absolute deviation of move durations from the median duration.
     *
     * @param median The median move duration.
     * @return The median absolute deviation.
     */
    private double getMedianAbsoluteDeviation(double median) {
        List<Double> deviations = new ArrayList<>();
        for (Double duration : moveDurations) {
            deviations.add(Math.abs(duration - median));
        }

        return getMedian(deviations);
    }

    /**
     * Calculates the median of a list of values.
     *
     * @param values The list of values.
     * @return The median value.
     */
    private double getMedian(List<Double> values) {
        List<Double> sortedValues = new ArrayList<>(values);
        Collections.sort(sortedValues);

        if (sortedValues.size() % 2 == 0) {
            int midIndex = sortedValues.size() / 2;
            double midValue1 = sortedValues.get(midIndex - 1);
            double midValue2 = sortedValues.get(midIndex);
            return (midValue1 + midValue2) / 2.0;
        } else {
            int midIndex = sortedValues.size() / 2;
            return sortedValues.get(midIndex);
        }
    }

    public XYChart.Series<Number, Number> getDurationData() {
        return durationData;
    }

    private void updateDurationData() {
        durationData = new XYChart.Series<>();
        for (int i = 0; i < moveDurations.size(); i++) {
            durationData.getData().add(new XYChart.Data<>(i + 1, moveDurations.get(i)));
        }
    }

    /**
     * makeBoard method takes method from deck to make hands and method from board to assign cards to the rows
     */
    public void makeBoard() {
        mainDeck.startRound();
        board.initializeRow(mainDeck);
    }

    public void clear() {
        mainDeck.remakeCards();
        board.clear();
    }

    public Deck getDeck() {
        return mainDeck;
    }

//    public void startGame() {
//        leaderboard.addPlayer(human);
//        human.setId();
//        leaderboard.addPlayer(ai);
//        ai.setId();
//
//    }


    /**
     * calling newRound from deck, method is called in gamePresenter
     * @param cards list of active cards in the ongoing game
     */
    public void newRound(LinkedList<Card> cards){
        mainDeck.newRound(cards);
        turn = 0;
    }


    /**
     * method to return the number of turns to call method newRound
     * @return the turn at which the game currently is
     */
    public int getTurn(){
        return turn;
    }

    /**
     * method to call playCard from board inside javaFx classes
     *
     * @param card the card that has to be played
     * @return is true if the method worked
     */
    public boolean playCard(Card card) {
        boolean played = board.playCard(card, human);
        board.checkLists(human);
        turn++;
        return played;

    }

    /**
     * same as playCard but for AI
     *
     * @return the card that got played by the AI
     */
    public Card playAICard() {
        Card card = ai.chooseCard(mainDeck, board);
        board.playCard(card, ai);
        board.checkLists(ai);
        return card;
    }

    /**
     * method used to call rows and use them in javaFx classes
     *
     * @param row the number of the row that has to be retrieved
     * @return the row of cards
     */
    public LinkedList<Card> getRow(int row) {
        return switch (row) {
            case 1 -> board.getRow1();
            case 2 -> board.getRow2();
            case 3 -> board.getRow3();
            case 4 -> board.getRow4();
            default -> throw new IllegalArgumentException("Invalid stack number");
        };
    }

    /**
     * same as getRow but for humanHand and AIHand
     *
     * @param type is either human or AI to determine which hand has to be retrieved
     * @return a list of cards also called hand
     */
    public LinkedList<Card> getHand(String type) {
        return switch (type) {
            case "human" -> mainDeck.getHumanHand();
            case "ai" -> mainDeck.getAiHand();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    /**
     * method used to retrieve the bullTotal in gamePresenter
     * @param type is either human or AI to determine which bullTotal has to be retrieved
     * @return the bullTotal of the player
     */
    public int getBullTotal(String type) {
        return switch (type) {
            case "human" -> human.getHumanBullTotal();
            case "ai" -> ai.getAiBullTotal();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    public void resetBullTotal(){
        human.resetBullTotal();
    }


    /**
     * method that is called in gamePresenter and calls the method in board, to pass all parameters
     * @param row the number of the row that has to be removed
     * @param type is either human or AI to determine which player played the invalid card
     * @param card
     */
    public void chooseRow(int row, String type, Card card){
        if (type.equals("human")){
            board.chooseRow(row, human, card);
        } else {
            board.chooseRow(row, ai, card);
        }
    }

}