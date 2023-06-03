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
        view.setOnCloseButtonClicked(this::onCloseButtonClicked);

        // Update view with initial data
        updateView();
    }

    private void onCloseButtonClicked() {
        view.hide();
    }

    private void updateView() {
        double averageDuration = 10.2;
        String outliers = "8, 7, 17";
        XYChart.Series<Number, Number> durationData = new XYChart.Series<>();
        durationData.getData().add(new XYChart.Data<>(1, 12));
        durationData.getData().add(new XYChart.Data<>(2, 10));
        durationData.getData().add(new XYChart.Data<>(3, 10));
        durationData.getData().add(new XYChart.Data<>(4, 9));
        durationData.getData().add(new XYChart.Data<>(5, 11));
        durationData.getData().add(new XYChart.Data<>(6, 9));
        durationData.getData().add(new XYChart.Data<>(7, 10));
        durationData.getData().add(new XYChart.Data<>(8, 10));
        durationData.getData().add(new XYChart.Data<>(9, 10));
        durationData.getData().add(new XYChart.Data<>(10, 13));
        durationData.getData().add(new XYChart.Data<>(11, 9));
        durationData.getData().add(new XYChart.Data<>(12, 10));
        durationData.getData().add(new XYChart.Data<>(13, 11));
        durationData.getData().add(new XYChart.Data<>(14, 12));
        durationData.getData().add(new XYChart.Data<>(15, 8));
        durationData.getData().add(new XYChart.Data<>(16, 9));
        durationData.getData().add(new XYChart.Data<>(17, 10));
        durationData.getData().add(new XYChart.Data<>(18, 9));
        durationData.getData().add(new XYChart.Data<>(19, 10));
        durationData.getData().add(new XYChart.Data<>(20, 14));
        durationData.getData().add(new XYChart.Data<>(21, 8));
        durationData.getData().add(new XYChart.Data<>(22, 9));
        durationData.getData().add(new XYChart.Data<>(23, 10));
        durationData.getData().add(new XYChart.Data<>(24, 12));
        durationData.getData().add(new XYChart.Data<>(25, 11));
        durationData.getData().add(new XYChart.Data<>(26, 11));
        durationData.getData().add(new XYChart.Data<>(27, 11));
        durationData.getData().add(new XYChart.Data<>(28, 9));
        durationData.getData().add(new XYChart.Data<>(29, 9));
        durationData.getData().add(new XYChart.Data<>(30, 14));
        durationData.getData().add(new XYChart.Data<>(31, 10));
        durationData.getData().add(new XYChart.Data<>(32, 10));
        durationData.getData().add(new XYChart.Data<>(33, 9));
        durationData.getData().add(new XYChart.Data<>(34, 8));
        durationData.getData().add(new XYChart.Data<>(35, 10));
        durationData.getData().add(new XYChart.Data<>(36, 10));
        durationData.getData().add(new XYChart.Data<>(37, 8));
        durationData.getData().add(new XYChart.Data<>(38, 7));
        durationData.getData().add(new XYChart.Data<>(39, 8));
        durationData.getData().add(new XYChart.Data<>(40, 13));
        durationData.getData().add(new XYChart.Data<>(41, 8));
        durationData.getData().add(new XYChart.Data<>(42, 9));

        view.setAverageDuration(String.valueOf(averageDuration));
        view.setOutliers(outliers);
        view.setDurationData(durationData);
    }
}



