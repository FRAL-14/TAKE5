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

        HBox bottom = new HBox(50, returnBtn, submitBtn);
        setBottom(bottom);
        setAlignment(bottom, Pos.BOTTOM_CENTER);
        setMargin(bottom, new Insets(10, 10, 150, 660));



        this.setStyle("-fx-background-color: #fffced;");
        headerLbl.setFont(new Font(50));
        inputField.setMaxWidth(200);
        inputField.setFont(new Font(20));
        returnBtn.setStyle("-fx-background-color: #EFD0CA;-fx-background-radius: 15px;");
        returnBtn.setFont(new Font(20));
        submitBtn.setStyle("-fx-background-color: #DDFFC1;-fx-background-radius: 15px;");
        submitBtn.setFont(new Font(20));
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
