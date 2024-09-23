import java.io.*;

public class SudokuSaver {
    /**
     * Row * Col * Size of Int in Bit * 2
     */
    private static final int SUDOKUSIZE = 9 * 9 * Integer.BYTES * 2;

    public static void saveBinary(String filename, SudokuBook book) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(book);
        out.close();
        fos.close();
    }

    public static SudokuBook readBinary(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fis);
        Object obj = in.readObject();
        SudokuBook book = (SudokuBook) obj;
        return book;
    }

    public static void saveRABook(String filename, SudokuBook book) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        while (book.hasNext()) {
            SudokuPuzzle puzzle = book.next();
            if (puzzle == null) {
                long index = raf.getFilePointer();
                index += (SUDOKUSIZE);
                raf.writeInt(-1);
                raf.seek(index);
            } else {
                outputRAPuzzle(raf, puzzle);
            }
        }
        raf.close();
    }

    public static SudokuBook readRABook(String filename) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(filename, "r");
        long size = raf.length() / SUDOKUSIZE;
        if (raf.length() % SUDOKUSIZE != 0) {
            size++;
        }
        SudokuBook book = new SudokuBook((int) size);
        for (int index = 0; index < size; index++) {
            raf.seek(index * SUDOKUSIZE);
            if (raf.readInt() < 0) {
                continue;
            } else {
                raf.seek(index * SUDOKUSIZE);
                book.savePuzzle(inputRAPuzzle(raf), index);
            }
        }
        raf.close();
        return book;
    }

    public static void saveRAPuzzle(String filename, SudokuPuzzle puzzle, int position) throws IOException {
        long index = position * SUDOKUSIZE;
        RandomAccessFile raf = new RandomAccessFile(filename, "rw");
        raf.seek(index);
        if (puzzle == null) {
            raf.writeInt(-1);
        } else {
            outputRAPuzzle(raf, puzzle);
        }
        raf.close();
    }

    public static SudokuPuzzle readRAPuzzle(String filename, int position) throws IOException {
        SudokuPuzzle puzzle;
        RandomAccessFile raf = new RandomAccessFile(filename, "r");
        long index = position * SUDOKUSIZE;
        raf.seek(index);
        if (raf.readInt() < 0) {
            puzzle = null;
        } else {
            raf.seek(index);
            puzzle = inputRAPuzzle(raf);
        }
        raf.close();
        return puzzle;
    }

    private static void outputRAPuzzle(final DataOutput out, SudokuPuzzle puzzle) throws IOException {

        SudokuPuzzle originalPuzzle = new SudokuPuzzle(puzzle);
        originalPuzzle.resetPuzzle();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                out.writeInt(originalPuzzle.getNumberAt(i, j));
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                out.writeInt(puzzle.getNumberAt(i, j));
            }
        }
    }

    private static SudokuPuzzle inputRAPuzzle(final DataInput in) throws IOException {
        SudokuPuzzle puzzle = new SudokuPuzzle();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int number = in.readInt();
                puzzle.setStartingNumberAt(number, i, j);
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int number = in.readInt();
                puzzle.setNumberAt(number, i, j);
            }
        }
        return puzzle;
    }


    public static void saveText(String filename, SudokuBook book) throws IOException {
        FileWriter fw = new FileWriter(filename);
        StringBuilder sb = new StringBuilder();
        sb.append(book.getSize()).append("\n");
        while (book.hasNext()) {
            SudokuPuzzle puzzle = book.next();
            if (puzzle != null) {
                SudokuPuzzle originalPuzzle = new SudokuPuzzle(puzzle);
                originalPuzzle.resetPuzzle();
                sb.append("original\n").append(originalPuzzle.toText());
                sb.append("grid\n").append(puzzle.toText());
            } else {
                sb.append("-1").append("\n");
            }
        }
        fw.write(sb.toString());
        fw.flush();
        fw.close();
    }

    public static SudokuBook readText(String filename) throws IOException, ClassNotFoundException {
        String ex = "x x x |x x x |x x x ";
        boolean[] isp = new boolean[20];
        for (int i = 0; i < 20; i++) {
            if (ex.charAt(i) == 'x') {
                isp[i] = true;
            }
        }

        BufferedReader reader = new BufferedReader(new FileReader(filename));

        int size = Integer.parseInt(reader.readLine());
        SudokuBook book = new SudokuBook(size);
        String line = reader.readLine();
        for (int bookIndex = 0; bookIndex < size; bookIndex++) {

            if (line.equals("-1")){
                line = reader.readLine();
                continue;
            }

            SudokuPuzzle puzzle = new SudokuPuzzle();
            String state = "";
            int row = 0;
            for (int i = 0; i < 24; i++) {

                if (line.charAt(1) == '-') {
                    line = reader.readLine();
                    continue;
                } else if (line.trim().equals("original")) {
                    state = line;
                    line = reader.readLine();
                    continue;
                } else if (line.trim().equals("grid")) {
                    state = line;
                    line = reader.readLine();
                    continue;
                } else {
                    int col = 0;
                    for (int j = 0; j < isp.length; j++) {
                        if(isp[j]){
                            char ch = line.charAt(j);
                            if (ch != ' ') {
                                Integer num = Integer.parseInt(ch + "");
                                if (state.equals("grid")) {
                                    puzzle.setNumberAt(num, row, col);
                                } else {
                                    puzzle.setStartingNumberAt(num, row, col);
                                }
                            }
                            col++;
                        }
                    }
                    row++;
                }
                line = reader.readLine();
            }
            book.savePuzzle(puzzle, bookIndex);
        }
        reader.close();
        return book;
    }
}
