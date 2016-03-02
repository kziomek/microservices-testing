package com.github.kziomek.library;

import com.github.kziomek.library.model.Book;
import com.github.kziomek.library.config.CentralLibraryClient;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 01/03/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MicroservicesTestingApplication.class)
@WebAppConfiguration
@IntegrationTest({"server.port=4000"})
@TestPropertySource("/test.properties")
@ActiveProfiles("mock")
public class CentralLibraryControllerIT {

    @Autowired
    private CentralLibraryClient centralLibraryClient;

    @Test
    public void shouldReturnTwoBooks() {

        List<Book> books = centralLibraryClient.getBooks();

        Assert.assertEquals(2, books.size());
        Assert.assertTrue(contains(books, "J.R.R. Tolkien"));
    }

    @Test
    public void shouldInvokeRegisterBookWithoutExcepton() {
        Book book = new Book("Frank Herbert", "Dune");
        centralLibraryClient.registerBook(true, book);
    }


    private boolean contains(List<Book> books, String author) {
        for (Book book : books) {
            if (author.equals(book.getAuthor())) {
                return true;
            }
        }
        return false;
    }

}
