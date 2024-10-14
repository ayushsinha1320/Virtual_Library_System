import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private final List<Book> books = new ArrayList<>();

    public void batchUploadFromCSV(String filePath) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        int addedBooks = 0, skippedBooks = 0;

        while ((line = br.readLine()) != null) {
            String[] details = line.split(",");
            try {
                Book book = new Book(details[0], details[1], Integer.parseInt(details[2]), details[3],
                        LocalDate.parse(details[4]), Integer.parseInt(details[5]));
                books.add(book);
                addedBooks++;
            } catch (IllegalArgumentException e) {
                skippedBooks++;
            }
        }
        br.close();


        System.out.println("Books added: " + addedBooks);
        System.out.println("Books skipped (duplicate ISBNs): " + skippedBooks);
    }
    public List<Book> searchBooks(String query) {
        return books.stream()
                .filter(book -> book.getTitle().contains(query) ||
                        book.getAuthor().contains(query) ||
                        Integer.toString(book.getISBN()).contains(query))
                .collect(Collectors.toList());
    }

    public void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found matching the criteria.");
        } else {
            for (Book book : books) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", ISBN: " + book.getISBN());
            }
        }
    }

    public List<Book> filterBooks(List<Book> books, String genre, LocalDate startDate, LocalDate endDate) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre) &&
                        (book.getPublicationDate().isAfter(startDate) && book.getPublicationDate().isBefore(endDate)))
                .collect(Collectors.toList());
    }

    public void displayBookDetails(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getISBN());
        System.out.println("Genre: " + book.getGenre());
        System.out.println("Publication Date: " + book.getPublicationDate());
        System.out.println("Number of Copies: " + book.getNumberOfCopies());
        if (book.getNumberOfCopies() > 0) {
            System.out.println("Available Copies: " + book.getNumberOfCopies());
        } else {
            System.out.println("Out of Stock");
        }
    }
}