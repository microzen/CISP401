package lab.w9;

public class Wizard extends Adventurer implements Magical {
    private MagicStaff magicStaff;

    public Wizard(String name, int strength, int dexterity, int intelligence) {
        super(name, strength, dexterity, intelligence + 2);
        this.magicStaff = new MagicStaff();
    }

    @Override
    public String toString() {
        return super.name + " the wizard";
    }

    @Override
    public String attackMonster() {
        return super.name + " " + this.magicStaff.getAction() + " their " + this.magicStaff.getName()
                + " and the summons of lightning";
    }

    @Override
    public String displayMagic() {
        return this.toString() + " radiates a powerful magical aura!";
    }

    @Override
    public String castSpell() {
        return this.toString()
                + " waves his hands around and causes ethereal lights to flicker in and out of existence!";
    }
}
