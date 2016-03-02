package com.github.kziomek.library.model;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Krzysztof Ziomek
 * @since 01/03/2016.
 */
public class Book {

    @NotEmpty
    private String author;

    @NotEmpty
    private String title;

    public Book() {

    }

    public Book(String author, String title) {
        setAuthor(author);
        setTitle(title);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
