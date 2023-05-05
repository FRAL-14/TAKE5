package be.kdg.integration2.take5.ui.db_stats;

import be.kdg.integration2.take5.model.*;
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
        // Update average duration label
        double averageDuration = model.getAverageDuration();
        view.setAverageDuration(averageDuration);

        // Update outliers label
        String outliers = model.getOutliers();
        view.setOutliers(outliers);

        // Update duration chart
        XYChart.Series<Number, Number> durationData = model.getDurationData();
        view.setDurationChartData(durationData);
    }
}

