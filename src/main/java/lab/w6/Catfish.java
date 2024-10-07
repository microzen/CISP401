package lab.w6;

public class Catfish extends Fish {
	
	protected boolean livesInSwamps;
	
	public Catfish(double weight) {
		super(10, weight);
		freshwater = true;
		livesInSwamps = true;
	}
	
	public void setEnvironment(boolean swamps) {
		livesInSwamps = swamps;
	}
	
	/*
	 * Create two new animal classes that fit into this inheritance structure somewhere
	 * Each of the classes should add at least one new variable and the getters/setters for that variable
	 * If the animal makes a different type of noise than normal, make sure you @Override the makeNoise
	 *   method
	 * Make sure the constructors work properly and make sense for the animal 
	 */
}
