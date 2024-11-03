package lab.w10;

import java.util.ArrayList;

public class LightCalculator {

    public static double sumWatts(ArrayList<Lightbulb> bulbs) {
        double totalWattage = 0;
        for (Lightbulb bulb : bulbs) {
            totalWattage += bulb.getWattage();
        }
        return totalWattage;
    }

    public static double sumLumens(ArrayList<Light> lights) {
        double totalLumens = 0;
        for (Light light : lights) {
            totalLumens += light.getLumens();
        }
        return totalLumens;
    }

    public static <T extends Light> void sumStats(ArrayList<T> lights) {
        double totalLumens = 0;
        double totalWattage = 0;

        for (Light light : lights) {
            totalLumens += light.getLumens();


            if (light instanceof Lightbulb) {
                Lightbulb bulb = (Lightbulb) light;
                totalWattage += bulb.getWattage();
            }
        }

        System.out.println("Total Lumens: " + totalLumens);
        System.out.println("Total Wattage: " + totalWattage);
    }


    public static void main(String[] args) {
        System.out.println("Part 2:");

        ArrayList<Lightbulb> bulbs1 = new ArrayList<>();
        for (int i = 0; i < 4; i++) bulbs1.add(new Incandescent());
        for (int i = 0; i < 5; i++) bulbs1.add(new LED());
        System.out.println("Total watts for 4 Incandescent and 5 LED: " + sumWatts(bulbs1));

        ArrayList<Lightbulb> bulbs2 = new ArrayList<>();
        for (int i = 0; i < 10; i++) bulbs2.add(new Incandescent());
        for (int i = 0; i < 10; i++) bulbs2.add(new LED());
        System.out.println("Total watts for 10 Incandescent and 10 LED: " + sumWatts(bulbs2));

        ArrayList<Light> lights1 = new ArrayList<>();
        for (int i = 0; i < 8; i++) lights1.add(new Incandescent());
        for (int i = 0; i < 8; i++) lights1.add(new LED());
        for (int i = 0; i < 8; i++) lights1.add(new Firefly());
        System.out.println("Total lumens for 8 Incandescent, 8 LED, and 8 Firefly: " + sumLumens(lights1));

        ArrayList<Light> lights2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) lights2.add(new Incandescent());
        for (int i = 0; i < 5; i++) lights2.add(new LED());
        lights2.add(new Firefly());
        System.out.println("Total lumens for 2 Incandescent, 5 LED, and 1 Firefly: " + sumLumens(lights2));

        ArrayList<Light> lights3 = new ArrayList<>();
        lights3.add(new Incandescent());
        lights3.add(new LED());
        for (int i = 0; i < 1000; i++) lights3.add(new Firefly());
        System.out.println("Total lumens for 1 Incandescent, 1 LED, and 1000 Firefly: " + sumLumens(lights3));

        System.out.println("\n---------Part 3:-----------");

        System.out.println("For 4 Incandescent and 5 LED:");
        sumStats(bulbs1);
        System.out.println();

        System.out.println("For 10 Incandescent and 10 LED:");
        sumStats(bulbs2);
        System.out.println();

        System.out.println("For 8 Incandescent, 8 LED, and 8 Firefly:");
        sumStats(lights1);
        System.out.println();

        System.out.println("For 2 Incandescent, 5 LED, and 1 Firefly");
        sumStats(lights2);
        System.out.println();

        System.out.println("For 1 Incandescent, 1 LED, and 1000 Firefly");
        sumStats(lights3);
        System.out.println();
    }
}

