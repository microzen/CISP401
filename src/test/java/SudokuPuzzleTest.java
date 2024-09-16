import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SudokuPuzzleTest {

    @Test
    void setNumber() {
        final SudokuPuzzle sudokuPuzzle = new SudokuPuzzle();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertTrue(sudokuPuzzle.setNumberAt(1,i,j));
            }
        }
    }
    @Test
    void checkStaringNumber(){
        final SudokuPuzzle sudokuPuzzle = new SudokuPuzzle();

        assertTrue(sudokuPuzzle.setStartingNumberAt(1,0,0));
        assertTrue(sudokuPuzzle.setStartingNumberAt(2,5,5));

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if((i == 0 && j==0) || (i==5 && j==5)){
                    assertFalse(sudokuPuzzle.isValidEntry(1,i,j));
                }else{
                    assertTrue(sudokuPuzzle.setNumberAt(1,i,j));
                }
            }
        }

        sudokuPuzzle.resetPuzzle();

        assertTrue(sudokuPuzzle.setNumberAt(1,3,6));
        assertEquals(0,sudokuPuzzle.getNumberAt(3,3));
        assertEquals(1,sudokuPuzzle.getNumberAt(0,0));
    }
    @Test
    void getNumberTest(){
        final SudokuPuzzle sudokuPuzzle = new SudokuPuzzle();
        assertEquals(0,sudokuPuzzle.getNumberAt(1,1));
        assertEquals(-1,sudokuPuzzle.getNumberAt(1,9));

        sudokuPuzzle.setStartingNumberAt(1,0,0);
        assertEquals(1,sudokuPuzzle.getNumberAt(0,0));

        sudokuPuzzle.setStartingNumberAt(1,2,6);
        assertEquals(1,sudokuPuzzle.getNumberAt(2,6));
        sudokuPuzzle.setStartingNumberAt(9,2,2);
        assertEquals(9,sudokuPuzzle.getNumberAt(2,2));
        sudokuPuzzle.setStartingNumberAt(1,3,3);
        assertEquals(1,sudokuPuzzle.getNumberAt(3,3));
        sudokuPuzzle.setStartingNumberAt(1,5,2);
        assertEquals(1,sudokuPuzzle.getNumberAt(5,2));
        sudokuPuzzle.setStartingNumberAt(2,5,5);
        assertEquals(2,sudokuPuzzle.getNumberAt(5,5));
        sudokuPuzzle.setStartingNumberAt(6,5,8);
        assertEquals(6,sudokuPuzzle.getNumberAt(5,8));

    }
}
