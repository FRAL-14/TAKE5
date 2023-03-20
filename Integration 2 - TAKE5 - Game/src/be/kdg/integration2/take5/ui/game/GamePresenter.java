package be.kdg.integration2.take5.ui.game;

import be.kdg.integration2.take5.model.GameSession;
import javafx.stage.Window;

public class GamePresenter {
    private GameSession model;
    private GameView gameView;

    public GamePresenter(GameSession model, GameView gameView) {
        this.model = model;
        this.gameView = gameView;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {gameView.getMenu().setOnAction(event -> showAbout());

    }

    private void showAbout() {
        //can only continue if i know i can or cant use combobox in GameView
    }

    private void updateView() {
// fills the view with model data
    }

    public void addWindowEventHandlers() {
        Window window = gameView.getScene().getWindow();
// Add event handlers to window
    }
}
