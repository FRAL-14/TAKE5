package be.kdg.integration2.take5.model;

import java.util.*;

public class Board {
    HashMap<String, Integer> board; //refactor to cell/stack, u cant have a board inside a board
    Card[][] cardsOnBoard;
    Card[] firstFiveCards;
    String[] lastFilledCells;
    int playedCard;
    int col;
    int row;
    int nextCol;
    String playedKey;
    int[] cardValues = new int[4];

//    public HashMap<String, Integer> createBoard() {
//        board = new HashMap<>();
//        for (int row = 1; row <= 4; row++) {
//            for (int col = 1; col <= 6; col++) {
//                String key = "row" + row + "col" + col;
//                board.put(key, null);
//
//            }
//        }
//        return board;
//    }

    //TODO: startRound() doesn't belong in the Board class
    public void initializeRow(Deck deck) {
        board.put("row1col1", deck.boardHand[0].getValue());
        board.put("row2col1", deck.boardHand[1].getValue());
        board.put("row3col1", deck.boardHand[2].getValue());
        board.put("row4col1", deck.boardHand[3].getValue());
    }


    public void checkBoard(Player player) {
        for (int row = 1; row <= 4; row++) {
            boolean rowFilled = true;
            ArrayList<Card> rowCards = new ArrayList<>();
            for (int col = 1; col <= 6; col++) {
                String key = "row" + row + "col" + col;
                if (!board.containsKey(key) || board.get(key) == null) {
                    rowFilled = false;
                    break;
                } else {
                    rowCards.add(Card.withValue(board.get(key)));
                }
            }
            if (rowFilled) {
                firstFiveCards = new Card[5];
                for (int i = 0; i < 5; i++) {
                    firstFiveCards[i] = rowCards.get(i);
                }
                Card sixthCard = rowCards.get(5);
                for (int i = 0; i < 5; i++) {
                    String key = "row" + row + "col" + (i + 1);
                    board.put(key, null);
                }
                board.put("row" + row + "col1", sixthCard.getValue());
                for (int col = 2; col <= 6; col++) {
                    String key = "row" + row + "col" + col;
                    board.put(key, null);
                }
                if (player instanceof Human){
                    for (int i = 0; i < 5; i++){
                        player.humanBullTotal = player.humanBullTotal + Card.getPointValue(firstFiveCards[i]);
                    }
                    System.out.println(player.humanBullTotal);
                } else if (player instanceof AI){
                    for (int i = 0; i < 5; i++){
                        player.aiBullTotal = player.aiBullTotal + Card.getPointValue(firstFiveCards[i]);
                    }
                    System.out.println(player.aiBullTotal);
                }
            }
        }
    }

    public String[] getLastFilledCells() {
        lastFilledCells = new String[4];
        for (int row = 0; row < 4; row++) {
            int col = 6;
            while (col > 0) {
                String key = "row" + (row+1) + "col" + col;
                if (board.containsKey(key) && board.get(key) != null) {
                    lastFilledCells[row] = key;
                    break;
                }
                col--;
            }
        }
        for (int i = 0; i < 4; i++) {
            cardValues[i] = board.get(lastFilledCells[i]);
        }
        return lastFilledCells;
    }

    //TODO: not sure but maybe this can be written in Card instead of Board?
    public String findClosestNumber() {
        Scanner scan = new Scanner(System.in);
        int closestNumber = Integer.MAX_VALUE;
        int smallestDifference = Integer.MAX_VALUE;
        String closestKey = new String();
        boolean isTooLow = true;

        if (board.get(lastFilledCells[0]) < playedCard) {
                int difference = playedCard - board.get(lastFilledCells[0]);
                if (difference < smallestDifference) {
                    smallestDifference = difference;
                    closestNumber = board.get(lastFilledCells[0]);
                    closestKey = lastFilledCells[0];
                    isTooLow = false;
                }
        }

        if (board.get(lastFilledCells[1]) < playedCard) {
            int difference = playedCard - board.get(lastFilledCells[1]);
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = board.get(lastFilledCells[1]);
                closestKey = lastFilledCells[1];
                isTooLow = false;
            }
        }

        if (board.get(lastFilledCells[2]) < playedCard) {
            int difference = playedCard - board.get(lastFilledCells[2]);
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = board.get(lastFilledCells[2]);
                closestKey = lastFilledCells[2];
                isTooLow = false;
            }
        }

        if (board.get(lastFilledCells[3]) < playedCard) {
            int difference = playedCard - board.get(lastFilledCells[3]);
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = board.get(lastFilledCells[3]);
                closestKey = lastFilledCells[3];
                isTooLow = false;
            }
        }

//        if (isTooLow = false){
//            System.out.print("The card is too low to be played, choose a row to take away: ");
//            int rowChosen = scan.nextInt();
//            System.out.println();
//        }

        return closestKey;
    }

        public void test () {
        System.out.println(Arrays.toString(lastFilledCells));
        System.out.println(board.get(lastFilledCells[0]));
        }

    public void getKeyInfo(){
        String key = findClosestNumber();
        row = Integer.parseInt(key.substring(3,4)); // extracts the "2" from the key string and parses it as an integer
        col = Integer.parseInt(key.substring(7)); // extracts the "4" from the key string and parses it as an integer
    }

    public void playKey(){
        nextCol = col + 1;
    }

    //TODO: this should be written in the Player class, and then you can call it in the Board class (!!)
    public Card playCard(Deck deck, Player player) {
        Card[] playHand;// = deck.humanHand;
        if (player instanceof Human) {
            playHand = deck.humanHand;
        } else if (player instanceof AI){
            playHand = deck.aiHand;
        } else {
            throw new IllegalArgumentException("Invalid player type");
        }
        // Print out the current hand
        System.out.println("Your current hand: " + Arrays.toString(playHand));

        // Prompt the user to enter the index of the card they want to play
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the card you want to play starting from 1 to 10: ");
        int index0 = scanner.nextInt();
        int index = index0 - 1;


        if (index < 0 || index >= playHand.length || playHand[index] == null) {
            // Index is out of bounds or the hand array is empty at the given index
            System.out.println("Failed to play card. Invalid index or hand is empty.");
            return null;
        }

        // Get the card number at the given index
        playedCard = playHand[index].getValue();

        // Remove the card from the hand array
        for (int i = index; i < playHand.length - 1; i++) {
            playHand[i] = playHand[i + 1];
        }
        playHand[playHand.length - 1] = null;

        getKeyInfo();
        playKey();
        playedKey = "row" + row + "col" + nextCol;
        board.put(playedKey, playedCard);

        // Print success message and return the card object
        System.out.println("Card played successfully! You played card number " + playedCard + " in cell " + playedKey);
        return playHand[index];

    }
}