package be.kdg.integration2.take5;

import be.kdg.integration2.take5.model.GameSession;
import java.util.Scanner;

public class ConsoleController {

    GameSession ctrl = new GameSession();

    Scanner kbd = new Scanner(System.in);

    public void startGame() {
        System.out.println("To play enter: \\'p\\'");
        String input = kbd.nextLine();
        boolean play;
        if (input.toLowerCase().equals("p")){
            play = true;
        } else {
            System.out.println("Invalid input");
            System.out.println("To play, enter \"p\":");
        }

        while (play = true) {
            boolean inGame = true;
            ctrl.makeBoard();
            while (inGame = true) {
                ctrl.startGame();
                //ask GameSession to give you the info
                if (human.humanBullTotal == 66 || ai.aiBullTotal == 66){
                    inGame = false;
                }
            }
        }
    }
}