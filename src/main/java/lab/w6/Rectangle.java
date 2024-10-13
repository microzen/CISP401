package lab.w6;

public class Rectangle extends Parallelogram{

    public Rectangle(int side1,int side2) {
        super(side1, side2, 90);
    }
    @Override
    public void printArea() {
        double area = sides[0] * sides[1];
        System.out.println("Area is " + area + "; found using Rectangle's method");
    }
}
