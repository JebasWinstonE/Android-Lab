package com.example.wilkinslibrary;

public class BookModel {
    private String isbnNumber;
    private String bookName;
    private String authorName;

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public BookModel(String isbnNumber, String bookName, String authorName) {
        this.isbnNumber = isbnNumber;
        this.bookName = bookName;
        this.authorName = authorName;
    }
}