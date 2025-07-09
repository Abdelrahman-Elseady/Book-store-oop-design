package org.example;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        BookstoreManager manager = new BookstoreManager("ali", "ali@gmil.com", "Giza", inventory);

        manager.addBook(new PaperBook("123", "Effective Java", 2018, 50, "John", 10));
        manager.addBook(new PaperBook("456", "Clean Code", 2008, 49, "Mike", 5));
        manager.addBook(new EBook("789", "Design Patterns", 1994, 30, "Mahmoud", "PDF"));
        manager.addBook(new ShowcaseBook("999", "OOP", 1950, 1000, "Fady"));

        Client client1 = new Client("Abdo", "Abdo@gmail.com", "Dokki", 200.00);
        Client client2 = new Client("Samir", "Samir@gmail.com", "Cairo", 50.00);

        System.out.println("\n=== Test 1: Search books ===");
        System.out.println("Search by title 'Java':");
        client1.displayBooks(client1.searchBooks(inventory, new SearchFilter(null, "Java", null, null, null)));

        System.out.println("\nSearch by author 'Mike':");
        client1.displayBooks(client1.searchBooks(inventory, new SearchFilter(null, null, "Martin", null, null)));

        System.out.println("\nSearch by year 2008:");
        client1.displayBooks(client1.searchBooks(inventory, new SearchFilter(null, null, null, 2008, null)));

        System.out.println("\nSearch by type 'Paper':");
        client1.displayBooks(client1.searchBooks(inventory, new SearchFilter(null, null, null, null, "Paper")));

        System.out.println("\n=== Test 2: Client purchases ===");
        System.out.println("Abdo adds books to cart:");
        client1.addToCart(inventory.findBook("123"), 2);
        client1.addToCart(inventory.findBook("789"), 1);
        client1.addToCart(inventory.findBook("999"), 1);

        System.out.println("\nAbdo checks out:");
        client1.checkout();
        System.out.println("Abdo's balance: $" + client1.getBalance());

        System.out.println("\n=== Test 3: Insufficient funds ===");
        System.out.println("Samir tries to buy too many books:");
        client2.addToCart(inventory.findBook("123"), 5);
        client2.checkout();

        System.out.println("\n=== Test 4: Add funds and complete purchase ===");
        client2.addFunds(200.00);
        client2.checkout();
        System.out.println("Bob's balance: $" + client2.getBalance());

        System.out.println("\n=== Test 5: Out of stock scenario ===");
        Client client3 = new Client("Omar", "Omar@gmail.com", "New Cairo", 100.00);
        client3.addToCart(inventory.findBook("456"), 6);
        client3.checkout();

        System.out.println("\n=== Test 6: Remove outdated books ===");
        System.out.println("Before removal:");
        manager.displayBooks(manager.searchBooks(inventory, new SearchFilter(null, null, null, null, null)));

        manager.removeOutdatedBooks(2023, 10);

        System.out.println("\nAfter removal:");
        manager.displayBooks(manager.searchBooks(inventory, new SearchFilter(null, null, null, null, null)));


        System.out.println("\n=== Test 7: Empty cart ===");
        Client client4 = new Client("Mahmoud", "Mahmoud@gmail.com", "Maadi", 50.00);
        client4.checkout();
    }
}