package boardGame;
// A Die for the board game

import java.util.Random;

public class Die {
	private int sides;
	private Random rand;
	
	public Die(int sides) {
		this.sides = sides;
		rand = new Random();
	}
	
	public int roll() {
		return rand.nextInt(sides) + 1;
	}
	
	public int checkSides() {
		return sides;
	}
}
