package ecosystem;

import java.util.Random;

class OrangeTree extends Plant {
    public OrangeTree() {
        super(100);
    }

    @Override
    public void regenerate() {
        health = Math.min(health + 10, maxHealth);
    }

    @Override
    public Organism[] reproduce() {
        int numOranges = new Random().nextInt(6) + 5; // Produces between 5 and 10 oranges
        Organism[] oranges = new Organism[numOranges];
        for (int i = 0; i < numOranges; i++) {
            oranges[i] = new Orange();
        }
        return oranges;
    }

    @Override
    public String toString() {
        return "Orange Tree";
    }
}
