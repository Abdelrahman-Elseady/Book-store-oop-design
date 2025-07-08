package org.example;

class SearchFilter {
    private String isbn;
    private String keyword;
    private String author;
    private Integer year;
    private String bookType;

    public SearchFilter(String isbn, String keyword, String author, Integer year, String bookType) {
        this.isbn = isbn;
        this.keyword = keyword;
        this.author = author;
        this.year = year;
        this.bookType = bookType;
    }

    public String getIsbn() { return isbn; }
    public String getKeyword() { return keyword; }
    public String getAuthor() { return author; }
    public Integer getYear() { return year; }
    public String getBookType() { return bookType; }
}

