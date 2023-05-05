package be.kdg.integration2.take5.model;

import be.kdg.integration2.take5.ui.CardView;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class GameSession {
    Deck mainDeck = new Deck();
    Board board = new Board(mainDeck);
    Human human = new Human("human");
    AI ai = new AI();
    private List<Double> moveDurations;
    private double averageDuration;
    private List<Double> outliers;
    private XYChart.Series<Number, Number> durationData;

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

    private double getMedianAbsoluteDeviation(double median) {
        List<Double> deviations = new ArrayList<>();
        for (Double duration : moveDurations) {
            deviations.add(Math.abs(duration - median));
        }

        return getMedian(deviations);
    }

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


    public void makeBoard() {
        mainDeck.startRound();
        board.initializeRow(mainDeck);
    }

    public void clear() {
        board.clear();
    }

    public Deck getDeck() {
        return mainDeck;
    }

    public void startGame() {
    }

    public boolean playCard(Card card) {
        board.playCard(card);
        return true;
    }

    public Card playAICard() {
        return board.playAICard();
    }

    public LinkedList<Card> getRow(int row) {
        return switch (row) {
            case 1 -> board.getRow1();
            case 2 -> board.getRow2();
            case 3 -> board.getRow3();
            case 4 -> board.getRow4();
            default -> throw new IllegalArgumentException("Invalid stack number");
        };
    }

    public LinkedList<Card> getHand(String type) {
        return switch (type) {
            case "human" -> mainDeck.getHumanHand();
            case "ai" -> mainDeck.getAiHand();
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

}