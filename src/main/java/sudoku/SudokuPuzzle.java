package sudoku;

import java.io.Serializable;

public class SudokuPuzzle implements Serializable {
    private int[][] grid;
    private int[][] original;

    public SudokuPuzzle() {
        this.grid = new int[9][9];
        this.original = new int[9][9];
    }

    public SudokuPuzzle(int[][] grid) {
        if (grid.length != 9 || grid[0].length != 9) {
            throw new IllegalArgumentException("Grid must have 9x9 numbers only.");
        }
        this.grid = new int[9][9];
        this.original = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.grid[i][j] = grid[i][j];
                this.original[i][j] = grid[i][j];
            }
        }
    }

    public SudokuPuzzle(SudokuPuzzle copy) {
        this.grid = new int[9][9];
        this.original = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.grid[i][j] = copy.grid[i][j];
                this.original[i][j] = copy.original[i][j];
            }
        }
    }

    /**
     * Che the row and col that have to be in the range (0 - 8)
     *
     * @param row
     * @param col
     * @return
     */
    private boolean validRowAndColNumber(int row, int col) {
        if (row < 0 || row >= 9 || col < 0 || col >= 9) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Check the value if it is in the range (1-9) or not.
     *
     * @param value
     * @return True when value in the range 1 - 9.
     */
    private boolean validValue(int value) {
        return value >= 0 && value <= 9;
    }

    public int getNumberAt(int row, int col) {
        return this.validRowAndColNumber(row, col) ? this.grid[row][col] : -1;
    }

    public boolean setNumberAt(int number, int row, int col) {
//        boolean result = this.isValidEntry(value, row, col);
        boolean result = this.validRowAndColNumber(row, col) && this.validValue(number);

        // if original row and col has value, should set result to false
        result = result && this.original[row][col] == 0;
        if (result) {
            this.grid[row][col] = number;
        }
        return result;
    }

    public boolean setStartingNumberAt(int number, int row, int col) {
//        boolean result = this.isValidEntry(number, row, col);
        boolean result = this.validRowAndColNumber(row, col) && this.validValue(number);
        if (result) {
            this.grid[row][col] = number;
            this.original[row][col] = number;
        }
        return result;
    }

//    public boolean resetOriginalNumberAt(int row, int col) {
//        boolean result = this.validRowAndColNumber(row, col);
//        if (result) {
//            this.grid[row][col] = 0;
//            this.original[row][col] = 0;
//        }
//        return result;
//    }

    public boolean isValidEntry(int number, int row, int col) {
        boolean result = this.validRowAndColNumber(row, col) && this.validValue(number);

        // if original row and col has value, should set result to false
        result = result && this.original[row][col] == 0;

        if (result) {
            for (int i = 0; i < 9; i++) {
                if (this.grid[row][i] == number) {
                    return false;
                }
                if (this.grid[i][col] == number) {
                    return false;
                }
            }

            int rrow = (row / 3) * 3;
            int ccol = (col / 3) * 3;
            for (int i = rrow; i < rrow + 3; i++) {
                for (int j = ccol; j < ccol + 3; j++) {
                    if (this.grid[i][j] == number) {
                        return false;
                    }
                }
            }
        }

        return result;
    }

    public void resetPuzzle() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                this.grid[row][col] = this.original[row][col];
            }
        }
    }

    public void display() {
        System.out.println(this.toText());
    }
    public String toText(){
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                String output = String.format("%s ", grid[row][col] == 0 ? " " : grid[row][col]);
                sb.append(output);
                if ((col+1) % 3 == 0 && col < 8) {
                    sb.append("|");
                }
            }
            if ( (row+1) % 3 == 0 && row < 8) {
                sb.append("\n").append("-".repeat(20));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
