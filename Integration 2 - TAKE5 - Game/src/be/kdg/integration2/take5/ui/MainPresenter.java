package be.kdg.integration2.take5.ui;

import be.kdg.integration2.take5.model.GameSession;
import be.kdg.integration2.take5.ui.game.GamePresenter;
import be.kdg.integration2.take5.ui.game.GameView;
import be.kdg.integration2.take5.ui.help.HelpPresenter;
import be.kdg.integration2.take5.ui.help.HelpView;
import be.kdg.integration2.take5.ui.user_input.InputPresenter;
import be.kdg.integration2.take5.ui.user_input.InputView;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainPresenter {
    private GameSession model;
    private MainView startView;

    public MainPresenter(GameSession model, MainView startView) {
        this.model = model;
        this.startView = startView;
        addEventHandlers();
//        updateView(); not used
    }

    private void addEventHandlers() {
        //        this.startView.getPlay().setOnAction(e -> setGameView());
        this.startView.getPlay().setOnAction(e -> setUserInput());
        //if button 'STATS' is clicked ( TODO DBView and DBPresenter are commented right now so cannot implement)
        this.startView.getHelp().setOnMouseClicked(e -> setHelpView());
    }

    private void setUserInput() {
        InputView ipv = new InputView();
        new InputPresenter(model, ipv);
        startView.getScene().setRoot(ipv);
        ipv.getScene().getWindow();
    }
    private void setHelpView() {
        HelpView helpView = new HelpView();
        HelpPresenter presenter = new HelpPresenter(model, helpView);
        Stage helpStage = new Stage();
        helpStage.initOwner(startView.getScene().getWindow());
        helpStage.initModality(Modality.APPLICATION_MODAL);
        helpStage.setScene(new Scene(helpView));
        helpStage.setX(startView.getScene().getWindow().getX() + 200);
        helpStage.setY(startView.getScene().getWindow().getY() + 200);
        helpStage.showAndWait();
    }
    //    private void updateView() { } no model data is used here
    public void addWindowEventHandlers() {
        startView.getScene().getWindow().setOnCloseRequest(event -> closeApplication(event));
    }

    private void closeApplication(WindowEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("You're about to close the application!");
        alert.setContentText("Are you sure you want to leave?");
        alert.setTitle("Leaving?");
        alert.getButtonTypes().clear();
        ButtonType no = new ButtonType("no");
        ButtonType yes = new ButtonType("yes");
        alert.getButtonTypes().addAll(no, yes);
        alert.showAndWait();
        if (!(alert.getResult().equals(yes))) {
            event.consume();
        }
    }
}
