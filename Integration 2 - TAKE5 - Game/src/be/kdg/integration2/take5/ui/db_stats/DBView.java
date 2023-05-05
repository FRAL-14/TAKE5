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
    private final Stage stage;  // Stage for displaying the view
    private final Label averageDurationLabel;  // Label to display the average duration of moves
    private final Label outliersLabel;  // Label to display the outlier moves
    private final LineChart<Number, Number> durationChart;  // Chart to display the move durations

    public DBView() {
        // Create UI elements
        Label titleLabel = new Label("Game Statistics"); // Title label for the view
        titleLabel.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");

        Label averageLabel = new Label("Average duration of moves:"); // Label to describe the average duration
        averageDurationLabel = new Label(); // Label to display the average duration
        averageDurationLabel.setStyle("-fx-font-size: 16pt;");

        Label outliersTitleLabel = new Label("Outlier moves:"); // Label to describe the outlier moves
        outliersTitleLabel.setStyle("-fx-font-size: 20pt; -fx-font-weight: bold;");

        outliersLabel = new Label(); // Label to display the outlier moves
        outliersLabel.setStyle("-fx-font-size: 16pt;");

        // Create line chart to display move durations
        NumberAxis xAxis = new NumberAxis(); // X-axis for the chart
        NumberAxis yAxis = new NumberAxis(); // Y-axis for the chart
        durationChart = new LineChart<>(xAxis, yAxis); // Create the chart
        durationChart.setTitle("Move Durations"); // Set the chart title
        durationChart.setLegendVisible(false); // Hide the legend

        // Create close button
        Button closeButton = new Button("Close");

        // Create layout and add elements
        GridPane layout = new GridPane(); // Grid layout for the UI elements
        layout.setAlignment(Pos.CENTER); // Center the layout
        layout.setPadding(new Insets(20));  // Add padding
        layout.setVgap(20); // Add vertical gap between elements
        layout.add(titleLabel, 0, 0); // Add the title label
        layout.add(averageLabel, 0, 1); // Add the label to describe the average duration
        layout.add(averageDurationLabel, 1, 1); // Add the label to display the average duration
        layout.add(outliersTitleLabel, 0, 2); // Add the label to describe the outlier moves
        layout.add(outliersLabel, 1, 2); // Add the label to display the outlier moves
        layout.add(durationChart, 0, 3, 2, 1);  // Add the chart
        layout.add(closeButton, 0, 4, 2, 1); // Add the close button

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

