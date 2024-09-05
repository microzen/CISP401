import java.util.Scanner;
public class Discussion2 {
    public static void main(String[] args) {
        // A simple text scanner with java.io.InputStream
        Scanner scanner = new Scanner(System.in);
        // array with size 3
        int[] i = new int[3];
        int n = 0;
        // loop
        while (n < 3) {
            // output
            System.out.print("Enter a number: ");
            // input a number
            i[n] = scanner.nextInt();
            if (i[n] == 5) {
                System.out.println("You just entered a 5!");
            }
            else if(i[n] != 5) {
                System.out.println("You did not enter a 5.");
            }
            n++;
        }
    }
}
