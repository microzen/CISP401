package sudoku;

import java.io.Serializable;
import java.util.Iterator;

public class SudokuBook implements Iterator<SudokuPuzzle>, Serializable {
    public SudokuPuzzle[] puzzles;
    private int sizeOfPages;
    private int currentPage = 0;
    private void initSize(int size){
        this.sizeOfPages = size;
        puzzles = new SudokuPuzzle[sizeOfPages];
    }
    public SudokuBook(int sizeOfPages){
       initSize(sizeOfPages);
    }

    /**
     * the default size of page is 10.
     */
    public SudokuBook(){
        initSize(0);
    }
    public SudokuPuzzle getPuzzle(int index){
        if(index < 0 || index >= sizeOfPages){
            throw new IndexOutOfBoundsException("The specified index is out of bounds, size > " + sizeOfPages);
        }
        return puzzles[index];
    }
    public boolean hasPuzzle(int index){
        boolean hasPuzzle = false;
        try {
            hasPuzzle = getPuzzle(index) != null;
        }catch (IndexOutOfBoundsException e){
            hasPuzzle = false;
        }
        return hasPuzzle;
    }
    public boolean savePuzzle(SudokuPuzzle puzzle, int index){
        boolean hasPuzzle = hasPuzzle(index) ;
        if(!hasPuzzle){
            this.puzzles[index] = puzzle;
        }
        return hasPuzzle;
    }
    public void deletePuzzle(int index){
        if(hasPuzzle(index)){
            puzzles[index] = null;
        }
    }
    public static void main(String[] args) {
        int sizeOfPages = 4;
        SudokuBook book = new SudokuBook(sizeOfPages);

        book.savePuzzle(SudokuGenerator.generatePuzzle("Easy"),0);
        System.out.println("Generated Easy Puzzle");
        book.savePuzzle(SudokuGenerator.generatePuzzle("m"),1);
        System.out.println("Generated Mid Puzzle");
        book.savePuzzle(SudokuGenerator.generatePuzzle("h"),2);
        System.out.println("Generated Hard Puzzle");
        book.savePuzzle(SudokuGenerator.generateUnique(),3);
        System.out.println("Generated Unique Puzzle");

        book.forEachRemaining(puzzle->{
            System.out.format("\n[-------------------Sudoku %d---------------]\n",book.currentPage);
            puzzle.display();
            System.out.println("\n\n");
        });

        book.forEachRemaining(puzzle->{
            System.out.format("\n[---------------Sudoku %d Solution-----------]\n",book.currentPage);
            SudokuGenerator.solveSudoku(puzzle).display();
            System.out.println("\n\n");
        });
    }

    public int getSize(){
        return sizeOfPages;
    }

    @Override
    public boolean hasNext() {
        if(sizeOfPages >= (currentPage + 1)){
            return true;
        }else {
            currentPage = 0;
            return false;
        }
    }

    @Override
    public SudokuPuzzle next() {
        return puzzles[currentPage++];
    }
}
