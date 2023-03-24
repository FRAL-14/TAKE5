package be.kdg.integration2.take5;

import be.kdg.integration2.take5.model.*;

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
//                ask GameSession to give you the info
                if (Player.getHumanBullTotal() == 66 || Player.getAiBullTotal() == 66){
                    inGame = false;
                    break;
                }

            }
            System.out.println("To play again enter a, to exit enter e: ");
            String playAgain = kbd.nextLine();
            if (playAgain.equals("a")){
                play = true;
            } else if (playAgain.equals("e")){
                break;
            } else {
                System.out.println("Invalid input, exiting...");
            }
        }
    }
}