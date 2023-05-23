package be.kdg.integration2.take5.model;

import java.util.Arrays;
import java.util.Scanner;

public class Human extends Player{
    private String name;

    public Human(String name) {
        this.name = name;
    }

    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public int humanBullTotal = 0;


    public int getHumanBullTotal() {
        return humanBullTotal;
    }


    public void setHumanBullTotal(int humanBullTotal) {
        this.humanBullTotal = humanBullTotal;
    }
}