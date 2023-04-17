package be.kdg.integration2.take5.model;

import javafx.scene.control.Cell;

import java.util.*;

public class Board {
    LinkedList<Card> closestRow = new LinkedList<>();
    private LinkedList<Card>[] rows;

    public Board() {
        // create an array of linked lists for the rows
        rows = new LinkedList[4];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new LinkedList<>();
        }
    }

    public LinkedList<Card> getRow(int index) {
        return rows[index];
    }
    Card[] firstFiveCards = new Card[5];
    LinkedList<Card> lastFilledCells = new LinkedList<>();
    int playedCard;
    boolean isClicked;


//    public void checkBoard(Player player) {
//        for (int row = 1; row <= 4; row++) {
//            boolean rowFilled = true;
//            ArrayList<Card> rowCards = new ArrayList<>();
//            for (int col = 1; col <= 6; col++) {
//                String key = "row" + row + "col" + col;
//                if (!board.containsKey(key) || board.get(key) == null) {
//                    rowFilled = false;
//                    break;
//                } else {
//                    rowCards.add(Card.withValue(board.get(key)));
//                }
//            }
//            if (rowFilled) {
//                firstFiveCards = new Card[5];
//                for (int i = 0; i < 5; i++) {
//                    firstFiveCards[i] = rowCards.get(i);
//                }
//                Card sixthCard = rowCards.get(5);
//                for (int i = 0; i < 5; i++) {
//                    String key = "row" + row + "col" + (i + 1);
//                    board.put(key, null);
//                }
//                board.put("row" + row + "col1", sixthCard.getValue());
//                for (int col = 2; col <= 6; col++) {
//                    String key = "row" + row + "col" + col;
//                    board.put(key, null);
//                }
//                if (player instanceof Human){
//                    for (int i = 0; i < 5; i++){
//                        player.humanBullTotal = player.humanBullTotal + Card.getPointValue(firstFiveCards[i]);
//                    }
//                    System.out.println(player.humanBullTotal);
//                } else if (player instanceof AI){
//                    for (int i = 0; i < 5; i++){
//                        player.aiBullTotal = player.aiBullTotal + Card.getPointValue(firstFiveCards[i]);
//                    }
//                    System.out.println(player.aiBullTotal);
//                }
//            }
//        }
//    }

    public void checkLists(Player player) {
        boolean listFilled = false;
        LinkedList<Card> removeCards = new LinkedList<>();
        for (int i = 0; i < rows.length; i++) {
            if (rows[i].size() == 6) {
                for (int j = 0; j < 6; j++) {
                    removeCards.add(rows[i].get(j));
                    listFilled = true;
                }
                for (int j = 0; j < 5; j++) {
                    rows[i].remove(j);
                }
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


//    public String[] getLastFilledCellsX() {
//        lastFilledCellsX = new String[4];
//        for (int row = 0; row < 4; row++) {
//            int col = 6;
//            while (col > 0) {
//                String key = "row" + (row+1) + "col" + col;
//                if (board.containsKey(key) && board.get(key) != null) {
//                    lastFilledCells[Xrow] = key;
//                    break;
//                }
//                col--;
//            }
//        }
//        for (int i = 0; i < 4; i++) {
//            cardValues[i] = board.get(lastFilledCells[i]);
//        }
//        return lastFilledCellsX;
//    }

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
//    public LinkedList<Card> findClosestNumber(LinkedList<Card>[] rows) {
//        Scanner scan = new Scanner(System.in);
//        int closestNumber = Integer.MAX_VALUE;
//        int smallestDifference = Integer.MAX_VALUE;
//        boolean isTooLow = true;
//        LinkedList<Card> closestRow = null;
//
//        for (LinkedList<Card> row : rows) {
//            if (row.getLast().getValue() < playedCard) {
//                int difference = playedCard - row.getLast().getValue();
//                if (difference < smallestDifference) {
//                    smallestDifference = difference;
//                    closestNumber = row.getLast().getValue();
//                    closestRow = row;
//                    isTooLow = false;
//                }
//            }
//        }
//
//        if (isTooLow == true) {
//            System.out.print("The card is too low to be played, choose a row to take away: ");
//            int rowChosen = scan.nextInt();
//            System.out.println();
//            closestRow = rows[rowChosen - 1];
//        }
//
//        return closestRow;
////        if (row1.getLast().getValue() < playedCard) {
////            int difference = playedCard - row1.getLast().getValue();
////            if (difference < smallestDifference) {
////                smallestDifference = difference;
////                closestNumber = row1.getLast().getValue();
////                closestRow = row1;
////                isTooLow = false;
////            }
////        }
////
////        if (row2.getLast().getValue() < playedCard) {
////            int difference = playedCard - row2.getLast().getValue();
////            if (difference < smallestDifference) {
////                smallestDifference = difference;
////                closestNumber = row2.getLast().getValue();
////                closestRow = row2;
////                isTooLow = false;
////            }
////        }
////
////        if (row3.getLast().getValue() < playedCard) {
////            int difference = playedCard - row3.getLast().getValue();
////            if (difference < smallestDifference) {
////                smallestDifference = difference;
////                closestNumber = row3.getLast().getValue();
////                closestRow = row3;
////                isTooLow = false;
////            }
////        }
////
////        if (row4.getLast().getValue() < playedCard) {
////            int difference = playedCard - row4.getLast().getValue();
////            if (difference < smallestDifference) {
////                smallestDifference = difference;
////                closestNumber = row4.getLast().getValue();
////                closestRow = row4;
////                isTooLow = false;
////            }
////        }
////
////        if (!isTooLow) {
////            System.out.print("The card is too low to be played, choose a row to take away: ");
////            int rowChosen = scan.nextInt();
////            System.out.println();
////        }
////
////        return closestRow;
//    }

    public int getPlayedCard() {
        return playedCard;
    }

    public void setPlayedCard(int playedCard) {
        this.playedCard = playedCard;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    // TODO: this should be written in the Player class, and then you can call it in the Board class (!!)
//    public Card playCard(Deck deck, Player player) {
//        Card[] playHand;// = deck.humanHand;
//        if (player instanceof Human) {
//            playHand = deck.humanHand;
//        } else if (player instanceof AI) {
//            playHand = deck.aiHand;
//        } else {
//            throw new IllegalArgumentException("Invalid player type");
//        }
//        return playHand[0];
//
//        // TODO will be replaced by cards in javafx
////        System.out.println("Your current hand: " + Arrays.toString(playHand));
//
//        // Prompt the user to enter the index of the card they want to play
//
//        // TODO will be replaced by eventhandler in javafx
////        Scanner scanner = new Scanner(System.in);
////        System.out.print("Enter the index of the card you want to play starting from 0 to 9: ");
////        int index = scanner.nextInt();
//        //int index = index0 - 2;
//
//
////        if (index < 0 || index >= playHand.length || playHand[index] == null) {
////            // Index is out of bounds or the hand array is empty at the given index
////            System.out.println("Failed to play card. Invalid index or hand is empty.");
////            return null;
////        }
//
//        // Get the card number at the given index
////        playedCard = playHand[index].getValue();
//
////        findClosestNumber(rows);
//        // Remove the card from the hand array
////        for (int i = index; i < playHand.length - 1; i++) {
////            playHand[i] = playHand[i + 1];
////        }
////        playHand[playHand.length - 1] = null;
////
////        if (closestRow == row1) {
////            row1.addLast(playHand[index]);
////            System.out.println("Card played successfully! You played card number " + playHand[index] + " in row 1.");
////        } else if (closestRow == row2) {
////            row2.addLast(playHand[index]);
////            System.out.println("Card played successfully! You played card number " + playHand[index] + " in row 2.");
////        } else if (closestRow == row3) {
////            row3.addLast(playHand[index]);
////            System.out.println("Card played successfully! You played card number " + playHand[index] + " in row 3.");
////        } else if (closestRow == row4) {
////            row4.addLast(playHand[index]);
////            System.out.println("Card played successfully! You played card number " + playHand[index] + " in row 4.");
////        }
////
////        return playHand[index];
//    }
}