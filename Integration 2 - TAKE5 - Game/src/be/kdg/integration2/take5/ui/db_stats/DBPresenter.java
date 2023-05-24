package be.kdg.integration2.take5.ui.db_stats;

import be.kdg.integration2.take5.model.GameSession;
import javafx.scene.chart.XYChart;

public class DBPresenter {
    private final DBView view;
    private final GameSession model;

    public DBPresenter(DBView view, GameSession model) {
        this.view = view;
        this.model = model;

        // Set up event handlers
        view.setCloseButtonAction(this::onCloseButtonClicked);

        // Update view with initial data
        updateView();
    }

    private void onCloseButtonClicked() {
        view.close();
    }

    private void updateView() {
        // Retrieve and update data from the model
        double averageDuration = model.getAverageDuration();
        String outliers = model.getOutliers();
        XYChart.Series<Number, Number> durationData = model.getDurationData();

        // Update the view with the new data
        view.setAverageDuration(averageDuration);
        view.setOutliers(outliers);
        view.setDurationChartData(durationData);
    }
}


