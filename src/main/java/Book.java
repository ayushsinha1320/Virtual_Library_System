import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Book {
    private final String title;
    private final String author;
    private final int ISBN;
    private final String genre;
    private final LocalDate publicationDate;
    private final int numberOfCopies;

    private static final Set<Integer> isbnSet = new HashSet<>();

    public Book(String title, String author, int ISBN, String genre, LocalDate publicationDate, int numberOfCopies) {
        if (isUniqueISBN(ISBN)) {
            this.title = title;
            this.author = author;
            this.ISBN = ISBN;
            this.genre = genre;
            this.publicationDate = publicationDate;
            this.numberOfCopies = numberOfCopies;
            isbnSet.add(ISBN);
        } else {
            throw new IllegalArgumentException("ISBN must be unique");
        }
    }

    private boolean isUniqueISBN(int ISBN) {
        return !isbnSet.contains(ISBN);
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getISBN() { return ISBN; }
    public String getGenre() { return genre; }
    public LocalDate getPublicationDate() { return publicationDate; }
    public int getNumberOfCopies() { return numberOfCopies; }
}