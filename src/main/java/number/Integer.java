package number;

public class Integer extends Rational {
    public Integer(int number) {
        super(number,1);
    }
    public Integer(Integer copy){
        super(copy);
    }
    public int getValue(){
        return super.getRealNumerator();
    }
    public void setValue(int value){
        super.setRealNumerator(value);
    }

    @Override
    public void setRealDenominator(int realDenominator) {
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
