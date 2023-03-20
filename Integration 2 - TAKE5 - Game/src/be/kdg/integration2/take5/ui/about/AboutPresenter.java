package be.kdg.integration2.take5.ui.about;

import be.kdg.integration2.take5.model.GameSession;
import javafx.stage.Window;

public class AboutPresenter {
    private GameSession model;
    private AboutView aboutView;
    public AboutPresenter(
            GameSession model, AboutView aboutView) {
        this.model = model;
        this.aboutView = aboutView;
        addEventHandlers();
        updateView();
    }
    private void addEventHandlers() {
// Add event handlers (inner classes or
// lambdas) to view controls.
// In the event handlers: call model methods
// and updateView().
    }
    private void updateView() {
// fills the view with model data
    }
    public void addWindowEventHandlers () {
        Window window = aboutView.getScene().getWindow();
// Add event handlers to window
    }
}
