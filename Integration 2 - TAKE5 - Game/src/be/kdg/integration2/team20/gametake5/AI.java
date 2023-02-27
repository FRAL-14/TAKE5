package be.kdg.integration2.team20.gametake5;

import java.util.ArrayList;

public class AI extends Player{

    public AI(String name, ArrayList<Integer> hand) {
        super(name, hand);
    }

    public AI() {

    }

    @Override
    public int chooseCard() {
        return 0; //random card gets chosen
    }
}