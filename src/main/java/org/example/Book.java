package org.example;

public abstract class Book {
    protected String isbn;
    protected String title;
    protected int year;
    protected double price;
    protected String author;

    public Book(String isbn, String title, int year, double price, String author) {
        this.isbn = isbn;
        this.title = title;
        this.year = year;
        this.price = price;
        this.author = author;
    }

    public String getIsbn() { return isbn; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    public abstract boolean isPurchasable();
    public abstract void deliver(String email, String address, DeliveryService deliveryService);
    public abstract String getType();
}

