package lab.w6;

public class Fish extends Animal {
	protected boolean freshwater;
	
	public Fish(int lifespan, double weight) {
		super();
		averageLifespan = lifespan;
		adultWeight = weight;
		freshwater = false;
	}
	
	public boolean isFreshWater() {
		return freshwater;
	}
	
	public void setFreshWater(boolean fresh) {
		freshwater = fresh;
	}
	
	@Override
	public void makeNoise() {
		System.out.println("The fish does not make any noise");
	}
}
