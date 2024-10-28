package lab.w9;

public class Thief extends Adventurer {
    private Dagger dagger;
    public Thief(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity + 2, intelligence);
        dagger = new Dagger();
    }

    @Override
    public String toString() {
        return super.name + " the thief";
    }

    @Override
    public String attackMonster() {
        return super.name + " " + this.dagger.getAction() + " their "+ this.dagger.getName();
    }

}
