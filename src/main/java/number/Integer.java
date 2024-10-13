package number;

public class Integer extends Rational {
    public Integer(int number) throws ArithmeticException{
        super(number,1);
    }
    public Integer(Integer copy) throws ArithmeticException {
        this(copy.realNumerator);
    }
    public int getValue(){
        return super.getRealNumerator();
    }
    public void setValue(int value) throws NumberAccessException, IllegalNaturalNumberException {
        super.setRealNumerator(value);
    }

    @Override
    public void setRealDenominator(int realDenominator) throws NumberAccessException {
        throw new NumberAccessException("The denominator could not be set by the mutators in integer");
    }

    @Override
    public String toString() {
        return String.valueOf(getRealNumerator());
    }

    @Override
    public double addDouble(double num) {
        return (double) this.getValue() + num;
    }
}
