package ecosystem;


class Deer extends Animal implements Edible {
    public Deer() {
        super(1);
        this.energyUsage = 10;
    }

    @Override
    public boolean isHungry() {
        return energy <= 10 || Math.random() < 0.2;
    }

    @Override
    public boolean canEat(Edible food) {
        return food instanceof GrassPatch || food instanceof Orange;
    }

    @Override
    public int getCalories() {
        return 200 + energy;
    }

    @Override
    public void eaten() {
        die();
    }

    @Override
    public Organism[] reproduce() {
        if (isHungry()) return new Organism[0];
        return new Organism[]{new Deer()};
    }

    @Override
    public String toString() {
        return "Deer";
    }
}
