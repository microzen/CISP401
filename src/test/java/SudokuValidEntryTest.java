import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SudokuValidEntryTest {
    @Test
    void testRangeOfRowAndColumn() {
        final SudokuPuzzle sudokuPuzzle = new SudokuPuzzle();
        int value = 1;
        // Check
        assertTrue(sudokuPuzzle.isValidEntry(value,0,0));
    }
    @Test
    void testRangeOfValue(){
        final SudokuPuzzle sudokuPuzzle = new SudokuPuzzle();
        int row = 0,column = 0;
        assertTrue(sudokuPuzzle.isValidEntry(1,row,column));
        assertTrue(sudokuPuzzle.isValidEntry(5,row,column));
        assertTrue(sudokuPuzzle.isValidEntry(9,row,column));
        assertFalse(sudokuPuzzle.isValidEntry(10,row,column));
        assertFalse(sudokuPuzzle.isValidEntry(-1,row,column));

        // ?
//        assertTrue(sudokuPuzzle.isValidEntry(0,row,column));
    }
    @Test
    void validRowAndColumn() {
        final SudokuPuzzle sudokuPuzzle = new SudokuPuzzle();
        int value = 1;
        int row = 2,column = 2;

        sudokuPuzzle.setStartingNumberAt(value,row,column);

        assertFalse(sudokuPuzzle.isValidEntry(value,row,2));
        assertFalse(sudokuPuzzle.isValidEntry(value,row,3));
        assertFalse(sudokuPuzzle.isValidEntry(value,5,column));
        assertFalse(sudokuPuzzle.isValidEntry(value,0,column));

        assertFalse(sudokuPuzzle.isValidEntry(value,0,0));
        assertTrue(sudokuPuzzle.isValidEntry(1,3,3));
        sudokuPuzzle.setNumberAt(1,3,3);
        assertFalse(sudokuPuzzle.isValidEntry(1,3,3));
        assertFalse(sudokuPuzzle.isValidEntry(1,5,5));
    }
}
