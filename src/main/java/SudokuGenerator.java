import java.util.Random;

public final class SudokuGenerator {
    private SudokuGenerator() {
    }

    // generates a new SudokuPuzzle object based on an existing grid of numbers
    public static SudokuPuzzle generatePuzzle(int[][] grid) {
        if (grid.length != 9 || grid[0].length != 9) return null;
        SudokuPuzzle p = new SudokuPuzzle(grid);
        if (solveSudoku(p) == null) {
            return null;
        }
        return p;
    }

    // randomly generates a new SudokuPuzzle object with the specified number of spaces filled
    // the puzzle is guaranteed to have at least one solution, but may have more than one valid solution

    // may take several minutes to complete
    public static SudokuPuzzle generatePuzzle(int spacesFilled) {
        Random rand = new Random();
        if (spacesFilled < 1 || spacesFilled > 80) return null;
        SudokuPuzzle p = new SudokuPuzzle();
        int number, row, column, filledBoxes = 0;
        while (filledBoxes < spacesFilled) {
            number = rand.nextInt(9) + 1;
            row = rand.nextInt(9);
            column = rand.nextInt(9);
            while (p.getNumberAt(row, column) != 0 || !
                    p.isValidEntry(number, row, column)) {
                number = rand.nextInt(9) + 1;
                row = rand.nextInt(9);
                column = rand.nextInt(9);
            }
            p.setStartingNumberAt(number, row, column);
            if (solveSudoku(p) == null) {
                p.setStartingNumberAt(0, row, column);
//                p.resetOriginalNumberAt(row, column);
            } else {
                filledBoxes++;
            }
        }
        return p;
    }
// randomly generates a new SudokuPuzzle object that only has one valid solution

    // the number of spaces filled will vary
// may take several minutes to complete
    public static SudokuPuzzle generateUnique() {
        Random rand = new Random();
        SudokuPuzzle p = generatePuzzle(80);
        int row, column, attempts = 0;
        while (attempts < 10) {
            do {
                row = rand.nextInt(9);
                column = rand.nextInt(9);
            } while (p.getNumberAt(row, column) == 0);
            SudokuPuzzle test = new SudokuPuzzle(p);
            test.setStartingNumberAt(0, row, column);
//            test.resetOriginalNumberAt(row, column);
            if (countSolutions(test) != 1) {
                attempts++;
            } else {
                p = test;
                attempts = 0;
            }
        }
        return p;
    }
// randomly generates a new SudokuPuzzle object based on the stated difficulty

    public static SudokuPuzzle generatePuzzle(String difficulty) {
        SudokuPuzzle p = null;
        switch (difficulty) {
            case "e":
            case "E":
            case "easy":
            case "Easy":
            case "EASY":
                p = generatePuzzle(40);
                break;
            case "m":
            case "M":
            case "medium":
            case "Medium":
            case "MEDIUM":
                p = generatePuzzle(30);
                break;
            case "h":
            case "H":
            case "hard":
            case "Hard":
            case "HARD":
                p = generatePuzzle(20);
                break;
            default:
                return null;
        }
        return p;
    }

    // randomly generates a medium difficulty puzzle
    public static SudokuPuzzle generatePuzzle() {
        return generatePuzzle("Medium");
    }

    // return a solution to the given puzzle, or null if none found
// utilizes recursion to solve the puzzle and may take minutes to complete
    public static SudokuPuzzle solveSudoku(SudokuPuzzle puzzle) {
        SudokuPuzzle copy = new SudokuPuzzle(puzzle);
        if (recursiveSolve(copy, 0, 0)) {
            return copy;
        } else {
            return null;
        }
    }

    // used internally by the solveSudoku method
    private static boolean recursiveSolve(SudokuPuzzle puzzle, int row, int col) {
        if (row == 9) return true;
        int nextCol = col + 1;
        int nextRow = row;
        if (nextCol == 9) {
            nextCol = 0;
            nextRow++;
        }
        if (puzzle.getNumberAt(row, col) != 0) {
            return recursiveSolve(puzzle, nextRow, nextCol);
        }
        for (int i = 1; i <= 9; i++) {
            if (puzzle.isValidEntry(i, row, col)) {
                puzzle.setNumberAt(i, row, col);
                if (recursiveSolve(puzzle, nextRow, nextCol)) return true;
            }
        }
        puzzle.setNumberAt(0, row, col);
        return false;
    }

    // Counts the number of valid solutions to a single puzzle
// utilizes recursion to solve the puzzle and may take minutes to complete
    public static int countSolutions(SudokuPuzzle puzzle) {
        SudokuPuzzle copy = new SudokuPuzzle(puzzle);
        int row = 0;
        int col = 0;
        return recursiveCount(copy, row, col);
    }

    // used internally by the countSolutions method
    private static int recursiveCount(SudokuPuzzle puzzle, int row, int col) {
        if (row == 9) return 1;
        int nextCol = col + 1;
        int nextRow = row;
        if (nextCol == 9) {
            nextCol = 0;
            nextRow++;
        }
        if (puzzle.getNumberAt(row, col) != 0) {
            return recursiveCount(puzzle, nextRow, nextCol);
        }
        int solutionsFound = 0;
        for (int i = 1; i <= 9; i++) {
            if (puzzle.isValidEntry(i, row, col)) {
                puzzle.setNumberAt(i, row, col);
                solutionsFound += recursiveCount(puzzle, nextRow, nextCol);
            }
        }
        puzzle.setNumberAt(0, row, col);
        return solutionsFound;
    }
}