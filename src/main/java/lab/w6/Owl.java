package lab.w6;

public class Owl extends Bird {

	// show off how default constructor isn't an option
	public Owl(int lifespan, double weight) {
		super(lifespan, weight);
		noise = "Hoo";
	}
}
