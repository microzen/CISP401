package number;

public class Natural extends Integer{
    public Natural(int number) {
        super(number);
//        if (number < 1) throw new IllegalArgumentException("number must be greater than 0");
        if(super.getValue() < 1){
            this.setValue(1);
        }
    }

    @Override
    public void setValue(int value) {
//        if (value < 1) throw new IllegalArgumentException("value must be greater than 0");
        super.setValue(Math.max(value, 1));
    }

    @Override
    public void setNumerator(int numerator) {
//        if (numerator < 1) throw new IllegalArgumentException("numerator must be greater than 0");
        super.setNumerator(Math.max(numerator,1));
    }

    @Override
    public void setRealNumerator(int realNumerator) {
//        if (realNumerator < 1) throw new IllegalArgumentException("real numerator must be greater than 0");
        super.setRealNumerator(Math.max(realNumerator,1));
    }

    @Override
    public double addDouble(double num) {
        double result = super.addDouble(num);
        return result < 1 ? 1 : result;
    }
}
