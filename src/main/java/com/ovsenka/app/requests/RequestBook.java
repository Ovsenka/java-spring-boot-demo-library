package com.ovsenka.app.requests;

import com.ovsenka.app.entity.Book;

public class RequestBook{
    private Integer id;
    private String title;
    private String author;

    public RequestBook(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
    public RequestBook(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

}
