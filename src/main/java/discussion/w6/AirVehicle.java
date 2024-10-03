package discussion.w6;

public class AirVehicle extends Vehicle {
    protected double airSpeed;
    public AirVehicle(double speed, double airSpeed) {
        super(speed);
        this.airSpeed = airSpeed;
    }
    public AirVehicle(double airSpeed) {
        super(0);
        this.airSpeed = airSpeed;
    }
    @Override
    public double timeToDestination(double distance) {
        return distance / this.airSpeed;
    }
}
