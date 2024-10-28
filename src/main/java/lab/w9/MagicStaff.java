package lab.w9;

public class MagicStaff extends Weapon implements Magical, Throwable {

    public MagicStaff() {
        super("waves");
    }

    @Override
    public String getName() {
        return "magic staff";
    }

    @Override
    public String displayMagic() {
        return "The staff has a slight magical glow.";
    }

    @Override
    public String castSpell() {
        return "The staff channels magical energy and summons a gout of flames!";
    }

    @Override
    public String describeThrow() {
        return "After being thrown, the magic staff glows with magic power and zooms back to its wielder's hand!";
    }
}
