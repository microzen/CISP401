package lab.w9;

public abstract class Adventurer {
    protected String name;
    protected int strength;
    protected int dexterity;
    protected int intelligence;

    public Adventurer(String name, int strength, int dexterity, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    @Override
    public abstract String toString();

    public abstract String attackMonster();

    public String describe() {
        String description = "So you want to know more about " + toString() + "? \n";
        if (strength <= 3) {
            description += "They are as weak as a baby! ";
        } else if (strength <= 7) {
            description += "They have average physical strength. ";
        }else{
            description += "They have superhuman strength! ";
        }

        if (dexterity <= 3) {
            description += "They are very clumsy! ";
        }else if (dexterity <= 7) {
            description += "They have a good sense of balance. ";
        }else {
            description += "Their reflexes are faster than a cat's. ";
        }

        if (intelligence <= 3) {
            description += "They are dumber than a sack of potatoes! ";
        }else if (intelligence <= 7) {
            description += "They are of average intelligence. ";
        }else {
            description += "Their intellect rivals history's greatest scholars! ";
        }
        return description;
    }
}
