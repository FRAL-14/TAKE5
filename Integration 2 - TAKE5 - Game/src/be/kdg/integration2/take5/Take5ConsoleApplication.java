package be.kdg.integration2.take5;

import be.kdg.integration2.take5.model.Board;
import be.kdg.integration2.take5.model.GameSession;

public class Take5ConsoleApplication {
    public static void main(String[] args) {
        ConsoleController gameSession = new ConsoleController();
        gameSession.startGame();

    }
}