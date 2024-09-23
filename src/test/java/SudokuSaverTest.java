import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

public class SudokuSaverTest {
    @Test
    void binaryBookSaverTest() throws IOException, ClassNotFoundException {
        final String FILENAME = "sudoku-puzzle-saver.bin";
        File file = new File(FILENAME);
        file.deleteOnExit();

        SudokuBook book = initBookAndPuzzle();
        SudokuSaver.saveBinary(FILENAME,book);
        SudokuBook rbook = SudokuSaver.readBinary(FILENAME);
        bookCheck(rbook);

        file.deleteOnExit();
    }
    @Test
    void accessRBookSaverTest() throws IOException {
        final String FILENAME = "sudoku-puzzle-saver.data";
        File file = new File(FILENAME);
        file.deleteOnExit();

        SudokuBook book = this.initBookAndPuzzle();
        SudokuSaver.saveRABook(FILENAME,book);
        SudokuBook rbook = SudokuSaver.readRABook(FILENAME);
        bookCheck(rbook);
        puzzleCheck(rbook.getPuzzle(1));

        SudokuBook book1 = new SudokuBook(1);
        SudokuSaver.saveRABook(FILENAME,book1);
        SudokuBook rbook1 = SudokuSaver.readRABook(FILENAME);

        assertNotEquals(1,rbook1.getSize());


        file.deleteOnExit();
    }
    @Test
    void accessRPuzzleSaverTest() throws IOException {
        final String FILENAME = "sudoku-puzzle-saver.data";
        File file = new File(FILENAME);
        file.deleteOnExit();

        SudokuBook book = this.initBookAndPuzzle();
        SudokuSaver.saveRAPuzzle(FILENAME,book.getPuzzle(1),0);

        SudokuPuzzle rpuzzle = SudokuSaver.readRAPuzzle(FILENAME,0);
        puzzleCheck(rpuzzle);

        SudokuBook rbook = SudokuSaver.readRABook(FILENAME);
        puzzleCheck(rbook.getPuzzle(0));

        SudokuSaver.saveRAPuzzle(FILENAME,null,2);
        SudokuBook rbook1 = SudokuSaver.readRABook(FILENAME);
        assertNull(rbook1.getPuzzle(2));
        file.deleteOnExit();
    }

    SudokuBook initBookAndPuzzle(){
        SudokuBook book = new SudokuBook(3);

        SudokuPuzzle sudoku = new SudokuPuzzle();
        /*
         (8,8)->8
         (0,0)->1
         (1,0)->1
         */
        sudoku.setStartingNumberAt(8,8,8);
        sudoku.setNumberAt(1,0,0);
        sudoku.setNumberAt(1,1,0);

        book.savePuzzle(sudoku, 1);

        return book;
    }
    void bookCheck(SudokuBook book){
        assertEquals(3,book.getSize(),"Size mismatch");

        assertThrowsExactly(IndexOutOfBoundsException.class,()->{
            book.getPuzzle(4);
        });


    }
    void puzzleCheck(SudokuPuzzle sudoku){
        // equal
        assertEquals(8,sudoku.getNumberAt(8,8));
        assertEquals(0,sudoku.getNumberAt(1,1));
        assertEquals(1,sudoku.getNumberAt(0,0));

        // not equal
        assertNotEquals(0,sudoku.getNumberAt(1,0));
        assertNotEquals(1,sudoku.getNumberAt(1,1));
        assertNotEquals(1,sudoku.getNumberAt(2,2));
    }

}
