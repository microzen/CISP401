package lab.w6;

public class Quadrilateral extends Polygon{
    public Quadrilateral(int a, int b, int c, int d) {
        super(new int[4]);
        super.sides[0] = a;
        super.sides[1] = b;
        super.sides[2] = c;
        super.sides[3] = d;
    }
}
