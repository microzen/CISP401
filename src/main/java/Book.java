
public class Book {
    private String title;
    private String[] text;
    private int currentPage;
    protected int sizeOfBook = 5;

    private void initBookSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Book size must be greater than 0");
        }
        this.sizeOfBook = size;
        this.text = new String[this.sizeOfBook];
    }

    /**
     * The default size of book is 5.
     */
    public Book() {
        setTitle("");
        initBookSize(5);
        turnToCover();
    }

    public Book(int size) {
        initBookSize(size);
        setTitle("");
        turnToCover();
    }

    public Book(String title) {
        this.initBookSize(5);
        this.setTitle(title);
        this.turnToCover();
    }
    public Book(String title, int size) {
        this.initBookSize(size);
        this.setTitle(title);
        this.turnToCover();
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void turnToPage(int page) {
        if (page >= 0 && page < this.sizeOfBook) {
            this.currentPage = page;
        }else{
            throw new IndexOutOfBoundsException("Invalid page number");
        }
    }

    public void turnPage() {
        if (this.currentPage < this.sizeOfBook - 1 || this.currentPage >= 0) {
            this.currentPage++;
        }else {
            throw new IndexOutOfBoundsException("Invalid page number");
        }
    }

    public void turnToCover() {
        this.currentPage = 0;
    }

    public int getNumberOfPages() {
        return text.length;
    }

    /**
     * The getter for the text on the currently opened page of the book (which is a String)
     *
     * @return text -on current page
     */
    public String read() {
        return text[currentPage];
    }
    public String read(int page) {
        int temp = this.getCurrentPage();
        this.turnToPage(page);
        String result = read();
        turnToPage(temp);
        return result;

    }

    /**
     * The setter for the text on the currently opened page of the book (which is a String).
     * This method takes a String parameter and saves it in the pages array at the current page index.
     *
     * @param text
     */
    public void writeOnPage(String text) {
        this.text[currentPage] = text;
    }

    public void writeOnPage(String text, int page) {
        int temp = this.currentPage;
        this.turnToPage(page);
        writeOnPage(text);
        this.turnToPage(temp);
    }



}
