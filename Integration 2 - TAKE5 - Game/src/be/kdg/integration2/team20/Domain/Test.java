package be.kdg.integration2.team20.Domain;

import java.util.*;


       public class Test {
           public static void mainly(String[] args) {
               CardValue[] shuffledCards = shuffle(CardValue.values());
               CardValue[] playerCards = deal(shuffledCards, 10);

               System.out.println("Player 1 cards: " + Arrays.toString(playerCards));

           }

           static Random rand = new Random();

           public static CardValue[] shuffle(CardValue[] cards) {
               List<CardValue> cardList = Arrays.asList(cards);
               for (int i = cardList.size() - 1; i > 0; i--) {
                   int j = rand.nextInt(i + 1);
                   Collections.swap(cardList, i, j);
               }
               return cardList.toArray(cards);
           }

           public static CardValue[] deal(CardValue[] cards, int numCards) {
               CardValue[] dealtCards = new CardValue[numCards];
               for (int i = 0; i < numCards; i++) {
                   dealtCards[i] = cards[i * 2];
               }
               return dealtCards;
           }
       }



