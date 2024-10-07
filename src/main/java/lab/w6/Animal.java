package lab.w6;

public class Animal {
	protected String noise;
	protected int averageLifespan;
	protected double adultWeight;
	
	public Animal() {
		noise = "";
		averageLifespan = 0;
		adultWeight = 0;
	}
	
	public Animal(String sound, int lifespan, double weight) {
		noise = sound;
		averageLifespan = lifespan;
		adultWeight = weight;
	}
	
	public void setAverageLifespan(int lifespan) {
		averageLifespan = lifespan;
	}
	
	public void setAdultWeight(double weight) {
		adultWeight = weight;
	}
	
	public int getAverageLifespan() {
		return averageLifespan;
	}
	
	public double getAdultWeight() {
		return adultWeight;
	}
	
	public void makeNoise() {
		System.out.println("The animal says: " + noise + "!");
	}
}
