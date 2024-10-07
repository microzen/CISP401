package lab.w6;

public class Bird extends Animal {
	
	public Bird(int lifespan, double weight) {
		super("chirp", lifespan, weight);
	}
	
	@Override
	public void makeNoise() {
		System.out.println("The bird says: " + noise + "!");
	}
}
