//package be.kdg.integration2.take5.ui.db_stats;
//
//import be.kdg.integration2.take5.model.Move;
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.scene.Scene;
//import javafx.scene.chart.BarChart;
//import javafx.scene.chart.CategoryAxis;
//import javafx.scene.chart.NumberAxis;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//
//import java.time.Duration;
//
//public class DBView extends Application {
//
//    private TableView<Move> moveTable = new TableView<>();
//    private final ObservableList<Move> moveData = FXCollections.observableArrayList();
//    private Label avgDurationLabel = new Label();
//    private Label outlierLabel = new Label();
//    private BarChart<String, Number> durationChart;
//
//    @Override
//    public void start(Stage primaryStage) {
//
//        primaryStage.setTitle("Game Statistics");
//
//        TableColumn<Move, Integer> moveCol = new TableColumn<>("Move");
//        moveCol.setCellValueFactory(new PropertyValueFactory<>("moveNumber"));
//
//        TableColumn<Move, Double> durationCol = new TableColumn<>("Duration");
//        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));
//
//        TableColumn<Move, Integer> scoreCol = new TableColumn<>("Score");
//        scoreCol.setCellValueFactory(new PropertyValueFactory<>("score"));
//
//        moveTable.getColumns().addAll(moveCol, durationCol, scoreCol);
//
//        // TODO: Fetch data from the database and populate moveData
//
//        moveTable.setItems(moveData);
//
//        CategoryAxis xAxis = new CategoryAxis();
//        NumberAxis yAxis = new NumberAxis();
//        durationChart = new BarChart<>(xAxis, yAxis);
//        durationChart.setTitle("Move Duration Chart");
//
//        VBox vbox1 = new VBox();
//        vbox1.setSpacing(5);
//        vbox1.setPadding(new Insets(10, 0, 0, 10));
//        vbox1.getChildren().addAll(moveTable);
//
//        HBox hbox1 = new HBox();
//        hbox1.setSpacing(5);
//        hbox1.setPadding(new Insets(10, 0, 0, 10));
//        hbox1.getChildren().addAll(avgDurationLabel);
//
//        HBox hbox2 = new HBox();
//        hbox2.setSpacing(5);
//        hbox2.setPadding(new Insets(10, 0, 0, 10));
//        hbox2.getChildren().addAll(outlierLabel);
//
//        VBox vbox2 = new VBox();
//        vbox2.setSpacing(5);
//        vbox2.setPadding(new Insets(10, 0, 0, 10));
//        vbox2.getChildren().addAll(durationChart);
//
//        BorderPane borderPane = new BorderPane();
//        borderPane.setLeft(vbox1);
//        borderPane.setTop(hbox1);
//        borderPane.setCenter(vbox2);
//        borderPane.setBottom(hbox2);
//
//        Scene scene = new Scene(borderPane, 800, 600);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//}
