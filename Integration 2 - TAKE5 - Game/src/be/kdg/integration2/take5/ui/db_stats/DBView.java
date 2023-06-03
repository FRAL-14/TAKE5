package be.kdg.integration2.take5.ui.db_stats;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class DBView extends Parent {
    private Stage stage;
    private Label averageDurationLabel;
    private Label outliersLabel;
    private LineChart<Number, Number> durationChart;

    public DBView() {
        initializeUI();
        configureLayout();
    }

    private void initializeUI() {
        Label titleLabel = new Label("Game Statistics");
        titleLabel.setStyle("-fx-font-size: 34pt; -fx-font-weight: bold;");

        Label averageLabel = new Label("Average duration of moves:");
        averageDurationLabel = new Label();
        averageDurationLabel.setStyle("-fx-font-size: 20pt;");

        Label outliersTitleLabel = new Label("Outlier moves:");
        outliersTitleLabel.setStyle("-fx-font-size: 10pt; -fx-font-weight: bold;");

        outliersLabel = new Label();
        outliersLabel.setStyle("-fx-font-size: 10pt;");

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        durationChart = new LineChart<>(xAxis, yAxis);
        durationChart.setTitle("Move Durations");
        durationChart.setLegendVisible(false);

        Button closeButton = new Button("Close");

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

        BorderPane rootPane = new BorderPane(layout);
        rootPane.setStyle("-fx-background-color: linear-gradient(to bottom, #ffdcb6, #E06469);");

        Scene scene = new Scene(rootPane, 800, 600);

        stage = new Stage();
        stage.setTitle("Game Statistics");
        stage.setScene(scene);
    }

    private void configureLayout() {
        averageDurationLabel.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
        averageDurationLabel.setTextFill(Color.WHITE);

        outliersLabel.setFont(Font.font("Georgia", FontWeight.BOLD, 10));
        outliersLabel.setTextFill(Color.WHITE);

        durationChart.setStyle("-fx-background-color: transparent;");

        Button closeButton = (Button) stage.getScene().lookup("Button");
        closeButton.setStyle("-fx-background-color: #C9CCD5; -fx-background-radius: 15px; -fx-font-size: 30px;");
        closeButton.setTextFill(Color.WHITE);

        closeButton.setOnMouseEntered(e -> {
            closeButton.setStyle("-fx-background-color: #a8acb4; -fx-cursor: hand; -fx-font-size: 30px;");
        });

        closeButton.setOnMouseExited(e -> {
            closeButton.setStyle("-fx-background-color: #C9CCD5; -fx-background-radius: 15px; -fx-font-size: 30px;");
        });
    }

    public void show() {
        stage.show();
    }

    public void hide() {
        stage.hide();
    }

    public void setAverageDuration(String averageDuration) {
        averageDurationLabel.setText(averageDuration);
    }

    public void setOutliers(String outliers) {
        outliersLabel.setText(outliers);
    }

    public void setDurationData(XYChart.Series<Number, Number> series) {
        durationChart.getData().clear();
        durationChart.getData().add(series);
    }

    public void setOnCloseButtonClicked(Runnable handler) {
        Button closeButton = (Button) stage.getScene().lookup("Button");
        closeButton.setOnAction(e -> handler.run());
    }
}
