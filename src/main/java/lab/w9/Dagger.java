package lab.w9;

public class Dagger extends Weapon implements Throwable {
    public Dagger() {
        super("swiftly thrusts");
    }

    @Override
    public String getName() {
        return "dagger";
    }

    @Override
    public String describeThrow() {
        return "The dagger is thrown like a dart. Bullseye!";
    }
}
