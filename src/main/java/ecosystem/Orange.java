package ecosystem;

class Orange extends Plant implements Edible {
    public Orange() {
        super(2);
    }

    @Override
    public void regenerate() {
        health -= 1;
        if (health <= 0) {
            die();
        }
    }

    @Override
    public int getCalories() {
        return 25;
    }

    @Override
    public void eaten() {
        die();
    }

    @Override
    public Organism[] reproduce() {
        return new Organism[0];
    }

    @Override
    public String toString() {
        return "Orange";
    }
}
