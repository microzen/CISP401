import number.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberTest {
    @Test
    public void complexTest(){
        Complex complex = new Complex(6,2,4,5);
        Assertions.assertEquals("3/1+4/5i",complex.toString());

        complex.setRealDenominator(Math.negateExact(complex.getRealDenominator()));
        Assertions.assertEquals("-3/1+4/5i",complex.toString());

        complex.setImaginaryDenominator(Math.negateExact(complex.getImaginaryDenominator()));
        Assertions.assertEquals("-3/1-4/5i",complex.toString());


        Complex complex2 = new Complex(3,1,4,5);
        Assertions.assertEquals("3/1+4/5i",complex2.toString());


        Assertions.assertNotEquals(complex, complex2);
        complex2.setRealDenominator(Math.negateExact(complex2.getRealDenominator()));
        complex2.setImaginaryDenominator(Math.negateExact(complex2.getImaginaryDenominator()));
        Assertions.assertEquals(complex, complex2, "Complex 1:" + complex + " Complex 2:" + complex2);
    }
    @Test
    public void imaginaryTest(){
        Imaginary imaginary = new Imaginary(4,5);
        Assertions.assertEquals("4/5i",imaginary.toString());

        imaginary.setDenominator(2);
        Assertions.assertEquals("2/1i",imaginary.toString());

        imaginary.setRealNumerator(5);
        imaginary.setRealDenominator(3);
        Assertions.assertNotEquals(5,imaginary.getRealNumerator());
        Assertions.assertNotEquals(3,imaginary.getRealDenominator());

        Imaginary imaginary2 = new Imaginary(6,-3);
        Assertions.assertNotEquals(imaginary, imaginary2);

        imaginary.setDenominator(Math.negateExact(imaginary.getDenominator()));
        Assertions.assertEquals(imaginary, imaginary2);
    }

    @Test
    public void rationalTest(){
        Rational rational = new Rational(4,5);
        Assertions.assertEquals("4/5",rational.toString());

        rational.setDenominator(2);
        Assertions.assertEquals("2/1",rational.toString());

        rational.setImaginaryNumerator(5);
        rational.setImaginaryDenominator(3);
        Assertions.assertNotEquals(5,rational.getImaginaryNumerator());
        Assertions.assertNotEquals(3,rational.getImaginaryDenominator());

        Rational rational2 = new Rational(6,-3);
        Assertions.assertNotEquals(rational, rational2);

        rational.setDenominator(Math.negateExact(rational.getDenominator()));
        Assertions.assertEquals(rational, rational2);
    }
    @Test
    public void naturalTest(){
        Natural natural = new Natural(-1);
        Assertions.assertNotEquals("-1",natural.toString());
        natural.setRealNumerator(1);
        Assertions.assertEquals("1",natural.toString());
        Assertions.assertEquals(1, natural.addDouble(-100));
        Assertions.assertEquals(101, natural.addDouble(100));
    }
    @Test
    public void integerTest(){
        number.Integer integer = new number.Integer(1);
        Assertions.assertEquals("1",integer.toString());
        integer.setRealNumerator(2);
        Assertions.assertEquals("2",integer.toString());

        integer.setImaginaryNumerator(5);
        Assertions.assertNotEquals("5",integer.toString());
        integer.setImaginaryDenominator(3);
        Assertions.assertNotEquals("3",integer.toString());
        integer.setRealDenominator(100);
        Assertions.assertNotEquals("100",integer.toString());

        integer.setRealNumerator(30);
        Assertions.assertEquals("30",integer.toString());

        Assertions.assertEquals(30.1,integer.addDouble(0.1));
        Assertions.assertEquals(-70.1,integer.addDouble(-100.1));
    }

}
