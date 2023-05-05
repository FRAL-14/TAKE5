package be.kdg.integration2.take5.ui.user_input;

import be.kdg.integration2.take5.model.GameSession;
import be.kdg.integration2.take5.ui.MainPresenter;
import be.kdg.integration2.take5.ui.MainView;
import be.kdg.integration2.take5.ui.game.GamePresenter;
import be.kdg.integration2.take5.ui.game.GameView;
import javafx.stage.Window;
/**
 * This class is responsible for handling the user input
 */
public class InputPresenter {
    private GameSession model;
    private InputView ipView;

    public InputPresenter(GameSession model, InputView ipView) {
        this.model = model;
        this.ipView = ipView;
        addEventHandlers();
//        updateView();
    }

    private void addEventHandlers() {
        ipView.getReturnBtn().setOnAction(event -> goToMain());
        ipView.getSubmitBtn().setOnAction(event -> setGameView());
        requiredInput();
    }

    /**
     * Disables submit button when input field is empty
     */
    private void requiredInput() {
        ipView.getSubmitBtn().setDisable(true); //disables btn when empty when method is called for the first time
        ipView.getInputField().textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                ipView.getSubmitBtn().setDisable(true);//disables btn if you delete text (so it becomes empty)
            } else {
                ipView.getSubmitBtn().setDisable(false);
            }
        });
    }

    private void goToMain() {
        MainView mainView = new MainView();
        new MainPresenter(model, mainView);
        ipView.getScene().setRoot(mainView);
        mainView.getScene().getWindow();
    }

    private void setGameView() {
        GameView gameView = new GameView();
        new GamePresenter(model, gameView);
        ipView.getScene().setRoot(gameView);
        gameView.getScene().getWindow();
    }

//    private void updateView() {
//// fills the view with model data
//    }

    public void addWindowEventHandlers() {
        Window window = ipView.getScene().getWindow();
// Add event handlers to window
    }
}
