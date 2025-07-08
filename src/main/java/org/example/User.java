package org.example;
import java.util.List;

abstract class User {
    protected String name;
    protected String email;
    protected String address;

    public User(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public Book findBook(Inventory inventory, String isbn) {
        return inventory.findBook(isbn);
    }

    public List<Book> searchBooks(Inventory inventory, SearchFilter filter) {
        return inventory.searchBooks(filter);
    }

    public void displayBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No matching books found.");
            return;
        }
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() +
                    " | Year: " + book.getYear() + " | Price: $" + book.getPrice());
        }
    }

}

