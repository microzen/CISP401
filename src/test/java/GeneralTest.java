import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class GeneralTest {
    @Test
    public void GeneralTest() {
        eq((4/5),doDivision(4,5));
        th(ArithmeticException.class,()->{
            doDivision(49,0);
        });
        eq("Returning to main menu...",getOption(0));
        eq("Please enter your password",getOption(1));
        isn(getOption(100));
    }
    static void eq(Object expected, Object actual) {
        if(!expected.equals(actual)){
            System.out.println("Fail: expected = "+expected.toString() + ", actual = " + actual.toString());
        }else{
            System.out.println("Success");
        }
    }
    static void isn(Object obj) {
        if(obj == null){
            System.out.println("Success");
        }else {
            System.out.println("Fail: obj is not null");
        }
    }
    static void th(Class<? extends Throwable> expected, Executable executable){
        try{
            executable.execute();
        }catch (Throwable t){
            if(expected.equals(t.getClass())){
                System.out.println("Success");
            }else {
                System.out.println("Fail: exception is not " + expected.getName());
            }
            return;
        }
        System.out.println("Fail: exception is not " + expected.getName());
    }
    public static int doDivision(int dividend, int divisor) throws ArithmeticException {
        return dividend / divisor;
    }

    public static String getOption(int number) {
        switch (number) {
            case 0:
                return "Returning to main menu...";
            case 1:
                return "Please enter your password";
            default:
                return null;
        }
    }

    public class Fan {
        protected double[] speeds;      // the speed settings available on the fan
        protected boolean power;        // whether the fan is on or off
        protected int currentSpeed;     // the current speed setting of the fan

        public Fan(double[] fanSpeeds) {
            speeds = fanSpeeds;
            currentSpeed = 0;
            power = false;
        }

        public boolean powerSwitch() {
            power = !power;
            return power;
        }

        public double setSpeed(int newSpeed) {
            currentSpeed = newSpeed;
            return speeds[currentSpeed];
        }
    }
    public class CeilingFan extends Fan {
        protected boolean lightPower;
        protected double bladeLength;
        CeilingFan(double[] speeds, boolean lightPower, double bladeLength) {
            super(speeds);
            this.lightPower = lightPower;
            this.bladeLength = bladeLength;
        }

        public double getBladeLength() {
            return bladeLength;
        }

        public void setBladeLength(double bladeLength) {
            this.bladeLength = bladeLength;
        }
        @Override
        public double setSpeed(int newSpeed) {
            int temp = currentSpeed;
            for (int i = 0; i < speeds.length; i++) {
                currentSpeed = (int)speeds[i];
            }
            currentSpeed = temp;
            return currentSpeed;
        }
    }
}
