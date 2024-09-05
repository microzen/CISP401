import java.util.Scanner;
import java.util.Random;

public class Lab2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final String menu;
        String input;
        menu = "Enter the number of the operation you would like to perform\n" +
                "1. Test random number generation\n" +
                "2. Find the average of a set of positive numbers\n" +
                "3. Draw a box on screen";
        do {

            System.out.println(menu);
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    optionOne(scanner);
                    break;
                case "2":
                    optionTwo(scanner);
                    break;
                case "3":
                    optionThree(scanner);
                    break;
                default:
                    System.out.println("Invalid input");

            }
            System.out.println("Would you like to perform another operation?\n" +
                    "Type 'yes' to perform another operation, or any other words to exit: ");
            // Clean up the input buffer [\r\n+]
            scanner.skip("\\R?");
            input = scanner.nextLine();
        } while (input.trim().equals("yes"));
        scanner.close();
    }

    private static void optionThree(Scanner scanner) {
        int width = 0, height = 0;
        String box_width = "";

        System.out.println("Enter the width of the box to draw: ");
        width = scanner.nextInt();
        System.out.println("Enter the height of the box to draw: ");
        height = scanner.nextInt();

        for (int i = 0; i < width; i++) {
            box_width += "*";
        }
        for (int i = 0; i < height; i++) {
            System.out.println(box_width);
        }
    }

    private static void optionTwo(Scanner scanner) {
        System.out.println("Enter as many positive numbers as you'd like.\n" +
                "When you are finished, enter a negative number.");
        int number = 0, total = 0;
        int counter = 0;
        while (true) {
            number = scanner.nextInt();
            if (number < 0) break;
            total = total + number;
            counter++;
        }
        System.out.println("The average of all numbers you entered is: " + ((0.0 + total) / counter));
    }

    private static void optionOne(Scanner scanner) {
        Random random = new Random();
        int amount, max, min;
        System.out.println("How many numbers do you want to generation?");
        amount = scanner.nextInt();
        System.out.println("Enter the minimum number for the random number generation: ");
        min = scanner.nextInt();
        System.out.println("Enter the maximum number for the random number generation: ");
        max = scanner.nextInt();
        System.out.println("Here are the numbers that were generated: ");
        for (int i = 1; i <= amount; i++) {
            int output = random.nextInt(max);
            output += min;
            System.out.print(output + ", ");
        }
        System.out.println();
    }
}
