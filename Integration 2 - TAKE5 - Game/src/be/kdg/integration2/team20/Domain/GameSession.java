package be.kdg.integration2.team20.Domain;

import java.util.Scanner;

public class GameSession {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AI ai = new AI();
        Human human = new Human();
//        Player player = new Player();   //how can i add Player player and as parameters Human human and AI ai?
        Deck deck = new Deck();
        Board board = new Board();


        System.out.print("Enter your name: ");
        human.setName(scanner.nextLine());

        System.out.println("not shuffled deck --> " + deck);
        deck.shuffle();
        System.out.println("shuffled deck --> " + deck);
        board.fillTable();

        human.getHand(/*deck*/);
//        human.toString(); maybe write this instead of this below
        System.out.println("User hand " + human.getHand(/*deck*/));
        System.out.println(deck);

        ai.getHand(/*deck*/);
        System.out.println("AI hand " + ai.getHand(/*deck*/));
        System.out.println(deck);
    }
}
