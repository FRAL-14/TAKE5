package be.kdg.integration2.take5;

import be.kdg.integration2.take5.model.GameSession;
import be.kdg.integration2.take5.ui.MainPresenter;
import be.kdg.integration2.take5.ui.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
// fixed?

public class Take5JavafxApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GameSession model = new GameSession();
        MainView startView = new MainView();
        MainPresenter startPresenter = new MainPresenter(model, startView);
        HBox root = new HBox();
        root.setSpacing(10);
        Scene scene = new Scene(startView);
        scene.setFill(Color.web("#ffff80"));
        primaryStage.setScene(scene);
        primaryStage.setTitle("Take 5");
//        primaryStage.setResizable(false);
        primaryStage.setMinWidth(1500);
        primaryStage.setMinHeight(1500);
//        primaryStage.setFullScreen(true);
        startPresenter.addWindowEventHandlers();
        primaryStage.show();
    }
}
