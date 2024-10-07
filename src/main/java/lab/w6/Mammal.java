package lab.w6;

public class Mammal extends Animal {
    protected int age;
    public Mammal(int age) {
        super();
        this.setAge(age);
    }
    public Mammal(String sound, int lifespan, double weight, int age) {
        super(sound, lifespan, weight);
        this.setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    @Override
    public void makeNoise() {
        System.out.println("The "+ this.getClass().getSimpleName() +" says: " + noise + "!");
    }
}

