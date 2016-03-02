package com.github.kziomek.library.config;

import com.github.kziomek.library.model.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 01/03/2016.
 */
@Path("/central/api/v1/books")
public interface CentralLibraryClient {

    @GET
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    List<Book> getBooks();

    @POST
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    void registerBook(
            @QueryParam(value = "inBranch") Boolean inBranch,
            @RequestBody Book book);
}
