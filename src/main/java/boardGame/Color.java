package boardGame;
// Keeps track of colors so each player gets a unique color

public final class Color {
	private static int colorIndex;
	private static String[] colors = {"Red", "Blue", "Yellow", "Green", "Pink", 
			"Orange", "Cyan", "White", "Brown", "Black"};
	
	private Color() {}
	
	public static String getNextColor() throws ArrayIndexOutOfBoundsException {
		return colors[colorIndex++];
	}
}
