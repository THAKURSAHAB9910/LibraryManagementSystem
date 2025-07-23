// Book.java
public class Book {
    private int id;
    private String title;
    private String author;
    private boolean isBorrowed;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title.trim();
        this.author = author.trim();
        this.isBorrowed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }

    public void borrow() { isBorrowed = true; }
    public void returned() { isBorrowed = false; }

    public String toString() {
        return "📘 ID: " + id + " | " + title + " by " + author + (isBorrowed ? " [Borrowed]" : " [Available]");
    }
}
