package lab;

import java.util.Random;
import java.util.Scanner;

public class MemoryGame {
    /**
     * Size of the row and column
     */
    final int SIZE = 4;
    /**
     * To store the card values
     */
    int[][] holder;
    /**
     * To store revealed card
     */
    boolean[][] visited;

    public static void main(String[] args) {

        MemoryGame game = new MemoryGame();
        int counter = 0;
        game.shuffle();

        while (true) {
            game.playerTurn();
            counter++;
            if (game.gameComplete()) {
                break;
            }

        }

        System.out.println("You win the game in " + counter + " turns.");

    }
    MemoryGame(){
        init();
    }

    /**
     * Initial the game.
     */
    void init() {
        this.holder = new int[this.SIZE][this.SIZE];
        // loop for init
        for (int i = 0; i < Math.pow(this.SIZE, 2); i++) {
            holder[i / this.SIZE][i % this.SIZE] = (i / 2) + 1;
        }
        this.visited = new boolean[this.SIZE][this.SIZE];
    }

    /**
     * Display and interface.
     */
    public void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        int x1, y1, x2, y2;

        display();

        while (true) {
            x1 = getValidNumber(scanner, "Enter the row of the first card you want to flip:");
            y1 = getValidNumber(scanner, "Enter the column of the first card you want to flip:");
            if (visited[x1][y1]) { //check if the card has revealed.
                System.out.println("You have already flipped the card. Please choose another one.");
            } else {
                break;
            }
        }

        display(x1, y1);

        while (true) {
            x2 = getValidNumber(scanner, "Enter the row of the second card you want to flip: ");
            y2 = getValidNumber(scanner, "Enter the column of the second card you want to flip: ");
            if ((x1 == x2 && y1 == y2) || visited[x2][y2]) { //check if the card has revealed.
                System.out.println("You have already flipped the card. Please choose another one.");
            } else {
                break;
            }
        }

        display(x1, y1, x2, y2);

        if (this.holder[x1][y1] == this.holder[x2][y2]) { //if match
            this.visited[x1][y1] = true;
            this.visited[x2][y2] = true;
            System.out.println("Match!!! " + this.holder[x1][y1]);
        } else {
            System.out.println("Not Match.");
        }
        System.out.println("Press enter to continue....");
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        scanner.nextLine();
    }

    /**
     * Display the game. Revealed card values are displayed, and unrevealed cards are shown as asterisks.
     */
    public void display() {
        display(-1, -1, -1, -1);
    }

    /**
     * Display the game with first choose position. Revealed card values are displayed, and unrevealed cards are shown as asterisks.
     * @param x first choose
     * @param y first choose
     */
    public void display(int x, int y) {
        display(x, y, -1, -1);
    }

    /**
     * Display the game with first and second chooses positions. Revealed card values are displayed, and unrevealed cards are shown as asterisks.
     * @param x1 first choose
     * @param y1 first choose
     * @param x2 second choose
     * @param y2 second choose
     */
    public void display(int x1, int y1, int x2, int y2) {
        String line = "   ";


        for (int i = 0; i < this.SIZE; i++) {
            line += ((i + 1) + " ");
        }
        // underline
        String utxt = String.join("\u0332", line.split("", -1));
        System.out.println(utxt);

        for (int i = 0; i < this.SIZE; i++) {
            String temp = "";
            temp += (i + 1) + "| ";
            for (int j = 0; j < this.SIZE; j++) {
                if (this.visited[i][j] || (i == x1 && j == y1) || (i == x2 && j == y2)) {
                    temp += holder[i][j] + " ";
                } else {
                    temp += "X ";
                }
            }
            System.out.println(temp);
        }
    }

    /**
     * To check does the game complete or not.
     * @return completion to true
     */
    public boolean gameComplete() {
        for (int i = 0; i < this.SIZE; i++) {
            for (int j = 0; j < this.SIZE; j++) {
                if (!visited[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Shuffle the position of the card.
     */
    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < this.SIZE; i++) {
            for (int j = 0; j < this.SIZE; j++) {
                // random a position
                int x = random.nextInt(this.SIZE);
                int y = random.nextInt(this.SIZE);

                // shift position of the card
                int temp = this.holder[i][j];
                this.holder[i][j] = this.holder[x][y];
                this.holder[x][y] = temp;
            }
        }

    }

    /**
     * To get a valid int number in the range of SIZE.
     * @param scanner input.
     * @param prompt prompt for client input.
     * @return client input
     */
    private int getValidNumber(Scanner scanner, String prompt) {
        int result = -1;
        while (true) {
            System.out.print(prompt);
            result = scanner.nextInt();
            if (result < 1 || result > this.SIZE) {
                System.out.println("Invalid number! Try again. Range from 1 to " + (this.SIZE));
            } else {
                return result - 1;
            }
        }
    }
}

