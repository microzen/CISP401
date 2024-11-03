package ecosystem;

public abstract class Plant extends Organism {
    protected int health;
    protected int maxHealth;

    public Plant(int maxHealth) {
        super();
        this.health = maxHealth;
        this.maxHealth = maxHealth;
    }

    public abstract void regenerate();
}
