package boardGame;
// A single playing card

public class Card {
	private int number;
	private String suit;
	
	public Card(int number, String suit) {
		this.number = number;
		this.suit = suit;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getSuit() {
		return suit;
	}
	
	@Override
	public String toString() {
		String cardName;
		switch (number) {
		case 1:
			cardName = "Ace";
			break;
		case 11:
			cardName = "Jack";
			break;
		case 12:
			cardName = "Queen";
			break;
		case 13:
			cardName = "King";
			break;
		default: cardName = number + "";
		}
		cardName += " of " + suit;
		return cardName;
	}
}
