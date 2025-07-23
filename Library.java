// Library.java
import java.util.*;

public class Library {
    private final HashMap<Integer, Book> books = new HashMap<>();
    private int nextId = 1;

    public int addBook(String title, String author) {
        Book book = new Book(nextId, title, author);
        books.put(nextId, book);
        return nextId++;
    }

    public String viewBooks() {
        if (books.isEmpty()) return "📂 No books in the library.";
        StringBuilder sb = new StringBuilder("📚 List of Books:\n\n");
        for (Book book : books.values()) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }

    public String borrowBook(int id) {
        Book b = books.get(id);
        if (b == null) return "❌ Book ID not found.";
        if (b.isBorrowed()) return "⚠️ Book already borrowed.";
        b.borrow();
        return "✅ You borrowed: " + b.getTitle();
    }

    public String returnBook(int id) {
        Book b = books.get(id);
        if (b == null) return "❌ Book ID not found.";
        if (!b.isBorrowed()) return "⚠️ This book wasn't borrowed.";
        b.returned();
        return "✅ Book returned: " + b.getTitle();
    }

    public String deleteBook(int id) {
        Book b = books.remove(id);
        return (b == null) ? "❌ Book not found." : "🗑️ Deleted: " + b.getTitle();
    }
}
