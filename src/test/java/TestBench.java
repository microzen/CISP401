import number.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestBench {
    @Test
    public void main() throws NumberAccessException {

        // Constructor
        Complex complex = new Complex(6, 2, 4, 5);

        Assertions.assertEquals(6, complex.getRealNumerator());
        Assertions.assertEquals(2, complex.getRealDenominator());
        Assertions.assertEquals(4, complex.getImaginaryNumerator());
        Assertions.assertEquals(5, complex.getImaginaryDenominator());

        Assertions.assertThrowsExactly(ArithmeticException.class, () -> {
            new Complex(1, 0, 1, 1);
        });
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> {
            new Complex(1, 1, 1, 0);
        });

        // Copy constructor
        Complex copy = new Complex(complex);
        Assertions.assertEquals(6, copy.getRealNumerator());
        Assertions.assertEquals(2, copy.getRealDenominator());
        Assertions.assertEquals(4, copy.getImaginaryNumerator());
        Assertions.assertEquals(5, copy.getImaginaryDenominator());

        // Mutators test
        Assertions.assertDoesNotThrow(() -> {
            complex.setRealNumerator(3);
            complex.setRealDenominator(5);
            complex.setImaginaryNumerator(6);
            complex.setImaginaryDenominator(7);
        });

        // Accessors test
        Assertions.assertEquals(3, complex.getRealNumerator(),
                "The real numerator should be 3 by new Complex(3,5,6,7)");
        Assertions.assertEquals(5, complex.getRealDenominator(),
                "The real denominator should be 5 by new Complex(3,5,6,7)");
        Assertions.assertEquals(6, complex.getImaginaryNumerator(),
                "The image numerator should be 6 by new Complex(3,5,6,7)");
        Assertions.assertEquals(7, complex.getImaginaryDenominator(),
                "The image denominator should be 7 by new Complex(3,5,6,7)");

        // Method throws an exception when denominator is set to 0
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> {
            complex.setRealDenominator(0);
            complex.setImaginaryDenominator(0);
        });

        complex.setRealNumerator(6);
        complex.setRealDenominator(2);
        complex.setImaginaryNumerator(4);
        complex.setImaginaryDenominator(5);

        // ToString
        Assertions.assertEquals("3/1+4/5i", complex.toString());
        // Simplify
        complex.simplify();
        Assertions.assertEquals(3, complex.getRealNumerator());
        Assertions.assertEquals(1, complex.getRealDenominator());
        Assertions.assertEquals(4, complex.getImaginaryNumerator());
        Assertions.assertEquals(5, complex.getImaginaryDenominator());

        // ToString and simplify in real denominators are no longer negative.
        complex.setRealDenominator(Math.negateExact(complex.getRealDenominator()));
        Assertions.assertEquals("-3/1+4/5i", complex.toString());
        complex.simplify();
        Assertions.assertEquals(-3, complex.getRealNumerator());
        Assertions.assertEquals(1, complex.getRealDenominator());

        // ToString and simplify in imaginary denominators are no longer negative.
        complex.setImaginaryDenominator(Math.negateExact(complex.getImaginaryDenominator()));
        Assertions.assertEquals("-3/1-4/5i", complex.toString());
        complex.simplify();
        Assertions.assertEquals(-4, complex.getImaginaryNumerator());
        Assertions.assertEquals(5, complex.getImaginaryDenominator());

        // Method works correctly for different Complex objects and string in false
        Complex complex2 = new Complex(9, 3, 8, 10);
        Assertions.assertFalse(complex.equals( complex2));
        Assertions.assertFalse(complex.toString() == complex2.toString());

        Assertions.assertNotEquals(complex.hashCode(), complex2.hashCode());
        // Equals in true
        complex2.setRealDenominator(Math.negateExact(complex2.getRealDenominator()));
        complex2.setImaginaryDenominator(Math.negateExact(complex2.getImaginaryDenominator()));

        Assertions.assertTrue(complex.equals(complex2));
        Assertions.assertEquals(complex.toString(), complex2.toString());
    }

    @Test
    public void StandardConstructorTest() throws IllegalNaturalNumberException {
        // Complex constructor test
        Complex complex = new Complex(3, 5, 6, 7);
        Assertions.assertEquals(3, complex.getRealNumerator(),
                "The real numerator should be 3 by new Complex(3,5,6,7)");
        Assertions.assertEquals(5, complex.getRealDenominator(),
                "The real denominator should be 5 by new Complex(3,5,6,7)");
        Assertions.assertEquals(6, complex.getImaginaryNumerator(),
                "The image numerator should be 6 by new Complex(3,5,6,7)");
        Assertions.assertEquals(7, complex.getImaginaryDenominator(),
                "The image denominator should be 7 by new Complex(3,5,6,7)");
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> {
            new Complex(2, 0, 3, 1);
        }, "Should throw ArithmeticException by new Complex(2,0,3,1)");
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> {
            new Complex(2, 1, 3, 0);
        }, "Should throw ArithmeticException by new Complex(2,1,3,0)");

        // Imaginary constructor test
        var imaginary = new Imaginary(5, 10);
        Assertions.assertEquals(5, imaginary.getImaginaryNumerator(),
                "The image numerator should be 5 by newImaginary(5,10)");
        Assertions.assertEquals(10, imaginary.getImaginaryDenominator(),
                "The image denominator should be 10 by new Imaginary(5,10)");
        Assertions.assertEquals(0, imaginary.getRealNumerator(),
                "The real numerator in Imaginary should be 0 by new Imaginary(5,10)");
        Assertions.assertEquals(1, imaginary.getRealDenominator(),
                "The real denominator in Imaginary should be 1 by new Imaginary(5,10)");

        Assertions.assertThrows(ArithmeticException.class, () -> {
            new Imaginary(5, 0);
        }, "Should throw ArithmeticException by new Imaginary(5,0)");

        // Rational constructor test
        var rational = new Rational(5, -10);
        Assertions.assertEquals(5, rational.getRealNumerator(),
                "The real numerator should be 5 by new Rational(5, -10)");
        Assertions.assertEquals(-10, rational.getRealDenominator(),
                "The real denominator should be -10 by new Rational(5,-10)");
        Assertions.assertEquals(0, rational.getImaginaryNumerator(),
                "The image numerator in Rational 0 by new Rational(5,-10)");
        Assertions.assertEquals(1, rational.getImaginaryDenominator(),
                "The image denominator in Rational 1 by new Rational(5,-10)");

        Assertions.assertThrows(ArithmeticException.class, () -> {
            new Rational(10, 0);
        }, "Should throw ArithmeticException by new Rational(10,0)");

        // Integer constructor test
        Assertions.assertDoesNotThrow(() -> {
            new number.Integer(5);
            new number.Integer(0);
            new number.Integer(-100);
        }, "Should not throw any exception");

        number.Integer integer = new number.Integer(5);

        Assertions.assertEquals(5, integer.getValue(),
                "The integer value should be 5 by new Integer(5)");

        Assertions.assertEquals(5, integer.getRealNumerator(),
                "The integer value should be 5 by new Integer(5)");


        // Natural constructor test
        Assertions.assertDoesNotThrow(() -> {
            new Natural(5);
            new Natural(10000);
        }, "Should not throw any exception");

        Natural natural = new Natural(5);
        Assertions.assertEquals(5, natural.getValue(),
                "The natural value should be 5 by new Natural(5)");

        Assertions.assertThrows(IllegalNaturalNumberException.class, () -> {
            new Natural(-1);
        }, "Should throw IllegalNaturalNumberException by new Natural(-1)");
        Assertions.assertThrows(IllegalNaturalNumberException.class, () -> {
            new Natural(0);
        }, "Should throw IllegalNaturalNumberException by new Natural(0)");
    }

    @Test
    public void CopyConstructorTest() throws IllegalNaturalNumberException {
        // Complex copy constructor test
        Complex complex = new Complex(3, 5, 6, 7);
        Assertions.assertEquals(complex, new Complex(complex),
                "Copy should be the same in the values by new Complex(3, 5, 6, 7)");

        // Imaginary copy constructor test
        Imaginary imaginary = new Imaginary(5, 10);
        Assertions.assertEquals(imaginary, new Imaginary(imaginary),
                "Copy should be the same in the values by new Imaginary(5, 10)");

        // Rational
        Rational rational = new Rational(5, -10);
        Assertions.assertEquals(rational, new Rational(rational),
                "Copy should be the same in the values by new Rational(5,-10)");

        // Integer copy test
        number.Integer integer = new number.Integer(5);
        Assertions.assertEquals(integer, new number.Integer(integer),
                "Copy should be the same in the values by new Integer(5)");
        Assertions.assertEquals(integer, new number.Integer(new Natural(5)),
                "Copy should be the same in the values by new Natural(5) and Integer(5)");

        // Natural copy test
        Natural natural = new Natural(5);
        Natural copyNatural = new Natural(natural);
        Assertions.assertEquals(natural, copyNatural,
                "Copy should be the same in the values by new Natural(5)");
    }

    @Test
    public void AccessorAndMutatorTest() {
        // Complex accessors and mutators test
        Complex complex = new Complex(0, 1, 0, 1);
        Assertions.assertDoesNotThrow(() -> {
            complex.setRealNumerator(3);
            complex.setRealDenominator(5);
            complex.setImaginaryNumerator(6);
            complex.setImaginaryDenominator(7);
        });
        Assertions.assertEquals(3, complex.getRealNumerator(),
                "The real numerator should be 3 by new Complex(3,5,6,7)");
        Assertions.assertEquals(5, complex.getRealDenominator(),
                "The real denominator should be 5 by new Complex(3,5,6,7)");
        Assertions.assertEquals(6, complex.getImaginaryNumerator(),
                "The image numerator should be 6 by new Complex(3,5,6,7)");
        Assertions.assertEquals(7, complex.getImaginaryDenominator(),
                "The image denominator should be 7 by new Complex(3,5,6,7)");
        Assertions.assertThrowsExactly(ArithmeticException.class, () -> {
            complex.setRealDenominator(0);
            complex.setImaginaryDenominator(0);
        });


        // Imaginary accessors and mutators test
        Imaginary imaginary = new Imaginary(0, 1);

        Assertions.assertDoesNotThrow(() -> {
            imaginary.setImaginaryNumerator(3);
            imaginary.setImaginaryDenominator(10);
        });

        Assertions.assertEquals(3, imaginary.getImaginaryNumerator(),
                "The real numerator should be 3");
        Assertions.assertEquals(10, imaginary.getImaginaryDenominator(),
                "The real denominator should be 10");

        Assertions.assertThrowsExactly(ArithmeticException.class, () -> {
            imaginary.setDenominator(0);
        });

        Assertions.assertThrowsExactly(NumberAccessException.class, () -> {
            imaginary.setRealNumerator(10);
            imaginary.setRealDenominator(9);
        });

        Assertions.assertThrowsExactly(NumberAccessException.class, () -> {
            imaginary.setRealNumerator(10);
        }, "Could not set real numerator by mutator in a imaginary, imaginary.setRealNumerator(3)");

        Assertions.assertThrowsExactly(NumberAccessException.class, () -> {
            imaginary.setRealDenominator(5);
        }, "Could not set real denominator by mutator in a imaginary, imaginary.setRealDenominator(5)");

//        Assertions.assertEquals(5, natural.getValue(), "The natural value should be 5 by new Natural(5)");

//        Assertions.assertEquals(5, imaginary.getImaginaryNumerator(), "The image numerator should be 5 by
//        newImaginary(5,10)");
//        Assertions.assertEquals(10, imaginary.getImaginaryDenominator(), "The image denominator should be 10 by new
//        Imaginary(5,10)");
//        Assertions.assertEquals(0, imaginary.getRealNumerator(), "The real numerator in Imaginary should be 0 by
//        new Imaginary(5,10)");
//        Assertions.assertEquals(1, imaginary.getRealDenominator(), "The real denominator in Imaginary should be 1
//        by new Imaginary(5,10)");

//        Assertions.assertEquals(5, rational.getRealNumerator(), "The real numerator should be 5 by new Rational(5,
//        -10)");
//        Assertions.assertEquals(-10, rational.getRealDenominator(), "The real denominator should be -10 by new
//        Rational(5,-10)");
//        Assertions.assertEquals(0, rational.getImaginaryNumerator(), "The image numerator in Rational 0 by new
//        Rational(5,-10)");
//        Assertions.assertEquals(1, rational.getImaginaryDenominator(), "The image denominator in Rational 1 by new
//        Rational(5,-10)");

//        number.Integer integer = new number.Integer(5);
//        Assertions.assertEquals(5, integer.getValue(), "The integer value should be 5 by new Integer(5)");

    }

    @Test
    public void Equ() {
    }
}
