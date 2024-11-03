package ecosystem;
public abstract class Animal extends Organism {
    protected int energy;
    protected int energyUsage;

    public Animal(int startingEnergy) {
        super();
        this.energy = startingEnergy;
    }

    public void useEnergy() {
        energy -= energyUsage;
        if (energy <= 0) {
            super.die();
        }
    }

    public void eat(Edible food) {
        energy += food.getCalories();
        food.eaten();
    }

    public abstract boolean isHungry();
    public abstract boolean canEat(Edible food);
}
