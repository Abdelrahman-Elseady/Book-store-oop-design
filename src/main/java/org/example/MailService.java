package org.example;

class MailService implements DeliveryService {
    public void deliver(Book book, String email, String address) {
        System.out.println("Emailing \"" + book.getTitle() + "\" to " + email);
    }
}
