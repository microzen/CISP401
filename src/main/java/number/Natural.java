package number;

public class Natural extends Integer{
    public Natural(int number) throws IllegalNaturalNumberException {
        super(number);
        if (number < 1) throw new IllegalNaturalNumberException();
    }
    public Natural(Natural copy) throws IllegalNaturalNumberException{
        this(copy.realNumerator);
    }

    @Override
    public void setValue(int value) throws NumberAccessException, IllegalNaturalNumberException {
        if (value < 1) throw new IllegalArgumentException("value must be greater than 0");
        this.realNumerator = value;
    }

    @Override
    public void setNumerator(int numerator) throws NumberAccessException, IllegalNaturalNumberException {
        if (numerator < 1) throw new IllegalArgumentException("numerator must be greater than 0");
        this.realNumerator = numerator;
    }

    @Override
    public void setRealNumerator(int realNumerator) throws NumberAccessException {
        if (realNumerator < 1) throw new IllegalArgumentException("real numerator must be greater than 0");
        this.realNumerator = realNumerator;
    }

    @Override
    public double addDouble(double num) {
        double result = super.addDouble(num);
        if(result < 1) throw new ArithmeticException("the result in natural cannot be negative");
        return  result;
    }
}
