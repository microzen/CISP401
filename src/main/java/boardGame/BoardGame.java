package boardGame;
// simulates a board game

public class BoardGame {
	private final int NUMBER_OF_DICE = 2;
	private final int DICE_SIDES = 6;
	protected Player[] players;
	private Die[] dice;
	protected int turnNumber;
	
	protected BoardGame() {
		dice = new Die[NUMBER_OF_DICE];
		for (int i = 0; i < NUMBER_OF_DICE; i++) {
			dice[i] = new Die(DICE_SIDES);
		}
		turnNumber = 0;
	}
	
	public BoardGame(int numberOfPlayers) {
		players = new Player[numberOfPlayers];
		for (int i = 0; i < numberOfPlayers; i++) {
			players[i] = new Player(Color.getNextColor());
		}
		
		dice = new Die[NUMBER_OF_DICE];
		for (int i = 0; i < NUMBER_OF_DICE; i++) {
			dice[i] = new Die(DICE_SIDES);
		}
		
		assignTurns();
		turnNumber = 0;
	}
	
	// turns are assigned based on who rolled highest using a normal dice roll
	protected void assignTurns() {
		int[] rolls = new int[players.length];
		for (int i = 0; i < players.length; i++) {
			rolls[i] = rollDice();
		}
		
		int max, maxIndex, tempRoll;
		Player tempPlayer;
		for (int i = 0; i < players.length - 1; i++) {
			max = rolls[i];
			maxIndex = i;
			for (int j = i + 1; j < players.length; j++) {
				if (rolls[j] > max) {
					max = rolls[j];
					maxIndex = j;
				}
			}
			tempRoll = rolls[i];
			tempPlayer = players[i];
			rolls[i] = rolls[maxIndex];
			players[i] = players[maxIndex];
			rolls[maxIndex] = tempRoll;
			players[maxIndex] = tempPlayer;
		}
	}
	
	public int rollDice() {
		int rollSum = 0;
		for (int i = 0; i < NUMBER_OF_DICE; i++) {
			rollSum += dice[i].roll();
		}
		return rollSum;
	}
	
	public void nextTurn() {
		System.out.println("Next turn: " + players[turnNumber]);
		turnNumber = ++turnNumber % players.length;
	}
}
