package com.github.kziomek.library.service;

import com.github.kziomek.library.client.BranchLibraryClient;
import com.github.kziomek.library.model.Book;
import com.github.kziomek.library.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 01/03/2016.
 */
@Service
public class BookService {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BranchLibraryClient branchLibraryClient;


    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.getAllBooks();
        try {
            books.addAll(branchLibraryClient.getBooks());
        } catch (Exception ex) {
            //catch exception, log message and continue method
            logger.error("Failed query to branch library", ex);
        }
        return books;
    }

    public void register(Book book, Boolean inBranch) {
        if (inBranch) {
            branchLibraryClient.register(book);
        } else {
            bookRepository.register(book);
        }
    }
}
