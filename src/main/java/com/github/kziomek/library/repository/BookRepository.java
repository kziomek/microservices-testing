package com.github.kziomek.library.repository;

import com.github.kziomek.library.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 01/03/2016.
 */
@Repository
public class BookRepository {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public List<Book> getAllBooks() {
        List<Book> books = new LinkedList<>();

        Book book = new Book("Frank Herbert", "Dune");
        books.add(book);

        return books;
    }

    public void register(Book book) {
        logger.info("Book registered. Title: {} , Author: {}", book.getTitle(), book.getAuthor());
    }
}
