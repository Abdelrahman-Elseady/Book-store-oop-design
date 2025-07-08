package org.example;

class BookstoreManager extends User {
    private Inventory inventory;

    public BookstoreManager(String name, String email, String address, Inventory inventory) {
        super(name, email, address);
        this.inventory = inventory;
    }

    public void addBook(Book book) {
        inventory.addBook(book);
        System.out.println("Book \"" + book.getTitle() + "\" added.");
    }

    public void removeOutdatedBooks(int currentYear, int maxAge) {
        inventory.removeOutdatedBooks(currentYear, maxAge);
    }

    public Inventory getInventory() {
        return inventory;
    }
}

