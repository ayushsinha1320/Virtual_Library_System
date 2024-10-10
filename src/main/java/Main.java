import java.time.LocalDate;
public class Main{
    public static void main(String[] args) {
        LocalDate publication_date = LocalDate.of(2024,10,1);
        Book b1 = new Book("Book1","John", 13, "Horror", publication_date,1);
    }
}

class Book{
    private final String Title;
    private final String Author;
    private final int ISBN;
    private final String Genre;
    private final LocalDate Publication_Date;
    private final int NumberOfCopies;

    public Book(String title, String author, int isbn, String genre, LocalDate publication_Date, int numberOfCopies){
        this.Title = title;
        this.Author = author;
        this.ISBN = isbn;
        this.Genre = genre;
        this.Publication_Date = publication_Date;
        this.NumberOfCopies = numberOfCopies;
    }

    public String getAuthor(){
        return this.Author;
    }

    public String getTitle(){
        return this.Title;
    }

    public int getISBN() {
        return ISBN;
    }

    public String getGenre() {
        return Genre;
    }

    public LocalDate getPublication_Date() {
        return Publication_Date;
    }
}