package boardGame;
// A player in a card game

import java.util.ArrayList;
public class CardPlayer extends Player {
	private ArrayList<Card> hand;
	
	public CardPlayer(String color) {
		super(color);
		hand = new ArrayList<Card>();
	}
	
	public void getCard(Card newCard) {
		hand.add(newCard);
	}
	
	public void loseCard(Card card) {
		hand.remove(card);
	}
	
	public void loseCard(int number, String suit) {
		for (Card card : hand) {
			if (card.getNumber() == number && card.getSuit().equals(suit)) {
				hand.remove(card);
				return;
			}
		}
	}
	
	public void printHand() {
		for (Card card : hand) {
			System.out.println(card);
		}
	}
}
