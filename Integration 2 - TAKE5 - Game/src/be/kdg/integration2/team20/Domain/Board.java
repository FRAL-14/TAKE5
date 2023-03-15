package be.kdg.integration2.team20.Domain;

import java.util.*;

public class Board {
    HashMap<String, Integer> board;
    Card[] firstFiveCards;
    String[] lastFilledCells;
    int playedCard;
    int col;
    int row;
    int nextCol;
    String playedKey;

    public HashMap<String, Integer> createBoard() {
        board = new HashMap<>();
        for (int row = 1; row <= 4; row++) {
            for (int col = 1; col <= 6; col++) {
                String key = "row" + row + "col" + col;
                board.put(key, null);
            }
        }
        return board;
    }

    public void startRound(Deck deck) {
        board.put("row1col1", deck.boardHand[0].getValue());
        board.put("row2col1", deck.boardHand[1].getValue());
        board.put("row3col1", deck.boardHand[2].getValue());
        board.put("row4col1", deck.boardHand[3].getValue());
    }


    public void checkBoard() {
        for (int row = 1; row <= 4; row++) {
            boolean rowFilled = true;
            ArrayList<Card> rowCards = new ArrayList<Card>();
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
        return lastFilledCells;
    }

    public String findClosestNumber() {
        int closestNumber = Integer.MAX_VALUE;
        int smallestDifference = Integer.MAX_VALUE;
        String closestKey = new String();

        if (board.get(lastFilledCells[0]) < playedCard) {
            int difference = playedCard - board.get(lastFilledCells[0]);
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = board.get(lastFilledCells[0]);
                closestKey = lastFilledCells[0];
            }
        }

        if (board.get(lastFilledCells[1]) < playedCard) {
            int difference = playedCard - board.get(lastFilledCells[1]);
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = board.get(lastFilledCells[1]);
                closestKey = lastFilledCells[1];
            }
        }

        if (board.get(lastFilledCells[2]) < playedCard) {
            int difference = playedCard - board.get(lastFilledCells[2]);
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = board.get(lastFilledCells[2]);
                closestKey = lastFilledCells[2];
            }
        }

        if (board.get(lastFilledCells[3]) < playedCard) {
            int difference = playedCard - board.get(lastFilledCells[3]);
            if (difference < smallestDifference) {
                smallestDifference = difference;
                closestNumber = board.get(lastFilledCells[3]);
                closestKey = lastFilledCells[3];
            }
        }

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

    public Card playCard(Deck deck) {
        Card[] playHand = deck.humanHand;
//        if (player.equals("human")) {
//            playHand = deck.humanHand;
//        } else if (player.equals("ai")){
//            playHand = deck.aiHand;
//        }
        // Print out the current hand
        System.out.println("Your current hand: " + Arrays.toString(playHand));

        // Prompt the user to enter the index of the card they want to play
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the card you want to play starting from 0 to 9: ");
        int index = scanner.nextInt();

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

        // Print success message and return the card object
        System.out.printf("Card played successfully! You played card number " + playedCard + " in cell " + playedKey);

        getKeyInfo();
        playKey();
        playedKey = "row" + row + "col" + nextCol;
        board.put(playedKey, playedCard);
        return playHand[index];

    }

    public void eureka(Deck deck){
        System.out.println(Arrays.toString(deck.boardHand));
        System.out.println(findClosestNumber());
        System.out.println(playedKey);
        System.out.println(board.get(playedKey));
    }

    }