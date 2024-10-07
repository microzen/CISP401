package lab.w6;

public class Shark extends Fish {
	
	protected int yearlyDeaths;
	
	public Shark(int lifespan, double weight) {
		super(lifespan, weight);
		freshwater = false;
		yearlyDeaths = 0;
	}
	
	public void newDeath() {
		yearlyDeaths++;
	}
	
	public int getYearlyDeaths() {
		return yearlyDeaths;
	}

}
