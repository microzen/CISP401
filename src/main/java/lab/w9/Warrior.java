package lab.w9;

public class Warrior extends Adventurer {
    private Sword sword;

    public Warrior(String name, int strength, int dexterity, int intelligence) {
        super(name, strength + 2, dexterity, intelligence);
        sword = new Sword();
    }

    @Override
    public String toString() {
        return super.name + "the warrior";
    }

    @Override
    public String attackMonster() {
        return super.name + " " + sword.getAction() + " their " + this.sword.getName();
    }

}
