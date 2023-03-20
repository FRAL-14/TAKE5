package be.kdg.integration2.take5.ui;

import be.kdg.integration2.take5.model.GameSession;
import be.kdg.integration2.take5.ui.game.GamePresenter;
import be.kdg.integration2.take5.ui.game.GameView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

public class MainPresenter {
    private final GameSession model;
    private final MainView startView;

    public MainPresenter(GameSession model, MainView startView) {
        this.model = model;
        this.startView = startView;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        startView.getsButton().setOnAction(e -> setGameView());
// Add event handlers (inner classes or
// lambdas) to view controls.
// In the event handlers: call model methods
// and updateView().
    }

    private void setGameView() {
        GameView gameView = new GameView();
        GamePresenter gamePresenter = new GamePresenter(model,gameView);
        startView.getScene().setRoot(gameView);
        gameView.getScene().getWindow().sizeToScene();
    }

    private void updateView() {
// fills the view with model data
    }

    public void addWindowEventHandlers() {
        startView.getScene().getWindow().setOnCloseRequest(event -> closeApplication(event));
// Add event handlers to window
    }

    private void closeApplication(WindowEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Watch Out!");
        alert.setHeaderText("You're about to close the application!");
        alert.setContentText("Are you sure you want to leave? :(");
        ButtonType no = new ButtonType("no");
        ButtonType yes = new ButtonType("yes");
        alert.getButtonTypes().addAll(no, yes);
        alert.show();
        if (alert.getResult().equals(no)) {
            event.consume();
        }
    }
}
