package be.kdg.integration2.take5.model;

import javafx.scene.control.Cell;

import java.util.*;

public class Board {
    LinkedList<Card> closestRow = new LinkedList<>();
    private LinkedList<Card>[] rows;
    private LinkedList<Card> row1;
    private LinkedList<Card> row2;
    private LinkedList<Card> row3;
    private LinkedList<Card> row4;

    public Board() {
        // create an array of linked lists for the rows
//        rows = new LinkedList[4];
//        for (int i = 0; i < rows.length; i++) {
//            rows[i] = new LinkedList<>();
//        }
        row1 = new LinkedList<Card>();
        row2 = new LinkedList<Card>();
        row3 = new LinkedList<Card>();
        row4 = new LinkedList<Card>();
    }

    public LinkedList<Card> getRow(int index) {
        return rows[index];
    }
    Card[] firstFiveCards = new Card[5];
    LinkedList<Card> lastFilledCells = new LinkedList<>();
    boolean isClicked;


    public void checkLists(Player player) {
        boolean listFilled = false;
        LinkedList<Card> removeCards = new LinkedList<>();
        if (row1.size() == 6) {
            for (int i = 0; i < 5; i++) {
                removeCards.add(row1.getFirst());
                row1.remove(row1.getFirst());
                listFilled = true;
            }
        }
        if (row2.size() == 6) {
            for (int i = 0; i < 5; i++) {
                removeCards.add(row2.getFirst());
                row2.remove(row2.getFirst());
                listFilled = true;
            }
        }
        if (row3.size() == 6) {
            for (int i = 0; i < 5; i++) {
                removeCards.add(row3.getFirst());
                row3.remove(row3.getFirst());
                listFilled = true;
            }
        }
        if (row4.size() == 6) {
            for (int i = 0; i < 5; i++) {
                removeCards.add(row4.getFirst());
                row4.remove(row4.getFirst());
                listFilled = true;
            }
        }

        if (listFilled) {
            firstFiveCards = new Card[5];
            for (int i = 0; i < 5; i++) {
                firstFiveCards[i] = removeCards.get(i);
            }
            if (player instanceof Human) {
                for (int i = 0; i < 5; i++) {
                    player.humanBullTotal = player.humanBullTotal + Card.getPointValue(firstFiveCards[i]);
                }
                System.out.println(player.humanBullTotal);
            } else if (player instanceof AI) {
                for (int i = 0; i < 5; i++) {
                    player.aiBullTotal = player.aiBullTotal + Card.getPointValue(firstFiveCards[i]);
                }
                System.out.println(player.aiBullTotal);
            }
        }
    }

    public LinkedList<Card> getLastFilledCells() {
        lastFilledCells = new LinkedList<>();
        for (LinkedList<Card> row : rows) {
            if (row.size() == 6) {
                lastFilledCells.add(row.getLast());
            }
        }
        return lastFilledCells;
    }

    //was causing NullPointerExceptions so is replaced by codeblock above
//    public LinkedList<Card> getLastFilledCells() {
//        if (row1.size() == 6 || row2.size() == 6 || row3.size() == 6 || row4.size() == 6) {
//            lastFilledCells = new LinkedList<>();
//            lastFilledCells.add(0, row1.getLast());
//            lastFilledCells.add(1, row2.getLast());
//            lastFilledCells.add(2, row3.getLast());
//            lastFilledCells.add(3, row4.getLast());
//        }
//        if (lastFilledCells.isEmpty()) {
//            return new LinkedList<>();
//        }
//        return lastFilledCells;
//    }

    //TODO: not sure but maybe this can be written in Card instead of Board?
    public LinkedList<Card> findClosestNumber(int playedCard) {
        Scanner scan = new Scanner(System.in);
        int closestNumber = Integer.MAX_VALUE;
        int smallestDifference = Integer.MAX_VALUE;
        boolean isTooLow = true;
        LinkedList<Card> closestRow = null;

//        return closestRow;
        if (row1.getLast().getValue() < playedCard) {
            int difference = playedCard - row1.getLast().getValue();
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = row1.getLast().getValue();
                closestRow = row1;
                isTooLow = false;
            }
        }

        if (row2.getLast().getValue() < playedCard) {
            int difference = playedCard - row2.getLast().getValue();
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = row2.getLast().getValue();
                closestRow = row2;
                isTooLow = false;
            }
        }

        if (row3.getLast().getValue() < playedCard) {
            int difference = playedCard - row3.getLast().getValue();
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = row3.getLast().getValue();
                closestRow = row3;
                isTooLow = false;
            }
        }

        if (row4.getLast().getValue() < playedCard) {
            int difference = playedCard - row4.getLast().getValue();
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = row4.getLast().getValue();
                closestRow = row4;
                isTooLow = false;
            }
        }

        if (!isTooLow) {
            System.out.print("The card is too low to be played, choose a row to take away: ");
            int rowChosen = scan.nextInt();
            System.out.println();
        }

        return closestRow;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

}