package lab.w13;

public class Exponent<T extends Number> extends Number{
    private T number;
    private T power;
    public Exponent(T number, T power) {
        this.number = number;
        this.power = power;
    }
    @Override
    public int intValue() {
       return (int)Math.pow(number.intValue(), power.intValue());
    }

    @Override
    public long longValue() {
        return (long)Math.pow(number.longValue(), power.longValue());
    }

    @Override
    public float floatValue() {
        return (float)Math.pow(number.floatValue(), power.floatValue());
    }

    @Override
    public double doubleValue() {
        return Math.pow(number.doubleValue(), power.doubleValue());
    }
}
