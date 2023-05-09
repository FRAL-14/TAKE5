package be.kdg.integration2.take5.ui.user_input;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * This class is responsible for the view of the user input screen.
 * It extends BorderPane and contains a Label, TextField and two Buttons.
 */
public class InputView extends BorderPane {

    private Label headerLbl = new Label();
    private TextField inputField = new TextField();
    private Button returnBtn = new Button();
    private Button submitBtn = new Button();

    public InputView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        headerLbl = new Label("Enter your name!");
        inputField = new TextField();
        returnBtn = new Button("Return");
        submitBtn = new Button("Submit");
    }

    private void layoutNodes() {
        setTop(headerLbl);
        setAlignment(headerLbl, Pos.TOP_CENTER);
        setMargin(headerLbl, new Insets(100, 10, 10, 10));

        setCenter(inputField);
        setAlignment(inputField, Pos.CENTER);
        setMargin(inputField, new Insets(10, 10, 10, 10));

        HBox leftBox = new HBox(10, returnBtn);
        leftBox.setAlignment(Pos.CENTER_LEFT);
        HBox rightBox = new HBox(10, submitBtn);
        rightBox.setAlignment(Pos.CENTER_RIGHT);

        HBox bottom = new HBox(leftBox, rightBox);
        bottom.setSpacing(400); // set spacing between buttons
        bottom.setAlignment(Pos.BOTTOM_CENTER);
        setBottom(bottom);
        setMargin(bottom, new Insets(10, 10, 150, 10));




        this.setStyle("-fx-background-color: linear-gradient(to bottom, #ffdcb6, #E06469);");
        headerLbl.setFont(Font.font("Georgia", FontWeight.BOLD, 80));
        inputField.setMaxWidth(200);
        inputField.setFont(new Font(20));
        returnBtn.setStyle("-fx-background-color: #C9CCD5;-fx-background-radius: 15px;");
        returnBtn.setFont(new Font(30));
        submitBtn.setStyle("-fx-background-color: #A4D0A4;-fx-background-radius: 15px;");
        submitBtn.setFont(new Font(30));

        returnBtn.setOnMouseEntered(e -> {
            returnBtn.setStyle("-fx-background-color: #a8acb4; -fx-cursor: hand; -fx-font-size: 30px;-fx-background-radius: 15px;");
        });
        returnBtn.setOnMouseExited(e -> {
            returnBtn.setStyle("-fx-background-color: #C9CCD5; -fx-font-size: 30px;-fx-background-radius: 15px;");
        });

        submitBtn.setOnMouseEntered(e -> {
            submitBtn.setStyle("-fx-background-color: #7AA874; -fx-cursor: hand; -fx-font-size: 30px;-fx-background-radius: 15px;;");
        });
        submitBtn.setOnMouseExited(e -> {
            submitBtn.setStyle("-fx-background-color: #A4D0A4; -fx-font-size: 30px;-fx-background-radius: 15px;");
        });
    }

    public TextField getInputField() {
        return inputField;
    }

    public void setInputField(TextField inputField) {
        this.inputField = inputField;
    }

    public Button getReturnBtn() {
        return returnBtn;
    }

    public void setReturnBtn(Button returnBtn) {
        this.returnBtn = returnBtn;
    }

    public Button getSubmitBtn() {
        return submitBtn;
    }

    public void setSubmitBtn(Button submitBtn) {
        this.submitBtn = submitBtn;
    }
}
