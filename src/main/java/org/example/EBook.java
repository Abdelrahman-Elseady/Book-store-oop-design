package org.example;

class EBook extends Book {
    private String fileType;

    public EBook(String isbn, String title, int year, double price, String author, String fileType) {
        super(isbn, title, year, price, author);
        this.fileType = fileType;
    }

    @Override
    public boolean isPurchasable() { return true; }

    @Override
    public void deliver(String email, String address, DeliveryService deliveryService) {
        deliveryService.deliver(this, email, address);
    }

    @Override
    public String getType() {
        return "EBook";
    }
}

