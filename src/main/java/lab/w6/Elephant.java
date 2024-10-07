package lab.w6;

public class Elephant extends Mammal {
    protected String habitat;
    public Elephant(String habitat, String noise, int age) {
        super(0);
        super.noise = noise;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }
}
