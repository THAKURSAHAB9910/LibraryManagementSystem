// LibraryApp.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LibraryApp extends JFrame {
    private final Library library = new Library();
    private final JTextArea displayArea = new JTextArea();

    public LibraryApp() {
        setTitle("✨ Library Management System");
        setSize(700, 550);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(new Color(255, 255, 240));

        JLabel title = new JLabel("📚 Library System", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 26));
        title.setForeground(new Color(40, 40, 90));
        add(title, BorderLayout.NORTH);

        displayArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        displayArea.setEditable(false);
        displayArea.setBackground(new Color(250, 250, 250));
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        String[] actions = {"Add Book", "View Books", "Borrow Book", "Return Book", "Delete Book", "Clear"};
        for (String text : actions) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("SansSerif", Font.BOLD, 14));
            btn.setBackground(new Color(240, 248, 255));
            btn.addActionListener(new ButtonHandler());
            buttonPanel.add(btn);
        }

        add(buttonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "Add Book":
                    String title = JOptionPane.showInputDialog("Enter Book Title:");
                    String author = JOptionPane.showInputDialog("Enter Author Name:");
                    if (title != null && author != null && !title.isBlank() && !author.isBlank()) {
                        int id = library.addBook(title, author);
                        displayArea.append("📌 Book Added → ID: " + id + "\n");
                    } else {
                        displayArea.append("❗ Title or Author cannot be empty.\n");
                    }
                    break;

                case "View Books":
                    displayArea.setText(library.viewBooks());
                    break;

                case "Borrow Book":
                    try {
                        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID to borrow:"));
                        displayArea.append(library.borrowBook(id) + "\n");
                    } catch (Exception ex) {
                        displayArea.append("⚠️ Invalid ID input.\n");
                    }
                    break;

                case "Return Book":
                    try {
                        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID to return:"));
                        displayArea.append(library.returnBook(id) + "\n");
                    } catch (Exception ex) {
                        displayArea.append("⚠️ Invalid ID input.\n");
                    }
                    break;

                case "Delete Book":
                    try {
                        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID to delete:"));
                        displayArea.append(library.deleteBook(id) + "\n");
                    } catch (Exception ex) {
                        displayArea.append("⚠️ Invalid ID input.\n");
                    }
                    break;

                case "Clear":
                    displayArea.setText("");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new LibraryApp();
    }
}
