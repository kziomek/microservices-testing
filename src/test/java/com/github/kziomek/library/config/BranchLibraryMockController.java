package com.github.kziomek.library.config;

import com.github.kziomek.library.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


/**
 * @author Krzysztof Ziomek
 * @since 01/03/2016.
 */
@RestController
@RequestMapping(value = "/branch/api/v1/books")
@Profile("mock")
public class BranchLibraryMockController {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(method = GET)
    public ResponseEntity<List<Book>> getBooks() {
        logger.info("BranchLibraryMockController.getBooks() invoked.");

        List<Book> books = new LinkedList<>();

        Book book = new Book("J.R.R. Tolkien", "The Lord of the Rings");
        books.add(book);

        return new ResponseEntity<>(books, OK);

    }

    @RequestMapping(method = POST)
    public ResponseEntity<Void> registerBook(@Valid @RequestBody Book book) {
        logger.info("BranchLibraryMockController.registerBook() invoked.");
        return new ResponseEntity<>(OK);
    }
}
