package be.kdg.integration2.take5.model;

import be.kdg.integration2.take5.ui.CardView;
import javafx.scene.chart.XYChart;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class GameSession {
    Board board = new Board();
    Deck mainDeck = new Deck();
    Human human = new Human();
    AI ai = new AI();
    private List<CardView> boardCardViews;
    private LinkedList<Card>[] rows;

    private List<Double> moveDurations;
    private double averageDuration;
    private List<Double> outliers;
    private XYChart.Series<Number, Number> durationData;



    public GameSession(List<Double> moveDurations) {
        this.moveDurations = moveDurations;
    }

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

    public Card[] makeBoard() {
        mainDeck.startRound();
//        board.initializeRow(mainDeck);
//        presenter.updateView();
        rows = new LinkedList[4];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new LinkedList<>();
        }
        return new Card[0];
    }

    public void displayBoard() {
        for (int i = 0; i < 4; i++) {
            CardView cardView = new CardView(rows[i].getFirst());
            boardCardViews.get(i).getChildren().clear();
            boardCardViews.get(i).getChildren().add(cardView);
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

// In the Model class:

//    public int findRowToPlace(Card selectedCard) {
//        List<List<Card>> rows = getRows();
//        int minDiff = Integer.MAX_VALUE;
//        int minDiffIndex = 0;
//
//        // Iterate over each row to find the one with the lowest difference
//        for (int i = 0; i < rows.size(); i++) {
//            List<Card> row = rows.get(i);
//            int diff = row.get(row.size() - 1).getValue() - selectedCard.getValue();
//            if (diff >= 0 && diff < minDiff) {
//                minDiff = diff;
//                minDiffIndex = i;
//            }
//        }
//
//        return minDiffIndex;
//    }
//
//    public List<List<Card>> getRows() {
//        return List.of(rows);
//    }

    public Card getBoardCard(int i) {
        return rows[i].getFirst();
    }

    public void startGame() {
//        board.playCard(mainDeck, human);
        board.checkLists(human);
//        board.playCard(mainDeck, ai);
        board.checkLists(ai);
    }

    public ArrayList<Card> getDeck() {
        return mainDeck.dealPlay(mainDeck.cards, 104);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Deck getMainDeck() {
        return mainDeck;
    }

    public void setMainDeck(Deck mainDeck) {
        this.mainDeck = mainDeck;
    }

    public Human getHuman() {
        return human;
    }

    public void setHuman(Human human) {
        this.human = human;
    }

    public AI getAi() {
        return ai;
    }

    public void setAi(AI ai) {
        this.ai = ai;
    }

    public List<CardView> getBoardCardViews() {
        return boardCardViews;
    }

    public void setBoardCardViews(List<CardView> boardCardViews) {
        this.boardCardViews = boardCardViews;
    }

//    public LinkedList<Card>[] getRows() {
//        return rows;
//    }

    public void setRows(LinkedList<Card>[] rows) {
        this.rows = rows;
    }



}