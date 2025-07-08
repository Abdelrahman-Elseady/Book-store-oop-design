package org.example;

class ShippingService implements DeliveryService {
    public void deliver(Book book, String email, String address) {
        System.out.println("Shipping \"" + book.getTitle() + "\" to " + address);
    }

}

