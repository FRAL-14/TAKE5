package be.kdg.integration2.take5.ui.help;

import be.kdg.integration2.take5.model.GameSession;
import javafx.stage.Window;

public class HelpPresenter {
    private GameSession model;
    private HelpView view;
    public HelpPresenter(GameSession model, HelpView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }
    private void addEventHandlers() {
        view.getReturnButton().setOnAction(event -> {
            view.getScene().getWindow().hide();
        });
    }
    private void updateView() {
// fills the view with model data
    }
    public void addWindowEventHandlers () {
        Window window = view.getScene().getWindow();
    }
}
