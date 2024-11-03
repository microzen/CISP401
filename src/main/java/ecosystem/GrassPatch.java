package ecosystem;

class GrassPatch extends Plant implements Edible {
    public GrassPatch() {
        super(10);
    }

    @Override
    public void regenerate() {
        health = Math.min(health + 5, maxHealth);
    }

    @Override
    public int getCalories() {
        return health > 0 ? 10 : 0;
    }

    @Override
    public void eaten() {
        health = Math.max(health - 2, 0);
    }

    @Override
    public Organism[] reproduce() {
        return new Organism[0];
    }

    @Override
    public String toString() {
        return "Grass Patch";
    }
}
