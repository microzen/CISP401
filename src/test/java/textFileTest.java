import org.junit.jupiter.api.Test;
import sudoku.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class textFileTest {
    @Test
    void test() throws IOException, ClassNotFoundException {
        final String FILE = "sudoku.txt";
        SudokuBook book = new SudokuBook(3);
        SudokuPuzzle puzzle = SudokuGenerator.generatePuzzle("e");
        book.savePuzzle(puzzle,1);
        SudokuSaver.saveText(FILE,book);

        SudokuBook rbook = SudokuSaver.readText(FILE);
        assertEquals(book.getSize(),rbook.getSize());

        for (int i = 0; i < book.getSize(); i++) {
            if(book.getPuzzle(i) == null){
                assertNull(rbook.getPuzzle(i));
            }else{
                assertEquals(book.getPuzzle(i).toText(),rbook.getPuzzle(i).toText());
            }
        }

    }
}
