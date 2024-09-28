package boardGame;
// A player in a board game

public class Player {
	protected String color;
	protected int turnOrder;
	protected int points;
	
	public Player(String playerColor) {
		color = playerColor;
		points = 0;
	}
	
	public Player(String playerColor, int turnOrder) {
		color = playerColor;
		this.turnOrder = turnOrder;
		points = 0;
	}
	
	public void setTurnOrder(int position) {
		turnOrder = position;
	}
	
	public int getTurnOrder() {
		return turnOrder;
	}
	
	public int checkPoints() {
		return points;
	}
	
	public void gainPoints(int pointsGained) {
		points += pointsGained;
	}
	
	public void losePoints(int pointsLost) {
		points -= pointsLost;
	}
	
	public void resetPoints() {
		points = 0;
	}
	
	@Override
	public String toString() {
		return color + " player";
	}
}
