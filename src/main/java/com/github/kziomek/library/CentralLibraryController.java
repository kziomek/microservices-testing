package com.github.kziomek.library;

import com.github.kziomek.library.model.Book;
import com.github.kziomek.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

/**
 * @author Krzysztof Ziomek
 * @since 01/03/2016.
 */
@RestController
@RequestMapping(value = "/central/api/v1/books", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class CentralLibraryController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> registerBook(@RequestParam(name = "inBranch", required = false) Boolean inBranch,
                                             @Valid @RequestBody Book book) {
        bookService.register(book, inBranch);
        return new ResponseEntity<>(OK);
    }
}
