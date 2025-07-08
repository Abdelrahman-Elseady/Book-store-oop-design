package org.example;

class PaperBook extends Book {
    private int stock;

    public PaperBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author);
        this.stock = stock;
    }

    public int getStock() { return stock; }

    public void reduceStock(int quantity) {
        if (quantity > stock)
            throw new IllegalArgumentException("Quantum book store: Not enough stock.");
        stock -= quantity;
    }
    public void increaseStock(int quantity) {
        stock += quantity;
    }

    @Override
    public boolean isPurchasable() { return stock > 0; }

    @Override
    public void deliver(String email, String address, DeliveryService deliveryService) {
        deliveryService.deliver(this, email, address);
    }

    @Override
    public String getType() {
        return "Paper";
    }
}

