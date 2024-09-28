package boardGame;
// A standard deck of playing cards

import java.util.Random;

public class CardDeck {
    public static int TOTAL_CARDS = 52;
    private Card[] cards;
    private int nextCard;

    public CardDeck() {
        nextCard = 0;
        cards = new Card[TOTAL_CARDS];
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <= 13; j++) {
                String suit = "";
                switch (i) {
                    case 0:
                        suit = "Spades";
                        break;
                    case 1:
                        suit = "Hearts";
                        break;
                    case 2:
                        suit = "Clubs";
                        break;
                    case 3:
                        suit = "Diamonds";
                        break;
                }
                cards[j + (i * 13) - 1] = new Card(i, suit);
            }
        }
    }

    public Card draw() throws ArrayIndexOutOfBoundsException {
        return cards[nextCard++];
    }

    public void reshuffle() {
        nextCard = 0;
        Random rand = new Random();
        int swapIndex;
        Card temp;
        for (int i = 0; i < TOTAL_CARDS - 1; i++) {
//			swapIndex = rand.nextInt(i, TOTAL_CARDS);
            swapIndex = rand.nextInt(TOTAL_CARDS - i) + i;
            temp = cards[i];
            cards[i] = cards[swapIndex];
            cards[swapIndex] = temp;
        }
    }
}
