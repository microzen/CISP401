package discussion.w6;

public class Vehicle {
    protected double groundSpeed;

    public Vehicle(double speed) {
        groundSpeed = speed;
    }

    public double timeToDestination(double distance) {
        return distance / groundSpeed;
    }
}
