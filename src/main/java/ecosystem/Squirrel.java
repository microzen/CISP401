package ecosystem;


class Squirrel extends Animal implements Edible {
    public Squirrel() {
        super(1);
        this.energyUsage = 5;
    }

    @Override
    public boolean isHungry() {
        return energy < 4 * this.energyUsage;
    }

    @Override
    public boolean canEat(Edible food) {
        return food instanceof Orange;
    }

    @Override
    public int getCalories() {
        return 30 + energy;
    }

    @Override
    public void eaten() {
        die();
    }

    @Override
    public Organism[] reproduce() {
        if (isHungry()) return new Organism[0];
        return new Organism[]{new Squirrel(), new Squirrel()};
    }

    @Override
    public String toString() {
        return "Squirrel";
    }
}
