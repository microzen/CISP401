package ecosystem;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class EnvironmentSimulation {
    private ArrayList<Organism> organisms;
    private ArrayList<Edible> foods;
    private int turn;
    private static Map<Class<? extends Organism>, Integer[]> record;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EnvironmentSimulation simulation = new EnvironmentSimulation();
        simulation.init();

        while (true) {
            System.out.format("\n\n\t\tSimulation Step %d\n", simulation.turn);
            System.out.println("----------------------------------");
            record.forEach((aClass, integers) -> {
                System.out.format("\n%s: ", aClass.getSimpleName());
                integers[0] = integers[3];
                integers[3] += integers[1];
                integers[3] -= integers[2];
                System.out.format("\n\t Old Total\t: %d", integers[0]);
                System.out.format("\n\t Born\t\t: %d", integers[1]);
                System.out.format("\n\t Died\t\t: %d", integers[2]);
                System.out.format("\n\t New Total\t: %d\n", integers[3]);
                integers[1] = 0;
                integers[2] = 0;
            });
            scanner.nextLine();
            simulation.next();
        }

    }

    private void init() {
        this.turn = 1;
        organisms = new ArrayList<>();
        foods = new ArrayList<>();
        record = new HashMap<>();
        record.put(GrassPatch.class, new Integer[]{0, 0, 0, 0});
        record.put(OrangeTree.class, new Integer[]{0, 0, 0, 0});
        record.put(Orange.class, new Integer[]{0, 0, 0, 0});
        record.put(Squirrel.class, new Integer[]{0, 0, 0, 0});
        record.put(Deer.class, new Integer[]{0, 0, 0, 0});
        record.put(Wolf.class, new Integer[]{0, 0, 0, 0});
        this.addOrganism(OrangeTree.class, 5);
        this.addOrganism(GrassPatch.class, 30);
    }

    private void next() {
        this.turn++;
        ArrayList<Organism> nextOrganisms = new ArrayList<>();

        if (this.turn == 5) {
            this.addOrganism(Squirrel.class, 30);
        } else if (this.turn == 10) {
            this.addOrganism(Deer.class, 50);
        } else if (this.turn == 20) {
            this.addOrganism(Wolf.class, 20);
        } else {

        }

        for (Organism organism : organisms) {
            nextOrganisms.addAll(Arrays.asList(organism.reproduce()));
            if (organism instanceof Animal) {
                var animal = (Animal) organism;
                while (animal.isHungry()) {
                    var food = findFoods(animal);
                    if (food != null) {
                        animal.eat(food);
                    }else {
                        break;
                    }
                }
                animal.useEnergy();
            } else if (organism instanceof Plant) {
                var plant = (Plant) organism;
                plant.regenerate();
            }
        }
        ArrayList<Organism> deadOrganisms = new ArrayList<>();
        for (Organism organism : organisms) {
            if (organism.isDead()){
                deadOrganisms.add(organism);
                record.get(organism.getClass())[2]++;
            }
        }
        organisms.removeAll(deadOrganisms);
        foods.removeAll(deadOrganisms);

        for (Organism organism : nextOrganisms) {
            this.addOrganism(organism);
        }
    }

    private Edible findFoods(Animal animal) {
        Edible food = null;
        for(int i = 0;i< foods.size();i++) {
            if (animal.canEat(foods.get(i))) {
                food = foods.get(i);
                if(food instanceof GrassPatch){
                    if(food.getCalories()<=0){
                        food = null;
                        continue;
                    }
                }else{
                    foods.remove(food);
                }
                break;
            }
        }
        return food;
    }


    private void addOrganism(Class<? extends Organism> type, int num) {
        for (int i = 0; i < num; i++) {
            try {
                var obj = type.getDeclaredConstructor().newInstance();
                this.addOrganism(obj);
            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                     InvocationTargetException e) {
                e.printStackTrace();
                return;
            }
        }
    }

    private void addOrganism(Organism organism) {
        if (organism instanceof Edible) {
            foods.add((Edible) organism);
        }
        organisms.add(organism);
        record.get(organism.getClass())[1]++;
    }
}
