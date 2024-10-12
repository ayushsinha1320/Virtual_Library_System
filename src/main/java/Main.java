import java.time.LocalDate;
import java.util.*;

public class Main{
    public static void main(String[] args) {

    }
}

class Book{
    private final String Title;
    private final String Author;
    private final int ISBN;
    private final String Genre;
    private final LocalDate Publication_Date;
    private final int NumberOfCopies;

    private static Set<Integer> isbnSet = new HashSet<>();

    public Book(String title, String author, int isbn, String genre, LocalDate publication_Date, int numberOfCopies){
        if(checkISBN(isbn)){
            this.Title = title;
            this.Author = author;
            this.ISBN = isbn;
            this.Genre = genre;
            this.Publication_Date = publication_Date;
            this.NumberOfCopies = numberOfCopies;

            isbnSet.add(isbn);
        }else{
            throw new IllegalArgumentException("Enter unique ISBN number");
        }

    }

    private boolean checkISBN(int isbn){
        if(isbnSet.contains(isbn)){
            return false;
        }else{
            return true;
        }
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