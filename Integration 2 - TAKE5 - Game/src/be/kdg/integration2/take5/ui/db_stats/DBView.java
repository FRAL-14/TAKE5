package be.kdg.integration2.take5.ui.db_stats;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DBView {
    private final Stage stage;
    private final Label averageDurationLabel;
    private final Label outliersLabel;
    private final LineChart<Number, Number> durationChart;

    public DBView() {
        // Create UI elements
        Label titleLabel = new Label("Game Statistics");
        titleLabel.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");

        Label averageLabel = new Label("Average duration of moves:");
        averageDurationLabel = new Label();
        averageDurationLabel.setStyle("-fx-font-size: 16pt;");

        Label outliersTitleLabel = new Label("Outlier moves:");
        outliersTitleLabel.setStyle("-fx-font-size: 20pt; -fx-font-weight: bold;");

        outliersLabel = new Label();
        outliersLabel.setStyle("-fx-font-size: 16pt;");

        // Create line chart to display move durations
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        durationChart = new LineChart<>(xAxis, yAxis);
        durationChart.setTitle("Move Durations");
        durationChart.setLegendVisible(false);

        // Create close button
        Button closeButton = new Button("Close");

        // Create layout and add elements
        GridPane layout = new GridPane();
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20));
        layout.setVgap(20);
        layout.add(titleLabel, 0, 0);
        layout.add(averageLabel, 0, 1);
        layout.add(averageDurationLabel, 1, 1);
        layout.add(outliersTitleLabel, 0, 2);
        layout.add(outliersLabel, 1, 2);
        layout.add(durationChart, 0, 3, 2, 1);
        layout.add(closeButton, 0, 4, 2, 1);

        // Create scene and set layout
        Scene scene = new Scene(layout, 800, 600);

        // Set stage properties
        stage = new Stage();
        stage.setTitle("Game Statistics");
        stage.setScene(scene);
    }

    public void show() {
        stage.show();
    }

    public void setAverageDuration(double duration) {
        averageDurationLabel.setText(String.format("%.2f seconds", duration));
    }

    public void setOutliers(String outliers) {
        outliersLabel.setText(outliers);
    }

    public void setDurationChartData(XYChart.Series<Number, Number> series) {
        durationChart.getData().clear();
        durationChart.getData().add(series);
    }

    public void setCloseButtonAction(Runnable action) {
        stage.setOnCloseRequest(event -> action.run());
    }

    public void close() {
        stage.close();
    }

}

