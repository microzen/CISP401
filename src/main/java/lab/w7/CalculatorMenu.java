package lab.w7;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class CalculatorMenu {
    private static void addNums(final Scanner scanner, int[] array)
            throws InputMismatchException,
            ArrayIndexOutOfBoundsException {
        System.out.print("Enter the index of the first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter the index of the second number: ");
        int second = scanner.nextInt();

        int sum = array[first] + array[second];
        System.out.println("The sum of " + array[first] + " and " + array[second] + " is " + sum);
        System.out.println("Enter the index of the number to save the result: ");
        CalculatorMenu.arrayPrint(array);
        int index = scanner.nextInt();
        array[index] = sum;
        System.out.println("The sum saved at index " + index + " is: " + array[index]);
    }

    private static void subNums(final Scanner scanner, int[] array)
            throws InputMismatchException,
            ArrayIndexOutOfBoundsException,
            IllegalNumberException {
        System.out.print("Enter the index of the first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter the index of the second number: ");
        int second = scanner.nextInt();
        int difference = array[first] - array[second];
        if (difference < 0) {
            throw new IllegalNumberException("Result was negative, which is not allowed");
        }
        System.out.println("The difference of " + array[first] + " and " + array[second] + " is " + difference);
        System.out.println("Enter the index of the number to save the result: ");
        CalculatorMenu.arrayPrint(array);
        int index = scanner.nextInt();
        array[index] = difference;
        System.out.println("The difference saved at index " + index + " is: " + array[index]);
    }

    public static void multNums(final Scanner scanner, int[] array)
            throws IndexOutOfBoundsException, InputMismatchException {
        System.out.print("Enter the index of the first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter the index of the second number: ");
        int second = scanner.nextInt();
        int product = array[first] * array[second];
        System.out.println("The product of " + array[first] + " and " + array[second] + " is " + product);
        System.out.println("Enter the index of the number to save the result: ");
        CalculatorMenu.arrayPrint(array);
        int index = scanner.nextInt();
        array[index] = product;
        System.out.println("The product saved at index " + index + " is: " + array[index]);
    }

    public static void divNums(final Scanner scanner, int[] array)
            throws InputMismatchException, ArithmeticException, IndexOutOfBoundsException {
        System.out.print("Enter the index of the first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter the index of the second number: ");
        int second = scanner.nextInt();
        int quotient = array[first] / array[second];
        System.out.println("The quotient of " + array[first] + " and " + array[second] + " is " + quotient);
        System.out.println("Enter the index of the number to save the result: ");
        CalculatorMenu.arrayPrint(array);
        int index = scanner.nextInt();
        array[index] = quotient;
        System.out.println("The quotient saved at index " + index + " is: " + array[index]);
    }

    public static void modNums(final Scanner scanner, int[] array)
            throws ArithmeticException, InputMismatchException, IndexOutOfBoundsException {
        System.out.print("Enter the index of the first number: ");
        int first = scanner.nextInt();
        System.out.print("Enter the index of the second number: ");
        int second = scanner.nextInt();
        int modulus = array[first] % array[second];
        System.out.println("The modulus of " + array[first] + " and " + array[second] + " is " + modulus);
        System.out.println("Enter the index of the number to save the result: ");
        CalculatorMenu.arrayPrint(array);
        int index = scanner.nextInt();
        array[index] = modulus;
        System.out.println("The modulus saved at index " + index + " is: " + array[index]);
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int option;
        final String menu = "0: Print the array\n" +
                "1: Add two numbers\n" +
                "2: Subtract two numbers\n" +
                "3: Multiply two numbers\n" +
                "4: Divide two numbers\n" +
                "5: Modulo two numbers\n" +
                "6: Exit the program";

        for (int i = 0; i < 10; i++) {
            array[i] = rand.nextInt(200);
        }
        do {
            try {
                System.out.println(menu);
                System.out.print("Enter your choice: ");
                option = scanner.nextInt();
                if (option > 6 || option < 0) {
                    throw new IllegalNumberException("That is not a valid menu option");
                }
                switch (option) {
                    case 0:
                        arrayPrint(array);
                        break;
                    case 1:
                        addNums(scanner, array);

                        break;
                    case 2:
                        subNums(scanner, array);
                        break;
                    case 3:
                        multNums(scanner, array);
                        break;
                    case 4:
                        divNums(scanner, array);
                        break;
                    case 5:
                        modNums(scanner, array);
                        break;
                    case 6:
                        System.exit(0);
                }
            } catch (IllegalNumberException | IndexOutOfBoundsException e) {
                System.out.println("Exception! " + e.getMessage());
            } catch (InputMismatchException inputMismatchException) {
                // Clare the input buffer
                scanner.skip("\\R?");
                scanner.nextLine();
                System.out.println("Exception! " + inputMismatchException);
                System.out.println("Invalid input. Try again.");
            }
        } while (true);
    }

    private static void arrayPrint(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("Array: [");
        for (var item : array) {
            sb.append(item);
            sb.append(", ");
        }
        sb.append("]");
        System.out.println(sb);
    }
}
