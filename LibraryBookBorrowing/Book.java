package LibraryBookBorrowing;

public class Book {
    private String isbn;
    private String  title;
    private String author;
    private int availCopies;

    @Override
    public String toString() {
        return "Book [isbn=" + isbn + ", title=" + title + ", author=" + author + ", availCopies=" + availCopies + "]";
    }

    public Book(String isbn, String title , String author, int availCopies ){
        this.isbn=isbn;
        this.author=author;
        this.title=title;
        this.availCopies=availCopies;   
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public synchronized int getAvailCopies(){
        return availCopies;
    }

    public synchronized void updateAvailCopies(int copies){
        this.availCopies-=copies;
    }
    
}
