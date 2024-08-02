package melquisedicrecalde.entities;

public class Book extends CatalogItem {
    private String author;
    private String genre;

    public Book(String code, String title, int publicationYear, int pageCount, String author, String genre) {
        super(code, title, publicationYear, pageCount);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book {" +
                " author= '" + author + '\'' +
                " , genre= '" + genre + '\'' +
                '}' + super.toString();
    }
}
