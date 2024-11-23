package lab.w13;

import java.util.ArrayList;

import static java.util.Collections.sort;

public class Jar implements Comparable<Jar> {
    private int volume;
    private double fillPercent;
    public Jar(int maxVolume){
        this.volume = maxVolume;
        this.fillPercent = 0;
    }

    public int getVolume() {
        return volume;
    }

    public double getAmount() {
        return volume * fillPercent;
    }

    public void setFillPercent(double fillPercent) {
        this.fillPercent = fillPercent;
    }
    public void clean(){
        this.volume = 0;
    }

    @Override
    public int compareTo(Jar o) {
        if(this.getAmount() == o.getAmount()){
            if(this.getVolume() > o.getVolume()){
                return 1;
            } else if (this.getVolume() < o.getVolume()) {
                return -1;
            }else{
                return 0;
            }
        }
        else if(this.getAmount() > o.getAmount()){
            return 1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        ArrayList<Jar> jars = new ArrayList<>();
        var jar1 = new Jar(18);
        jar1.setFillPercent(0.5);
        var jar2 = new Jar(10);
        jar2.setFillPercent(0.1);
        var jar3 = new Jar(10);
        jar3.setFillPercent(0.9);

        jars.add(jar1);
        jars.add(jar2);
        jars.add(jar3);

        System.out.println("Unsorted");
        jars.forEach(e->{
            System.out.printf("Amount: %.2f, Max Volume: %doz\n",e.getAmount(),e.getVolume());
        });

        sort(jars);
        System.out.println("\nSorted");
        jars.forEach(e->{
            System.out.printf("Amount: %.2f, Max Volume: %doz\n",e.getAmount(),e.getVolume());
        });
    }
}
