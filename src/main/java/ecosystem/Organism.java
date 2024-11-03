package ecosystem;
public abstract class Organism {
    protected boolean dead;

    public Organism() {
        this.dead = false;
    }

    public boolean isDead() {
        return dead;
    }

    public void die() {
        this.dead = true;
    }

    public abstract Organism[] reproduce();
}
