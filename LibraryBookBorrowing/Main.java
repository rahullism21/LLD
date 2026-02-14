package LibraryBookBorrowing;

public class Main {
    public static void main(String[] args) {
        LibraryService library= new LibraryService();

        library.addBook(new Book("123", "Da Vinci Code", "Dan Brown", 200));
library.addBook(new Book("124", "Angels & Demons", "Dan Brown", 150));
library.addBook(new Book("125", "Inferno", "Dan Brown", 180));
library.addBook(new Book("126", "Harry Potter and the Sorcerer's Stone", "J.K. Rowling", 300));
library.addBook(new Book("127", "Harry Potter and the Chamber of Secrets", "J.K. Rowling", 250));
library.addBook(new Book("128", "The Hobbit", "J.R.R. Tolkien", 1));
library.addBook(new Book("129", "The Lord of the Rings", "J.R.R. Tolkien", 100));
library.addBook(new Book("130", "Pride and Prejudice", "Jane Austen", 1));
library.addBook(new Book("131", "1984", "George Orwell", 0));
library.addBook(new Book("132", "To Kill a Mockingbird", "Harper Lee", 110));


        System.out.println(library.borrowBook("123")==true ? "Book Borrowed" :"Cant Borrow");
        System.out.println(library.borrowBook("130")==true ? "Book Borrowed" :"Cant Borrow");
        System.out.println(library.borrowBook("131")==true ? "Book Borrowed" :"Cant Borrow");
        System.out.println(library.borrowBook("140")==true ? "Book Borrowed" :"Cant Borrow");


        System.out.println(library.returnBook("123")==true ? "Book returned" :"Cant Return");
        System.out.println(library.returnBook("130")==true ? "Book returned" :"Cant Return");
        System.out.println(library.returnBook("131")==true ? "Book returned" :"Cant Return");
        System.out.println(library.returnBook("140")==true ? "Book returned" :"Cant Return");

        System.out.println(library.getAvailaBooksbyAuthor("J.K. Rowling"));
        System.out.println(library.getAvailaBooksbyAuthor("Dan Brown"));
        }
}
    