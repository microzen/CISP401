
public class Book {
    private String title;
    private String[] text;
    private int currentPage;
    protected final int SIZE_OF_BOOK = 5;
    public Book() {
        title = "";
        currentPage = 0;
        text = new String[this.SIZE_OF_BOOK];
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getCurrentPage(){
        return currentPage;
    }
    public void turnToPage(int page){
        if(page >= 0 && page < this.SIZE_OF_BOOK){
            this.currentPage = page;
        }
    }
    public void turnPage(){
        if(this.currentPage < this.SIZE_OF_BOOK - 1 || this.currentPage >= 0){
            this.currentPage++;
        }
    }
    public void turnToCover(){
        this.currentPage = 0;
    }
    public int getNumberOfPages(){
        return text.length;
    }

    /**
     * The getter for the text on the currently opened page of the book (which is a String)
     * @return
     */
    public String read(){
        return text[currentPage];
    }

    /**
     * The setter for the text on the currently opened page of the book (which is a String).
     * This method takes a String parameter and saves it in the pages array at the current page index.
     * @param text
     */
    public void writeOnPage(String text){
        this.text[currentPage] = text;
    }

}
