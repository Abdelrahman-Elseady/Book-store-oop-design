package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Inventory {
    private Map<String, Book> books = new HashMap<>();

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book findBook(String isbn) {
        return books.get(isbn);
    }

    public List<Book> searchBooks(SearchFilter filter) {
        return books.values().stream()
                .filter(book -> {
                    if (filter.getIsbn() != null && !book.getIsbn().equalsIgnoreCase(filter.getIsbn()))
                        return false;
                    if (filter.getKeyword() != null && !book.getTitle().toLowerCase().contains(filter.getKeyword().toLowerCase()))
                        return false;
                    if (filter.getAuthor() != null && !book.getAuthor().toLowerCase().contains(filter.getAuthor().toLowerCase()))
                        return false;
                    if (filter.getYear() != null && book.getYear() != filter.getYear())
                        return false;
                    if (filter.getBookType() != null && !book.getType().equalsIgnoreCase(filter.getBookType()))
                        return false;
                    return true;
                })
                .collect(Collectors.toList());
    }

    public void removeOutdatedBooks(int currentYear, int maxAge) {
        books.values().removeIf(book -> {
            boolean outdated = currentYear - book.getYear() > maxAge;
            if (outdated)
                System.out.println("Removed outdated \"" + book.getTitle() + "\"");
            return outdated;
        });
    }
}

