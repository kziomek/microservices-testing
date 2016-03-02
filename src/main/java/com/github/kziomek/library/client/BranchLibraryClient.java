package com.github.kziomek.library.client;

import com.github.kziomek.library.model.Book;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;

import javax.ws.rs.*;
import java.util.List;

/**
 * @author Krzysztof Ziomek
 * @since 01/03/2016.
 */
@FeignClient(url = "${remote.api.branchlibrary.base-url}")
@Path("/branch/api/v1/books")
public interface BranchLibraryClient {

    @POST
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    void register(Book book);

    @GET
    List<Book> getBooks();

}
