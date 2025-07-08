package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create inventory
        Inventory inventory = new Inventory();

        // Create bookstore manager
        BookstoreManager manager = new BookstoreManager(
                "Abdo", "Abdo@gmail.com", "Giza", inventory);

        // Add books to inventory
        manager.addBook(new PaperBook("ISBN001", "OOP in Java", 2018, 45.99, "ali", 10));
        manager.addBook(new EBook("ISBN002", "learn c#", 2021, 25.50, "Mohamed", "PDF"));
        manager.addBook(new ShowcaseBook("ISBN003", "react", 1960, 1000.00, "Samir"));

        // Remove outdated books (older than 30 years)
        manager.removeOutdatedBooks(2025, 30);

        // Create client
        Client client = new Client("Hassan", "Hassan@gmail.com", "Dokki", 200.00);

        SearchFilter filter = new SearchFilter(null, "OOP", null, null, null);
        List<Book> searchResults = client.searchBooks(inventory, filter);
        System.out.println("\nSearch results for keyword 'OOP':");
        client.displayBooks(searchResults);

        Book bookToBuy = client.findBook(inventory, "ISBN001");
        if (bookToBuy != null) {
            client.addToCart(bookToBuy, 2);
        }
        client.checkout();

        Book nonPurchasable = client.findBook(inventory, "ISBN003");
        if (nonPurchasable != null) {
            client.addToCart(nonPurchasable, 1);
            client.checkout();
        }

        //views all books still in inventory
        List<Book> allBooks = client.searchBooks(inventory, new SearchFilter(null, null, null, null, null));
        System.out.println("\nAll books currently in inventory:");
        client.displayBooks(allBooks);
    }

}