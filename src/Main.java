import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Book {
    private String title;
    private String author;
    private int publicationYear;
    private int pages;
    private String category;
    private boolean isOnLoan;

    public Book(String title, String author, int publicationYear, int pages, String category) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.pages = pages;
        this.category = category;
        this.isOnLoan = false;
    }

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getPages() {
        return pages;
    }

    public String getCategory() {
        return category;
    }

    public boolean isOnLoan() {
        return isOnLoan;
    }

    public void setOnLoan(boolean onLoan) {
        isOnLoan = onLoan;
    }
}

class Library {
    private List<Book> books;
    private Map<String, Double> lateFees;  // Mapping of library card numbers to late fees

    public Library() {
        books = new ArrayList<>();
        lateFees = new HashMap<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    public List<Book> findBooksByYear(int year) {
        return books.stream()
                .filter(book -> book.getPublicationYear() == year)
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    public Book findBookWithMostPages() {
        return books.stream()
                .max(Comparator.comparingInt(Book::getPages))
                .orElse(null);
    }

    public List<Book> findBooksByMinPages(int minPages) {
        return books.stream()
                .filter(book -> book.getPages() > minPages)
                .collect(Collectors.toList());
    }

    public void printBookTitlesSorted() {
        books.stream()
                .map(Book::getTitle)
                .sorted()
                .forEach(System.out::println);
    }

    public List<Book> findBooksByCategory(String category) {
        return books.stream()
                .filter(book -> book.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    public void loanBook(Book book, String libraryCardNumber) {
        if (!book.isOnLoan()) {
            book.setOnLoan(true);
            // Add the book to the user's list of borrowed books
            // (assuming User class with appropriate methods)
            User user = findUserByLibraryCardNumber(libraryCardNumber);
            if (user != null) {
                user.borrowBook(book);
            }
        }
    }

    public void returnBook(Book book, String libraryCardNumber) {
        book.setOnLoan(false);
        // Remove the book from the user's list of borrowed books
        // (assuming User class with appropriate methods)
        User user = findUserByLibraryCardNumber(libraryCardNumber);
        if (user != null) {
            user.returnBook(book);
        }
    }

    private User findUserByLibraryCardNumber(String libraryCardNumber) {
        // Implementation to find a user by library card number
        return null;
    }

    public void registerUser(User user) {
        // Implementation to register a user
    }
}
