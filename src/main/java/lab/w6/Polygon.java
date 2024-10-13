package lab.w6;

public class Polygon {
    protected int[] sides;
    public Polygon(int[] sides){
        this.sides = sides;
    }
    public int findPerimeter(){
        int sum = 0;
        for(int i = 0; i < sides.length; i++){
            sum += sides[i];
        }
        return sum;
    }
}
