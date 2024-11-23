package lab.w13;

public class Exponent<Type extends Number,PowerType extends Number> extends Number{
    private Type number;
    private PowerType power;
    public Exponent(Type number, PowerType power) {
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

    public static void main(String[] args) {
        Exponent<Double,Integer> exponent = new Exponent<>(10.5,2);
        System.out.println(exponent.intValue());
    }
}
