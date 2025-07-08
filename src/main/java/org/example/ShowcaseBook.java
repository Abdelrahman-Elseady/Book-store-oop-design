package org.example;

class ShowcaseBook extends Book {
    public ShowcaseBook(String isbn, String title, int year, double price, String author) {
        super(isbn, title, year, price, author);
    }

    @Override
    public boolean isPurchasable() { return false; }

    @Override
    public void deliver(String email, String address, DeliveryService deliveryService) {
        System.out.println("Showcase book \"" + title + "\" is not for sale.");
    }


    @Override
    public String getType() {
        return "Demo";
    }
}
