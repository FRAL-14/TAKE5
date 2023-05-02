package be.kdg.integration2.take5.ui.game_over;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class GameOverView extends BorderPane {
    private Label congrLbl;
    private Button tryAgain;
    private Button exitGame;

    public GameOverView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        congrLbl = new Label();
        tryAgain = new Button("Play again!");
        exitGame = new Button("Exit");
    }

    private void layoutNodes() {
        this.setStyle("-fx-background-color: #EFD0CA"); //or #F9B3D1

        HBox box = new HBox(500, tryAgain, exitGame);
        setBottom(box);
        setAlignment(box, Pos.BOTTOM_CENTER);
        setMargin(box, new Insets(10, 10, 50, 150));

    }

    public Label getCongrLbl() {
        return congrLbl;
    }

    public void setCongrLbl(Label congrLbl) {
        this.congrLbl = congrLbl;
    }

    public Button getTryAgain() {
        return tryAgain;
    }

    public void setTryAgain(Button tryAgain) {
        this.tryAgain = tryAgain;
    }

    public Button getExitGame() {
        return exitGame;
    }

    public void setExitGame(Button exitGame) {
        this.exitGame = exitGame;
    }
}

