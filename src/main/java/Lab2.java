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
                    break;
                default:

            }
            System.out.println("Would you like to perform another operation?\n" +
                    "Type 'yes' to perform another operation, or any other words to exit.");
            // Clean up the input buffer [\r\n+]
            scanner.skip("\\R?");
            input = scanner.nextLine();
        } while (input.equals("yes"));
        scanner.close();
    }

    private static void optionOne(Scanner scanner) {
        Random random = new Random();
        int amount, max, min;
        System.out.println("How many numbers do you want to generation?");
        amount = scanner.nextInt();
        System.out.println("Enter the minimum number for the random number generation");
        min = scanner.nextInt();
        System.out.println("Enter the maximum number for the random number generation");
        max = scanner.nextInt();
        System.out.println("Here are the numbers that were generated:");
        for (int i = 1; i <= amount; i++) {
            int output = random.nextInt(max);
            output += min;
            System.out.print(output + ", ");
        }
        System.out.println();
    }
}
