package be.kdg.integration2.take5;

import be.kdg.integration2.take5.model.GameSession;
import be.kdg.integration2.take5.ui.MainPresenter;
import be.kdg.integration2.take5.ui.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
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
        Scene scene = new Scene(startView);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Take 5");
        primaryStage.setWidth(500);
        primaryStage.setHeight(500);
        startPresenter.addWindowEventHandlers();
        primaryStage.show();
    }
}
