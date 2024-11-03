package ecosystem;

class Wolf extends Animal {
    public Wolf() {
        super(10);
        this.energyUsage = 50;
    }

    @Override
    public boolean isHungry() {
        return energy < 2 * this.energyUsage;
    }

    @Override
    public boolean canEat(Edible food) {
        return food instanceof Squirrel || food instanceof Deer;
    }

    @Override
    public Organism[] reproduce() {
        if (isHungry()) return new Organism[0];
        else if (Math.random() < 0.25) return new Organism[]{new Wolf()};
        else return new Organism[]{new Wolf()};
    }

    @Override
    public String toString() {
        return "Wolf";
    }
}
