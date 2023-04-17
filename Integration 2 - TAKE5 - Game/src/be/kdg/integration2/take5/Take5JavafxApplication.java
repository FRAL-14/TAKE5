package be.kdg.integration2.take5;

import be.kdg.integration2.take5.model.GameSession;
import be.kdg.integration2.take5.ui.MainPresenter;
import be.kdg.integration2.take5.ui.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

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
        primaryStage.setScene(scene);
        primaryStage.setTitle("Take 5");
        primaryStage.setResizable(false);
        primaryStage.setMinWidth(600);
        primaryStage.setFullScreen(true);
        startPresenter.addWindowEventHandlers();
        primaryStage.show();
    }
}
