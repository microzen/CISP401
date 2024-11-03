package lab.w10;

public class LED extends Lightbulb {
    @Override
    public double getLumens() {
        return 750;
    }

    @Override
    public double getWattage() {
        return 10;
    }
}
