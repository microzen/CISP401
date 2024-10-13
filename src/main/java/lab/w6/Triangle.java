package lab.w6;

public class Triangle extends Polygon {

    public Triangle(int a, int b, int c) {
        super(new int[3]);
        super.sides[0] = a;
        super.sides[1] = b;
        super.sides[2] = c;
    }
}
