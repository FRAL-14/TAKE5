package be.kdg.integration2.take5.ui.game_over;

import be.kdg.integration2.take5.model.GameSession;
import be.kdg.integration2.take5.ui.MainPresenter;
import be.kdg.integration2.take5.ui.MainView;
import be.kdg.integration2.take5.ui.db_stats.DBPresenter;
import be.kdg.integration2.take5.ui.db_stats.DBView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * This class is responsible for handling all events that happen in the GameOverView.
 * It is the link between the GameOverView and the model.
 */
public class GameOverPresenter {
    private GameSession model;
    private GameOverView gameOverView;

    public GameOverPresenter(GameSession model, GameOverView view, String type) {
        this.model = model;
        this.gameOverView = view;
        addEventHandlers();
        updateView(type);
    }

    /**
     * This method adds all event handlers to the view.
     */
    private void addEventHandlers() {
        gameOverView.getExitGame().setOnAction(event -> {
            ((Stage) gameOverView.getScene().getWindow()).close();
        });
        gameOverView.getTryAgain().setOnAction(event -> tryAgain());
        gameOverView.getGameStatsButton().setOnAction(event -> {
            // Handle navigation to the game statistics screen (DBView)
            DBView dbView = new DBView();
            DBPresenter dbPresenter = new DBPresenter(dbView, model);
            Stage dbStage = new Stage();
            Scene dbScene = new Scene(dbView);
            dbStage.setScene(dbScene);
            dbStage.setTitle("Game Statistics");
            dbStage.show();

            // Close the current game over screen
            ((Stage) gameOverView.getScene().getWindow()).close();
        });
    }

    private void tryAgain() {
        MainView mainView = new MainView();
        MainPresenter pres=new MainPresenter(model,mainView);
        gameOverView.getScene().setRoot(mainView);
        mainView.getScene().getWindow();
            model.clear();
//            clearHand();
            model.makeBoard();
//        model.startGame();
    }

    private void updateView(String type) {
        gameOverView.setCongrLbl(type);
    }

    public void addWindowEventHandlers() {
        Window window = gameOverView.getScene().getWindow();
    }
}
