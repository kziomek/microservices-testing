# microservices-testing

@Author Krzysztof Ziomek

Implementation is based on Spring Boot 1.3.2

## Purpose of this application is to exemplify:

1. How to test microservice API with Spring
2. How to stub external restservice dependencies while running tests

## Run

1.Start microservice

    gradle bootRun
    
2.Test that service response is one book.
   
   curl -H "Content-Type:application/json" http://localhost:4000/central/api/v1/books
   
### What happend?
BookService class aggregates books from two sources: internal BookRepository and external BranchLibrary endpoint.
Endpoint defined in BranchLibraryClient doesn't exists soexceptions comes from external service invocation.
Exception is catched in BookService and response of CentralLibrary API is list of internal books (Only one book in the list: Frank Herbert's book). 

### Test
1.Run tests in class CentralLibraryControllerIT

    gradle -Dtest.single=CentralLibraryControllerIT --info
    
### What happend?
    TO BE DEPICTED