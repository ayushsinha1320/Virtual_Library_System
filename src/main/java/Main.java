public class Main{
    public static void main(String[] args) throws Exception {
        Library library = new Library();
        library.batchUploadFromCSV("books.csv");
    }
}