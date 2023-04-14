package be.kdg.integration2.take5.ui;

import be.kdg.integration2.take5.model.GameSession;
import be.kdg.integration2.take5.ui.game.GamePresenter;
import be.kdg.integration2.take5.ui.game.GameView;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

public class MainPresenter {
    private GameSession model;
    private MainView startView;

    public MainPresenter(GameSession model, MainView startView) {
        this.model = model;
        this.startView = startView;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        this.startView.getPlay().setOnAction(e -> setGameView());
        //if button 'STATS' is clicked ( TODO DBView and DBPresenter are empty right now so cannot implement)
//        helpView.setOnMouseClicked(e -> setHelpView());
    }


    private void setGameView() {
        GameView gameView = new GameView();
        new GamePresenter(model, gameView);
        startView.getScene().setRoot(gameView);
        gameView.getScene().getWindow().sizeToScene();

    }

    //LEAVE THIS, gonna be used when the help button is clicked on the starting screen
//    private void setHelpView() {
//        HelpView helpView = new HelpView();
//        HelpPresenter presenter = new HelpPresenter(model, helpView);
//        Stage helpStage = new Stage();
//        helpStage.initOwner(gameView.getScene().getWindow());
//        helpStage.initModality(Modality.APPLICATION_MODAL);
//        helpStage.setScene(new Scene(helpView));
//        helpStage.setX(gameView.getScene().getWindow().getX() + 150);
//        helpStage.setY(gameView.getScene().getWindow().getY() + 20);
//        helpStage.showAndWait();
//    }

    private void updateView() {

    }

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
