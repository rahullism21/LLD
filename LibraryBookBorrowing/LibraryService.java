package LibraryBookBorrowing;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class LibraryService {
    private ConcurrentHashMap<String, Book> hm= new ConcurrentHashMap<>();
     
    public void addBook(Book book){
        hm.put(book.getIsbn(),book);
    }

    public boolean borrowBook(String isbn){

        try {
             if(!hm.containsKey(isbn)){
            throw new IllegalArgumentException("Book with isbn "+isbn+" is not available ");
        }

        Book book=hm.get(isbn);

        synchronized (book){
            if(book.getAvailCopies()<=0){
                throw new IllegalArgumentException("No Available Copies for isbn :"+isbn);       
            }else{
                book.updateAvailCopies(-1);
                return true;
            }
        }
        } catch (Exception e) {
           System.out.println(e.getMessage()); 
        }
        return false;
       
   }

   public boolean returnBook(String isbn){

    try {
    if(!hm.containsKey(isbn)){
            throw new IllegalArgumentException("Book with isbn "+isbn+" is not available ");
        }
        Book book=hm.get(isbn);

        synchronized (book){
            book.updateAvailCopies(1);
                return true;
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    return false;
}

   List<Book> getAvailaBooksbyAuthor(String author){

      return hm.values().stream().filter(n-> n.getAuthor().equalsIgnoreCase(author))
                            .filter(n->n.getAvailCopies()>0)
                            .sorted(Comparator.comparing(Book::getTitle))
                            .collect(Collectors.toList());
   }
} 
