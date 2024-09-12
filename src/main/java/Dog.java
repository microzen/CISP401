public class Dog {
    private String name;
    private String breed;
    private int age;
    private double weight;
    private boolean fixed;
    private char ownerIninial;

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public boolean isFixed() {
        return fixed;
    }

    public int getAge() {
        return age;
    }

    public char getOwnerIninial() {
        return ownerIninial;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public void setOwnerIninial(char ownerIninial) {
        this.ownerIninial = Character.toUpperCase(ownerIninial);
    }

    /**
     *  set an age to the dog
     * @param age
     * @throws `IllegalArgumentException` if age less than zero
     */
    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Age cannot be negative.");
        else this.age = age;
    }

    /**
     *
     * @param weight
     * @throws `IllegalArgumentException` if weight less than zero
     */
    public void setWeight(double weight) {
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative.");
        else this.weight = weight;
    }

    public Dog(String newName, String newBreed, int newAge, double newWeight, boolean newFixed, char newOwnerInitial) {
        this.setName(newName);
        this.setAge(newAge);
        this.setBreed(newBreed);
        this.setFixed(newFixed);
        this.setOwnerIninial(newOwnerInitial);
        this.setWeight(newWeight);
    }

    public static void main(String[] args) {

        Dog friend = new Dog("Poochy", "Poodle", 4, 63.71, true, 'Y');
        Book novel = new Book();
        System.out.println("Dog's Name:" + friend.getName());
        Dog dog = new Dog("Barkley", "Labrador", 3, 71.08, true, 'J');

        System.out.format("The dogs' name are %s and %s.\n", dog.getName(), friend.getName());
        System.out.format("%s is a %s and is %d years old.\n", dog.getName(), dog.getBreed(), dog.getAge());
        System.out.format("That's %d in dog years!\n", dog.getAge() * 7);

        Book book = new Book();
        book.setTitle("All About Dogs");

        book.writeOnPage("Page 0");
        book.turnPage();
        book.writeOnPage("Page 1");
        book.turnPage();
        book.writeOnPage("Page 2");
        book.turnPage();
        book.writeOnPage("Page 3");
        book.turnPage();
        book.writeOnPage("Page 4");
        book.turnPage();

        System.out.println("\nNow for a reading of the book \"" + book.getTitle() + "\"");
        for (int i = 0; i < book.getNumberOfPages(); i++) {
            book.turnToPage(i);
            System.out.println(book.read());
        }
        System.out.println();

        Dog[] dogs = new Dog[3];
        dogs[0] = friend;
        dogs[1] = dog;
        dogs[2] = new Dog("Hallo","None",4,14,true,'Y');

        double sumOfWeight = 0;
        for (int i = 0; i < dogs.length; i++) {
            System.out.format("The weight of %s is .2%f.\n",dogs[i].getName(),dogs[i].getWeight());
            sumOfWeight += dogs[i].getWeight();
        }
        System.out.println("The total weight of dogs is " + sumOfWeight);

    }
}

