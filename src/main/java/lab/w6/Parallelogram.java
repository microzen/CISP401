package lab.w6;

public class Parallelogram extends Quadrilateral {
    int interiorAngle;
    public Parallelogram(int side1, int side2, int angle){
        super(side1,side2,side1,side2);
        this.interiorAngle = angle;
    }
    public void printArea(){
        double area = super.sides[0] * super.sides[1] * Math.sin(Math.toRadians(interiorAngle));
        System.out.println("Area is " + area + "; found using Parallelogram's method");
    }

    public static void main(String[] args) {
        Rhombus rhombus = new Rhombus(2, 90);
        rhombus.printArea();
        Square square = new Square(4);
        square.printArea();
    }
}
