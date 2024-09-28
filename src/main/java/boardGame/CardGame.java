package boardGame;
// simulates a card game (or a board game that uses a deck of cards)

public class CardGame extends BoardGame {
	private CardDeck deck;
	
	public CardGame(int numberOfPlayers) {
		super();
		players = new CardPlayer[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; i++) {
			players[i] = new Player(Color.getNextColor());
		}
		
		deck = new CardDeck();
	}
	
	public void currentPlayerDrawCard() {
		((CardPlayer) players[turnNumber]).getCard(drawCard());
	}
	
	public void dealCards(int number) {
		for (int i = 0; i < number; i++) {
			for (int j = 0; j < players.length; j++) {
				((CardPlayer) players[j]).getCard(drawCard());
			}
		}
	}
	
	public Card drawCard() {
		Card c;
		try {
			c = deck.draw();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			deck.reshuffle();
			c = deck.draw();
		}
		return c;
	}
}
