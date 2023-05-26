package be.kdg.integration2.take5.ui.game_over;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

/**
 * This class is responsible for displaying the GameOverView.
 * It is the link between the GameOverView and the model.
 */
public class GameOverView extends BorderPane {
    private Label congrLbl;
    private Button tryAgain;
    private Button gameStatsButton;
    private Button exitGame;

    public GameOverView() {
        initialiseNodes();
        layoutNodes();
    }

    /**
     * This method initializes the nodes in the view.
     */
    private void initialiseNodes() {
        congrLbl = new Label();
        congrLbl.setStyle("-fx-font-size: 36px; -fx-text-fill: #000000 ; -fx-font-weight: bold;"); // Customize label styling
        tryAgain = new Button("Play again!");
        gameStatsButton = new Button("Game Statistics");
        exitGame = new Button("Exit");
    }

    /**
     * This method lays out the nodes in the view.
     */
    private void layoutNodes() {
        this.setStyle("-fx-background-color: #EFD0CA"); // or #F9B3D1

        HBox buttonBox = new HBox(10, tryAgain, gameStatsButton, exitGame);
        buttonBox.setAlignment(Pos.CENTER);
        setBottom(buttonBox);
        setMargin(buttonBox, new Insets(10, 10, 50, 100));

        setCenter(congrLbl);
        setAlignment(congrLbl, Pos.CENTER);
        setMargin(congrLbl, new Insets(10, 20, 20 , 100));
    }

    public Label getCongrLbl() {
        return congrLbl;
    }

    public void setCongrLbl(String type) {
        if (type.equals("human")){
            congrLbl.setText("Congratulations! You won.");
        } else if (type.equals("ai")){
            congrLbl.setText("Unlucky! You lost.");
        } else if (type.equals("quit")) {
            congrLbl.setText("Are you leaving for real for real?");
        }
    }

    public Button getTryAgain() {
        return tryAgain;
    }

    public void setTryAgain(Button tryAgain) {
        this.tryAgain = tryAgain;
    }

    public Button getGameStatsButton() {
        return gameStatsButton;
    }

    public void setGameStatsButton(Button gameStatsButton) {
        this.gameStatsButton = gameStatsButton;
    }

    public Button getExitGame() {
        return exitGame;
    }

    public void setExitGame(Button exitGame) {
        this.exitGame = exitGame;
    }
}

