package be.kdg.integration2.take5.ui.game_over;

import be.kdg.integration2.take5.model.GameSession;
import javafx.stage.Stage;
import javafx.stage.Window;
/**
 * This class is responsible for handling all events that happen in the GameOverView.
 * It is the link between the GameOverView and the model.
 */
public class GameOverPresenter {
    private GameSession model;
    private GameOverView view;

    public GameOverPresenter(GameSession model, GameOverView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    /**
     * This method adds all event handlers to the view.
     */
    private void addEventHandlers() {
        this.view.getExitGame().setOnAction(event -> {
            ((Stage) this.view.getScene().getWindow()).close();
        });
    }

    private void updateView() {
//if scoreAI=66 --> user won! (view.getCongrLbl().setText("Congratulations, you won the game!");) as example
        //else , you lost the game!
        }

    public void addWindowEventHandlers() {
        Window window = view.getScene().getWindow();
    }
}
