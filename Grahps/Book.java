package library;

public class Book {
    private String code;
    private String title;
    private String author;
    private boolean available;

    public Book(String code, String title, String author) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", available=" + available +
                '}';
    }
}
